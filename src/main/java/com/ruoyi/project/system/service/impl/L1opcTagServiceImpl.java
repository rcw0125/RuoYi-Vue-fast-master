package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.L1opcTagMapper;
import com.ruoyi.project.system.domain.L1opcTag;
import com.ruoyi.project.system.service.IL1opcTagService;

/**
 * opctagService业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
@Service
public class L1opcTagServiceImpl implements IL1opcTagService 
{
    @Autowired
    private L1opcTagMapper l1opcTagMapper;

    /**
     * 查询opctag
     * 
     * @param id opctagID
     * @return opctag
     */
    @Override
    public L1opcTag selectL1opcTagById(Long id)
    {
        return l1opcTagMapper.selectL1opcTagById(id);
    }

    /**
     * 查询opctag列表
     * 
     * @param l1opcTag opctag
     * @return opctag
     */
    @Override
    public List<L1opcTag> selectL1opcTagList(L1opcTag l1opcTag)
    {
        return l1opcTagMapper.selectL1opcTagList(l1opcTag);
    }

    /**
     * 新增opctag
     * 
     * @param l1opcTag opctag
     * @return 结果
     */
    @Override
    public int insertL1opcTag(L1opcTag l1opcTag)
    {
        return l1opcTagMapper.insertL1opcTag(l1opcTag);
    }

    /**
     * 修改opctag
     * 
     * @param l1opcTag opctag
     * @return 结果
     */
    @Override
    public int updateL1opcTag(L1opcTag l1opcTag)
    {
        return l1opcTagMapper.updateL1opcTag(l1opcTag);
    }

    /**
     * 批量删除opctag
     * 
     * @param ids 需要删除的opctagID
     * @return 结果
     */
    @Override
    public int deleteL1opcTagByIds(Long[] ids)
    {
        return l1opcTagMapper.deleteL1opcTagByIds(ids);
    }

    /**
     * 删除opctag信息
     * 
     * @param id opctagID
     * @return 结果
     */
    @Override
    public int deleteL1opcTagById(Long id)
    {
        return l1opcTagMapper.deleteL1opcTagById(id);
    }
}
