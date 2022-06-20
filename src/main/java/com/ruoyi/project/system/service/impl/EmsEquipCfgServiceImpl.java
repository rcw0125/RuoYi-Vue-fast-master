package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EmsEquipCfgMapper;
import com.ruoyi.project.system.domain.EmsEquipCfg;
import com.ruoyi.project.system.service.IEmsEquipCfgService;

/**
 * 能源介质配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-22
 */
@Service
public class EmsEquipCfgServiceImpl implements IEmsEquipCfgService 
{
    @Autowired
    private EmsEquipCfgMapper emsEquipCfgMapper;

    /**
     * 查询能源介质配置
     * 
     * @param id 能源介质配置主键
     * @return 能源介质配置
     */
    @Override
    public EmsEquipCfg selectEmsEquipCfgById(Long id)
    {
        return emsEquipCfgMapper.selectEmsEquipCfgById(id);
    }

    /**
     * 查询能源介质配置列表
     * 
     * @param emsEquipCfg 能源介质配置
     * @return 能源介质配置
     */
    @Override
    public List<EmsEquipCfg> selectEmsEquipCfgList(EmsEquipCfg emsEquipCfg)
    {
        return emsEquipCfgMapper.selectEmsEquipCfgList(emsEquipCfg);
    }

    /**
     * 新增能源介质配置
     * 
     * @param emsEquipCfg 能源介质配置
     * @return 结果
     */
    @Override
    public int insertEmsEquipCfg(EmsEquipCfg emsEquipCfg)
    {
        return emsEquipCfgMapper.insertEmsEquipCfg(emsEquipCfg);
    }

    /**
     * 修改能源介质配置
     * 
     * @param emsEquipCfg 能源介质配置
     * @return 结果
     */
    @Override
    public int updateEmsEquipCfg(EmsEquipCfg emsEquipCfg)
    {
        return emsEquipCfgMapper.updateEmsEquipCfg(emsEquipCfg);
    }

    /**
     * 批量删除能源介质配置
     * 
     * @param ids 需要删除的能源介质配置主键
     * @return 结果
     */
    @Override
    public int deleteEmsEquipCfgByIds(Long[] ids)
    {
        return emsEquipCfgMapper.deleteEmsEquipCfgByIds(ids);
    }

    /**
     * 删除能源介质配置信息
     * 
     * @param id 能源介质配置主键
     * @return 结果
     */
    @Override
    public int deleteEmsEquipCfgById(Long id)
    {
        return emsEquipCfgMapper.deleteEmsEquipCfgById(id);
    }
}
