package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EmsEquipCfg;

/**
 * 能源介质配置Service接口
 * 
 * @author ruoyi
 * @date 2021-10-22
 */
public interface IEmsEquipCfgService 
{
    /**
     * 查询能源介质配置
     * 
     * @param id 能源介质配置主键
     * @return 能源介质配置
     */
    public EmsEquipCfg selectEmsEquipCfgById(Long id);

    /**
     * 查询能源介质配置列表
     * 
     * @param emsEquipCfg 能源介质配置
     * @return 能源介质配置集合
     */
    public List<EmsEquipCfg> selectEmsEquipCfgList(EmsEquipCfg emsEquipCfg);

    /**
     * 新增能源介质配置
     * 
     * @param emsEquipCfg 能源介质配置
     * @return 结果
     */
    public int insertEmsEquipCfg(EmsEquipCfg emsEquipCfg);

    /**
     * 修改能源介质配置
     * 
     * @param emsEquipCfg 能源介质配置
     * @return 结果
     */
    public int updateEmsEquipCfg(EmsEquipCfg emsEquipCfg);

    /**
     * 批量删除能源介质配置
     * 
     * @param ids 需要删除的能源介质配置主键集合
     * @return 结果
     */
    public int deleteEmsEquipCfgByIds(Long[] ids);

    /**
     * 删除能源介质配置信息
     * 
     * @param id 能源介质配置主键
     * @return 结果
     */
    public int deleteEmsEquipCfgById(Long id);
}
