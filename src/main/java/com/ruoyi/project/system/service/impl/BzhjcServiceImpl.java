package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.BzhjcMapper;
import com.ruoyi.project.system.domain.Bzhjc;
import com.ruoyi.project.system.service.IBzhjcService;

/**
 * 标准化检查Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-13
 */
@Service
public class BzhjcServiceImpl implements IBzhjcService 
{
    @Autowired
    private BzhjcMapper bzhjcMapper;

    /**
     * 查询标准化检查
     * 
     * @param id 标准化检查ID
     * @return 标准化检查
     */
    @Override
    public Bzhjc selectBzhjcById(Long id)
    {
        return bzhjcMapper.selectBzhjcById(id);
    }

    /**
     * 查询标准化检查列表
     * 
     * @param bzhjc 标准化检查
     * @return 标准化检查
     */
    @Override
    public List<Bzhjc> selectBzhjcList(Bzhjc bzhjc)
    {
        return bzhjcMapper.selectBzhjcList(bzhjc);
    }

    /**
     * 新增标准化检查
     * 
     * @param bzhjc 标准化检查
     * @return 结果
     */
    @Override
    public int insertBzhjc(Bzhjc bzhjc)
    {
        return bzhjcMapper.insertBzhjc(bzhjc);
    }

    /**
     * 修改标准化检查
     * 
     * @param bzhjc 标准化检查
     * @return 结果
     */
    @Override
    public int updateBzhjc(Bzhjc bzhjc)
    {
        return bzhjcMapper.updateBzhjc(bzhjc);
    }

    /**
     * 批量删除标准化检查
     * 
     * @param ids 需要删除的标准化检查ID
     * @return 结果
     */
    @Override
    public int deleteBzhjcByIds(Long[] ids)
    {
        return bzhjcMapper.deleteBzhjcByIds(ids);
    }

    /**
     * 删除标准化检查信息
     * 
     * @param id 标准化检查ID
     * @return 结果
     */
    @Override
    public int deleteBzhjcById(Long id)
    {
        return bzhjcMapper.deleteBzhjcById(id);
    }
}
