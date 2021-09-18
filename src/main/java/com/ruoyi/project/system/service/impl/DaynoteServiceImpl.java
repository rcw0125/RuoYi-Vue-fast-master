package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DaynoteMapper;
import com.ruoyi.project.system.domain.Daynote;
import com.ruoyi.project.system.service.IDaynoteService;

/**
 * 工作日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Service
public class DaynoteServiceImpl implements IDaynoteService 
{
    @Autowired
    private DaynoteMapper daynoteMapper;

    /**
     * 查询工作日志
     * 
     * @param id 工作日志ID
     * @return 工作日志
     */
    @Override
    public Daynote selectDaynoteById(Long id)
    {
        return daynoteMapper.selectDaynoteById(id);
    }

    /**
     * 查询工作日志列表
     * 
     * @param daynote 工作日志
     * @return 工作日志
     */
    @Override
    public List<Daynote> selectDaynoteList(Daynote daynote)
    {
        return daynoteMapper.selectDaynoteList(daynote);
    }

    /**
     * 新增工作日志
     * 
     * @param daynote 工作日志
     * @return 结果
     */
    @Override
    public int insertDaynote(Daynote daynote)
    {
        daynote.setCreateTime(DateUtils.getNowDate());
        return daynoteMapper.insertDaynote(daynote);
    }

    /**
     * 修改工作日志
     * 
     * @param daynote 工作日志
     * @return 结果
     */
    @Override
    public int updateDaynote(Daynote daynote)
    {
        daynote.setUpdateTime(DateUtils.getNowDate());
        return daynoteMapper.updateDaynote(daynote);
    }

    /**
     * 批量删除工作日志
     * 
     * @param ids 需要删除的工作日志ID
     * @return 结果
     */
    @Override
    public int deleteDaynoteByIds(Long[] ids)
    {
        return daynoteMapper.deleteDaynoteByIds(ids);
    }

    /**
     * 删除工作日志信息
     * 
     * @param id 工作日志ID
     * @return 结果
     */
    @Override
    public int deleteDaynoteById(Long id)
    {
        return daynoteMapper.deleteDaynoteById(id);
    }
}
