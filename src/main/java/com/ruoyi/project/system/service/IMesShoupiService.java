package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.MesShoupi;

/**
 * 收坯统计Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IMesShoupiService 
{
    /**
     * 查询收坯统计
     * 
     * @param ccmid 收坯统计主键
     * @return 收坯统计
     */
    public MesShoupi selectMesShoupiByCcmid(String ccmid);

    /**
     * 查询收坯统计列表
     * 
     * @param mesShoupi 收坯统计
     * @return 收坯统计集合
     */
    public List<MesShoupi> selectMesShoupiList(MesShoupi mesShoupi);

    /**
     * 新增收坯统计
     * 
     * @param mesShoupi 收坯统计
     * @return 结果
     */
    public int insertMesShoupi(MesShoupi mesShoupi);

    /**
     * 修改收坯统计
     * 
     * @param mesShoupi 收坯统计
     * @return 结果
     */
    public int updateMesShoupi(MesShoupi mesShoupi);

    /**
     * 批量删除收坯统计
     * 
     * @param ccmids 需要删除的收坯统计主键集合
     * @return 结果
     */
    public int deleteMesShoupiByCcmids(String[] ccmids);

    /**
     * 删除收坯统计信息
     * 
     * @param ccmid 收坯统计主键
     * @return 结果
     */
    public int deleteMesShoupiByCcmid(String ccmid);
}
