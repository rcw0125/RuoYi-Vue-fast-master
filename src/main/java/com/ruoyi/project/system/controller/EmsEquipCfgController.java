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
import com.ruoyi.project.system.domain.EmsEquipCfg;
import com.ruoyi.project.system.service.IEmsEquipCfgService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 能源介质配置Controller
 *
 * @author ruoyi
 * @date 2021-10-22
 */
@RestController
@RequestMapping("/system/emsequipcfg")
public class EmsEquipCfgController extends BaseController
{
    @Autowired
    private IEmsEquipCfgService emsEquipCfgService;

    /**
     * 查询能源介质配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:emsequipcfg:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmsEquipCfg emsEquipCfg)
    {
        startPage();
        List<EmsEquipCfg> list = emsEquipCfgService.selectEmsEquipCfgList(emsEquipCfg);
        return getDataTable(list);
    }


    @GetMapping("/info")
    public AjaxResult info(String type)
    {
        AjaxResult ajax = AjaxResult.success();
        EmsEquipCfg emsEquipCfg=new EmsEquipCfg ();
        emsEquipCfg.setType(type);
        ajax.put("equip", emsEquipCfgService.selectEmsEquipCfgList(emsEquipCfg));
        return ajax;
    }

    /**
     * 导出能源介质配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:emsequipcfg:export')")
    @Log(title = "能源介质配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EmsEquipCfg emsEquipCfg)
    {
        List<EmsEquipCfg> list = emsEquipCfgService.selectEmsEquipCfgList(emsEquipCfg);
        ExcelUtil<EmsEquipCfg> util = new ExcelUtil<EmsEquipCfg>(EmsEquipCfg.class);
        return util.exportExcel(list, "能源介质配置数据");
    }

    /**
     * 获取能源介质配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:emsequipcfg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(emsEquipCfgService.selectEmsEquipCfgById(id));
    }

    /**
     * 新增能源介质配置
     */
    @PreAuthorize("@ss.hasPermi('system:emsequipcfg:add')")
    @Log(title = "能源介质配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmsEquipCfg emsEquipCfg)
    {
        return toAjax(emsEquipCfgService.insertEmsEquipCfg(emsEquipCfg));
    }

    /**
     * 修改能源介质配置
     */
    @PreAuthorize("@ss.hasPermi('system:emsequipcfg:edit')")
    @Log(title = "能源介质配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmsEquipCfg emsEquipCfg)
    {
        return toAjax(emsEquipCfgService.updateEmsEquipCfg(emsEquipCfg));
    }

    /**
     * 删除能源介质配置
     */
    @PreAuthorize("@ss.hasPermi('system:emsequipcfg:remove')")
    @Log(title = "能源介质配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(emsEquipCfgService.deleteEmsEquipCfgByIds(ids));
    }
}
