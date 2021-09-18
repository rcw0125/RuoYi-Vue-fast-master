package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.project.system.domain.SysPost;
import com.ruoyi.project.system.service.ISysPostService;
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
import com.ruoyi.project.system.domain.Daynotecfg;
import com.ruoyi.project.system.service.IDaynotecfgService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 工作日志模板Controller
 *
 * @author ruoyi
 * @date 2021-06-22
 */
@RestController
@RequestMapping("/system/daynotecfg")
public class DaynotecfgController extends BaseController
{
    @Autowired
    private IDaynotecfgService daynotecfgService;
    @Autowired
    private ISysPostService postService;
    /**
     * 查询工作日志模板列表
     */
    @PreAuthorize("@ss.hasPermi('system:daynotecfg:list')")
    @GetMapping("/list")
    public TableDataInfo list(Daynotecfg daynotecfg)
    {
        startPage();
        List<Daynotecfg> list = daynotecfgService.selectDaynotecfgList(daynotecfg);
        return getDataTable(list);
    }

    /**
     * 获取所有岗位，填充下拉菜单数据
     */

    @GetMapping("/info_post")
    public AjaxResult info_post()
    {
        AjaxResult ajax = AjaxResult.success();
        SysPost post=new SysPost();
        List<SysPost> list = postService.selectPostList(post);
        ajax.put("post", list);
        return ajax;
    }

    /**
     * 获取部门下所有岗位，填充下拉菜单数据
     */
    @GetMapping("/getPostInfo")
    public AjaxResult getPostInfo(String dept)
    {
        AjaxResult ajax = AjaxResult.success();
        Daynotecfg daynotecfg=new Daynotecfg();
        daynotecfg.setDept(dept);
        List<Daynotecfg> list = daynotecfgService.selectDaynotecfgList(daynotecfg);
        ajax.put("noteCfg", list);
        return ajax;
    }

    /**
     * 导出工作日志模板列表
     */
    @PreAuthorize("@ss.hasPermi('system:daynotecfg:export')")
    @Log(title = "工作日志模板", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Daynotecfg daynotecfg)
    {
        List<Daynotecfg> list = daynotecfgService.selectDaynotecfgList(daynotecfg);
        ExcelUtil<Daynotecfg> util = new ExcelUtil<Daynotecfg>(Daynotecfg.class);
        return util.exportExcel(list, "daynotecfg");
    }

    /**
     * 获取工作日志模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:daynotecfg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(daynotecfgService.selectDaynotecfgById(id));
    }

    /**
     * 新增工作日志模板
     */
    @PreAuthorize("@ss.hasPermi('system:daynotecfg:add')")
    @Log(title = "工作日志模板", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Daynotecfg daynotecfg)
    {
        return toAjax(daynotecfgService.insertDaynotecfg(daynotecfg));
    }

    /**
     * 修改工作日志模板
     */
    @PreAuthorize("@ss.hasPermi('system:daynotecfg:edit')")
    @Log(title = "工作日志模板", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Daynotecfg daynotecfg)
    {
        return toAjax(daynotecfgService.updateDaynotecfg(daynotecfg));
    }

    /**
     * 删除工作日志模板
     */
    @PreAuthorize("@ss.hasPermi('system:daynotecfg:remove')")
    @Log(title = "工作日志模板", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(daynotecfgService.deleteDaynotecfgByIds(ids));
    }
}
