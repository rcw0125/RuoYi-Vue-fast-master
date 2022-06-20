package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.project.system.domain.Bzhjc;
import com.ruoyi.project.system.service.IBzhjcService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 标准化检查Controller
 *
 * @author ruoyi
 * @date 2021-04-13
 */
@RestController
@RequestMapping("/system/bzhjc")
public class BzhjcController extends BaseController
{
    @Autowired
    private IBzhjcService bzhjcService;
    @Autowired
    private ISysUserService userService;

    /**
     * 查询标准化检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:bzhjc:list')")
    @GetMapping("/list")
    public TableDataInfo list(Bzhjc bzhjc)
    {
        startPage();
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        return getDataTable(list);
    }

    /**
     * 供外部服务使用
     * **/
    @GetMapping("/api/BzhList")
    public TableDataInfo BzhList(Bzhjc bzhjc)
    {
        startPage();
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        return getDataTable(list);
    }

    /**
     * 供外部服务使用
     * **/
    @GetMapping(value = "/api/GetInfoById/{id}")
    public AjaxResult GetInfoById(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bzhjcService.selectBzhjcById(id));
    }

    /**
     * 查询需要整改回复列表--需要车间整改回复
     */
    @GetMapping("/getReplyList")
    public TableDataInfo getReplyList(Bzhjc bzhjc)
    {

        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        bzhjc.setModdept(checkUser.getDept().getDeptName());
        bzhjc.setStatus("等待处理");
        startPage();
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        return getDataTable(list);
    }

    /**
     * 查询需要整改回复列表--需要车间整改回复
     */
    @GetMapping("/getPmdlReplyList")
    public TableDataInfo getPmdlReplyList(Bzhjc bzhjc)
    {

        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        bzhjc.setModdept(checkUser.getDept().getDeptName());
        bzhjc.setStatus("等待处理");
        bzhjc.setCheckprop("跑冒滴漏");
        startPage();
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        return getDataTable(list);
    }

    /**
     * 查询需要验证列表--需要检查人验证
     */
    @GetMapping("/getConfirmList")
    public TableDataInfo getConfirmList(Bzhjc bzhjc)
    {
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        bzhjc.setCheckperson(checkUser.getNickName());
        bzhjc.setStatus("等待验证");
        startPage();
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        return getDataTable(list);
    }

    /**
     * 查询需要验证列表--需要检查人验证
     */
    @GetMapping("/getPmdlConfirmList")
    public TableDataInfo getPmdlConfirmList(Bzhjc bzhjc)
    {
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        bzhjc.setCheckperson(checkUser.getNickName());
        bzhjc.setStatus("等待验证");
        bzhjc.setCheckprop("跑冒滴漏");
        startPage();
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        return getDataTable(list);
    }



    /**
     * 导出标准化检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:bzhjc:export')")
    @Log(title = "标准化检查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Bzhjc bzhjc)
    {
        List<Bzhjc> list = bzhjcService.selectBzhjcList(bzhjc);
        ExcelUtil<Bzhjc> util = new ExcelUtil<Bzhjc>(Bzhjc.class);
        return util.exportExcel(list, "bzhjc");
    }

    /**
     * 获取标准化检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bzhjc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bzhjcService.selectBzhjcById(id));
    }

    /**
     * 获取标准化检查-----整改详细信息
     */

    @GetMapping(value = "/getReplyInfo/{id}")
    public AjaxResult getReplyInfo(@PathVariable("id") Long id)
    {
         Bzhjc bzhjc= bzhjcService.selectBzhjcById(id);
         if(!bzhjc.getStatus().equals("等待处理")){
             return AjaxResult.error("此检查单已处理，请选择其他未处理检查单！","错误！");
         }
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        if(!checkUser.getDept().getDeptName().equals(bzhjc.getModdept())){
            return AjaxResult.error("你不在所属整改车间！","错误！");
        }
        return AjaxResult.success(bzhjcService.selectBzhjcById(id));
    }

    @GetMapping(value = "/getConfirmInfo/{id}")
    public AjaxResult getConfirmInfo(@PathVariable("id") Long id)
    {
        Bzhjc bzhjc= bzhjcService.selectBzhjcById(id);
        if(!bzhjc.getStatus().equals("等待验证")){
            return AjaxResult.error("此检查单不是等待验证状态！","错误！");
        }
        String confirmAccount= SecurityUtils.getUsername();
        if(!confirmAccount.equals(bzhjc.getCheckaccount())){
            return AjaxResult.error("你不是检查人！","错误！");
        }
        return AjaxResult.success(bzhjcService.selectBzhjcById(id));
    }

    /**
     * 新增标准化检查
     */
    @PreAuthorize("@ss.hasPermi('system:bzhjc:add')")
    @Log(title = "标准化检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Bzhjc bzhjc)
    {
        /** 增加标准化检查单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        bzhjc.setCheckaccount(checkAccount);
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        /** 增加标准化检查单据时，先查询检查人开过的检查单据未被处理的有多少项，如果大于10项，则请先督促整改单位整改；然后查询自己未验证的检查单据，如果大于2项，则请先验证 */
        /*******属性为安全的，不进行检查*****/
        if(!(bzhjc.getCheckprop().equals("安全")||bzhjc.getCheckprop().equals("跑冒滴漏"))){
            Bzhjc bzh=new  Bzhjc();
            bzh.setCheckperson(checkUser.getNickName());
            bzh.setStatus("等待处理");
            List<Bzhjc> list = bzhjcService.selectBzhjcList(bzh);
            if(checkUser.getDept().getDeptName().contains("车间")){
                if(list.size()>9){
                    return AjaxResult.error("未被处理的单据大于10项，请先督促整改单位整改！","错误！");
                }
            }else{
                if(list.size()>19){
                    return AjaxResult.error("未被处理的单据大于20项，请先督促整改单位整改！","错误！");
                }
            }
            bzh.setStatus("等待验证");
            list = bzhjcService.selectBzhjcList(bzh);
            if(list.size()>2){
                return AjaxResult.error("未验证的检查单大于2项，请先验证 ！","错误！");
            }


            Bzhjc bzh1=new  Bzhjc();
            bzh1.setModdept(checkUser.getDept().getDeptName());
            bzh1.setStatus("等待处理");
            list = bzhjcService.selectBzhjcList(bzh1);

            if(checkUser.getDept().getDeptName().contains("车间")){
                if(list.size()>39){
                    return AjaxResult.error("所在单位未整改的单据超过40项，请先整改！","错误！");
                }
            }else{
                if(list.size()>9){
                    return AjaxResult.error("所在单位未整改的单据超过10项，请先整改！","错误！");
                }
            }
        }


        bzhjc.setCheckperson(checkUser.getNickName());
        bzhjc.setCheckdept(checkUser.getDept().getDeptName());
        /**  如果所属单位是车间，则设置整改单位是本车间 */
        if(checkUser.getDept().getDeptName().contains("车间")){
            /**  不是跑冒滴漏时，只能开给自己车间 */
            if(!bzhjc.getCheckprop().equals("跑冒滴漏")){
                bzhjc.setModdept(checkUser.getDept().getDeptName());
            }else{
                /**  当是跑冒滴漏时，如果整改时间为空，则报错*/
                if(StringUtils.isNull(bzhjc.getModdept())||StringUtils.isEmpty(bzhjc.getModdept())){
                    return AjaxResult.error("整改单位不能为空，请选择整改单位！","错误！");
                }
            }
        }
        else{
            if (bzhjc.getModdept() == null ||"".equals(bzhjc.getModdept()))
            {
                return AjaxResult.error("整改单位不能为空，请选择整改单位！","错误！");
            }
        }
        return toAjax(bzhjcService.insertBzhjc(bzhjc));
    }

    /**
     * 修改标准化检查
     */
    @PreAuthorize("@ss.hasPermi('system:bzhjc:edit')")
    @Log(title = "标准化检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Bzhjc bzhjc)
    {
//        if(!bzhjc.getStatus().equals("等待处理")){
//            return AjaxResult.error("此检查单已处理，不允许修改！","错误！");
//        }
      //  String checkAccount= SecurityUtils.getUsername();
//        if(!bzhjc.getCheckaccount().equals(checkAccount)){
//            return AjaxResult.error("你不是检查人，不允许修改！","错误！");
//        }

        return toAjax(bzhjcService.updateBzhjc(bzhjc));
    }

   // @Log(title = "标准化检查整改回复", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/reply")
    public AjaxResult reply(@RequestBody Bzhjc bzhjc)
    {
        bzhjc.setStatus("等待验证");
        String replayAccount= SecurityUtils.getUsername();
        bzhjc.setModperson(replayAccount);
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        bzhjc.setModdonedate(doneDate);
        return toAjax(bzhjcService.updateBzhjc(bzhjc));
    }

//    @Log(title = "标准化检查验证", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/confirm")
    public AjaxResult confirm(@RequestBody Bzhjc bzhjc)
    {
        bzhjc.setStatus("验证完成");
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        bzhjc.setConfirmdate(doneDate);
        return toAjax(bzhjcService.updateBzhjc(bzhjc));
    }


    /**
     * 删除标准化检查
     */
    @PreAuthorize("@ss.hasPermi('system:bzhjc:remove')")
    @Log(title = "标准化检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhjcService.deleteBzhjcByIds(ids));
    }
}
