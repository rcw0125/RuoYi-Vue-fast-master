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
import com.ruoyi.project.system.domain.Ipguanli;
import com.ruoyi.project.system.service.IIpguanliService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * IP管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
@RestController
@RequestMapping("/system/ipguanli")
public class IpguanliController extends BaseController
{
    @Autowired
    private IIpguanliService ipguanliService;

    /**
     * 查询IP管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:ipguanli:list')")
    @GetMapping("/list")
    public TableDataInfo list(Ipguanli ipguanli)
    {
        startPage();
        List<Ipguanli> list = ipguanliService.selectIpguanliList(ipguanli);
        return getDataTable(list);
    }

    /**
     * 导出IP管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:ipguanli:export')")
    @Log(title = "IP管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Ipguanli ipguanli)
    {
        List<Ipguanli> list = ipguanliService.selectIpguanliList(ipguanli);
        ExcelUtil<Ipguanli> util = new ExcelUtil<Ipguanli>(Ipguanli.class);
        return util.exportExcel(list, "ipguanli");
    }

    /**
     * 获取IP管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ipguanli:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ipguanliService.selectIpguanliById(id));
    }

    /**
     * 新增IP管理
     */
    @PreAuthorize("@ss.hasPermi('system:ipguanli:add')")
    @Log(title = "IP管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Ipguanli ipguanli)
    {
        return toAjax(ipguanliService.insertIpguanli(ipguanli));
    }

    /**
     * 修改IP管理
     */
    @PreAuthorize("@ss.hasPermi('system:ipguanli:edit')")
    @Log(title = "IP管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Ipguanli ipguanli)
    {
        return toAjax(ipguanliService.updateIpguanli(ipguanli));
    }

    /**
     * 删除IP管理
     */
    @PreAuthorize("@ss.hasPermi('system:ipguanli:remove')")
    @Log(title = "IP管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ipguanliService.deleteIpguanliByIds(ids));
    }
}
