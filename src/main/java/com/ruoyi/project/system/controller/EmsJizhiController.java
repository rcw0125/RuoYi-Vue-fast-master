package com.ruoyi.project.system.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 介质停送记录Controller
 *
 * @author ruoyi
 * @date 2021-10-22
 */
@RestController
@RequestMapping("/system/jiezhi")
public class EmsJizhiController extends BaseController
{
    @Autowired
    private IEmsJizhiService emsJizhiService;

    @Autowired
    private IEmsLuciService emsLuciService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IEmsEquipCfgService emsEquipCfgService;

    @Autowired
    private IMesLuciService mesLuciService;
    /**
     * 查询介质停送记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:jiezhi:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmsJizhi emsJizhi)
    {
        startPage();
        List<EmsJizhi> list = emsJizhiService.selectEmsJizhiList(emsJizhi);
        return getDataTable(list);
    }

    /**
     * 导出介质停送记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:jiezhi:export')")
    @Log(title = "介质停送记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EmsJizhi emsJizhi)
    {
        List<EmsJizhi> list = emsJizhiService.selectEmsJizhiList(emsJizhi);
        ExcelUtil<EmsJizhi> util = new ExcelUtil<EmsJizhi>(EmsJizhi.class);
        return util.exportExcel(list, "介质停送记录数据");
    }

    /**
     * 获取介质停送记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:jiezhi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        EmsJizhi jieZhi=emsJizhiService.selectEmsJizhiById(id);
        if(jieZhi.getStatus().equals("执行中")){
            EmsEquipCfg emsEquipCfg =new EmsEquipCfg();
            emsEquipCfg.setSbname(jieZhi.getSbname());
            List<EmsEquipCfg> list = emsEquipCfgService.selectEmsEquipCfgList(emsEquipCfg);
            if(list.size()>0){
                jieZhi.setSbdongzuotime(list.get(0).getChangetime());
            }
        }
        return AjaxResult.success(jieZhi);
    }

    /**
     * 新增介质停送记录
     */

    @PreAuthorize("@ss.hasPermi('system:jiezhi:add')")
    @Log(title = "介质停送记录", businessType = BusinessType.INSERT)
    @PostMapping

    public AjaxResult add(@RequestBody EmsJizhi emsJizhi)
    {
        emsJizhi.setStatus("待接收");
        /** 获取当前用户的岗位，并根据岗位查询对应的模板信息**/
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        emsJizhi.setDiaodu(checkUser.getNickName());
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        emsJizhi.setLgqztime(doneDate);

        EmsEquipCfg EquipCfg =new EmsEquipCfg();
        EquipCfg.setSbname(emsJizhi.getSbname());
        List<EmsEquipCfg> list = emsEquipCfgService.selectEmsEquipCfgList(EquipCfg);
        if(list.size()>0){
            if("停止".equals(emsJizhi.getOpertype())) {
                emsJizhi.setBiaozhuntime(list.get(0).getStoptime());
            }else {
                emsJizhi.setBiaozhuntime(list.get(0).getRuntime());
            }
        }

        if("停止".equals(emsJizhi.getOpertype())){
            /********炉次结束时间不为空，也不为null******/
            if(StringUtils.isNotEmpty(emsJizhi.getHeatendtime())&&StringUtils.isNotNull(emsJizhi.getHeatendtime())){
                /**计算用时***/
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date djTime;
                try
                {
                    /**计算用时(天)***/
                    djTime = sdf.parse(emsJizhi.getHeatendtime());
                    double chaZhi=((new Date()).getTime()-djTime.getTime())*1.0/1000/60;
                    emsJizhi.setShijitime(new BigDecimal(chaZhi));
                    if(chaZhi>emsJizhi.getBiaozhuntime().doubleValue()){
                        emsJizhi.setPanding("否");
                    }else {
                        emsJizhi.setPanding("否");
                    }
                }
                catch(Exception e)
                {

                }

            }
        }

        return toAjax(emsJizhiService.insertEmsJizhi(emsJizhi));
    }

    /**
     * 修改介质停送记录
     */

    @PutMapping
    public AjaxResult edit(@RequestBody EmsJizhi emsJizhi)
    {
        emsJizhi.setStatus("执行中");
        /** 获取当前用户的岗位，并根据岗位查询对应的模板信息**/
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        emsJizhi.setZhilingren(checkUser.getNickName());
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        emsJizhi.setCaozuotime(doneDate);
        return toAjax(emsJizhiService.updateEmsJizhi(emsJizhi));
    }


    @PostMapping(value = "/reply")
    public AjaxResult reply(@RequestBody EmsJizhi emsJizhi)
    {
        emsJizhi.setStatus("已完毕");
        /** 获取当前用户的岗位，并根据岗位查询对应的模板信息**/
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        emsJizhi.setWanbitime(doneDate);
        if("启动".equals(emsJizhi.getOpertype())){
            /********炉次结束时间不为空，也不为null******/
            if(StringUtils.isNotEmpty(emsJizhi.getSbdongzuotime())&&StringUtils.isNotNull(emsJizhi.getSbdongzuotime())){
                /**计算用时***/
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dzTime;
                Date jsTime;
                try
                {
                    /**计算用时(天)***/
                    dzTime = sdf.parse(emsJizhi.getSbdongzuotime());
                    jsTime = sdf.parse(emsJizhi.getCaozuotime());
                    double chaZhi=(dzTime.getTime()-jsTime.getTime())*1.0/1000/60;
                    emsJizhi.setShijitime(new BigDecimal(chaZhi));
                    if(chaZhi>emsJizhi.getBiaozhuntime().doubleValue()){
                        emsJizhi.setPanding("否");
                    }else  if(chaZhi<0){
                        emsJizhi.setPanding("否");
                    }else {
                        emsJizhi.setPanding("合");
                    }

                }
                catch(Exception e)
                {

                }

            }
        }
        return toAjax(emsJizhiService.updateEmsJizhi(emsJizhi));
    }

    /**
     * 删除介质停送记录
     */
    @PreAuthorize("@ss.hasPermi('system:jiezhi:remove')")
    @Log(title = "介质停送记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(emsJizhiService.deleteEmsJizhiByIds(ids));
    }

    @GetMapping("/getHeatIdInfo")
    public AjaxResult getHeatIdInfo(String gongxu)
    {
        AjaxResult ajax = AjaxResult.success();
//        EmsLuci emsLuci=new EmsLuci ();
//        emsLuci.setGongxu(gongxu);
//
//
//
//        List<EmsLuci> list = emsLuciService.selectEmsLuciList(emsLuci);
//        if(list==null ||list.size()==0){
//            return AjaxResult.error("系统中，没有该工序！","错误！");
//        }
        /** 根据第一个模板，设置到工作日志**/
        EmsJizhi jiezhi=new EmsJizhi();
        try {
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            MesLuci mesluci=mesLuciService.selectMesLuciByGongxu(gongxu);
            DynamicDataSourceContextHolder.clearDataSourceType();
            if(mesluci!=null){
                jiezhi.setHeatid(mesluci.getHeatid());
                if(!mesluci.getEndtime().contains("1899")){
                    jiezhi.setHeatendtime(mesluci.getEndtime());
                }
            }
        }
        catch (Exception ex)
        {

        }

//        jiezhi.setHeatid(list.get(0).getHeatid());
//        jiezhi.setHeatendtime(list.get(0).getEndtime());
        return AjaxResult.success(jiezhi);
    }
}
