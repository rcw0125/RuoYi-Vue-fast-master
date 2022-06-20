package com.ruoyi.project.system.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.project.system.domain.DianliangDay;
import com.ruoyi.project.system.service.IDianliangDayService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 每日电量Controller
 *
 * @author ruoyi
 * @date 2022-01-12
 */
@RestController
@RequestMapping("/system/dianliangday")
public class DianliangDayController extends BaseController
{
    @Autowired
    private IDianliangDayService dianliangDayService;

    /**
     * 查询每日电量列表
     */

    @GetMapping("/list")
    public TableDataInfo list(DianliangDay dianliangDay)
    {
        startPage();
        List<DianliangDay> list = dianliangDayService.selectDianliangDayList(dianliangDay);
        return getDataTable(list);
    }


    @GetMapping("/CalDianLiangDaylist")
    public AjaxResult CalDianLiangDaylist(DianliangDay dianliangDay)
    {
        if(StringUtils.isNull(dianliangDay.getLogtime())){
            return AjaxResult.error("抱歉，日期不能为空！","错误！");
        }
        if(StringUtils.isNotNull(dianliangDay.getDept())&&StringUtils.isNotEmpty(dianliangDay.getDept())){
            return AjaxResult.error("抱歉，单位必须为空！","错误！");
        }
        /******删除原有存在的电量数据*****/
        List<DianliangDay> existList = dianliangDayService.selectDianliangDayList(dianliangDay);
        if(StringUtils.isNotNull(existList)){
            for(DianliangDay item :existList){
                dianliangDayService.deleteDianliangDayById(item.getId());
            }
        }
        /******查询各车间总计用电量*****/
        BigDecimal chanliang=new BigDecimal(0);
        BigDecimal chanliang1=new BigDecimal(1);
        BigDecimal dianliang=new BigDecimal(0);
        BigDecimal qitadianliang=new BigDecimal(0);
        BigDecimal temp=new BigDecimal(0);
        /******外转电量*****/
        BigDecimal waizhuandianliang=new BigDecimal(0);
        List<DianliangDay> totalList = dianliangDayService.selectDianliangDayTotalList(dianliangDay);
        for(DianliangDay item :totalList){
           if(item.getDept().equals("其它")){
               chanliang=item.getDianliang();
           }else  if (item.getDept().equals("炼钢厂")) {
               dianliang = item.getDianliang();
           }else  if (item.getDept().equals("外转")) {
               waizhuandianliang = item.getDianliang();
           }

           if(!(item.getDept().equals("其它")||item.getDept().equals("炼钢厂"))){
               qitadianliang=qitadianliang.add(item.getDianliang());
           }
        }
        /*****如果产量小于1，则为1****/
        if(chanliang.compareTo(new BigDecimal(1))<1){
            chanliang=chanliang1;
        }
        /*****其它电量=总电量-各电量的和****/
        temp=dianliang.subtract(qitadianliang);
        /*****电量=总电量-外转****/
        dianliang=dianliang.subtract(waizhuandianliang);
        for(DianliangDay item :totalList){
            /****其它电量=总电量-生产车间的和****/
            if(item.getDept().equals("其它")){
               item.setDianliang(temp);
            }else if(item.getDept().equals("炼钢厂")) {
                item.setDianliang(dianliang);
            }
            /** 设置产量***/
            item.setChanliang(chanliang);
            item.setDianhao(item.getDianliang().divide(chanliang,2));
            item.setChazhi(item.getDianhao().subtract(item.getBiaozhun()));
            item.setLogtime(dianliangDay.getLogtime());
//            DianliangDay lastDianliang= dianliangDayService.selectLastDianliangDay(item);
//            if(StringUtils.isNotNull(lastDianliang)){
//                item.setZuori(lastDianliang.getDianhao());
//                item.setZuorichazhi(item.getZuori().subtract(item.getDianhao()));
//            }

            if(item.getDept().equals("精炼车间")){
                item.setOrdernum(1);
            }
            else  if(item.getDept().equals("炉渣车间")){
                item.setOrdernum(2);
            }
            else  if(item.getDept().equals("连铸车间")){
                item.setOrdernum(3);
            }
            else  if(item.getDept().equals("冶炼车间")){
                item.setOrdernum(4);
            }
            else if(item.getDept().equals("其它")){
                item.setOrdernum(5);
            }
            else if(item.getDept().equals("炼钢厂")){
                item.setOrdernum(6);
            }
            else if(item.getDept().equals("外转")){
                item.setOrdernum(7);
            }

            dianliangDayService.insertDianliangDay(item);
        }
//        for(DianliangDay item :totalList){
//            if(item.getDept().equals("精炼车间")){
//                item.setOrdernum(1);
//                dianliangDayService.insertDianliangDay(item);
//            }
//        }
//        for(DianliangDay item :totalList){
//            if(item.getDept().equals("脱硫车间")){
//                item.setOrdernum(2);
//                dianliangDayService.insertDianliangDay(item);
//            }
//        }
//        for(DianliangDay item :totalList){
//            if(item.getDept().equals("连铸车间")){
//                item.setOrdernum(3);
//                dianliangDayService.insertDianliangDay(item);
//            }
//        }
//        for(DianliangDay item :totalList){
//            if(item.getDept().equals("冶炼车间")){
//                item.setOrdernum(4);
//                dianliangDayService.insertDianliangDay(item);
//            }
//        }
//        for(DianliangDay item :totalList){
//            if(item.getDept().equals("其它")){
//                item.setOrdernum(5);
//                dianliangDayService.insertDianliangDay(item);
//            }
//        }
//        for(DianliangDay item :totalList){
//            if(item.getDept().equals("炼钢厂")){
//                item.setOrdernum(6);
//                dianliangDayService.insertDianliangDay(item);
//            }
//        }


        return AjaxResult.success("计算成功");
    }

    /**
     * 导出每日电量列表
     */

    @Log(title = "每日电量", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DianliangDay dianliangDay)
    {
        List<DianliangDay> list = dianliangDayService.selectDianliangDayList(dianliangDay);
        ExcelUtil<DianliangDay> util = new ExcelUtil<DianliangDay>(DianliangDay.class);
        return util.exportExcel(list, "每日电量数据");
    }

    /**
     * 获取每日电量详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dianliangDayService.selectDianliangDayById(id));
    }

    /**
     * 新增每日电量
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangday:add')")
    @Log(title = "每日电量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DianliangDay dianliangDay)
    {
        return toAjax(dianliangDayService.insertDianliangDay(dianliangDay));
    }

    /**
     * 修改每日电量
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangday:edit')")
    @Log(title = "每日电量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DianliangDay dianliangDay)
    {
        return toAjax(dianliangDayService.updateDianliangDay(dianliangDay));
    }

    /**
     * 删除每日电量
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangday:remove')")
    @Log(title = "每日电量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dianliangDayService.deleteDianliangDayByIds(ids));
    }
}
