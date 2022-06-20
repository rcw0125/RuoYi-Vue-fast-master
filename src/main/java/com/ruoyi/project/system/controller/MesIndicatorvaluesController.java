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
import com.ruoyi.project.system.domain.MesIndicatorvalues;
import com.ruoyi.project.system.service.IMesIndicatorvaluesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 能源指标值Controller
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
@RestController
@RequestMapping("/system/indicatorvalues")
public class MesIndicatorvaluesController extends BaseController
{
    @Autowired
    private IMesIndicatorvaluesService mesIndicatorvaluesService;

    /**
     * 查询能源指标值列表
     */
    @PreAuthorize("@ss.hasPermi('system:indicatorvalues:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesIndicatorvalues mesIndicatorvalues)
    {
        startPage();
        List<MesIndicatorvalues> list = mesIndicatorvaluesService.selectMesIndicatorvaluesList(mesIndicatorvalues);
        return getDataTable(list);
    }

    /**
     * 导出能源指标值列表
     */
    @PreAuthorize("@ss.hasPermi('system:indicatorvalues:export')")
    @Log(title = "能源指标值", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesIndicatorvalues mesIndicatorvalues)
    {
        List<MesIndicatorvalues> list = mesIndicatorvaluesService.selectMesIndicatorvaluesList(mesIndicatorvalues);
        ExcelUtil<MesIndicatorvalues> util = new ExcelUtil<MesIndicatorvalues>(MesIndicatorvalues.class);
        return util.exportExcel(list, "能源指标值数据");
    }

    /**
     * 获取能源指标值详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:indicatorvalues:query')")
    @GetMapping(value = "/{code}")
    public AjaxResult getInfo(@PathVariable("code") String code)
    {
        return AjaxResult.success(mesIndicatorvaluesService.selectMesIndicatorvaluesByCode(code));
    }

    /**
     * 新增能源指标值
     */
    @PreAuthorize("@ss.hasPermi('system:indicatorvalues:add')")
    @Log(title = "能源指标值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesIndicatorvalues mesIndicatorvalues)
    {
        return toAjax(mesIndicatorvaluesService.insertMesIndicatorvalues(mesIndicatorvalues));
    }

    /**
     * 修改能源指标值
     */
    @PreAuthorize("@ss.hasPermi('system:indicatorvalues:edit')")
    @Log(title = "能源指标值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesIndicatorvalues mesIndicatorvalues)
    {
        return toAjax(mesIndicatorvaluesService.updateMesIndicatorvalues(mesIndicatorvalues));
    }

    /**
     * 删除能源指标值
     */
    @PreAuthorize("@ss.hasPermi('system:indicatorvalues:remove')")
    @Log(title = "能源指标值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codes}")
    public AjaxResult remove(@PathVariable String[] codes)
    {
        return toAjax(mesIndicatorvaluesService.deleteMesIndicatorvaluesByCodes(codes));
    }
}
