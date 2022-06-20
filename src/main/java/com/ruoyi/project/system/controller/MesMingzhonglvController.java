package com.ruoyi.project.system.controller;

import java.text.DecimalFormat;
import java.util.List;

import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.project.system.domain.MesMingzhonglv;
import com.ruoyi.project.system.service.IMesMingzhonglvService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 成分命中率Controller
 *
 * @author ruoyi
 * @date 2022-05-23
 */
@RestController
@RequestMapping("/system/mingzhonglv")
public class MesMingzhonglvController extends BaseController
{
    @Autowired
    private IMesMingzhonglvService mesMingzhonglvService;

    /**
     * 查询成分命中率列表
     */

    @GetMapping("/list")
    public TableDataInfo list(MesMingzhonglv mesMingzhonglv)
    {
        startPage();
        List<MesMingzhonglv> list = mesMingzhonglvService.selectMesMingzhonglvList(mesMingzhonglv);


        return getDataTable(list);
    }

    /**
     * 导出成分命中率列表
     */

    @Log(title = "成分命中率", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesMingzhonglv mesMingzhonglv)
    {
        List<MesMingzhonglv> list = mesMingzhonglvService.selectMesMingzhonglvList(mesMingzhonglv);
        ExcelUtil<MesMingzhonglv> util = new ExcelUtil<MesMingzhonglv>(MesMingzhonglv.class);
        return util.exportExcel(list, "成分命中率数据");
    }

    /**
     * 获取成分命中率详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mesMingzhonglvService.selectMesMingzhonglvById(id));
    }

    /**
     * 新增成分命中率
     */

    @Log(title = "成分命中率", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesMingzhonglv mesMingzhonglv)
    {
        return toAjax(mesMingzhonglvService.insertMesMingzhonglv(mesMingzhonglv));
    }

    /**
     * 修改成分命中率
     */

    @Log(title = "成分命中率", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesMingzhonglv mesMingzhonglv)
    {
        return toAjax(mesMingzhonglvService.updateMesMingzhonglv(mesMingzhonglv));
    }

    /**
     * 删除成分命中率
     */

    @Log(title = "成分命中率", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesMingzhonglvService.deleteMesMingzhonglvByIds(ids));
    }
}
