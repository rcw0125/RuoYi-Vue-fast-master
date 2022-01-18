package com.ruoyi.project.system.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.EquipDianjianBiaozhun;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.IEquipDianjianBiaozhunService;
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
import com.ruoyi.project.system.domain.EquipDianjianList;
import com.ruoyi.project.system.service.IEquipDianjianListService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 点检记录Controller
 *
 * @author ruoyi
 * @date 2021-09-23
 */
@RestController
@RequestMapping("/system/dianjianlist")
public class EquipDianjianListController extends BaseController
{
    @Autowired
    private IEquipDianjianListService equipDianjianListService;
    @Autowired
    private IEquipDianjianBiaozhunService equipDianjianBiaozhunService;
    @Autowired
    private ISysUserService userService;
    /**
     * 查询点检记录列表
     */

    @GetMapping("/list")
    public TableDataInfo list(EquipDianjianList equipDianjianList)
    {
        startPage();
        List<EquipDianjianList> list = equipDianjianListService.selectEquipDianjianListList(equipDianjianList);
        return getDataTable(list);
    }

    /**
     * 导出点检记录列表
     */

    @Log(title = "点检记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipDianjianList equipDianjianList)
    {
        List<EquipDianjianList> list = equipDianjianListService.selectEquipDianjianListList(equipDianjianList);
        ExcelUtil<EquipDianjianList> util = new ExcelUtil<EquipDianjianList>(EquipDianjianList.class);
        return util.exportExcel(list, "点检记录数据");
    }

    /**
     * 获取点检记录详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipDianjianListService.selectEquipDianjianListById(id));
    }
    @GetMapping(value = "/getBzInfo/{id}")
    public AjaxResult getBzInfo(@PathVariable("id") Long id)
    {
        EquipDianjianBiaozhun equipDianjianBiaozhun=new EquipDianjianBiaozhun();
        equipDianjianBiaozhun.setSbid(id);
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipDianjianBiaozhun.setDept(checkUser.getDept().getDeptName());
        String deptname=checkUser.getDept().getDeptName();
        if(deptname.equals("冶炼维修车间")||deptname.equals("连铸维修车间")||deptname.equals("运行车间")){
            /** 设置岗位 */
            String post=userService.selectUserPostGroup(checkUser.getUserName());
            if(StringUtils.isNull(post)||StringUtils.isEmpty(post)){
                return AjaxResult.error("抱歉，系统中你没有分配班组，请联系管理员！","错误！");
            }
            equipDianjianBiaozhun.setTeam(post);
        }


        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
        if(StringUtils.isNull(list)||list.size()<1){
            return AjaxResult.error("抱歉，你所在班组没有此设备的点检标准！","错误！");
        }
        EquipDianjianBiaozhun curBz=list.get(0);
        EquipDianjianList dianJian=new EquipDianjianList();
        dianJian.setFlag(0);

//        /** 1、存在点检标准后，如果周期每班12小时，则进行判断 */
//        EquipDianjianList djLast=new EquipDianjianList();
//        djLast.setDept(checkUser.getDept().getDeptName());
//        djLast.setTeam(post);
//        djLast.setSbid(id);
//        List<EquipDianjianList> lastList = equipDianjianListService.selectLastEquipDianjianList(djLast);
//
//        /** 存在点检记录数据**/
//        if(StringUtils.isNotNull(lastList) &&lastList.size()>0){
//            EquipDianjianList lastJiLu=lastList.get(0);
//            if(curBz.getZhouqi().equals("每班12小时")){
//               /**时间差大于12小时，则必然可以点检**/
//               long hour=((new Date()).getTime()-lastJiLu.getDjtime().getTime())/1000/60/60;
//               if(hour<12){
//                   SimpleDateFormat sdf = new SimpleDateFormat("HH");//设置日期格式
//                   int curHour=Integer.parseInt(sdf.format(new Date()));
//                   int lastHour=Integer.parseInt(sdf.format(lastJiLu.getDjtime()));
//                   /*******小时相等******/
//                   if(lastHour==curHour){
//                       dianJian.setFlag(1);
//                   }
//                   /*******现在大于上一次******/
//                   else if(lastHour<curHour){
//                       if(curHour<8){
//                           dianJian.setFlag(1);
//                       }
//                       else if(lastHour>=20){
//                           dianJian.setFlag(1);
//                       }
//                       ////
//                       else if(lastHour>=8 && curHour<20){
//                           dianJian.setFlag(1);
//                       }
//
//                   }
//                   /*******现在小于上一次，即昨日20点以后点检过******/
//                   else {
//                       if(curHour<8){
//                           dianJian.setFlag(1);
//                       }
//                   }
//
//
//               }
//            }
//            else {
//                /** 与当前日期是否一样、如果不一样，就可以进行正常点检*/
//                String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//                if(doneDate.equals(lastJiLu.getDjrq())){
//                    dianJian.setFlag(1);
//                }
//            }
//            SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH点mm分");//设置日期格式
//         //        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//            dianJian.setNote("上次点检时刻:"+df.format(lastJiLu.getDjtime()));
//        }


        if(curBz.getZhouqi().equals("每班12小时")){
            /**时间差大于12小时，则必然可以点检**/
            long hour=((new Date()).getTime()-curBz.getLasttime().getTime())/1000/60/60;
            if(hour<12){
                SimpleDateFormat sdf = new SimpleDateFormat("HH");//设置日期格式
                int curHour=Integer.parseInt(sdf.format(new Date()));
                int lastHour=Integer.parseInt(sdf.format(curBz.getLasttime()));
                /*******小时相等******/
                if(lastHour==curHour){
                    dianJian.setFlag(1);
                }
                /*******现在大于上一次******/
                else if(lastHour<curHour){
                    if(curHour<8){
                        dianJian.setFlag(1);
                    }
                    else if(lastHour>=20){
                        dianJian.setFlag(1);
                    }
                    ////
                    else if(lastHour>=8 && curHour<20){
                        dianJian.setFlag(1);
                    }
                }
                /*******现在小于上一次，即昨日20点以后点检过******/
                else {
                    if(curHour<8){
                        dianJian.setFlag(1);
                    }
                }
            }
        }
        else {
            /** 与当前日期是否一样、如果不一样，就可以进行正常点检*/
            String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            if(doneDate.equals(sdf.format(curBz.getLasttime()))){
                dianJian.setFlag(1);
            }
        }
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH点mm分");//设置日期格式
        //        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        dianJian.setNote("上次点检时刻:"+df.format(curBz.getLasttime()));

        dianJian.setDjr(checkUser.getNickName());
        dianJian.setSbid(curBz.getSbid());
        dianJian.setSbname(curBz.getSbname());
        dianJian.setBzhid(curBz.getId());
        dianJian.setBiaozhun(curBz.getBiaozhun());
        dianJian.setDept(curBz.getDept());
        dianJian.setTeam(curBz.getTeam());
        dianJian.setZhouqi(curBz.getZhouqi());
        dianJian.setLeibie(curBz.getLeibie());
        dianJian.setZhoucishu(curBz.getZhoucishu());
        dianJian.setDjcontent("");
        return AjaxResult.success(dianJian);
    }




    /**
     * 新增点检记录
     */


    @PostMapping
    public AjaxResult add(@RequestBody EquipDianjianList equipDianjianList)
    {
        /**查询点检标准，更新最近点检时间*/
        EquipDianjianBiaozhun equipDianjianBiaozhun=new EquipDianjianBiaozhun();
        equipDianjianBiaozhun.setSbid(equipDianjianList.getSbid());
        equipDianjianBiaozhun.setDept(equipDianjianList.getDept());
        equipDianjianBiaozhun.setTeam(equipDianjianList.getTeam());
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
        if(StringUtils.isNull(list)||list.size()<1){
            return AjaxResult.error("抱歉，你所在班组没有此设备的点检标准！","错误！");
        }
        EquipDianjianBiaozhun curBz=list.get(0);

        /**新增时，不再判断是否已点检，没必要弄的太精准，复杂*/
//        if("正常".equals(equipDianjianList.getDjresult())){
//            equipDianjianList.setFlag(0);
//            /** 1、查询最新的一条的记录，判断是否允许新增 */
//
//            if(equipDianjianList.getZhouqi().equals("每班12小时")){
//                /**时间差大于12小时，则必然可以点检**/
//                long hour=((new Date()).getTime()-curBz.getLasttime().getTime())/1000/60/60;
//                if(hour<12){
//                    SimpleDateFormat sdf = new SimpleDateFormat("HH");//设置日期格式
//                    int curHour=Integer.parseInt(sdf.format(new Date()));
//                    int lastHour=Integer.parseInt(sdf.format(curBz.getLasttime()));
//                    /*******小时相等******/
//                    if(lastHour==curHour){
//                        equipDianjianList.setFlag(1);
//                    }
//                    /*******现在大于上一次******/
//                    else if(lastHour<curHour){
//                        if(curHour<8){
//                            equipDianjianList.setFlag(1);
//                        }
//                        else if(lastHour>=20){
//                            equipDianjianList.setFlag(1);
//                        }
//                        ////
//                        else if(lastHour>=8 && curHour<20){
//                            equipDianjianList.setFlag(1);
//                        }
//
//                    }
//                    /*******现在小于上一次，即昨日20点以后点检过******/
//                    else {
//                        if(curHour<8){
//                            equipDianjianList.setFlag(1);
//                        }
//                    }
//
//
//                }
//            }
//            else {
//                /** 与当前日期是否一样、如果不一样，就可以进行正常点检*/
//                String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//                if(doneDate.equals(sdf.format(curBz.getLasttime()))){
//                    equipDianjianList.setFlag(1);
//                }
//            }
//
//            if(equipDianjianList.getFlag()==1){
//                return AjaxResult.error("抱歉，该设备的已经被点检！请点检其它设备","错误！");
//            }
//
//        }


        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        equipDianjianList.setDjtime(new Date());
        equipDianjianList.setDjrq(doneDate);
        int result=equipDianjianListService.insertEquipDianjianList(equipDianjianList);
        curBz.setLasttime(new Date());
        int res=equipDianjianBiaozhunService.updateEquipDianjianBiaozhun(curBz);
//        return toAjax(equipDianjianListService.insertEquipDianjianList(equipDianjianList));
        return  toAjax(result);
    }

    /**
     * 修改点检记录
     */

    @PutMapping
    public AjaxResult edit(@RequestBody EquipDianjianList equipDianjianList)
    {
        return toAjax(equipDianjianListService.updateEquipDianjianList(equipDianjianList));
    }

    /**
     * 删除点检记录
     */
    @PreAuthorize("@ss.hasPermi('system:dianjianlist:remove')")
    @Log(title = "点检记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipDianjianListService.deleteEquipDianjianListByIds(ids));
    }
}
