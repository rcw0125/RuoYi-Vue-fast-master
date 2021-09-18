package com.ruoyi.project.system.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.domain.Zhibiaocfg;
import com.ruoyi.project.system.service.IZhibiaocfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ZhibiaoMapper;
import com.ruoyi.project.system.domain.Zhibiao;
import com.ruoyi.project.system.service.IZhibiaoService;

/**
 * 指标记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-15
 */
@Service
public class ZhibiaoServiceImpl implements IZhibiaoService
{
    @Autowired
    private ZhibiaoMapper zhibiaoMapper;
    @Autowired
    private IZhibiaocfgService zhibiaocfgService;

    /**
     * 查询指标记录
     *
     * @param id 指标记录ID
     * @return 指标记录
     */
    @Override
    public Zhibiao selectZhibiaoById(Long id)
    {
        return zhibiaoMapper.selectZhibiaoById(id);
    }

    /**
     * 查询指标记录列表
     *
     * @param zhibiao 指标记录
     * @return 指标记录
     */
    @Override
    public List<Zhibiao> selectZhibiaoList(Zhibiao zhibiao)
    {
        return zhibiaoMapper.selectZhibiaoList(zhibiao);
    }

    /**
     * 新增指标记录
     *
     * @param zhibiao 指标记录
     * @return 结果
     */
    @Override
    public int insertZhibiao(Zhibiao zhibiao)
    {
        return zhibiaoMapper.insertZhibiao(zhibiao);
    }

    /**
     * 修改指标记录
     *
     * @param zhibiao 指标记录
     * @return 结果
     */
    @Override
    public int updateZhibiao(Zhibiao zhibiao)
    {
        return zhibiaoMapper.updateZhibiao(zhibiao);
    }

    /**
     * 批量删除指标记录
     *
     * @param ids 需要删除的指标记录ID
     * @return 结果
     */
    @Override
    public int deleteZhibiaoByIds(Long[] ids)
    {
        return zhibiaoMapper.deleteZhibiaoByIds(ids);
    }

    /**
     * 删除指标记录信息
     *
     * @param id 指标记录ID
     * @return 结果
     */
    @Override
    public int deleteZhibiaoById(Long id)
    {
        return zhibiaoMapper.deleteZhibiaoById(id);
    }


    /**
     * 导入用户数据
     *
     * @param zhibiaoList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importZhibiao(List<Zhibiao> zhibiaoList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(zhibiaoList) || zhibiaoList.size() == 0)
        {
            throw new CustomException("导入指标数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        //String password = configService.selectConfigByKey("sys.user.initPassword");
        for (Zhibiao zhibiao : zhibiaoList)
        {
            /**
             * 1、检查指标配置中是否存在该指标，车间、指标名称，
             * 2、检查时间字符串是否符合格式
             * 3、检查指定日期是否已存在该指标记录
             * **/

            try
            {
                // 验证是否存在这个指标
                Zhibiaocfg zhibiaocfg=new Zhibiaocfg();
                zhibiaocfg.setDept(zhibiao.getDept());
                zhibiao.setName(zhibiao.getName());
                List<Zhibiaocfg> CfgList = zhibiaocfgService.selectZhibiaocfgList(zhibiaocfg);
                if(CfgList.size()==0){
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、指标： " + zhibiao.getName() + " 不存在");
                }
                else{
                    if(isValidDate(zhibiao.getLogtime())){

                        Zhibiao Zb=new Zhibiao();
                        Zb.setDept(zhibiao.getDept());
                        Zb.setName(zhibiao.getName());
                        Zb.setLogtime(zhibiao.getLogtime());
                        List<Zhibiao> ZbList=zhibiaoMapper.selectZhibiaoList(Zb);
                        if(ZbList.size()==0){
                           zhibiao.setLogperson(operName);
                           zhibiaoMapper.insertZhibiao(zhibiao);
                            successNum++;
                        }
                        else{
                            failureNum++;
                            failureMsg.append("<br/>" + failureNum + "时间： " + zhibiao.getLogtime()+"指标："+zhibiao.getName() + " 当前指标已存在记录");
                        }


                    }
                    else{
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、时间： " + zhibiao.getLogtime() + " 格式不正确");
                    }


                }




            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、指标 " + zhibiao.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());

            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    public  boolean isValidDate(String str) {
        boolean convertSuccess ;
        convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            formatDate.parse(str);
            convertSuccess = true;
        } catch (ParseException e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return  convertSuccess;
    }

}
