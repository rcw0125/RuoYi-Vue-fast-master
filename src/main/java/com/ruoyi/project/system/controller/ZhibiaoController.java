package com.ruoyi.project.system.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.project.system.domain.SysUser;
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
import com.ruoyi.project.system.domain.Zhibiao;
import com.ruoyi.project.system.service.IZhibiaoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 指标记录Controller
 *
 * @author ruoyi
 * @date 2021-04-15
 */
@RestController
@RequestMapping("/system/zhibiao")
public class ZhibiaoController extends BaseController
{
    @Autowired
    private IZhibiaoService zhibiaoService;

    @Autowired
    private TokenService tokenService;
    /**
     * 查询指标记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiao:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zhibiao zhibiao)
    {
        startPage();
        List<Zhibiao> list = zhibiaoService.selectZhibiaoList(zhibiao);
        return getDataTable(list);
    }

    /**
     * 供外部服务使用
     * **/
    @GetMapping("/api/ZhiBiaoList")
    public TableDataInfo ZhiBiaoList(Zhibiao zhibiao)
    {
        startPage();
        List<Zhibiao> list = zhibiaoService.selectZhibiaoList(zhibiao);
        return getDataTable(list);
    }

    /**
     * 供外部服务使用，获取考核单详细信息
     */
    @GetMapping(value = "/api/GetInfoById/{ZhiBiaoId}")
    public AjaxResult GetInfoById(@PathVariable("ZhiBiaoId") Long ZhiBiaoId)
    {
        return AjaxResult.success(zhibiaoService.selectZhibiaoById(ZhiBiaoId));
    }

    /**
     *  查询图表 一个指标所需的数据
     */

    @GetMapping("/chart")
    public AjaxResult chart(Zhibiao zhibiao)
    {
        AjaxResult ajax = AjaxResult.success();
        List<Zhibiao> list = zhibiaoService.selectZhibiaoList(zhibiao);
        ajax.put("zhibiao", list);
        return ajax;
    }


    /**
     * 导出指标记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiao:export')")
    @Log(title = "指标记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Zhibiao zhibiao)
    {
        List<Zhibiao> list = zhibiaoService.selectZhibiaoList(zhibiao);
        ExcelUtil<Zhibiao> util = new ExcelUtil<Zhibiao>(Zhibiao.class);
        return util.exportExcel(list, "zhibiao");
    }

    /**
     * 获取指标记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiao:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhibiaoService.selectZhibiaoById(id));
    }

    /**
     * 新增指标记录
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiao:add')")
    @Log(title = "指标记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zhibiao zhibiao)
    {
        Zhibiao zb=new Zhibiao();
        zb.setDept(zhibiao.getDept());
        zb.setName(zhibiao.getName());
        zb.setLogtime(zhibiao.getLogtime());
        List<Zhibiao> list = zhibiaoService.selectZhibiaoList(zhibiao);
        if(list.size()>0){
            return AjaxResult.error("已存在该日期的指标记录，不能重复添加！","错误！");
        }

        String logAccount= SecurityUtils.getUsername();
        zhibiao.setLogperson(logAccount);
        return toAjax(zhibiaoService.insertZhibiao(zhibiao));
    }

    /**
     * 修改指标记录
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiao:edit')")
    @Log(title = "指标记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zhibiao zhibiao)
    {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date logDate = null;
        try {
            // 注意格式需要与上面一致，不然会出现异常
            logDate = sdf.parse(zhibiao.getLogtime());
            Date nowDate=new Date();
            long day=(nowDate.getTime()-logDate.getTime())/(24*60*60*1000);
            if(day>2){
                return AjaxResult.error("记录日期超过2天，不允许再修改！","错误！");
            }

        } catch (ParseException e) {

        }

        String logAccount= SecurityUtils.getUsername();
        zhibiao.setUpdateperson(logAccount);
        return toAjax(zhibiaoService.updateZhibiao(zhibiao));
    }




    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Zhibiao> util = new ExcelUtil<Zhibiao>(Zhibiao.class);
        List<Zhibiao> zhibiaoList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = zhibiaoService.importZhibiao(zhibiaoList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<Zhibiao> util = new ExcelUtil<Zhibiao>(Zhibiao.class);
        return util.importTemplateExcel("指标模板数据");
    }

    /**
     * 删除指标记录
     */
    @PreAuthorize("@ss.hasPermi('system:zhibiao:remove')")
    @Log(title = "指标记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhibiaoService.deleteZhibiaoByIds(ids));
    }
}
