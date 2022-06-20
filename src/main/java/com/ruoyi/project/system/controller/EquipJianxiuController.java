package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.ruoyi.project.system.domain.EquipJianxiu;
import com.ruoyi.project.system.service.IEquipJianxiuService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 计划检修Controller
 *
 * @author ruoyi
 * @date 2021-12-09
 */
@RestController
@RequestMapping("/system/jianxiu")
public class EquipJianxiuController extends BaseController
{
    @Autowired
    private IEquipJianxiuService equipJianxiuService;

    /**
     * 查询计划检修列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipJianxiu equipJianxiu)
    {
        startPage();
        List<EquipJianxiu> list = equipJianxiuService.selectEquipJianxiuList(equipJianxiu);
        return getDataTable(list);
    }

    /**
     * 导出计划检修列表
     */

    @Log(title = "计划检修", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipJianxiu equipJianxiu)
    {
        List<EquipJianxiu> list = equipJianxiuService.selectEquipJianxiuList(equipJianxiu);
        ExcelUtil<EquipJianxiu> util = new ExcelUtil<EquipJianxiu>(EquipJianxiu.class);
        return util.exportExcel(list, "计划检修数据");
    }

    /**
     * 获取计划检修详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:jianxiu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipJianxiuService.selectEquipJianxiuById(id));
    }

    /**
     * 新增计划检修
     */

    @Log(title = "计划检修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipJianxiu equipJianxiu)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipJianxiu.setDjtime(doneDate);
        return toAjax(equipJianxiuService.insertEquipJianxiu(equipJianxiu));
    }

    /**
     * 修改计划检修
     */

    @Log(title = "计划检修", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipJianxiu equipJianxiu)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipJianxiu.setJxtime(doneDate);
        return toAjax(equipJianxiuService.updateEquipJianxiu(equipJianxiu));
    }

    /**
     * 删除计划检修
     */
    @PreAuthorize("@ss.hasPermi('system:jianxiu:remove')")
    @Log(title = "计划检修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipJianxiuService.deleteEquipJianxiuByIds(ids));
    }
}
