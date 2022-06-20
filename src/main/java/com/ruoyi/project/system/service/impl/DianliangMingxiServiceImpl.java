package com.ruoyi.project.system.service.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import com.ruoyi.project.system.domain.DianliangCfg;
import com.ruoyi.project.system.domain.MesNengyuanDay;
import com.ruoyi.project.system.mapper.DianliangCfgMapper;
import com.ruoyi.project.system.mapper.MesNengyuanDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DianliangMingxiMapper;
import com.ruoyi.project.system.domain.DianliangMingxi;
import com.ruoyi.project.system.service.IDianliangMingxiService;

/**
 * 电量明细Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-10
 */
@Service
public class DianliangMingxiServiceImpl implements IDianliangMingxiService
{
    @Autowired
    private DianliangMingxiMapper dianliangMingxiMapper;

    @Autowired
    private DianliangCfgMapper dianliangCfgMapper;

    @Autowired
    private MesNengyuanDayMapper mesNengyuanDayMapper;

    /**
     * 查询电量明细
     *
     * @param id 电量明细主键
     * @return 电量明细
     */
    @Override
    public DianliangMingxi selectDianliangMingxiById(Long id)
    {
        return dianliangMingxiMapper.selectDianliangMingxiById(id);
    }

    /**
     * 查询电量明细列表
     *
     * @param dianliangMingxi 电量明细
     * @return 电量明细
     */
    @Override
    public List<DianliangMingxi> selectDianliangMingxiList(DianliangMingxi dianliangMingxi)
    {
        return dianliangMingxiMapper.selectDianliangMingxiList(dianliangMingxi);
    }

    /**
     * 新增电量明细
     *
     * @param dianliangMingxi 电量明细
     * @return 结果
     */
    @Override
    public int insertDianliangMingxi(DianliangMingxi dianliangMingxi)
    {
        return dianliangMingxiMapper.insertDianliangMingxi(dianliangMingxi);
    }

    /**
     * 修改电量明细
     *
     * @param dianliangMingxi 电量明细
     * @return 结果
     */
    @Override
    public int updateDianliangMingxi(DianliangMingxi dianliangMingxi)
    {
        return dianliangMingxiMapper.updateDianliangMingxi(dianliangMingxi);
    }

    /**
     * 批量删除电量明细
     *
     * @param ids 需要删除的电量明细主键
     * @return 结果
     */
    @Override
    public int deleteDianliangMingxiByIds(Long[] ids)
    {
        return dianliangMingxiMapper.deleteDianliangMingxiByIds(ids);
    }

    /**
     * 删除电量明细信息
     *
     * @param id 电量明细主键
     * @return 结果
     */
    @Override
    public int deleteDianliangMingxiById(Long id)
    {
        return dianliangMingxiMapper.deleteDianliangMingxiById(id);
    }

    @Override
    public String importDianLiang(List<DianliangMingxi> userList, String logtime, String operName)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入电量数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        DianliangCfg dianliangCfg=new DianliangCfg();
        dianliangCfg.setLaiyuan("自动采集");
        List<DianliangCfg> listCfg=dianliangCfgMapper.selectDianliangCfgList(dianliangCfg);
        Iterator<DianliangCfg> it1 = listCfg.iterator();
        while (it1.hasNext()) {
            DianliangCfg d = (DianliangCfg) it1.next();
            if(StringUtils.isNull( d.getBianhao())||StringUtils.isEmpty( d.getBianhao())){
                /**断路器编码为空的先移除掉**/
                it1.remove();
            }
        }

        for (DianliangMingxi mingxi : userList)
        {
            try
            {
                if(StringUtils.isNotNull(mingxi.getTotal())){

                    /******对电量配置表进行遍历，如果存在相同的断路器编号和描述，则插入到数据库中*******/
                    Iterator<DianliangCfg> it = listCfg.iterator();
                    while (it.hasNext()) {
                        DianliangCfg d = (DianliangCfg) it.next();
                        if(mingxi.getBianhao().trim().equals(d.getBianhao().trim())&&mingxi.getMiaoshu().trim().equals(d.getMiaoshu().trim()))
                        {
                            mingxi.setLogtime(logtime);
                            mingxi.setName(d.getName());
                            mingxi.setDept(d.getDept());
                            mingxi.setBeilv(d.getBeilv());
                            mingxi.setLeibie(d.getLeibie());
                            mingxi.setLaiyuan(d.getLaiyuan());
                            mingxi.setOrdernum(d.getOrdernum());
                            mingxi.setNote(d.getNote());
                            this.insertDianliangMingxi(mingxi);
                            successNum++;
                            if(mingxi.getName().equals("4#转炉一次除尘")){
                                DianliangMingxi dingXiChuChen=new DianliangMingxi();
                                dingXiChuChen.setName("4#转炉顶侧吸");
                                dingXiChuChen.setLeibie("除尘风机");
                                dingXiChuChen.setLaiyuan("自动采集");
                                dingXiChuChen.setDept("冶炼车间");
                                dingXiChuChen.setOrdernum(15);
                                dingXiChuChen.setNote("0.5*4#转炉一次除尘");
                                dingXiChuChen.setTotal(mingxi.getTotal().multiply(new BigDecimal(0.5) ));
                                dingXiChuChen.setLogtime(logtime);
                                this.insertDianliangMingxi(dingXiChuChen);
                                successNum++;
                            }
                            it.remove();
                        }
                    }
                }

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、断路器编号 " + mingxi.getBianhao() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());

            }
        }

        dianliangCfg.setLaiyuan("手工录入");
        List<DianliangCfg> listShouGong=dianliangCfgMapper.selectDianliangCfgList(dianliangCfg);
        for(DianliangCfg cfg :listShouGong){
            DianliangMingxi dingXiChuChen=new DianliangMingxi();
            dingXiChuChen.setName(cfg.getName());
            dingXiChuChen.setLeibie(cfg.getLeibie());
            dingXiChuChen.setLaiyuan("手工录入");
            dingXiChuChen.setDept(cfg.getDept());
            dingXiChuChen.setOrdernum(cfg.getOrdernum());
            dingXiChuChen.setNote(cfg.getNote());
            dingXiChuChen.setTotal(cfg.getVal());
            dingXiChuChen.setLogtime(logtime);
            this.insertDianliangMingxi(dingXiChuChen);
            successNum++;
        }
        DianliangMingxi chanliang=new DianliangMingxi();
        chanliang.setName("炼钢总产量");
        chanliang.setLeibie("其它");
        chanliang.setLaiyuan("自动采集");
        chanliang.setDept("其它");
        chanliang.setOrdernum(55);
        chanliang.setLogtime(logtime);

        DianliangMingxi dianliang=new DianliangMingxi();
        dianliang.setName("炼钢总电量");
        dianliang.setLeibie("其它");
        dianliang.setLaiyuan("自动采集");
        dianliang.setDept("炼钢厂");
        dianliang.setOrdernum(56);
        //chanliang.setTotal(cfg.getVal());
        dianliang.setLogtime(logtime);
        try{
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            MesNengyuanDay NengyuanDay= mesNengyuanDayMapper.selectMesNengyuanDayByLogtime(logtime);
            DynamicDataSourceContextHolder.clearDataSourceType();
            if(StringUtils.isNotNull(NengyuanDay)){
                chanliang.setTotal(NengyuanDay.getTg());
                dianliang.setTotal(NengyuanDay.getDianhao());
            }
        }
        catch (Exception e){

        }


        this.insertDianliangMingxi(chanliang);
        successNum++;

        this.insertDianliangMingxi(dianliang);
        successNum++;

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
