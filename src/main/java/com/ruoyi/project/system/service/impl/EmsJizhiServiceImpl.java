package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EmsJizhiMapper;
import com.ruoyi.project.system.domain.EmsJizhi;
import com.ruoyi.project.system.service.IEmsJizhiService;

/**
 * 介质停送记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-22
 */
@Service
public class EmsJizhiServiceImpl implements IEmsJizhiService 
{
    @Autowired
    private EmsJizhiMapper emsJizhiMapper;

    /**
     * 查询介质停送记录
     * 
     * @param id 介质停送记录主键
     * @return 介质停送记录
     */
    @Override
    public EmsJizhi selectEmsJizhiById(Long id)
    {
        return emsJizhiMapper.selectEmsJizhiById(id);
    }

    /**
     * 查询介质停送记录列表
     * 
     * @param emsJizhi 介质停送记录
     * @return 介质停送记录
     */
    @Override
    public List<EmsJizhi> selectEmsJizhiList(EmsJizhi emsJizhi)
    {
        return emsJizhiMapper.selectEmsJizhiList(emsJizhi);
    }

    /**
     * 新增介质停送记录
     * 
     * @param emsJizhi 介质停送记录
     * @return 结果
     */
    @Override
    public int insertEmsJizhi(EmsJizhi emsJizhi)
    {
        return emsJizhiMapper.insertEmsJizhi(emsJizhi);
    }

    /**
     * 修改介质停送记录
     * 
     * @param emsJizhi 介质停送记录
     * @return 结果
     */
    @Override
    public int updateEmsJizhi(EmsJizhi emsJizhi)
    {
        return emsJizhiMapper.updateEmsJizhi(emsJizhi);
    }

    /**
     * 批量删除介质停送记录
     * 
     * @param ids 需要删除的介质停送记录主键
     * @return 结果
     */
    @Override
    public int deleteEmsJizhiByIds(Long[] ids)
    {
        return emsJizhiMapper.deleteEmsJizhiByIds(ids);
    }

    /**
     * 删除介质停送记录信息
     * 
     * @param id 介质停送记录主键
     * @return 结果
     */
    @Override
    public int deleteEmsJizhiById(Long id)
    {
        return emsJizhiMapper.deleteEmsJizhiById(id);
    }
}
