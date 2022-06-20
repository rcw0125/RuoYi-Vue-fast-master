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
import com.ruoyi.project.system.domain.EquipJianxiutongji;
import com.ruoyi.project.system.service.IEquipJianxiutongjiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 设备检修统计Controller
 *
 * @author ruoyi
 * @date 2022-06-04
 */
@RestController
@RequestMapping("/system/jianxiutongji")
public class EquipJianxiutongjiController extends BaseController
{
    @Autowired
    private IEquipJianxiutongjiService equipJianxiutongjiService;

    /**
     * 查询设备检修统计列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipJianxiutongji equipJianxiutongji)
    {
        startPage();
        List<EquipJianxiutongji> list = equipJianxiutongjiService.selectEquipJianxiutongjiList(equipJianxiutongji);
        return getDataTable(list);
    }

    /**
     * 导出设备检修统计列表
     */

    @GetMapping("/export")
    public AjaxResult export(EquipJianxiutongji equipJianxiutongji)
    {
        List<EquipJianxiutongji> list = equipJianxiutongjiService.selectEquipJianxiutongjiList(equipJianxiutongji);
        ExcelUtil<EquipJianxiutongji> util = new ExcelUtil<EquipJianxiutongji>(EquipJianxiutongji.class);
        return util.exportExcel(list, "设备检修统计数据");
    }

    /**
     * 获取设备检修统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:jianxiutongji:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipJianxiutongjiService.selectEquipJianxiutongjiById(id));
    }

    /**
     * 新增设备检修统计
     */
    @PreAuthorize("@ss.hasPermi('system:jianxiutongji:add')")
    @Log(title = "设备检修统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipJianxiutongji equipJianxiutongji)
    {
        return toAjax(equipJianxiutongjiService.insertEquipJianxiutongji(equipJianxiutongji));
    }

    /**
     * 修改设备检修统计
     */
    @PreAuthorize("@ss.hasPermi('system:jianxiutongji:edit')")
    @Log(title = "设备检修统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipJianxiutongji equipJianxiutongji)
    {
        return toAjax(equipJianxiutongjiService.updateEquipJianxiutongji(equipJianxiutongji));
    }

    /**
     * 删除设备检修统计
     */
    @PreAuthorize("@ss.hasPermi('system:jianxiutongji:remove')")
    @Log(title = "设备检修统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipJianxiutongjiService.deleteEquipJianxiutongjiByIds(ids));
    }
}
