package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.ISysUserService;
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
import com.ruoyi.project.system.domain.SysCarInfo;
import com.ruoyi.project.system.service.ISysCarInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用车台账Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@RestController
@RequestMapping("/system/carinfo")
public class SysCarInfoController extends BaseController
{
    @Autowired
    private ISysCarInfoService sysCarInfoService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询用车台账列表
     */
    @PreAuthorize("@ss.hasPermi('system:carinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCarInfo sysCarInfo)
    {
        startPage();
        List<SysCarInfo> list = sysCarInfoService.selectSysCarInfoList(sysCarInfo);
        return getDataTable(list);
    }

    @GetMapping("/myList")
    public TableDataInfo myList(SysCarInfo sysCarInfo)
    {
        /** 记录用人单位，和录入人**/
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        sysCarInfo.setLogren(checkUser.getNickName());
        /** 添加当前日期* */
        String logDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        sysCarInfo.setTimespan(logDate);
        startPage();
        List<SysCarInfo> list = sysCarInfoService.selectSysCarInfoList(sysCarInfo);
        return getDataTable(list);
    }

    /**
     * 导出用车台账列表
     */
    @PreAuthorize("@ss.hasPermi('system:carinfo:export')")
    @Log(title = "用车台账", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCarInfo sysCarInfo)
    {
        List<SysCarInfo> list = sysCarInfoService.selectSysCarInfoList(sysCarInfo);
        ExcelUtil<SysCarInfo> util = new ExcelUtil<SysCarInfo>(SysCarInfo.class);
        return util.exportExcel(list, "carinfo");
    }

    /**
     * 获取用车台账详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:carinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysCarInfoService.selectSysCarInfoById(id));
    }

    /**
     * 新增用车台账
     */
    @PreAuthorize("@ss.hasPermi('system:carinfo:add')")
    @Log(title = "用车台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCarInfo sysCarInfo)
    {
        /** 记录用人单位，和录入人**/
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        sysCarInfo.setLogren(checkUser.getNickName());
        sysCarInfo.setDept(checkUser.getDept().getDeptName());
        /** 添加当前日期* */
        String logDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        sysCarInfo.setTimespan(logDate);
        return toAjax(sysCarInfoService.insertSysCarInfo(sysCarInfo));
    }

    /**
     * 修改用车台账
     */
    @PreAuthorize("@ss.hasPermi('system:carinfo:edit')")
    @Log(title = "用车台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCarInfo sysCarInfo)
    {
        return toAjax(sysCarInfoService.updateSysCarInfo(sysCarInfo));
    }

    /**
     * 删除用车台账
     */

    @Log(title = "用车台账", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysCarInfoService.deleteSysCarInfoByIds(ids));
    }
}
