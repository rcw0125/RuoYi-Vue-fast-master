package com.ruoyi.project.system.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.EquipQuyu;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.IEquipQuyuService;
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
import com.ruoyi.project.system.domain.EquipGuzhang;
import com.ruoyi.project.system.service.IEquipGuzhangService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 故障报修Controller
 *
 * @author ruoyi
 * @date 2021-09-27
 */
@RestController
@RequestMapping("/system/guzhang")
public class EquipGuzhangController extends BaseController
{
    @Autowired
    private IEquipGuzhangService equipGuzhangService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private IEquipQuyuService equipQuyuService;
    /**
     * 查询故障报修列表
     */
    @PreAuthorize("@ss.hasPermi('system:guzhang:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipGuzhang equipGuzhang)
    {
        startPage();
        List<EquipGuzhang> list = equipGuzhangService.selectEquipGuzhangList(equipGuzhang);
        return getDataTable(list);
    }


    /**
     * 查询故障报修接收列表
     */
    @GetMapping("/JsList")
    public TableDataInfo JsList(EquipGuzhang equipGuzhang)
    {
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipGuzhang.setDjwxdept(checkUser.getDept().getDeptName());
        equipGuzhang.setStatus("等待接收");
        startPage();
        List<EquipGuzhang> list = equipGuzhangService.selectEquipGuzhangList(equipGuzhang);
        return getDataTable(list);
    }

    /**
     * 查询故障报修处理列表
     */
    @GetMapping("/ClList")
    public TableDataInfo ClList(EquipGuzhang equipGuzhang)
    {
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipGuzhang.setDjwxdept(checkUser.getDept().getDeptName());
        equipGuzhang.setStatus("正在处理");
        startPage();
        List<EquipGuzhang> list = equipGuzhangService.selectEquipGuzhangList(equipGuzhang);
        return getDataTable(list);
    }

    /**
     * 查询故障报修验证列表
     */
    @GetMapping("/YzList")
    public TableDataInfo YzList(EquipGuzhang equipGuzhang)
    {
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipGuzhang.setDjwxdept(checkUser.getDept().getDeptName());
        equipGuzhang.setStatus("等待验证");
        startPage();
        List<EquipGuzhang> list = equipGuzhangService.selectEquipGuzhangList(equipGuzhang);
        return getDataTable(list);
    }

    /**
     * 导出故障报修列表
     */
    @PreAuthorize("@ss.hasPermi('system:guzhang:export')")
    @Log(title = "故障报修", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipGuzhang equipGuzhang)
    {
        List<EquipGuzhang> list = equipGuzhangService.selectEquipGuzhangList(equipGuzhang);
        ExcelUtil<EquipGuzhang> util = new ExcelUtil<EquipGuzhang>(EquipGuzhang.class);
        return util.exportExcel(list, "故障报修数据");
    }

    /**
     * 获取故障报修详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:guzhang:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipGuzhangService.selectEquipGuzhangById(id));
    }

    @GetMapping(value = "/getAddInfoByPhone/{sid}")
    public AjaxResult getAddInfoByPhone(@PathVariable("sid") Long sid)
    {
        EquipGuzhang gzhang=new EquipGuzhang();
        EquipQuyu equip=equipQuyuService.selectEquipQuyuById(sid);
        if(StringUtils.isNull(equip)){
            return AjaxResult.error("抱歉，不存在该设备！","错误！");
        }
        gzhang.setSbname(equip.getName());
        gzhang.setSbid(sid);
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        String deptName=checkUser.getDept().getDeptName();
        gzhang.setDjdept(deptName);
        gzhang.setDjr(checkUser.getNickName());
        gzhang.setDjrphone(checkUser.getPhonenumber());
        if(StringUtils.isEmpty(checkUser.getPhonenumber())||StringUtils.isNull(checkUser.getPhonenumber())){
            return AjaxResult.error("抱歉，你的个人信息不完整，请完善个人电话！","错误！");
        }
        gzhang.setFlag(0);
        if("冶炼维修车间".equals(deptName)||"连铸维修车间".equals(deptName)||"运行车间".equals(deptName)){
            gzhang.setDjwxdept(deptName);
            gzhang.setFlag(1);
        }
        return AjaxResult.success(gzhang);
    }


    @GetMapping(value = "/getAddInfo")
    public AjaxResult getAddInfo()
    {
        EquipGuzhang gzhang=new EquipGuzhang();
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        String deptName=checkUser.getDept().getDeptName();
        gzhang.setDjdept(deptName);
        gzhang.setDjr(checkUser.getNickName());
        gzhang.setDjrphone(checkUser.getPhonenumber());
        if(StringUtils.isEmpty(checkUser.getPhonenumber())||StringUtils.isNull(checkUser.getPhonenumber())){
            return AjaxResult.error("抱歉，你的个人信息不完整，请完善个人电话！","错误！");
        }
        gzhang.setFlag(0);
        if("冶炼维修车间".equals(deptName)||"连铸维修车间".equals(deptName)||"运行车间".equals(deptName)){
            gzhang.setDjwxdept(deptName);
            gzhang.setFlag(1);
        }
        return AjaxResult.success(gzhang);
    }

    /**
     * 新增故障报修
     */
    @PreAuthorize("@ss.hasPermi('system:guzhang:add')")
    @Log(title = "故障报修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipGuzhang equipGuzhang)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipGuzhang.setDjsk(doneDate);
        equipGuzhang.setLocked(0);
        equipGuzhang.setStatus("等待接收");
        /******查询是否存在相同的未完结的故障****/
        EquipGuzhang gzhang=new EquipGuzhang();
        gzhang.setSbid(equipGuzhang.getSbid());
        gzhang.setDjcontent(equipGuzhang.getDjcontent());
        gzhang.setDjdept(equipGuzhang.getDjdept());
        gzhang.setLocked(0);
        List<EquipGuzhang> list = equipGuzhangService.selectEquipGuzhangList(gzhang);
        if(StringUtils.isNotNull(list)&&list.size()>0){
            return AjaxResult.error("抱歉，存在相同的未完结的故障，正在处理中！","错误！");
        }
        equipGuzhang.setSbname(equipQuyuService.selectEquipQuyuById(equipGuzhang.getSbid()).getName());
        return toAjax(equipGuzhangService.insertEquipGuzhang(equipGuzhang));
    }


    /**
     * 更正维修车间
     */

    @PostMapping(value = "/gzDept")
    public AjaxResult gzDept(@RequestBody EquipGuzhang equipGuzhang)
    {
        /**计算用时***/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date djTime;
        try
        {
            /**计算用时(天)***/
            djTime = sdf.parse(equipGuzhang.getDjsk());
            double chaZhi=((new Date()).getTime()-djTime.getTime())*1.0/1000/60/60/24;
           if(chaZhi>1){
               return AjaxResult.error("抱歉，超过24小时，不允许更正维修车间，请联系登记人更正！","错误！");
           }
        }
        catch(Exception e)
        {

        }
        return toAjax(equipGuzhangService.updateEquipGuzhang(equipGuzhang));
    }

    /**
     * 接收故障
     */

    @PostMapping(value = "/accept")
    public AjaxResult accept(@RequestBody EquipGuzhang equipGuzhang)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipGuzhang.setJssk(doneDate);
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipGuzhang.setJsr(checkUser.getNickName());

        equipGuzhang.setStatus("正在处理");
        /**计算用时***/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date djTime;
        try
        {
            /**计算用时(天)***/
            djTime = sdf.parse(equipGuzhang.getDjsk());
            double chaZhi=((new Date()).getTime()-djTime.getTime())*1.0/1000/60/60/24;
            equipGuzhang.setJsys(new BigDecimal(chaZhi));
        }
        catch(Exception e)
        {

        }

        return toAjax(equipGuzhangService.updateEquipGuzhang(equipGuzhang));
    }


    /**
     * 处理故障
     */

    @PostMapping(value = "/reply")
    public AjaxResult reply(@RequestBody EquipGuzhang equipGuzhang)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipGuzhang.setClsk(doneDate);
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipGuzhang.setClr(checkUser.getNickName());
        if(StringUtils.isEmpty(checkUser.getPhonenumber())||StringUtils.isNull(checkUser.getPhonenumber())){
            return AjaxResult.error("抱歉，你的个人信息不完整，请完善个人电话！","错误！");
        }
        equipGuzhang.setClrphone(checkUser.getPhonenumber());
        equipGuzhang.setStatus("等待验证");
        /**计算用时***/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date djTime;
        try
        {
            /**计算用时(天)***/
            djTime = sdf.parse(equipGuzhang.getJssk());
            double chaZhi=((new Date()).getTime()-djTime.getTime())*1.0/1000/60/60/24;
            equipGuzhang.setClys(new BigDecimal(chaZhi));
        }
        catch(Exception e)
        {

        }
        return toAjax(equipGuzhangService.updateEquipGuzhang(equipGuzhang));
    }


    /**
     * 验证故障
     */

    @PostMapping(value = "/confirm")
    public AjaxResult confirm(@RequestBody EquipGuzhang equipGuzhang)
    {
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipGuzhang.setYzsk(doneDate);
        /** 增加单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipGuzhang.setYzr(checkUser.getNickName());
        equipGuzhang.setStatus("已验证");
        equipGuzhang.setLocked(1);
        /**计算用时***/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date djTime;
        try
        {
            /**计算用时(天)***/
            djTime = sdf.parse(equipGuzhang.getClsk());
            double chaZhi=((new Date()).getTime()-djTime.getTime())*1.0/1000/60/60/24;
            equipGuzhang.setYzys(new BigDecimal(chaZhi));

            Date dTime = sdf.parse(equipGuzhang.getDjsk());
            double cZ=((new Date()).getTime()-dTime.getTime())*1.0/1000/60/60/24;
            equipGuzhang.setTotalys(new BigDecimal(cZ));

        }
        catch(Exception e)
        {

        }
        return toAjax(equipGuzhangService.updateEquipGuzhang(equipGuzhang));
    }


    /**
     * 修改故障报修
     */
    @PreAuthorize("@ss.hasPermi('system:guzhang:edit')")
    @Log(title = "故障报修", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipGuzhang equipGuzhang)
    {
        equipGuzhang.setSbname(equipQuyuService.selectEquipQuyuById(equipGuzhang.getSbid()).getName());
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        equipGuzhang.setDjsk(doneDate);
        return toAjax(equipGuzhangService.updateEquipGuzhang(equipGuzhang));
    }

    /**
     * 删除故障报修
     */
    @PreAuthorize("@ss.hasPermi('system:guzhang:remove')")
    @Log(title = "故障报修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipGuzhangService.deleteEquipGuzhangByIds(ids));
    }
}
