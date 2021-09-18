package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ZhibiaocfgMapper;
import com.ruoyi.project.system.domain.Zhibiaocfg;
import com.ruoyi.project.system.service.IZhibiaocfgService;

/**
 * 指标配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@Service
public class ZhibiaocfgServiceImpl implements IZhibiaocfgService 
{
    @Autowired
    private ZhibiaocfgMapper zhibiaocfgMapper;

    /**
     * 查询指标配置
     * 
     * @param id 指标配置ID
     * @return 指标配置
     */
    @Override
    public Zhibiaocfg selectZhibiaocfgById(Long id)
    {
        return zhibiaocfgMapper.selectZhibiaocfgById(id);
    }

    /**
     * 查询指标配置列表
     * 
     * @param zhibiaocfg 指标配置
     * @return 指标配置
     */
    @Override
    public List<Zhibiaocfg> selectZhibiaocfgList(Zhibiaocfg zhibiaocfg)
    {
        return zhibiaocfgMapper.selectZhibiaocfgList(zhibiaocfg);
    }

    /**
     * 新增指标配置
     * 
     * @param zhibiaocfg 指标配置
     * @return 结果
     */
    @Override
    public int insertZhibiaocfg(Zhibiaocfg zhibiaocfg)
    {
        return zhibiaocfgMapper.insertZhibiaocfg(zhibiaocfg);
    }

    /**
     * 修改指标配置
     * 
     * @param zhibiaocfg 指标配置
     * @return 结果
     */
    @Override
    public int updateZhibiaocfg(Zhibiaocfg zhibiaocfg)
    {
        return zhibiaocfgMapper.updateZhibiaocfg(zhibiaocfg);
    }

    /**
     * 批量删除指标配置
     * 
     * @param ids 需要删除的指标配置ID
     * @return 结果
     */
    @Override
    public int deleteZhibiaocfgByIds(Long[] ids)
    {
        return zhibiaocfgMapper.deleteZhibiaocfgByIds(ids);
    }

    /**
     * 删除指标配置信息
     * 
     * @param id 指标配置ID
     * @return 结果
     */
    @Override
    public int deleteZhibiaocfgById(Long id)
    {
        return zhibiaocfgMapper.deleteZhibiaocfgById(id);
    }
}
