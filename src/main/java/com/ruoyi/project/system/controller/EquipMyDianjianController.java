package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.project.system.domain.EquipMyDianjian;
import com.ruoyi.project.system.service.IEquipMyDianjianService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 配置我的点检Controller
 *
 * @author ruoyi
 * @date 2022-06-15
 */
@RestController
@RequestMapping("/system/mydianjian")
public class EquipMyDianjianController extends BaseController
{
    @Autowired
    private IEquipMyDianjianService equipMyDianjianService;

    /**
     * 查询配置我的点检列表
     */
    @PreAuthorize("@ss.hasPermi('system:mydianjian:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipMyDianjian equipMyDianjian)
    {
        startPage();
        List<EquipMyDianjian> list = equipMyDianjianService.selectEquipMyDianjianList(equipMyDianjian);
        return getDataTable(list);
    }

    /**
     * 将设备从我的设备移除
     */

    @GetMapping("/delMyDianJian")
    public AjaxResult delMyDianJian(Long bzid)
    {
        AjaxResult ajax = AjaxResult.success();
        EquipMyDianjian equipMyDianjian=new EquipMyDianjian();
        equipMyDianjian.setBzid(bzid);
        String checkAccount= SecurityUtils.getUsername();
        equipMyDianjian.setUsername(checkAccount);
        List<EquipMyDianjian> list = equipMyDianjianService.selectEquipMyDianjianList(equipMyDianjian);
        if(list.size()>0){
            for(EquipMyDianjian item :list){
                equipMyDianjianService.deleteEquipMyDianjianById(item.getId());
            }
        }
        return ajax;
    }



    @GetMapping("/addMyDianJian")
    public AjaxResult addMyDianJian(Long[] ids)
    {
        AjaxResult ajax = AjaxResult.success();
        String checkAccount= SecurityUtils.getUsername();
        for( Long item:ids){
            EquipMyDianjian equipMyDianjian=new EquipMyDianjian();
            equipMyDianjian.setBzid(item);
            equipMyDianjian.setUsername(checkAccount);
            equipMyDianjianService.insertEquipMyDianjian(equipMyDianjian);
        }
        return ajax;
    }

    /**
     * 导出配置我的点检列表
     */
    @PreAuthorize("@ss.hasPermi('system:mydianjian:export')")
    @Log(title = "配置我的点检", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipMyDianjian equipMyDianjian)
    {
        List<EquipMyDianjian> list = equipMyDianjianService.selectEquipMyDianjianList(equipMyDianjian);
        ExcelUtil<EquipMyDianjian> util = new ExcelUtil<EquipMyDianjian>(EquipMyDianjian.class);
        return util.exportExcel(list, "配置我的点检数据");
    }

    /**
     * 获取配置我的点检详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:mydianjian:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipMyDianjianService.selectEquipMyDianjianById(id));
    }




    /**
     * 新增配置我的点检
     */
    @PreAuthorize("@ss.hasPermi('system:mydianjian:add')")
    @Log(title = "配置我的点检", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipMyDianjian equipMyDianjian)
    {
        return toAjax(equipMyDianjianService.insertEquipMyDianjian(equipMyDianjian));
    }

    /**
     * 修改配置我的点检
     */
    @PreAuthorize("@ss.hasPermi('system:mydianjian:edit')")
    @Log(title = "配置我的点检", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipMyDianjian equipMyDianjian)
    {
        return toAjax(equipMyDianjianService.updateEquipMyDianjian(equipMyDianjian));
    }

    /**
     * 删除配置我的点检
     */
    @PreAuthorize("@ss.hasPermi('system:mydianjian:remove')")
    @Log(title = "配置我的点检", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipMyDianjianService.deleteEquipMyDianjianByIds(ids));
    }
}
