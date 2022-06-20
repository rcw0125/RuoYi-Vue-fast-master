package com.ruoyi.project.system.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.project.system.domain.SysPost;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.ruoyi.project.system.domain.EquipDianjianBiaozhun;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 点检标准Controller
 *
 * @author ruoyi
 * @date 2021-09-22
 */
@RestController
@RequestMapping("/system/equipbiaozhun")
public class EquipDianjianBiaozhunController extends BaseController
{
    @Autowired
    private IEquipDianjianBiaozhunService equipDianjianBiaozhunService;
    @Autowired
    private IEquipQuyuService equipQuyuService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private ISysPostService postService;

    /**
     * 查询点检标准列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);


        return getDataTable(list);
    }

    @GetMapping("/YueMingXiList")
    public TableDataInfo YueMingXiList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectDianjianMingxi(equipDianjianBiaozhun);
        return getDataTable(list);
    }

    @GetMapping("/YueTeamList")
    public TableDataInfo YueTeamList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectDianjianTeamRate(equipDianjianBiaozhun);
        return getDataTable(list);
    }

    @GetMapping("/YueDeptList")
    public TableDataInfo YueDeptList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectDianjianDeptRate(equipDianjianBiaozhun);
        return getDataTable(list);
    }


    @GetMapping("/ZhouMingXiList")
    public TableDataInfo ZhouMingXiList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectZhouDianjianMingxi(equipDianjianBiaozhun);
        return getDataTable(list);
    }

    @GetMapping("/ZhouTeamList")
    public TableDataInfo ZhouTeamList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectZhouDianjianTeamRate(equipDianjianBiaozhun);
        return getDataTable(list);
    }

    @GetMapping("/ZhouDeptList")
    public TableDataInfo ZhouDeptList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectZhouDianjianDeptRate(equipDianjianBiaozhun);
        return getDataTable(list);
    }

    @GetMapping("/notMyDianJianList")
    public TableDataInfo notMyDianJianList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        /** 增加标准化检查单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        /**赋值个人用户名**/
        equipDianjianBiaozhun.setNote(checkAccount);
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        /**赋值个人单位**/
        equipDianjianBiaozhun.setDept(checkUser.getDept().getDeptName());
        /**维检车间赋值个人岗位**/
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectNotMyDianJianList(equipDianjianBiaozhun);
        String deptname=checkUser.getDept().getDeptName();
        if(deptname.equals("维修车间")||deptname.equals("运行车间")){
            /** 设置岗位 */
            String post=userService.selectUserPostGroup(checkUser.getUserName());
            equipDianjianBiaozhun.setTeam(post);
        }
        return getDataTable(list);
    }

    /**
     * 查询我的车间、班组的点检标准列表
     */
    @GetMapping("/myList")
    public TableDataInfo myList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        /** 增加标准化检查单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipDianjianBiaozhun.setDept(checkUser.getDept().getDeptName());
        //equipDianjianBiaozhun.setTeam(checkUser.getTeam());
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
        return getDataTable(list);
    }


    /**
     * 0-班组未点检，1-班组已点检、2-车间点检情况、3-我的点检，共用此方法
     * 查询我的车间、班组的点检标准列表
     *    查询班组未点检，班组已点检时，需要设置岗位即所在班组，查询车间设备点检情况时不需要
     */
    @GetMapping("/myDianJianList")
    public TableDataInfo myDianJianList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        /** 增加标准化检查单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipDianjianBiaozhun.setDept(checkUser.getDept().getDeptName());

        /**0 未点检 1 已点检 2为 我的车间 根据标志，是否是维检车间，设置班组*/
        if(equipDianjianBiaozhun.getFlag().equals(0)||equipDianjianBiaozhun.getFlag().equals(1)){
            String deptname=checkUser.getDept().getDeptName();
            if(deptname.equals("维修车间")||deptname.equals("运行车间")){
                /** 设置岗位 */
                String post=userService.selectUserPostGroup(checkUser.getUserName());
                equipDianjianBiaozhun.setTeam(post);
            }
        }
        /**我的点检、需要设置我的账号**/
        if(equipDianjianBiaozhun.getFlag().equals(3)){
            equipDianjianBiaozhun.setNote(checkAccount);
        }


        startPage();
        List<EquipDianjianBiaozhun> list;

        if(equipDianjianBiaozhun.getFlag().equals(3)){
            //System.out.println("参数flag="+equipDianjianBiaozhun.getFlag()+",参数note="+equipDianjianBiaozhun.getNote());
            list = equipDianjianBiaozhunService.selectMyDianJianList(equipDianjianBiaozhun);

        }else {
            //System.out.println("参数:flag="+equipDianjianBiaozhun.getFlag());
            list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunByQuyuList(equipDianjianBiaozhun);
        }

        Iterator<EquipDianjianBiaozhun> it = list.iterator();
        while (it.hasNext())
        {
            EquipDianjianBiaozhun d = (EquipDianjianBiaozhun) it.next();
            d.setFlag(0);
            d.setRemark("未点检");
            if( d.getZhouqi().equals("每班12小时")){
                /**时间差大于12小时，则必然可以点检**/
                long hour=((new Date()).getTime()- d.getLasttime().getTime())/1000/60/60;
                if(hour<12){
                    SimpleDateFormat sdf = new SimpleDateFormat("HH");//设置日期格式
                    int curHour=Integer.parseInt(sdf.format(new Date()));
                    int lastHour=Integer.parseInt(sdf.format( d.getLasttime()));
                    /*******小时相等******/
                    if(lastHour==curHour){
                        d.setFlag(1);
                        d.setRemark("已点检");
                    }
                    /*******现在大于上一次******/
                    else if(lastHour<curHour){
                        if(curHour<8){
                            d.setFlag(1);
                            d.setRemark("已点检");
                        }
                        else if(lastHour>=20){
                            d.setFlag(1);
                            d.setRemark("已点检");
                        }
                        ////
                        else if(lastHour>=8 && curHour<20){
                            d.setFlag(1);
                            d.setRemark("已点检");
                        }
                    }
                    /*******现在小于上一次，即昨日20点以后点检过******/
                    else {
                        if(curHour<8){
                            d.setFlag(1);
                            d.setRemark("已点检");
                        }
                    }
                }
            }
            else {
                /** 与当前日期是否一样、如果不一样，就可以进行正常点检*/
                String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                if(doneDate.equals(sdf.format( d.getLasttime()))){
                    d.setFlag(1);
                    d.setRemark("已点检");
                }
            }
            /***0 代表班组未点检  1 代表班组已点检**/
            /***当 设备当前状态与查询条件不一致时，则移除**/

            if(equipDianjianBiaozhun.getFlag().equals(0)){
                if(d.getFlag().equals(1)){
                    it.remove();
                }
            }else if(equipDianjianBiaozhun.getFlag().equals(1)){
                if(d.getFlag().equals(0)){
                    it.remove();
                }
            }

        }

        return getDataTable(list);
    }

    /**
     * 导出点检标准列表
     */

    @Log(title = "点检标准", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
        ExcelUtil<EquipDianjianBiaozhun> util = new ExcelUtil<EquipDianjianBiaozhun>(EquipDianjianBiaozhun.class);
        return util.exportExcel(list, "点检标准数据");
    }

    /**
     * 获取点检标准详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:equipbiaozhun:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipDianjianBiaozhunService.selectEquipDianjianBiaozhunById(id));
    }
    // 根据部门查询岗位列表
    @GetMapping(value = "/getPostInfo")
    public AjaxResult getPostInfo( String dept)
    {
        SysPost post=new SysPost();
        if(dept.equals("0")){
            /** 增加标准化检查单据时，添加检查人姓名，单位 */
            String checkAccount= SecurityUtils.getUsername();
            SysUser checkUser=userService.selectUserByUserName(checkAccount);
            post.setRemark(checkUser.getDept().getDeptName());
        }
        else {
            post.setRemark(dept);
        }

        AjaxResult ajax = AjaxResult.success();
        ajax.put("posts", postService.selectPostList(post));
        return ajax;
    }

    /**
     * 新增点检标准
     */
    @PreAuthorize("@ss.hasPermi('system:equipbiaozhun:add')")
    @Log(title = "点检标准", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add( @Validated @RequestBody EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        /** 设置设备名称**/
        equipDianjianBiaozhun.setSbname(equipQuyuService.selectEquipQuyuById(equipDianjianBiaozhun.getSbid()).getName());
        if(StringUtils.isNull(equipDianjianBiaozhun.getDept())||StringUtils.isEmpty(equipDianjianBiaozhun.getDept())){
            /** 增加标准化检查单据时，添加检查人姓名，单位 ,添加标准时，必须选择班组*/
            String checkAccount= SecurityUtils.getUsername();
            SysUser checkUser=userService.selectUserByUserName(checkAccount);
            equipDianjianBiaozhun.setDept(checkUser.getDept().getDeptName());
            //equipDianjianBiaozhun.setTeam(checkUser.getTeam());
        }

        /** 增加每周应点检次数 */
        SysDictData dictData=new SysDictData();
        dictData.setDictType("dianjianzhouqi");
        dictData.setDictLabel(equipDianjianBiaozhun.getZhouqi());
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        if(StringUtils.isNotNull(list)){
            equipDianjianBiaozhun.setZhoucishu(list.get(0).getRemark());
        }

        return toAjax(equipDianjianBiaozhunService.insertEquipDianjianBiaozhun(equipDianjianBiaozhun));
    }

    /**
     * 修改点检标准
     */
    @PreAuthorize("@ss.hasPermi('system:equipbiaozhun:edit')")
    @Log(title = "点检标准", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
//        /** 设置设备名称**/
//        equipDianjianBiaozhun.setSbname(equipQuyuService.selectEquipQuyuById(equipDianjianBiaozhun.getSbid()).getName());
//
      /** 增加每周应点检次数 */
        SysDictData dictData=new SysDictData();
        dictData.setDictType("dianjianzhouqi");
        dictData.setDictLabel(equipDianjianBiaozhun.getZhouqi());
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        equipDianjianBiaozhun.setZhoucishu(list.get(0).getRemark());
        return toAjax(equipDianjianBiaozhunService.updateEquipDianjianBiaozhun(equipDianjianBiaozhun));
    }

    /**
     * 删除点检标准
     */
    @PreAuthorize("@ss.hasPermi('system:equipbiaozhun:remove')")
    @Log(title = "点检标准", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipDianjianBiaozhunService.deleteEquipDianjianBiaozhunByIds(ids));
    }
}
