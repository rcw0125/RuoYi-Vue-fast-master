package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.framework.security.service.TokenService;
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
import com.ruoyi.project.system.domain.Zhibiaocfg;
import com.ruoyi.project.system.service.IZhibiaocfgService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 指标配置Controller
 *
 * @author ruoyi
 * @date 2021-04-15
 */
@RestController
@RequestMapping("/system/zhibiaocfg")
public class ZhibiaocfgController extends BaseController
{
    @Autowired
    private IZhibiaocfgService zhibiaocfgService;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询指标配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiaocfg:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zhibiaocfg zhibiaocfg)
    {
        startPage();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        /** 是否是管理员账号 */
        if (StringUtils.isNotNull(loginUser.getUser()) && !loginUser.getUser().isAdmin())
        {
            zhibiaocfg.setDept(loginUser.getUser().getDept().getDeptName());
        }
        List<Zhibiaocfg> list = zhibiaocfgService.selectZhibiaocfgList(zhibiaocfg);
        return getDataTable(list);
    }

    /**
     * 导出指标配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiaocfg:export')")
    @Log(title = "指标配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Zhibiaocfg zhibiaocfg)
    {
        List<Zhibiaocfg> list = zhibiaocfgService.selectZhibiaocfgList(zhibiaocfg);
        ExcelUtil<Zhibiaocfg> util = new ExcelUtil<Zhibiaocfg>(Zhibiaocfg.class);
        return util.exportExcel(list, "zhibiaocfg");
    }

    /**
     * 获取指标配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiaocfg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {

        return AjaxResult.success(zhibiaocfgService.selectZhibiaocfgById(id));
    }

    /**
     * 新增指标配置
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiaocfg:add')")
    @Log(title = "指标配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zhibiaocfg zhibiaocfg)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        /** 是否是管理员账号 */
        if (StringUtils.isNotNull(loginUser.getUser()) && !loginUser.getUser().isAdmin())
        {
            /** 选择的单位与你所在单位是否相同 */
             if(!loginUser.getUser().getDept().getDeptName().equals(zhibiaocfg.getDept()))
             {
                 return AjaxResult.error("选择的单位与你所在单位不相同！","错误！");
             }
        }
        return toAjax(zhibiaocfgService.insertZhibiaocfg(zhibiaocfg));
    }

    /**
     * 修改指标配置
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiaocfg:edit')")
    @Log(title = "指标配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zhibiaocfg zhibiaocfg)
    {
        return toAjax(zhibiaocfgService.updateZhibiaocfg(zhibiaocfg));
    }

    /**
     * g根据部门查询所有指标
     */

    @GetMapping("/info")
    public AjaxResult info(String dept)
    {
        AjaxResult ajax = AjaxResult.success();
        Zhibiaocfg zhibiaocfg=new Zhibiaocfg();
        zhibiaocfg.setDept(dept);
        ajax.put("dept", zhibiaocfgService.selectZhibiaocfgList(zhibiaocfg));
        return ajax;
    }

    /**
     * g根据部门查询所有指标,外部接口
     */

    @GetMapping("/api/GetInfo")
    public AjaxResult GetInfo(String dept)
    {
        AjaxResult ajax = AjaxResult.success();
        /**
         * 外部接口
         * */
        Zhibiaocfg zhibiaocfg=new Zhibiaocfg();
        zhibiaocfg.setDept(dept);
        ajax.put("dept", zhibiaocfgService.selectZhibiaocfgList(zhibiaocfg));
        return ajax;
    }

    /**
     * 删除指标配置
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiaocfg:remove')")
    @Log(title = "指标配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhibiaocfgService.deleteZhibiaocfgByIds(ids));
    }
}
