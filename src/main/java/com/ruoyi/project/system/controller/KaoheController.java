package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.system.domain.SysDept;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.ISysDeptService;
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
import com.ruoyi.project.system.domain.Kaohe;
import com.ruoyi.project.system.service.IKaoheService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 考核单Controller
 *
 * @author ruoyi
 * @date 2021-04-08
 */
@RestController
@RequestMapping("/system/kaohe")
public class KaoheController extends BaseController
{
    @Autowired
    private IKaoheService kaoheService;
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询考核单列表
     */
    @PreAuthorize("@ss.hasPermi('system:kaohe:list')")
    @GetMapping("/list")
    public TableDataInfo list(Kaohe kaohe)
    {
        startPage();

        List<Kaohe> list = kaoheService.selectKaoheList(kaohe);
        return getDataTable(list);
    }

    /**
     * 获取用户列表（本车间）
     */
    @GetMapping("/myList_user")
    public TableDataInfo myList_user(SysUser user)
    {
        String khAccount=SecurityUtils.getUsername();
        SysUser khUser=userService.selectUserByUserName(khAccount);
        user.setDeptId(khUser.getDeptId());
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 获取用户列表（炼钢厂）
     */
    @GetMapping("/lgList_user")
    public TableDataInfo lgList_user(SysUser user)
    {
        startPage();

        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 获取用户列表（外方）
     */
    @GetMapping("/wfList_user")
    public TableDataInfo wfList_user(SysUser user)
    {
        startPage();
        if(user.getDeptId()==null){
            long deptId=102L;
            user.setDeptId(deptId);
        }
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    /**
     * 获取所有部门，填充下拉菜单数据
     */

    @GetMapping("/info_dept")
    public AjaxResult info_dept()
    {
        AjaxResult ajax = AjaxResult.success();
        SysDept dept=new SysDept();
        List<SysDept> depts = deptService.selectDeptList(dept);
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext())
        {
            SysDept d = (SysDept) it.next();
            if (d.getDeptId().intValue() <103  )
            {
                it.remove();
            }
        }
        ajax.put("dept", depts);
        return ajax;
    }

    /**
     * 获取炼钢厂部门下拉树列表
     */
    @GetMapping("/treeSelectLg_dept")
    public AjaxResult treeSelectLg_dept(SysDept dept)
    {
        List<SysDept> depts = deptService.selectDeptList(dept);
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext())
        {
            SysDept d = (SysDept) it.next();
            if (d.getDeptId().intValue() !=101 && d.getParentId()!=101)
            {
                it.remove();
            }
        }
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }

    /**
     * 获取外方部门下拉树列表
     */
    @GetMapping("/treeSelectWf_dept")
    public AjaxResult treeSelectWf(SysDept dept)
    {
        List<SysDept> depts = deptService.selectDeptList(dept);
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext())
        {
            SysDept d = (SysDept) it.next();
            if (d.getDeptId().intValue() !=102 && d.getParentId()!=102)
            {
                it.remove();
            }
        }
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }

    @GetMapping("/myList")
    public TableDataInfo myList(Kaohe kaohe)
    {
        startPage();
        /** 添加当前日期* */
        String logDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        kaohe.setLogtime(logDate);
        /** 添加考评人账号* */
        String khAccount=SecurityUtils.getUsername();
        kaohe.setLeaderaccount(khAccount);

        List<Kaohe> list = kaoheService.selectKaoheList(kaohe);
        return getDataTable(list);
    }
    /**
     * 供外部服务使用
     * **/
    @GetMapping("/api/KaoHelist")
    public TableDataInfo KaoHelist(Kaohe kaohe)
    {

        startPage();
        List<Kaohe> list = kaoheService.selectKaoheList(kaohe);
        return getDataTable(list);
    }

    /**
     * 供外部服务使用，获取考核单详细信息
     */
    @GetMapping(value = "/api/GetInfoById/{kaoheId}")
    public AjaxResult GetInfoById(@PathVariable("kaoheId") Long kaoheId)
    {
        return AjaxResult.success(kaoheService.selectKaoheById(kaoheId));
    }

    /**
     * 导出考核单列表
     */
    @PreAuthorize("@ss.hasPermi('system:kaohe:export')")
    @Log(title = "考核单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Kaohe kaohe)
    {
        List<Kaohe> list = kaoheService.selectKaoheList(kaohe);
        ExcelUtil<Kaohe> util = new ExcelUtil<Kaohe>(Kaohe.class);
        return util.exportExcel(list, "kaohe");
    }

    /**
     * 获取考核单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:kaohe:query')")
    @GetMapping(value = "/{kaoheId}")
    public AjaxResult getInfo(@PathVariable("kaoheId") Long kaoheId)
    {
        return AjaxResult.success(kaoheService.selectKaoheById(kaoheId));
    }

    /**
     * 新增考核单
     */
    @PreAuthorize("@ss.hasPermi('system:kaohe:add')")
    @Log(title = "考核单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Kaohe kaohe)
    {
        if (kaohe.getUseraccount() == null ||"".equals(kaohe.getUseraccount()))
        {
            return AjaxResult.error("被考核人不能为空，请选择被考核人！","错误！");
        }
        //增加考核单时，添加考核人编码，姓名，单位
        String khAccount=SecurityUtils.getUsername();
        kaohe.setLeaderaccount(khAccount);
        SysUser khUser=userService.selectUserByUserName(khAccount);
        kaohe.setLeadername(khUser.getNickName());
        kaohe.setLeaderdept(khUser.getDept().getDeptName());
        /** 添加当前日期* */
        String logDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        kaohe.setLogtime(logDate);
        /** 考核属性 0 科室考评 1 内部考评  2 相关方考评 */
        /**     kaohe.setkhType("科室考评"); **/
        return toAjax(kaoheService.insertKaohe(kaohe));
    }



    /**
     * 修改考核单
     */
    @PreAuthorize("@ss.hasPermi('system:kaohe:edit')")
    @Log(title = "考核单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Kaohe kaohe)
    {
        return toAjax(kaoheService.updateKaohe(kaohe));
    }

    /**
     * 删除考核单
     */

    @Log(title = "考核单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{kaoheIds}")
    public AjaxResult remove(@PathVariable Long[] kaoheIds)
    {
        return toAjax(kaoheService.deleteKaoheByIds(kaoheIds));
    }
}
