package com.ruoyi.project.system.controller;

import java.util.List;
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
import com.ruoyi.project.system.domain.SysCarCfg;
import com.ruoyi.project.system.service.ISysCarCfgService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用车台账Controller
 * 
 * @author ruoyi
 * @date 2021-09-11
 */
@RestController
@RequestMapping("/system/carcfg")
public class SysCarCfgController extends BaseController
{
    @Autowired
    private ISysCarCfgService sysCarCfgService;

    /**
     * 查询用车台账列表
     */
    @PreAuthorize("@ss.hasPermi('system:carcfg:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCarCfg sysCarCfg)
    {
        startPage();
        List<SysCarCfg> list = sysCarCfgService.selectSysCarCfgList(sysCarCfg);
        return getDataTable(list);
    }

    /**
     * 导出用车台账列表
     */
    @PreAuthorize("@ss.hasPermi('system:carcfg:export')")
    @Log(title = "用车台账", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCarCfg sysCarCfg)
    {
        List<SysCarCfg> list = sysCarCfgService.selectSysCarCfgList(sysCarCfg);
        ExcelUtil<SysCarCfg> util = new ExcelUtil<SysCarCfg>(SysCarCfg.class);
        return util.exportExcel(list, "carcfg");
    }

    /**
     * 获取用车台账详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:carcfg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysCarCfgService.selectSysCarCfgById(id));
    }

    /**
     * 新增用车台账
     */
    @PreAuthorize("@ss.hasPermi('system:carcfg:add')")
    @Log(title = "用车台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCarCfg sysCarCfg)
    {
        return toAjax(sysCarCfgService.insertSysCarCfg(sysCarCfg));
    }

    /**
     * 修改用车台账
     */
    @PreAuthorize("@ss.hasPermi('system:carcfg:edit')")
    @Log(title = "用车台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCarCfg sysCarCfg)
    {
        return toAjax(sysCarCfgService.updateSysCarCfg(sysCarCfg));
    }

    /**
     * 删除用车台账
     */
    @PreAuthorize("@ss.hasPermi('system:carcfg:remove')")
    @Log(title = "用车台账", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysCarCfgService.deleteSysCarCfgByIds(ids));
    }
}
