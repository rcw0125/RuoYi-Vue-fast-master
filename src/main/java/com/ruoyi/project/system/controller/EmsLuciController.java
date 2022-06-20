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
import com.ruoyi.project.system.domain.EmsLuci;
import com.ruoyi.project.system.service.IEmsLuciService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 能源介质最新炉号Controller
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
@RestController
@RequestMapping("/system/emsluci")
public class EmsLuciController extends BaseController
{
    @Autowired
    private IEmsLuciService emsLuciService;

    /**
     * 查询能源介质最新炉号列表
     */
    @PreAuthorize("@ss.hasPermi('system:emsluci:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmsLuci emsLuci)
    {
        startPage();
        List<EmsLuci> list = emsLuciService.selectEmsLuciList(emsLuci);
        return getDataTable(list);
    }

    /**
     * 导出能源介质最新炉号列表
     */
    @PreAuthorize("@ss.hasPermi('system:emsluci:export')")
    @Log(title = "能源介质最新炉号", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EmsLuci emsLuci)
    {
        List<EmsLuci> list = emsLuciService.selectEmsLuciList(emsLuci);
        ExcelUtil<EmsLuci> util = new ExcelUtil<EmsLuci>(EmsLuci.class);
        return util.exportExcel(list, "能源介质最新炉号数据");
    }

    /**
     * 获取能源介质最新炉号详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:emsluci:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(emsLuciService.selectEmsLuciById(id));
    }

    /**
     * 新增能源介质最新炉号
     */
    @PreAuthorize("@ss.hasPermi('system:emsluci:add')")
    @Log(title = "能源介质最新炉号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmsLuci emsLuci)
    {
        return toAjax(emsLuciService.insertEmsLuci(emsLuci));
    }

    /**
     * 修改能源介质最新炉号
     */
    @PreAuthorize("@ss.hasPermi('system:emsluci:edit')")
    @Log(title = "能源介质最新炉号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmsLuci emsLuci)
    {
        return toAjax(emsLuciService.updateEmsLuci(emsLuci));
    }

    /**
     * 删除能源介质最新炉号
     */
    @PreAuthorize("@ss.hasPermi('system:emsluci:remove')")
    @Log(title = "能源介质最新炉号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(emsLuciService.deleteEmsLuciByIds(ids));
    }
}
