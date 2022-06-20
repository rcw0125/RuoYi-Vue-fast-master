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
import com.ruoyi.project.system.domain.MesLuci;
import com.ruoyi.project.system.service.IMesLuciService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 导入MES炉次Controller
 * 
 * @author ruoyi
 * @date 2022-03-04
 */
@RestController
@RequestMapping("/system/mesluci")
public class MesLuciController extends BaseController
{
    @Autowired
    private IMesLuciService mesLuciService;

    /**
     * 查询导入MES炉次列表
     */
    @PreAuthorize("@ss.hasPermi('system:mesluci:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesLuci mesLuci)
    {
        startPage();
        List<MesLuci> list = mesLuciService.selectMesLuciList(mesLuci);
        return getDataTable(list);
    }

    /**
     * 导出导入MES炉次列表
     */
    @PreAuthorize("@ss.hasPermi('system:mesluci:export')")
    @Log(title = "导入MES炉次", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesLuci mesLuci)
    {
        List<MesLuci> list = mesLuciService.selectMesLuciList(mesLuci);
        ExcelUtil<MesLuci> util = new ExcelUtil<MesLuci>(MesLuci.class);
        return util.exportExcel(list, "导入MES炉次数据");
    }

    /**
     * 获取导入MES炉次详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:mesluci:query')")
    @GetMapping(value = "/{gongxu}")
    public AjaxResult getInfo(@PathVariable("gongxu") String gongxu)
    {
        return AjaxResult.success(mesLuciService.selectMesLuciByGongxu(gongxu));
    }

    /**
     * 新增导入MES炉次
     */
    @PreAuthorize("@ss.hasPermi('system:mesluci:add')")
    @Log(title = "导入MES炉次", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesLuci mesLuci)
    {
        return toAjax(mesLuciService.insertMesLuci(mesLuci));
    }

    /**
     * 修改导入MES炉次
     */
    @PreAuthorize("@ss.hasPermi('system:mesluci:edit')")
    @Log(title = "导入MES炉次", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesLuci mesLuci)
    {
        return toAjax(mesLuciService.updateMesLuci(mesLuci));
    }

    /**
     * 删除导入MES炉次
     */
    @PreAuthorize("@ss.hasPermi('system:mesluci:remove')")
    @Log(title = "导入MES炉次", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gongxus}")
    public AjaxResult remove(@PathVariable String[] gongxus)
    {
        return toAjax(mesLuciService.deleteMesLuciByGongxus(gongxus));
    }
}
