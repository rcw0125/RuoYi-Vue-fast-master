package com.ruoyi.project.system.service.impl;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.project.system.domain.EquipDianjiantongji;
import com.ruoyi.project.system.mapper.EquipDianjiantongjiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipDianjianBiaozhunMapper;
import com.ruoyi.project.system.domain.EquipDianjianBiaozhun;
import com.ruoyi.project.system.service.IEquipDianjianBiaozhunService;

/**
 * 点检标准Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-22
 */
@Service
public class EquipDianjianBiaozhunServiceImpl implements IEquipDianjianBiaozhunService
{
    @Autowired
    private EquipDianjianBiaozhunMapper equipDianjianBiaozhunMapper;
    @Autowired
    private EquipDianjiantongjiMapper equipDianjiantongjiMapper;
    /**
     * 查询点检标准
     *
     * @param id 点检标准主键
     * @return 点检标准
     */
    @Override
    public EquipDianjianBiaozhun selectEquipDianjianBiaozhunById(Long id)
    {
        return equipDianjianBiaozhunMapper.selectEquipDianjianBiaozhunById(id);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectEquipDianjianBiaozhunList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectEquipDianjianBiaozhunList(equipDianjianBiaozhun);
    }

    /**
     * 查询我的点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectMyDianJianList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectMyDianJianList(equipDianjianBiaozhun);
    }

    /**
     * 查询我的点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectNotMyDianJianList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectNotMyDianJianList(equipDianjianBiaozhun);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectDianjianMingxi(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectDianjianMingxi(equipDianjianBiaozhun);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准-当月班组点检情况
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectDianjianTeamRate(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectDianjianTeamRate(equipDianjianBiaozhun);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准-当月车间点检情况
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectDianjianDeptRate(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectDianjianDeptRate(equipDianjianBiaozhun);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectZhouDianjianMingxi(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectZhouDianjianMingxi(equipDianjianBiaozhun);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准-当月班组点检情况
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectZhouDianjianTeamRate(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectZhouDianjianTeamRate(equipDianjianBiaozhun);
    }

    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准-当月车间点检情况
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectZhouDianjianDeptRate(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectZhouDianjianDeptRate(equipDianjianBiaozhun);
    }



    @Override
    public int  calDianjianDeptRate(String month)
    {
        if(month.length()!=7){
            month= LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        }
        EquipDianjianBiaozhun biaozhun=new EquipDianjianBiaozhun();
        biaozhun.setNote(month);
        System.out.print("月份为："+biaozhun.getName());
        List<EquipDianjianBiaozhun> list=equipDianjianBiaozhunMapper.selectDianjianDeptRate(biaozhun);
        for(EquipDianjianBiaozhun item :list){
            EquipDianjiantongji equipDianjiantongji=new EquipDianjiantongji();
            equipDianjiantongji.setLogtime(month);
            equipDianjiantongji.setDjdw(item.getDept());
            equipDianjiantongji.setYdjsl(Long.valueOf(item.getZhoucishu()));
            equipDianjiantongji.setSdjsl(Long.valueOf(item.getDjcs()));
            DecimalFormat df=new DecimalFormat("######0.0");
            equipDianjiantongji.setDjrate(Double.valueOf(df.format(equipDianjiantongji.getSdjsl()*1.0/equipDianjiantongji.getYdjsl())));
            equipDianjiantongjiMapper.insertEquipDianjiantongji(equipDianjiantongji);
        }

        return 0;
    }


    /**
     * 查询点检标准列表
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 点检标准
     */
    @Override
    public List<EquipDianjianBiaozhun> selectEquipDianjianBiaozhunByQuyuList(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.selectEquipDianjianBiaozhunByQuyuList(equipDianjianBiaozhun);
    }

    /**
     * 新增点检标准
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 结果
     */
    @Override
    public int insertEquipDianjianBiaozhun(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.insertEquipDianjianBiaozhun(equipDianjianBiaozhun);
    }

    /**
     * 修改点检标准
     *
     * @param equipDianjianBiaozhun 点检标准
     * @return 结果
     */
    @Override
    public int updateEquipDianjianBiaozhun(EquipDianjianBiaozhun equipDianjianBiaozhun)
    {
        return equipDianjianBiaozhunMapper.updateEquipDianjianBiaozhun(equipDianjianBiaozhun);
    }

    /**
     * 批量删除点检标准
     *
     * @param ids 需要删除的点检标准主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianBiaozhunByIds(Long[] ids)
    {
        return equipDianjianBiaozhunMapper.deleteEquipDianjianBiaozhunByIds(ids);
    }

    /**
     * 删除点检标准信息
     *
     * @param id 点检标准主键
     * @return 结果
     */
    @Override
    public int deleteEquipDianjianBiaozhunById(Long id)
    {
        return equipDianjianBiaozhunMapper.deleteEquipDianjianBiaozhunById(id);
    }
}
