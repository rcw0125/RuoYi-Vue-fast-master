package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DianliangCfgMapper;
import com.ruoyi.project.system.domain.DianliangCfg;
import com.ruoyi.project.system.service.IDianliangCfgService;

/**
 * 电量配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
@Service
public class DianliangCfgServiceImpl implements IDianliangCfgService 
{
    @Autowired
    private DianliangCfgMapper dianliangCfgMapper;

    /**
     * 查询电量配置
     * 
     * @param id 电量配置主键
     * @return 电量配置
     */
    @Override
    public DianliangCfg selectDianliangCfgById(Long id)
    {
        return dianliangCfgMapper.selectDianliangCfgById(id);
    }

    /**
     * 查询电量配置列表
     * 
     * @param dianliangCfg 电量配置
     * @return 电量配置
     */
    @Override
    public List<DianliangCfg> selectDianliangCfgList(DianliangCfg dianliangCfg)
    {
        return dianliangCfgMapper.selectDianliangCfgList(dianliangCfg);
    }

    /**
     * 新增电量配置
     * 
     * @param dianliangCfg 电量配置
     * @return 结果
     */
    @Override
    public int insertDianliangCfg(DianliangCfg dianliangCfg)
    {
        return dianliangCfgMapper.insertDianliangCfg(dianliangCfg);
    }

    /**
     * 修改电量配置
     * 
     * @param dianliangCfg 电量配置
     * @return 结果
     */
    @Override
    public int updateDianliangCfg(DianliangCfg dianliangCfg)
    {
        return dianliangCfgMapper.updateDianliangCfg(dianliangCfg);
    }

    /**
     * 批量删除电量配置
     * 
     * @param ids 需要删除的电量配置主键
     * @return 结果
     */
    @Override
    public int deleteDianliangCfgByIds(Long[] ids)
    {
        return dianliangCfgMapper.deleteDianliangCfgByIds(ids);
    }

    /**
     * 删除电量配置信息
     * 
     * @param id 电量配置主键
     * @return 结果
     */
    @Override
    public int deleteDianliangCfgById(Long id)
    {
        return dianliangCfgMapper.deleteDianliangCfgById(id);
    }
}
