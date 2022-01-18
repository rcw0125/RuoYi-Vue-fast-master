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
import com.ruoyi.project.system.domain.EquipQuyu;
import com.ruoyi.project.system.service.IEquipQuyuService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 设备区域Controller
 *
 * @author ruoyi
 * @date 2021-06-29
 */
@RestController
@RequestMapping("/system/quyu")
public class EquipQuyuController extends BaseController
{
    @Autowired
    private IEquipQuyuService equipQuyuService;

    /**
     * 查询设备区域列表
     */

    @GetMapping("/list")
    public AjaxResult list(EquipQuyu equipQuyu)
    {
        List<EquipQuyu> list = equipQuyuService.selectEquipQuyuList(equipQuyu);
        return AjaxResult.success(list);
    }

    /**
     * 导出设备区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:quyu:export')")
    @Log(title = "设备区域", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipQuyu equipQuyu)
    {
        List<EquipQuyu> list = equipQuyuService.selectEquipQuyuList(equipQuyu);
        ExcelUtil<EquipQuyu> util = new ExcelUtil<EquipQuyu>(EquipQuyu.class);
        return util.exportExcel(list, "quyu");
    }

    /**
     * 获取设备区域详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:quyu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipQuyuService.selectEquipQuyuById(id));
    }

    /**
     * 新增设备区域
     */
    @PreAuthorize("@ss.hasPermi('system:quyu:add')")
    @Log(title = "设备区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipQuyu equipQuyu)
    {
        return toAjax(equipQuyuService.insertEquipQuyu(equipQuyu));
    }

    /**
     * 修改设备区域
     */
    @PreAuthorize("@ss.hasPermi('system:quyu:edit')")
    @Log(title = "设备区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipQuyu equipQuyu)
    {
        return toAjax(equipQuyuService.updateEquipQuyu(equipQuyu));
    }

    /**
     * 删除设备区域
     */
    @PreAuthorize("@ss.hasPermi('system:quyu:remove')")
    @Log(title = "设备区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipQuyuService.deleteEquipQuyuByIds(ids));
    }


    /**
     * 获取部门下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(EquipQuyu dept)
    {
        List<EquipQuyu> depts = equipQuyuService.selectEquipQuyuList(dept);
        return AjaxResult.success(equipQuyuService.buildQuyuTreeSelect(depts));
    }

    @GetMapping("/api/treeselect")
    public AjaxResult apitreeselect(EquipQuyu dept)
    {
        List<EquipQuyu> depts = equipQuyuService.selectEquipQuyuList(dept);
        return AjaxResult.success(equipQuyuService.buildQuyuTreeSelect(depts));
    }
}
