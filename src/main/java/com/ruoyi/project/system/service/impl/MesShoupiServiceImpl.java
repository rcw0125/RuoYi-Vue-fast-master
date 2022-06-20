package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MesShoupiMapper;
import com.ruoyi.project.system.domain.MesShoupi;
import com.ruoyi.project.system.service.IMesShoupiService;

/**
 * 收坯统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class MesShoupiServiceImpl implements IMesShoupiService 
{
    @Autowired
    private MesShoupiMapper mesShoupiMapper;

    /**
     * 查询收坯统计
     * 
     * @param ccmid 收坯统计主键
     * @return 收坯统计
     */
    @Override
    public MesShoupi selectMesShoupiByCcmid(String ccmid)
    {
        return mesShoupiMapper.selectMesShoupiByCcmid(ccmid);
    }

    /**
     * 查询收坯统计列表
     * 
     * @param mesShoupi 收坯统计
     * @return 收坯统计
     */
    @Override
    public List<MesShoupi> selectMesShoupiList(MesShoupi mesShoupi)
    {
        return mesShoupiMapper.selectMesShoupiList(mesShoupi);
    }

    /**
     * 新增收坯统计
     * 
     * @param mesShoupi 收坯统计
     * @return 结果
     */
    @Override
    public int insertMesShoupi(MesShoupi mesShoupi)
    {
        return mesShoupiMapper.insertMesShoupi(mesShoupi);
    }

    /**
     * 修改收坯统计
     * 
     * @param mesShoupi 收坯统计
     * @return 结果
     */
    @Override
    public int updateMesShoupi(MesShoupi mesShoupi)
    {
        return mesShoupiMapper.updateMesShoupi(mesShoupi);
    }

    /**
     * 批量删除收坯统计
     * 
     * @param ccmids 需要删除的收坯统计主键
     * @return 结果
     */
    @Override
    public int deleteMesShoupiByCcmids(String[] ccmids)
    {
        return mesShoupiMapper.deleteMesShoupiByCcmids(ccmids);
    }

    /**
     * 删除收坯统计信息
     * 
     * @param ccmid 收坯统计主键
     * @return 结果
     */
    @Override
    public int deleteMesShoupiByCcmid(String ccmid)
    {
        return mesShoupiMapper.deleteMesShoupiByCcmid(ccmid);
    }
}
