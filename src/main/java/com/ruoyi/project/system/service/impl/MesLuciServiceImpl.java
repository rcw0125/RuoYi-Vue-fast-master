package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MesLuciMapper;
import com.ruoyi.project.system.domain.MesLuci;
import com.ruoyi.project.system.service.IMesLuciService;

/**
 * 导入MES炉次Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class MesLuciServiceImpl implements IMesLuciService
{
    @Autowired
    private MesLuciMapper mesLuciMapper;
    @Override
    public void ceshi()
    {
        System.out.println("测试定时任务---执行无参方法");
    }
    /**
     * 查询导入MES炉次
     *
     * @param gongxu 导入MES炉次主键
     * @return 导入MES炉次
     */
    @Override
    public MesLuci selectMesLuciByGongxu(String gongxu)
    {
        MesLuci luci=new MesLuci();
        if(gongxu.contains("转炉")){
            luci=mesLuciMapper.selectMesLuciByBof(gongxu);
        }else  if(gongxu.contains("精炼")){
            luci=mesLuciMapper.selectMesLuciByLf(gongxu);
        }else  if(gongxu.contains("铸机")){
            luci=mesLuciMapper.selectMesLuciByCcm(gongxu);
        }else  if(gongxu.contains("脱硫")){
            luci=mesLuciMapper.selectMesLuciByDes(gongxu);
        }
        return luci;
    }

    /**
     * 查询导入MES炉次列表
     *
     * @param mesLuci 导入MES炉次
     * @return 导入MES炉次
     */
    @Override
    public List<MesLuci> selectMesLuciList(MesLuci mesLuci)
    {
        return mesLuciMapper.selectMesLuciList(mesLuci);
    }

    /**
     * 新增导入MES炉次
     *
     * @param mesLuci 导入MES炉次
     * @return 结果
     */
    @Override
    public int insertMesLuci(MesLuci mesLuci)
    {
        return mesLuciMapper.insertMesLuci(mesLuci);
    }

    /**
     * 修改导入MES炉次
     *
     * @param mesLuci 导入MES炉次
     * @return 结果
     */
    @Override
    public int updateMesLuci(MesLuci mesLuci)
    {
        return mesLuciMapper.updateMesLuci(mesLuci);
    }

    /**
     * 批量删除导入MES炉次
     *
     * @param gongxus 需要删除的导入MES炉次主键
     * @return 结果
     */
    @Override
    public int deleteMesLuciByGongxus(String[] gongxus)
    {
        return mesLuciMapper.deleteMesLuciByGongxus(gongxus);
    }

    /**
     * 删除导入MES炉次信息
     *
     * @param gongxu 导入MES炉次主键
     * @return 结果
     */
    @Override
    public int deleteMesLuciByGongxu(String gongxu)
    {
        return mesLuciMapper.deleteMesLuciByGongxu(gongxu);
    }
}
