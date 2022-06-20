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
import com.ruoyi.project.system.domain.EquipGuzhangtongji;
import com.ruoyi.project.system.service.IEquipGuzhangtongjiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 设备故障统计Controller
 *
 * @author ruoyi
 * @date 2022-06-04
 */
@RestController
@RequestMapping("/system/guzhangtongji")
public class EquipGuzhangtongjiController extends BaseController
{
    @Autowired
    private IEquipGuzhangtongjiService equipGuzhangtongjiService;

    /**
     * 查询设备故障统计列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipGuzhangtongji equipGuzhangtongji)
    {
        startPage();
        List<EquipGuzhangtongji> list = equipGuzhangtongjiService.selectEquipGuzhangtongjiList(equipGuzhangtongji);
        return getDataTable(list);
    }

    /**
     * 导出设备故障统计列表
     */


    @GetMapping("/export")
    public AjaxResult export(EquipGuzhangtongji equipGuzhangtongji)
    {
        List<EquipGuzhangtongji> list = equipGuzhangtongjiService.selectEquipGuzhangtongjiList(equipGuzhangtongji);
        ExcelUtil<EquipGuzhangtongji> util = new ExcelUtil<EquipGuzhangtongji>(EquipGuzhangtongji.class);
        return util.exportExcel(list, "设备故障统计数据");
    }

    /**
     * 获取设备故障统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:guzhangtongji:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipGuzhangtongjiService.selectEquipGuzhangtongjiById(id));
    }

    /**
     * 新增设备故障统计
     */
    @PreAuthorize("@ss.hasPermi('system:guzhangtongji:add')")
    @Log(title = "设备故障统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipGuzhangtongji equipGuzhangtongji)
    {
        return toAjax(equipGuzhangtongjiService.insertEquipGuzhangtongji(equipGuzhangtongji));
    }

    /**
     * 修改设备故障统计
     */
    @PreAuthorize("@ss.hasPermi('system:guzhangtongji:edit')")
    @Log(title = "设备故障统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipGuzhangtongji equipGuzhangtongji)
    {
        return toAjax(equipGuzhangtongjiService.updateEquipGuzhangtongji(equipGuzhangtongji));
    }

    /**
     * 删除设备故障统计
     */
    @PreAuthorize("@ss.hasPermi('system:guzhangtongji:remove')")
    @Log(title = "设备故障统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipGuzhangtongjiService.deleteEquipGuzhangtongjiByIds(ids));
    }
}
