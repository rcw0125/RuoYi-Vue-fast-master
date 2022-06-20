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
import com.ruoyi.project.system.domain.DianliangCfg;
import com.ruoyi.project.system.service.IDianliangCfgService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 电量配置Controller
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/system/dianliangcfg")
public class DianliangCfgController extends BaseController
{
    @Autowired
    private IDianliangCfgService dianliangCfgService;

    /**
     * 查询电量配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangcfg:list')")
    @GetMapping("/list")
    public TableDataInfo list(DianliangCfg dianliangCfg)
    {
        startPage();
        List<DianliangCfg> list = dianliangCfgService.selectDianliangCfgList(dianliangCfg);
        return getDataTable(list);
    }

    /**
     * 导出电量配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangcfg:export')")
    @Log(title = "电量配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DianliangCfg dianliangCfg)
    {
        List<DianliangCfg> list = dianliangCfgService.selectDianliangCfgList(dianliangCfg);
        ExcelUtil<DianliangCfg> util = new ExcelUtil<DianliangCfg>(DianliangCfg.class);
        return util.exportExcel(list, "电量配置数据");
    }

    /**
     * 获取电量配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangcfg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dianliangCfgService.selectDianliangCfgById(id));
    }

    /**
     * 新增电量配置
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangcfg:add')")
    @Log(title = "电量配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DianliangCfg dianliangCfg)
    {
        return toAjax(dianliangCfgService.insertDianliangCfg(dianliangCfg));
    }

    /**
     * 修改电量配置
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangcfg:edit')")
    @Log(title = "电量配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DianliangCfg dianliangCfg)
    {
        return toAjax(dianliangCfgService.updateDianliangCfg(dianliangCfg));
    }

    /**
     * 删除电量配置
     */
    @PreAuthorize("@ss.hasPermi('system:dianliangcfg:remove')")
    @Log(title = "电量配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dianliangCfgService.deleteDianliangCfgByIds(ids));
    }
}
