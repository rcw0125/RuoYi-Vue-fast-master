package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.KaoheMapper;
import com.ruoyi.project.system.domain.Kaohe;
import com.ruoyi.project.system.service.IKaoheService;

/**
 * 考核单Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-08
 */
@Service
public class KaoheServiceImpl implements IKaoheService 
{
    @Autowired
    private KaoheMapper kaoheMapper;

    /**
     * 查询考核单
     * 
     * @param kaoheId 考核单ID
     * @return 考核单
     */
    @Override
    public Kaohe selectKaoheById(Long kaoheId)
    {
        return kaoheMapper.selectKaoheById(kaoheId);
    }

    /**
     * 查询考核单列表
     * 
     * @param kaohe 考核单
     * @return 考核单
     */
    @Override
    public List<Kaohe> selectKaoheList(Kaohe kaohe)
    {
        return kaoheMapper.selectKaoheList(kaohe);
    }

    /**
     * 新增考核单
     * 
     * @param kaohe 考核单
     * @return 结果
     */
    @Override
    public int insertKaohe(Kaohe kaohe)
    {
        return kaoheMapper.insertKaohe(kaohe);
    }

    /**
     * 修改考核单
     * 
     * @param kaohe 考核单
     * @return 结果
     */
    @Override
    public int updateKaohe(Kaohe kaohe)
    {
        return kaoheMapper.updateKaohe(kaohe);
    }

    /**
     * 批量删除考核单
     * 
     * @param kaoheIds 需要删除的考核单ID
     * @return 结果
     */
    @Override
    public int deleteKaoheByIds(Long[] kaoheIds)
    {
        return kaoheMapper.deleteKaoheByIds(kaoheIds);
    }

    /**
     * 删除考核单信息
     * 
     * @param kaoheId 考核单ID
     * @return 结果
     */
    @Override
    public int deleteKaoheById(Long kaoheId)
    {
        return kaoheMapper.deleteKaoheById(kaoheId);
    }
}
