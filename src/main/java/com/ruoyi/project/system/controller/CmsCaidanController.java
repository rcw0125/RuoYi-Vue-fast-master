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
import com.ruoyi.project.system.domain.CmsCaidan;
import com.ruoyi.project.system.service.ICmsCaidanService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 新闻菜单Controller
 *
 * @author ruoyi
 * @date 2021-06-29
 */
@RestController
@RequestMapping("/system/caidan")
public class CmsCaidanController extends BaseController
{
    @Autowired
    private ICmsCaidanService cmsCaidanService;

    /**
     * 查询新闻菜单列表
     */
    @PreAuthorize("@ss.hasPermi('system:caidan:list')")
    @GetMapping("/list")
    public AjaxResult list(CmsCaidan cmsCaidan)
    {
        List<CmsCaidan> list = cmsCaidanService.selectCmsCaidanList(cmsCaidan);
        return AjaxResult.success(list);
    }

    /**
     * 导出新闻菜单列表
     */
    @PreAuthorize("@ss.hasPermi('system:caidan:export')")
    @Log(title = "新闻菜单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CmsCaidan cmsCaidan)
    {
        List<CmsCaidan> list = cmsCaidanService.selectCmsCaidanList(cmsCaidan);
        ExcelUtil<CmsCaidan> util = new ExcelUtil<CmsCaidan>(CmsCaidan.class);
        return util.exportExcel(list, "caidan");
    }

    /**
     * 获取新闻菜单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:caidan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsCaidanService.selectCmsCaidanById(id));
    }

    /**
     * 新增新闻菜单
     */
    @PreAuthorize("@ss.hasPermi('system:caidan:add')")
    @Log(title = "新闻菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsCaidan cmsCaidan)
    {
        return toAjax(cmsCaidanService.insertCmsCaidan(cmsCaidan));
    }

    /**
     * 修改新闻菜单
     */
    @PreAuthorize("@ss.hasPermi('system:caidan:edit')")
    @Log(title = "新闻菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsCaidan cmsCaidan)
    {
        return toAjax(cmsCaidanService.updateCmsCaidan(cmsCaidan));
    }

    /**
     * 删除新闻菜单
     */
    @PreAuthorize("@ss.hasPermi('system:caidan:remove')")
    @Log(title = "新闻菜单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsCaidanService.deleteCmsCaidanByIds(ids));
    }
}
