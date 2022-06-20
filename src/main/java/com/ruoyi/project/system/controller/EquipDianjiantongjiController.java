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
import com.ruoyi.project.system.domain.EquipDianjiantongji;
import com.ruoyi.project.system.service.IEquipDianjiantongjiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 月点检统计Controller
 *
 * @author ruoyi
 * @date 2022-05-17
 */
@RestController
@RequestMapping("/system/dianjiantongji")
public class EquipDianjiantongjiController extends BaseController
{
    @Autowired
    private IEquipDianjiantongjiService equipDianjiantongjiService;

    /**
     * 查询月点检统计列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipDianjiantongji equipDianjiantongji)
    {
        startPage();
        List<EquipDianjiantongji> list = equipDianjiantongjiService.selectEquipDianjiantongjiList(equipDianjiantongji);
        return getDataTable(list);
    }

    /**
     * 导出月点检统计列表
     */

    @Log(title = "月点检统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipDianjiantongji equipDianjiantongji)
    {
        List<EquipDianjiantongji> list = equipDianjiantongjiService.selectEquipDianjiantongjiList(equipDianjiantongji);
        ExcelUtil<EquipDianjiantongji> util = new ExcelUtil<EquipDianjiantongji>(EquipDianjiantongji.class);
        return util.exportExcel(list, "月点检统计数据");
    }

    /**
     * 获取月点检统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dianjiantongji:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipDianjiantongjiService.selectEquipDianjiantongjiById(id));
    }

    /**
     * 新增月点检统计
     */
    @PreAuthorize("@ss.hasPermi('system:dianjiantongji:add')")
    @Log(title = "月点检统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipDianjiantongji equipDianjiantongji)
    {
        return toAjax(equipDianjiantongjiService.insertEquipDianjiantongji(equipDianjiantongji));
    }

    /**
     * 修改月点检统计
     */
    @PreAuthorize("@ss.hasPermi('system:dianjiantongji:edit')")
    @Log(title = "月点检统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipDianjiantongji equipDianjiantongji)
    {
        return toAjax(equipDianjiantongjiService.updateEquipDianjiantongji(equipDianjiantongji));
    }

    /**
     * 删除月点检统计
     */
    @PreAuthorize("@ss.hasPermi('system:dianjiantongji:remove')")
    @Log(title = "月点检统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipDianjiantongjiService.deleteEquipDianjiantongjiByIds(ids));
    }
}
