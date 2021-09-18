package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.system.domain.Daynotecfg;
import com.ruoyi.project.system.domain.SysPost;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.IDaynotecfgService;
import com.ruoyi.project.system.service.ISysPostService;
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
import com.ruoyi.project.system.domain.Daynote;
import com.ruoyi.project.system.service.IDaynoteService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 工作日志Controller
 *
 * @author ruoyi
 * @date 2021-06-23
 */
@RestController
@RequestMapping("/system/daynote")
public class DaynoteController extends BaseController
{
    @Autowired
    private IDaynoteService daynoteService;
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private IDaynotecfgService daynotecfgService;
    /**
     * 查询工作日志列表
     */
    @PreAuthorize("@ss.hasPermi('system:daynote:list')")
    @GetMapping("/list")
    public TableDataInfo list(Daynote daynote)
    {
        startPage();
        List<Daynote> list = daynoteService.selectDaynoteList(daynote);
        return getDataTable(list);
    }

    /**
     * 查询相同单位、相同岗位正在录入的工作日志列表
     */
    @GetMapping("/samePostList")
    public TableDataInfo samePostList()
    {

        /** 获取当前用户的岗位，并根据岗位查询对应的模板信息**/
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        List<Integer> listpost= postService.selectPostListByUserId(checkUser.getUserId());
        /** 判断是否有岗位,没有岗位则返回空**/
        if(listpost==null || listpost.size()==0){

            return null;
        }
        /** 根据第一个岗位的编号，获取该岗位**/
        SysPost syspost= postService.selectPostById(listpost.get(0).longValue());
        /** 判断是否还存在未交班的工作日志，同一单位、同一岗位，四班岗位：相同岗位；白班人员就是自己**/
        Daynote daynote=new Daynote();
        daynote.setDept(checkUser.getDept().getDeptName());
        daynote.setPost(syspost.getPostName());
        daynote.setStatus("正在录入");
        if(checkUser.getTeam().equals("白班")){
            daynote.setName(checkUser.getNickName());
        }

        startPage();
        List<Daynote> list = daynoteService.selectDaynoteList(daynote);
        return getDataTable(list);
    }

    /**
     * 导出工作日志列表
     */
    @PreAuthorize("@ss.hasPermi('system:daynote:export')")
    @Log(title = "工作日志", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Daynote daynote)
    {
        List<Daynote> list = daynoteService.selectDaynoteList(daynote);
        ExcelUtil<Daynote> util = new ExcelUtil<Daynote>(Daynote.class);
        return util.exportExcel(list, "daynote");
    }

    /**
     * 获取工作日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:daynote:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(daynoteService.selectDaynoteById(id));
    }

    @GetMapping(value = "/getCfg")
    public AjaxResult getCfg()
    {

        /** 获取当前用户的岗位，并根据岗位查询对应的模板信息**/
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);

        List<Integer> listpost= postService.selectPostListByUserId(checkUser.getUserId());

        /** 判断是否有岗位**/
        if(listpost==null || listpost.size()==0){
            return AjaxResult.error("系统中，你没有岗位，请联系管理员！","错误！");
        }
        /** 根据第一个岗位的编号，获取该岗位**/
        SysPost syspost= postService.selectPostById(listpost.get(0).longValue());

        Daynotecfg  daynotecfg=new Daynotecfg();
        /** 根据部门和岗位来查询是否有相应的日志**/
        daynotecfg.setDept(checkUser.getDept().getDeptName());
        daynotecfg.setCode(syspost.getPostName());
        List<Daynotecfg> listcfg = daynotecfgService.selectDaynotecfgList(daynotecfg);
        if(listcfg==null ||listcfg.size()==0){
            return AjaxResult.error("系统中，你所在岗位没有工作日志模板，请联系管理员！","错误！");
        }
        /** 根据第一个模板，设置到工作日志**/
        Daynote daynote=new Daynote();
        daynote.setNote(listcfg.get(0).getNote());
        daynote.setTeam(checkUser.getTeam());
        daynote.setPost(syspost.getPostName());
        daynote.setDept(checkUser.getDept().getDeptName());
        /*** 设置日期为当前日期**/
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        daynote.setLogtime(doneDate);
        return AjaxResult.success(daynote);
    }

    /**
     * 新增工作日志
     */
    @PreAuthorize("@ss.hasPermi('system:daynote:add')")
    @Log(title = "工作日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Daynote daynote)
    {
        /** 获取当前用户的姓名，设置到日志中*/
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        /** 判断是否还存在未交班的工作日志，四班岗位：相同岗位；白班人员就是自己**/
        Daynote dn= new Daynote();
        dn.setPost(daynote.getPost());
        dn.setDept(checkUser.getDept().getDeptName());
        dn.setStatus("正在录入");
        if(checkUser.getTeam().equals("白班")){
            dn.setName(checkUser.getNickName());
        }
        List<Daynote> list = daynoteService.selectDaynoteList(dn);
        if(list!=null && list.size()>0){
            return AjaxResult.error("系统中，你所在岗位有工作日志还未交班，请先交班！","错误！");
        }

        daynote.setName(checkUser.getNickName());
        daynote.setStatus("正在录入");
        return toAjax(daynoteService.insertDaynote(daynote));
    }

    /**
     * 锁定工作日志详细信息，交班
     */
    @GetMapping("/lockNote/{id}")
    public AjaxResult lockNote(@PathVariable Long id)
    {
        Daynote daynote= daynoteService.selectDaynoteById(id);
        daynote.setStatus("已交班");
        return toAjax(daynoteService.updateDaynote(daynote));
    }
    /**
     * 修改工作日志
     */
    @PreAuthorize("@ss.hasPermi('system:daynote:edit')")
    @Log(title = "工作日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Daynote daynote)
    {
        return toAjax(daynoteService.updateDaynote(daynote));
    }

    /**
     * 删除工作日志
     */
    @PreAuthorize("@ss.hasPermi('system:daynote:remove')")
    @Log(title = "工作日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(daynoteService.deleteDaynoteByIds(ids));
    }
}
