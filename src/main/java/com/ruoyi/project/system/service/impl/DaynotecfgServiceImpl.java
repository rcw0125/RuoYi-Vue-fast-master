package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DaynotecfgMapper;
import com.ruoyi.project.system.domain.Daynotecfg;
import com.ruoyi.project.system.service.IDaynotecfgService;

/**
 * 工作日志模板Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-22
 */
@Service
public class DaynotecfgServiceImpl implements IDaynotecfgService 
{
    @Autowired
    private DaynotecfgMapper daynotecfgMapper;

    /**
     * 查询工作日志模板
     * 
     * @param id 工作日志模板ID
     * @return 工作日志模板
     */
    @Override
    public Daynotecfg selectDaynotecfgById(Long id)
    {
        return daynotecfgMapper.selectDaynotecfgById(id);
    }

    /**
     * 查询工作日志模板列表
     * 
     * @param daynotecfg 工作日志模板
     * @return 工作日志模板
     */
    @Override
    public List<Daynotecfg> selectDaynotecfgList(Daynotecfg daynotecfg)
    {
        return daynotecfgMapper.selectDaynotecfgList(daynotecfg);
    }

    /**
     * 新增工作日志模板
     * 
     * @param daynotecfg 工作日志模板
     * @return 结果
     */
    @Override
    public int insertDaynotecfg(Daynotecfg daynotecfg)
    {
        daynotecfg.setCreateTime(DateUtils.getNowDate());
        return daynotecfgMapper.insertDaynotecfg(daynotecfg);
    }

    /**
     * 修改工作日志模板
     * 
     * @param daynotecfg 工作日志模板
     * @return 结果
     */
    @Override
    public int updateDaynotecfg(Daynotecfg daynotecfg)
    {
        daynotecfg.setUpdateTime(DateUtils.getNowDate());
        return daynotecfgMapper.updateDaynotecfg(daynotecfg);
    }

    /**
     * 批量删除工作日志模板
     * 
     * @param ids 需要删除的工作日志模板ID
     * @return 结果
     */
    @Override
    public int deleteDaynotecfgByIds(Long[] ids)
    {
        return daynotecfgMapper.deleteDaynotecfgByIds(ids);
    }

    /**
     * 删除工作日志模板信息
     * 
     * @param id 工作日志模板ID
     * @return 结果
     */
    @Override
    public int deleteDaynotecfgById(Long id)
    {
        return daynotecfgMapper.deleteDaynotecfgById(id);
    }
}
