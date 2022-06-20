package com.ruoyi.project.system.controller;

import java.text.DecimalFormat;
import java.util.List;

import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import com.ruoyi.project.system.domain.MesNengyuanDay;
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
import com.ruoyi.project.system.domain.MesShoupi;
import com.ruoyi.project.system.service.IMesShoupiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 收坯统计Controller
 *
 * @author ruoyi
 * @date 2022-05-19
 */
@RestController
@RequestMapping("/system/shoupi")
public class MesShoupiController extends BaseController
{
    @Autowired
    private IMesShoupiService mesShoupiService;

    /**
     * 查询收坯统计列表
     */

    @GetMapping("/list")
    public TableDataInfo list(MesShoupi mesShoupi)
    {
//        startPage();
//        List<MesShoupi> list = mesShoupiService.selectMesShoupiList(mesShoupi);
//        return getDataTable(list);

        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        /***只能设置一种分页类型，# PageHelper分页插件， 在application.yml中
         pagehelper:
         helperDialect: mysql
         supportMethodsArguments: true
         params: count=countSql*
         */
        //startPage();
//        mesNengyuanDay.setLogtime("2022-01-25");
        List<MesShoupi> list = mesShoupiService.selectMesShoupiList(mesShoupi);
        DynamicDataSourceContextHolder.clearDataSourceType();
        int count=list.size();
        if(count>0){
            double ironweight = 0, scrapweight = 0, pigironweight = 0, ykweight = 0, steelweight = 0, qingshao = 0, shoupi = 0,yangqi=0,bofalloy=0,lfalloy=0,bofshihui=0,lfshihui=0,dingzhahui=0,lgbaiyunshi=0,shihuishi=0;
            DecimalFormat df=new DecimalFormat("######0.0");
            for (MesShoupi item:list) {
                if (item.getBloomweight()>0){
                    item.setTiehao(Double.valueOf(df.format(item.getIronweight()*1000/item.getBloomweight())));
                }
                else {
                    item.setTiehao(0.0);
                }
                ironweight+=item.getIronweight();
                scrapweight+=item.getScrapweight();
                pigironweight+=item.getPigironweight();
                ykweight+=item.getYkweight();
                steelweight+=item.getSteelweight();
                qingshao+=item.getQingshaobaiyunshi();
                shoupi+=item.getBloomweight();
                yangqi+=item.getYangqi();
                bofalloy+=item.getBofalloy();
                lfalloy+=item.getLfalloy();
                bofshihui+=item.getBofshihui();
                lfshihui+=item.getLfshihui();
                dingzhahui+=item.getDingzhahui();
                lgbaiyunshi+=item.getLgbaiyunshi();
                shihuishi+=item.getShihuishi();
            }
            MesShoupi leiJi=new MesShoupi();
            leiJi.setCcmid("累计");
            leiJi.setIronweight(zhuanhuan(ironweight));
            leiJi.setScrapweight(zhuanhuan(scrapweight));
            leiJi.setPigironweight(zhuanhuan(pigironweight));
            leiJi.setYkweight(zhuanhuan(ykweight));
            leiJi.setSteelweight(zhuanhuan(steelweight));
            leiJi.setQingshaobaiyunshi(zhuanhuan(qingshao));
            leiJi.setBloomweight(zhuanhuan(shoupi));
            leiJi.setYangqi(zhuanhuan(yangqi));
            leiJi.setBofalloy(zhuanhuan(bofalloy));
            leiJi.setLfalloy(zhuanhuan(lfalloy));
            leiJi.setBofshihui(zhuanhuan(bofshihui));
            leiJi.setLfshihui(zhuanhuan(lfshihui));
            leiJi.setDingzhahui(zhuanhuan(dingzhahui));
            leiJi.setLgbaiyunshi(zhuanhuan(lgbaiyunshi));
            leiJi.setShihuishi(zhuanhuan(shihuishi));
            list.add(leiJi);

            MesShoupi pingjun=new MesShoupi();
            if(shoupi<1){
                shoupi=1;
            }
            if(count<1){
                count=1;
            }
            pingjun.setCcmid("平均");
            pingjun.setIronweight(zhuanhuan(ironweight/count));
            pingjun.setScrapweight(zhuanhuan(scrapweight/count));
            pingjun.setPigironweight(zhuanhuan(pigironweight/count));
            pingjun.setYkweight(zhuanhuan(ykweight/count));
            pingjun.setSteelweight(zhuanhuan(steelweight/count));
            pingjun.setBloomweight(zhuanhuan(shoupi/count));
            pingjun.setQingshaobaiyunshi(zhuanhuan(qingshao/shoupi));
            pingjun.setYangqi(zhuanhuan(yangqi/shoupi));
            pingjun.setBofalloy(zhuanhuan(bofalloy/shoupi));
            pingjun.setLfalloy(zhuanhuan(lfalloy/shoupi));
            pingjun.setBofshihui(zhuanhuan(bofshihui/shoupi));
            pingjun.setLfshihui(zhuanhuan(lfshihui/shoupi));
            pingjun.setTiehao(zhuanhuan(ironweight*1000/shoupi));
            pingjun.setDingzhahui(zhuanhuan(dingzhahui/shoupi));
            pingjun.setLgbaiyunshi(zhuanhuan(lgbaiyunshi/shoupi));
            pingjun.setShihuishi(zhuanhuan(shihuishi/shoupi));
            list.add(pingjun);
        }

        return getDataTable(list);
    }
    private  double zhuanhuan(double db){
        DecimalFormat df=new DecimalFormat("######0.0");
        return  Double.valueOf(df.format(db));
    }
    /**
     * 导出收坯统计列表
     */

    @Log(title = "收坯统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesShoupi mesShoupi)
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
        List<MesShoupi> list = mesShoupiService.selectMesShoupiList(mesShoupi);
        DynamicDataSourceContextHolder.clearDataSourceType();
        int count=list.size();
        if(count>0){
            double ironweight = 0, scrapweight = 0, pigironweight = 0, ykweight = 0, steelweight = 0, qingshao = 0, shoupi = 0,yangqi=0,bofalloy=0,lfalloy=0,bofshihui=0,lfshihui=0,dingzhahui=0,lgbaiyunshi=0,shihuishi=0;
            DecimalFormat df=new DecimalFormat("######0.0");
            for (MesShoupi item:list) {
                if (item.getBloomweight()>0){
                    item.setTiehao(Double.valueOf(df.format(item.getIronweight()*1000/item.getBloomweight())));
                }
                else {
                    item.setTiehao(0.0);
                }
                ironweight+=item.getIronweight();
                scrapweight+=item.getScrapweight();
                pigironweight+=item.getPigironweight();
                ykweight+=item.getYkweight();
                steelweight+=item.getSteelweight();
                qingshao+=item.getQingshaobaiyunshi();
                shoupi+=item.getBloomweight();
                yangqi+=item.getYangqi();
                bofalloy+=item.getBofalloy();
                lfalloy+=item.getLfalloy();
                bofshihui+=item.getBofshihui();
                lfshihui+=item.getLfshihui();
                dingzhahui+=item.getDingzhahui();
                lgbaiyunshi+=item.getLgbaiyunshi();
                shihuishi+=item.getShihuishi();
            }
            MesShoupi leiJi=new MesShoupi();
            leiJi.setCcmid("累计");
            leiJi.setIronweight(zhuanhuan(ironweight));
            leiJi.setScrapweight(zhuanhuan(scrapweight));
            leiJi.setPigironweight(zhuanhuan(pigironweight));
            leiJi.setYkweight(zhuanhuan(ykweight));
            leiJi.setSteelweight(zhuanhuan(steelweight));
            leiJi.setQingshaobaiyunshi(zhuanhuan(qingshao));
            leiJi.setBloomweight(zhuanhuan(shoupi));
            leiJi.setYangqi(zhuanhuan(yangqi));
            leiJi.setBofalloy(zhuanhuan(bofalloy));
            leiJi.setLfalloy(zhuanhuan(lfalloy));
            leiJi.setBofshihui(zhuanhuan(bofshihui));
            leiJi.setLfshihui(zhuanhuan(lfshihui));
            leiJi.setDingzhahui(zhuanhuan(dingzhahui));
            leiJi.setLgbaiyunshi(zhuanhuan(lgbaiyunshi));
            leiJi.setShihuishi(zhuanhuan(shihuishi));
            list.add(leiJi);

            MesShoupi pingjun=new MesShoupi();
            if(shoupi<1){
                shoupi=1;
            }
            if(count<1){
                count=1;
            }
            pingjun.setCcmid("平均");
            pingjun.setIronweight(zhuanhuan(ironweight/count));
            pingjun.setScrapweight(zhuanhuan(scrapweight/count));
            pingjun.setPigironweight(zhuanhuan(pigironweight/count));
            pingjun.setYkweight(zhuanhuan(ykweight/count));
            pingjun.setSteelweight(zhuanhuan(steelweight/count));
            pingjun.setBloomweight(zhuanhuan(shoupi/count));
            pingjun.setQingshaobaiyunshi(zhuanhuan(qingshao/shoupi));
            pingjun.setYangqi(zhuanhuan(yangqi/shoupi));
            pingjun.setBofalloy(zhuanhuan(bofalloy/shoupi));
            pingjun.setLfalloy(zhuanhuan(lfalloy/shoupi));
            pingjun.setBofshihui(zhuanhuan(bofshihui/shoupi));
            pingjun.setLfshihui(zhuanhuan(lfshihui/shoupi));
            pingjun.setTiehao(zhuanhuan(ironweight*1000/shoupi));
            pingjun.setDingzhahui(zhuanhuan(dingzhahui/shoupi));
            pingjun.setLgbaiyunshi(zhuanhuan(lgbaiyunshi/shoupi));
            pingjun.setShihuishi(zhuanhuan(shihuishi/shoupi));
            list.add(pingjun);

        }

        //List<MesShoupi> list = mesShoupiService.selectMesShoupiList(mesShoupi);
        ExcelUtil<MesShoupi> util = new ExcelUtil<MesShoupi>(MesShoupi.class);
        return util.exportExcel(list, "收坯统计数据");
    }

    /**
     * 获取收坯统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shoupi:query')")
    @GetMapping(value = "/{ccmid}")
    public AjaxResult getInfo(@PathVariable("ccmid") String ccmid)
    {
        return AjaxResult.success(mesShoupiService.selectMesShoupiByCcmid(ccmid));
    }

    /**
     * 新增收坯统计
     */
    @PreAuthorize("@ss.hasPermi('system:shoupi:add')")
    @Log(title = "收坯统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesShoupi mesShoupi)
    {
        return toAjax(mesShoupiService.insertMesShoupi(mesShoupi));
    }

    /**
     * 修改收坯统计
     */
    @PreAuthorize("@ss.hasPermi('system:shoupi:edit')")
    @Log(title = "收坯统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesShoupi mesShoupi)
    {
        return toAjax(mesShoupiService.updateMesShoupi(mesShoupi));
    }

    /**
     * 删除收坯统计
     */
    @PreAuthorize("@ss.hasPermi('system:shoupi:remove')")
    @Log(title = "收坯统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ccmids}")
    public AjaxResult remove(@PathVariable String[] ccmids)
    {
        return toAjax(mesShoupiService.deleteMesShoupiByCcmids(ccmids));
    }
}
