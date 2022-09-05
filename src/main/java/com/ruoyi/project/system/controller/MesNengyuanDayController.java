package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
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
import com.ruoyi.project.system.domain.MesNengyuanDay;
import com.ruoyi.project.system.service.IMesNengyuanDayService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 能源数据Controller
 *
 * @author ruoyi
 * @date 2022-01-21
 */
@RestController
@RequestMapping("/system/nengyuanday")
public class MesNengyuanDayController extends BaseController
{
    @Autowired
    private IMesNengyuanDayService mesNengyuanDayService;

    /**
     * 查询能源数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:nengyuanday:list')")
    @GetMapping("/list")
    @DataSource(value = DataSourceType.SLAVE)
    public TableDataInfo list(MesNengyuanDay mesNengyuanDay)
    {

        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        /***只能设置一种分页类型，# PageHelper分页插件， 在application.yml中
         pagehelper:
         helperDialect: mysql
         supportMethodsArguments: true
         params: count=countSql*
         */
        //startPage();
//        mesNengyuanDay.setLogtime("2022-01-25");
        List<MesNengyuanDay> list = mesNengyuanDayService.selectMesNengyuanDayList(mesNengyuanDay);
        DynamicDataSourceContextHolder.clearDataSourceType();

        return getDataTable(list);
    }

    @GetMapping("/lastList")
    public TableDataInfo lastList(MesNengyuanDay mesNengyuanDay)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<MesNengyuanDay> list = mesNengyuanDayService.selectMesNengyuanDayLastList(mesNengyuanDay);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }
    /**
     * 导出能源数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:nengyuanday:export')")
    @Log(title = "能源数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesNengyuanDay mesNengyuanDay)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        /***只能设置一种分页类型，# PageHelper分页插件， 在application.yml中
         pagehelper:
         helperDialect: mysql
         supportMethodsArguments: true
         params: count=countSql*
         */
        //startPage();
//        mesNengyuanDay.setLogtime("2022-01-25");
        List<MesNengyuanDay> list = mesNengyuanDayService.selectMesNengyuanDayList(mesNengyuanDay);
        DynamicDataSourceContextHolder.clearDataSourceType();
        //List<MesNengyuanDay> list = mesNengyuanDayService.selectMesNengyuanDayList(mesNengyuanDay);
        ExcelUtil<MesNengyuanDay> util = new ExcelUtil<MesNengyuanDay>(MesNengyuanDay.class);
        return util.exportExcel(list, "能源数据数据");
    }

    /**
     * 获取能源数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:nengyuanday:query')")
    @GetMapping(value = "/{logtime}")
    public AjaxResult getInfo(@PathVariable("logtime") String logtime)
    {
        return AjaxResult.success(mesNengyuanDayService.selectMesNengyuanDayByLogtime(logtime));
    }

    /**
     * 新增能源数据
     */
    @PreAuthorize("@ss.hasPermi('system:nengyuanday:add')")
    @Log(title = "能源数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesNengyuanDay mesNengyuanDay)
    {
        return toAjax(mesNengyuanDayService.insertMesNengyuanDay(mesNengyuanDay));
    }

    /**
     * 修改能源数据
     */
    @PreAuthorize("@ss.hasPermi('system:nengyuanday:edit')")
    @Log(title = "能源数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesNengyuanDay mesNengyuanDay)
    {
        return toAjax(mesNengyuanDayService.updateMesNengyuanDay(mesNengyuanDay));
    }

    /**
     * 删除能源数据
     */
    @PreAuthorize("@ss.hasPermi('system:nengyuanday:remove')")
    @Log(title = "能源数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{logtimes}")
    public AjaxResult remove(@PathVariable String[] logtimes)
    {
        return toAjax(mesNengyuanDayService.deleteMesNengyuanDayByLogtimes(logtimes));
    }
}
