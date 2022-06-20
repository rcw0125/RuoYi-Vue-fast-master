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
import com.ruoyi.project.system.domain.DianliangBiaozhun;
import com.ruoyi.project.system.service.IDianliangBiaozhunService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 电量标准Controller
 * 
 * @author ruoyi
 * @date 2022-01-12
 */
@RestController
@RequestMapping("/system/dianliangbiaozhun")
public class DianliangBiaozhunController extends BaseController
{
    @Autowired
    private IDianliangBiaozhunService dianliangBiaozhunService;

    /**
     * 查询电量标准列表
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangbiaozhun:list')")
    @GetMapping("/list")
    public TableDataInfo list(DianliangBiaozhun dianliangBiaozhun)
    {
        startPage();
        List<DianliangBiaozhun> list = dianliangBiaozhunService.selectDianliangBiaozhunList(dianliangBiaozhun);
        return getDataTable(list);
    }

    /**
     * 导出电量标准列表
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangbiaozhun:export')")
    @Log(title = "电量标准", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DianliangBiaozhun dianliangBiaozhun)
    {
        List<DianliangBiaozhun> list = dianliangBiaozhunService.selectDianliangBiaozhunList(dianliangBiaozhun);
        ExcelUtil<DianliangBiaozhun> util = new ExcelUtil<DianliangBiaozhun>(DianliangBiaozhun.class);
        return util.exportExcel(list, "电量标准数据");
    }

    /**
     * 获取电量标准详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangbiaozhun:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(dianliangBiaozhunService.selectDianliangBiaozhunById(id));
    }

    /**
     * 新增电量标准
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangbiaozhun:add')")
    @Log(title = "电量标准", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DianliangBiaozhun dianliangBiaozhun)
    {
        return toAjax(dianliangBiaozhunService.insertDianliangBiaozhun(dianliangBiaozhun));
    }

    /**
     * 修改电量标准
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangbiaozhun:edit')")
    @Log(title = "电量标准", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DianliangBiaozhun dianliangBiaozhun)
    {
        return toAjax(dianliangBiaozhunService.updateDianliangBiaozhun(dianliangBiaozhun));
    }

    /**
     * 删除电量标准
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangbiaozhun:remove')")
    @Log(title = "电量标准", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(dianliangBiaozhunService.deleteDianliangBiaozhunByIds(ids));
    }
}
