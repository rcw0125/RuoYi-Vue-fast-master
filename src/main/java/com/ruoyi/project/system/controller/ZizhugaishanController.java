package com.ruoyi.project.system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
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
import com.ruoyi.project.system.domain.Zizhugaishan;
import com.ruoyi.project.system.service.IZizhugaishanService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 员工自主改善Controller
 *
 * @author ruoyi
 * @date 2021-04-21
 */
@RestController
@RequestMapping("/system/zizhugaishan")
public class ZizhugaishanController extends BaseController
{
    @Autowired
    private IZizhugaishanService zizhugaishanService;
    @Autowired
    private ISysUserService userService;
    /**
     * 查询员工自主改善列表
     */
    @PreAuthorize("@ss.hasPermi('system:zizhugaishan:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zizhugaishan zizhugaishan)
    {
        startPage();
        List<Zizhugaishan> list = zizhugaishanService.selectZizhugaishanList(zizhugaishan);
        return getDataTable(list);
    }

    /**
     * 查询自主改善列表--需要车间审核
     */
    @GetMapping("/getChjList")
    public TableDataInfo getChjList(Zizhugaishan zizhugaishan)
    {

        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        zizhugaishan.setTcrdw(checkUser.getDept().getDeptName());
        zizhugaishan.setStatus("等待车间审核");
        startPage();
        List<Zizhugaishan> list = zizhugaishanService.selectZizhugaishanList(zizhugaishan);
        return getDataTable(list);
    }

    /**
     * 查询自主改善列表--需要科室审核 --班组级改善
     */
    @GetMapping("/getKesList")
    public TableDataInfo getKesList(Zizhugaishan zizhugaishan)
    {

        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        zizhugaishan.setShks(checkUser.getDept().getDeptName());
        zizhugaishan.setStatus("车间审核通过");
        zizhugaishan.setShuxing("班组");
        /** 发现问题，在前端不分页，将startPage方法下移到查询方法前 后，分页方法正常**/
        startPage();
        List<Zizhugaishan> list = zizhugaishanService.selectZizhugaishanList(zizhugaishan);
        return getDataTable(list);
    }

    /**
     * 查询自主改善列表--需要精益办审核 ， 科室审核通过的都需要精益办进行审核
     */
    @GetMapping("/getJybList")
    public TableDataInfo getJybList(Zizhugaishan zizhugaishan)
    {

        zizhugaishan.setStatus("科室审核通过");
        startPage();
        List<Zizhugaishan> list = zizhugaishanService.selectZizhugaishanList(zizhugaishan);
        return getDataTable(list);
    }

    /**
     * 导出员工自主改善列表
     */
    @PreAuthorize("@ss.hasPermi('system:zizhugaishan:export')")
    @GetMapping("/export")
    public AjaxResult export(Zizhugaishan zizhugaishan)
    {
        List<Zizhugaishan> list = zizhugaishanService.selectZizhugaishanList(zizhugaishan);
        ExcelUtil<Zizhugaishan> util = new ExcelUtil<Zizhugaishan>(Zizhugaishan.class);
        return util.exportExcel(list, "zizhugaishan");
    }

    /**
     * 获取员工自主改善详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(zizhugaishanService.selectZizhugaishanById(id));

    }


    /**
     * 获取员工修改详细信息
     */

    @GetMapping(value = "/getUpdateInfo/{id}")
    public AjaxResult getUpdateInfo(@PathVariable("id") Integer id)
    {
        Zizhugaishan zzgs= zizhugaishanService.selectZizhugaishanById(id);
        if(!zzgs.getStatus().equals("等待车间审核")){
            return AjaxResult.error("此单据已被审核！","错误！");
        }
        String replyAccount= SecurityUtils.getUsername();
        if(!replyAccount.equals(zzgs.getTcrcode())){
            return AjaxResult.error("你不是提报人，不能修改！","错误！");
        }
        return AjaxResult.success(zzgs);
    }

    /**
     * 获取车间审核详细信息
     */

    @GetMapping(value = "/getChjInfo/{id}")
    public AjaxResult getChjInfo(@PathVariable("id") Integer id)
    {
        Zizhugaishan zzgs= zizhugaishanService.selectZizhugaishanById(id);
        if(!zzgs.getStatus().equals("等待车间审核")){
            return AjaxResult.error("此单据已被审核！不能修改","错误！");
        }
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        if(!checkUser.getDept().getDeptName().equals(zzgs.getTcrdw())){
            return AjaxResult.error("你不在所属改善车间！","错误！");
        }
        return AjaxResult.success(zzgs);
    }

    /**
     * 获取科室审核详细信息
     */

    @GetMapping(value = "/getKesInfo/{id}")
    public AjaxResult getKesInfo(@PathVariable("id") Integer id)
    {
        Zizhugaishan zzgs= zizhugaishanService.selectZizhugaishanById(id);
        if(!zzgs.getStatus().equals("车间审核通过")){
            return AjaxResult.error("此单据不是车间审核通过状态，科室不能审核！","错误！");
        }
        String replyAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(replyAccount);
        if(!checkUser.getDept().getDeptName().equals(zzgs.getShks())){
            return AjaxResult.error("你不在所属审核科室！","错误！");
        }
        return AjaxResult.success(zzgs);
    }

    /**
     * 获取精益办审核详细信息
     */

    @GetMapping(value = "/getJybInfo/{id}")
    public AjaxResult getJybInfo(@PathVariable("id") Integer id)
    {
        Zizhugaishan zzgs= zizhugaishanService.selectZizhugaishanById(id);
        if(!zzgs.getStatus().equals("科室审核通过")){
            return AjaxResult.error("此单据不是科室审核通过状态，精益办不能审核！","错误！");
        }
//        String replyAccount= SecurityUtils.getUsername();
//        SysUser checkUser=userService.selectUserByUserName(replyAccount);
//        if(!checkUser.getDept().getDeptName().equals("精益生产办公室")){
//            return AjaxResult.error("你不在所属精益生产办公室！","错误！");
//        }
        return AjaxResult.success(zzgs);
    }


    /**
     * 新增员工自主改善
     */
    @PostMapping
    public AjaxResult add(@RequestBody Zizhugaishan zizhugaishan)
    {
        /** 增加标准化检查单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        zizhugaishan.setTcrcode(checkAccount);
        zizhugaishan.setTcr(checkUser.getNickName());
        zizhugaishan.setTcrdw(checkUser.getDept().getDeptName());
        zizhugaishan.setStatus("等待车间审核");
        return toAjax(zizhugaishanService.insertZizhugaishan(zizhugaishan));
    }

    /**
     * 修改员工自主改善
     */
    @PreAuthorize("@ss.hasPermi('system:zizhugaishan:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody Zizhugaishan zizhugaishan)
    {

        return toAjax(zizhugaishanService.updateZizhugaishan(zizhugaishan));
    }

    /**
     * 自主改善--车间审核  前端选择是否车间审核通过
     */
    @PostMapping(value = "/chjShh")
    public AjaxResult chjShh(@RequestBody Zizhugaishan zizhugaishan)
    {


        /*** //设置审核时间*/
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        zizhugaishan.setShtime(doneDate);
        /*** //设置审核人姓名*/
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        zizhugaishan.setShr(checkUser.getNickName());
        return toAjax(zizhugaishanService.updateZizhugaishan(zizhugaishan));
    }

    /**
     * 自主改善--科室审核  前端选择是否科室审核通过
     */
    @PostMapping(value = "/kesShh")
    public AjaxResult kesShh(@RequestBody Zizhugaishan zizhugaishan)
    {
        /*** //设置科室审核时间*/
        String doneDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        zizhugaishan.setPjtime(doneDate);
        /*** //设置科室审核人姓名*/
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        zizhugaishan.setPjr(checkUser.getNickName());
        return toAjax(zizhugaishanService.updateZizhugaishan(zizhugaishan));
    }

    /**
     * 自主改善--精益办审核，评级  前端选择是否科室审核通过
     */
    @PostMapping(value = "/jybShh")
    public AjaxResult jybShh(@RequestBody Zizhugaishan zizhugaishan)
    {
        return toAjax(zizhugaishanService.updateZizhugaishan(zizhugaishan));
    }


    /**
     * 删除员工自主改善
     */
    @PreAuthorize("@ss.hasPermi('system:zizhugaishan:remove')")
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(zizhugaishanService.deleteZizhugaishanByIds(ids));
    }
}
