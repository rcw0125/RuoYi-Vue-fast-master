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
import com.ruoyi.project.system.domain.L1opcTag;
import com.ruoyi.project.system.service.IL1opcTagService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * opctagController
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
@RestController
@RequestMapping("/system/opctag")
public class L1opcTagController extends BaseController
{
    @Autowired
    private IL1opcTagService l1opcTagService;

    /**
     * 查询opctag列表
     */
    @PreAuthorize("@ss.hasPermi('system:opctag:list')")
    @GetMapping("/list")
    public TableDataInfo list(L1opcTag l1opcTag)
    {
        startPage();
        List<L1opcTag> list = l1opcTagService.selectL1opcTagList(l1opcTag);
        return getDataTable(list);
    }

    /**
     * 导出opctag列表
     */
    @PreAuthorize("@ss.hasPermi('system:opctag:export')")
    @Log(title = "opctag", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(L1opcTag l1opcTag)
    {
        List<L1opcTag> list = l1opcTagService.selectL1opcTagList(l1opcTag);
        ExcelUtil<L1opcTag> util = new ExcelUtil<L1opcTag>(L1opcTag.class);
        return util.exportExcel(list, "opctag");
    }

    /**
     * 获取opctag详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:opctag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(l1opcTagService.selectL1opcTagById(id));
    }

    /**
     * 新增opctag
     */
    @PreAuthorize("@ss.hasPermi('system:opctag:add')")
    @Log(title = "opctag", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody L1opcTag l1opcTag)
    {
        return toAjax(l1opcTagService.insertL1opcTag(l1opcTag));
    }

    /**
     * 修改opctag
     */
    @PreAuthorize("@ss.hasPermi('system:opctag:edit')")
    @Log(title = "opctag", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody L1opcTag l1opcTag)
    {
        return toAjax(l1opcTagService.updateL1opcTag(l1opcTag));
    }

    /**
     * 删除opctag
     */
    @PreAuthorize("@ss.hasPermi('system:opctag:remove')")
    @Log(title = "opctag", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(l1opcTagService.deleteL1opcTagByIds(ids));
    }
}
