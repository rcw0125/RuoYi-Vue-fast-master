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
import com.ruoyi.project.system.domain.MesMingzhongmingxi;
import com.ruoyi.project.system.service.IMesMingzhongmingxiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 成分命中明细Controller
 *
 * @author ruoyi
 * @date 2022-05-23
 */
@RestController
@RequestMapping("/system/mingzhongmingxi")
public class MesMingzhongmingxiController extends BaseController
{
    @Autowired
    private IMesMingzhongmingxiService mesMingzhongmingxiService;

    /**
     * 查询成分命中明细列表
     */

    @GetMapping("/list")
    public TableDataInfo list(MesMingzhongmingxi mesMingzhongmingxi)
    {
        startPage();
        List<MesMingzhongmingxi> list = mesMingzhongmingxiService.selectMesMingzhongmingxiList(mesMingzhongmingxi);
        return getDataTable(list);
    }

    /**
     * 导出成分命中明细列表
     */

    @Log(title = "成分命中明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesMingzhongmingxi mesMingzhongmingxi)
    {
        List<MesMingzhongmingxi> list = mesMingzhongmingxiService.selectMesMingzhongmingxiList(mesMingzhongmingxi);
        ExcelUtil<MesMingzhongmingxi> util = new ExcelUtil<MesMingzhongmingxi>(MesMingzhongmingxi.class);
        return util.exportExcel(list, "成分命中明细数据");
    }

    /**
     * 获取成分命中明细详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mesMingzhongmingxiService.selectMesMingzhongmingxiById(id));
    }

    /**
     * 新增成分命中明细
     */

    @Log(title = "成分命中明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesMingzhongmingxi mesMingzhongmingxi)
    {
        return toAjax(mesMingzhongmingxiService.insertMesMingzhongmingxi(mesMingzhongmingxi));
    }

    /**
     * 修改成分命中明细
     */

    @Log(title = "成分命中明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesMingzhongmingxi mesMingzhongmingxi)
    {
        return toAjax(mesMingzhongmingxiService.updateMesMingzhongmingxi(mesMingzhongmingxi));
    }

    /**
     * 删除成分命中明细
     */

    @Log(title = "成分命中明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesMingzhongmingxiService.deleteMesMingzhongmingxiByIds(ids));
    }
}
