package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.system.domain.DianliangCfg;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.IDianliangCfgService;
import com.ruoyi.project.system.service.ISysUserService;
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
import com.ruoyi.project.system.domain.DianliangMingxi;
import com.ruoyi.project.system.service.IDianliangMingxiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 电量明细Controller
 *
 * @author ruoyi
 * @date 2022-01-10
 */
@RestController
@RequestMapping("/system/mingxi")
public class DianliangMingxiController extends BaseController
{
    @Autowired
    private IDianliangMingxiService dianliangMingxiService;

    @Autowired
    private IDianliangCfgService dianliangCfgService;
    @Autowired
    private ISysUserService userService;

    /**
     * 查询电量明细列表
     */

    @GetMapping("/list")
    public TableDataInfo list(DianliangMingxi dianliangMingxi)
    {
        startPage();
        List<DianliangMingxi> list = dianliangMingxiService.selectDianliangMingxiList(dianliangMingxi);
        return getDataTable(list);
    }

    /**
     * 导出电量明细列表
     */

    @Log(title = "电量明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DianliangMingxi dianliangMingxi)
    {
        List<DianliangMingxi> list = dianliangMingxiService.selectDianliangMingxiList(dianliangMingxi);
        ExcelUtil<DianliangMingxi> util = new ExcelUtil<DianliangMingxi>(DianliangMingxi.class);
        return util.exportExcel(list, "电量明细数据");
    }

    /**
     * 获取电量明细详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dianliangMingxiService.selectDianliangMingxiById(id));
    }

    /**
     * 新增电量明细
     */
    @PreAuthorize("@ss.hasPermi('system:mingxi:add')")
    @Log(title = "电量明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DianliangMingxi dianliangMingxi)
    {
        return toAjax(dianliangMingxiService.insertDianliangMingxi(dianliangMingxi));
    }

    /**
     * 修改电量明细
     */
    @PreAuthorize("@ss.hasPermi('system:mingxi:edit')")
    @Log(title = "电量明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DianliangMingxi dianliangMingxi)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH点mm分"));
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        dianliangMingxi.setNote(doneDate+","+checkUser.getNickName()+"手工录入");
        int i=dianliangMingxiService.updateDianliangMingxi(dianliangMingxi);
        if(dianliangMingxi.getLaiyuan().equals("手工录入")){
            DianliangCfg dianliangCfg=new DianliangCfg ();
            dianliangCfg.setLaiyuan("手工录入");
            dianliangCfg.setName(dianliangMingxi.getName());
            List<DianliangCfg> list = dianliangCfgService.selectDianliangCfgList(dianliangCfg);
            for(DianliangCfg item:list){
                if (item.getName().equals(dianliangMingxi.getName())){
                    item.setVal(dianliangMingxi.getTotal());
                    dianliangCfgService.updateDianliangCfg(item);
                }

            }
        }
        return toAjax(i);
    }

    /**
     * 删除电量明细
     */
    @PreAuthorize("@ss.hasPermi('system:mingxi:remove')")
    @Log(title = "电量明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dianliangMingxiService.deleteDianliangMingxiByIds(ids));
    }

    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, String logtime) throws Exception
    {
        ExcelUtil<DianliangMingxi> util = new ExcelUtil<DianliangMingxi>(DianliangMingxi.class);
        List<DianliangMingxi> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dianliangMingxiService.importDianLiang(userList, logtime, operName);
        return AjaxResult.success(message);
    }
}
