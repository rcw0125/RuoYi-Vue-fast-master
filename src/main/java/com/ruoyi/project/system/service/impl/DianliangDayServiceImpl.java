package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DianliangDayMapper;
import com.ruoyi.project.system.domain.DianliangDay;
import com.ruoyi.project.system.service.IDianliangDayService;

/**
 * 每日电量Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-12
 */
@Service
public class DianliangDayServiceImpl implements IDianliangDayService
{
    @Autowired
    private DianliangDayMapper dianliangDayMapper;

    /**
     * 查询每日电量
     *
     * @param id 每日电量主键
     * @return 每日电量
     */
    @Override
    public DianliangDay selectDianliangDayById(Long id)
    {
        return dianliangDayMapper.selectDianliangDayById(id);
    }

    public DianliangDay selectLastDianliangDay(DianliangDay dianliangDay)
    {
        return dianliangDayMapper.selectLastDianliangDay(dianliangDay);
    };

    /**
     * 查询每日电量列表
     *
     * @param dianliangDay 每日电量
     * @return 每日电量
     */
    @Override
    public List<DianliangDay> selectDianliangDayList(DianliangDay dianliangDay)
    {
        return dianliangDayMapper.selectDianliangDayList(dianliangDay);
    }

    @Override
    public List<DianliangDay> selectDianliangDayTotalList(DianliangDay dianliangDay)
    {
        return dianliangDayMapper.selectDianliangDayTotalList(dianliangDay);
    }
    /**
     * 新增每日电量
     *
     * @param dianliangDay 每日电量
     * @return 结果
     */
    @Override
    public int insertDianliangDay(DianliangDay dianliangDay)
    {
        return dianliangDayMapper.insertDianliangDay(dianliangDay);
    }

    /**
     * 修改每日电量
     *
     * @param dianliangDay 每日电量
     * @return 结果
     */
    @Override
    public int updateDianliangDay(DianliangDay dianliangDay)
    {
        return dianliangDayMapper.updateDianliangDay(dianliangDay);
    }

    /**
     * 批量删除每日电量
     *
     * @param ids 需要删除的每日电量主键
     * @return 结果
     */
    @Override
    public int deleteDianliangDayByIds(Long[] ids)
    {
        return dianliangDayMapper.deleteDianliangDayByIds(ids);
    }

    /**
     * 删除每日电量信息
     *
     * @param id 每日电量主键
     * @return 结果
     */
    @Override
    public int deleteDianliangDayById(Long id)
    {
        return dianliangDayMapper.deleteDianliangDayById(id);
    }
}
