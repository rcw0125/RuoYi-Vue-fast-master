package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.IEquipQuyuService;
import com.ruoyi.project.system.service.ISysDictDataService;
import com.ruoyi.project.system.service.ISysUserService;
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
import com.ruoyi.project.system.service.IEquipDianjianBiaozhunService;
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
    /**
     * 查询点检标准列表
     */
    @PreAuthorize("@ss.hasPermi('system:equipbiaozhun:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
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
        equipDianjianBiaozhun.setTeam(checkUser.getTeam());
        startPage();
        List<EquipDianjianBiaozhun> list = equipDianjianBiaozhunService.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
        return getDataTable(list);
    }

    /**
     * 导出点检标准列表
     */
    @PreAuthorize("@ss.hasPermi('system:equipbiaozhun:export')")
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
        /** 增加标准化检查单据时，添加检查人姓名，单位 */
        String checkAccount= SecurityUtils.getUsername();
        SysUser checkUser=userService.selectUserByUserName(checkAccount);
        equipDianjianBiaozhun.setDept(checkUser.getDept().getDeptName());
        equipDianjianBiaozhun.setTeam(checkUser.getTeam());

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
//        /** 修改每周应点检次数 */
//        SysDictData dictData=new SysDictData();
//        dictData.setDictType("dianjianzhouqi");
//        dictData.setDictLabel(equipDianjianBiaozhun.getZhouqi());
//        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
//        if(StringUtils.isNotNull(list)){
//            equipDianjianBiaozhun.setZhoucishu(list.get(0).getRemark());
//        }
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
