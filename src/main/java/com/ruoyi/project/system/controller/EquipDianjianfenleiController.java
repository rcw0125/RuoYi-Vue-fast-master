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
import com.ruoyi.project.system.domain.EquipDianjianfenlei;
import com.ruoyi.project.system.service.IEquipDianjianfenleiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 点检分类统计Controller
 *
 * @author ruoyi
 * @date 2022-06-04
 */
@RestController
@RequestMapping("/system/dianjianfenlei")
public class EquipDianjianfenleiController extends BaseController
{
    @Autowired
    private IEquipDianjianfenleiService equipDianjianfenleiService;

    /**
     * 查询点检分类统计列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipDianjianfenlei equipDianjianfenlei)
    {
        startPage();
        List<EquipDianjianfenlei> list = equipDianjianfenleiService.selectEquipDianjianfenleiList(equipDianjianfenlei);
        return getDataTable(list);
    }

    /**
     * 导出点检分类统计列表
     */

    @Log(title = "点检分类统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipDianjianfenlei equipDianjianfenlei)
    {
        List<EquipDianjianfenlei> list = equipDianjianfenleiService.selectEquipDianjianfenleiList(equipDianjianfenlei);
        ExcelUtil<EquipDianjianfenlei> util = new ExcelUtil<EquipDianjianfenlei>(EquipDianjianfenlei.class);
        return util.exportExcel(list, "点检分类统计数据");
    }

    /**
     * 获取点检分类统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dianjianfenlei:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipDianjianfenleiService.selectEquipDianjianfenleiById(id));
    }

    /**
     * 新增点检分类统计
     */
    @PreAuthorize("@ss.hasPermi('system:dianjianfenlei:add')")
    @Log(title = "点检分类统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipDianjianfenlei equipDianjianfenlei)
    {
        return toAjax(equipDianjianfenleiService.insertEquipDianjianfenlei(equipDianjianfenlei));
    }

    /**
     * 修改点检分类统计
     */
    @PreAuthorize("@ss.hasPermi('system:dianjianfenlei:edit')")
    @Log(title = "点检分类统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipDianjianfenlei equipDianjianfenlei)
    {
        return toAjax(equipDianjianfenleiService.updateEquipDianjianfenlei(equipDianjianfenlei));
    }

    /**
     * 删除点检分类统计
     */
    @PreAuthorize("@ss.hasPermi('system:dianjianfenlei:remove')")
    @Log(title = "点检分类统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipDianjianfenleiService.deleteEquipDianjianfenleiByIds(ids));
    }
}
