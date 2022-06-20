package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.DianliangDay;

/**
 * 每日电量Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-12
 */
public interface DianliangDayMapper
{
    /**
     * 查询每日电量
     *
     * @param id 每日电量主键
     * @return 每日电量
     */
    public DianliangDay selectDianliangDayById(Long id);


    /**
     * 查询每日电量
     *
     * @param id 每日电量主键
     * @return 每日电量
     */
    public DianliangDay selectLastDianliangDay(DianliangDay dianliangDay);

    /**
     * 查询每日电量列表
     *
     * @param dianliangDay 每日电量
     * @return 每日电量集合
     */
    public List<DianliangDay> selectDianliangDayList(DianliangDay dianliangDay);

    public List<DianliangDay> selectDianliangDayTotalList(DianliangDay dianliangDay);

    /**
     * 新增每日电量
     *
     * @param dianliangDay 每日电量
     * @return 结果
     */
    public int insertDianliangDay(DianliangDay dianliangDay);

    /**
     * 修改每日电量
     *
     * @param dianliangDay 每日电量
     * @return 结果
     */
    public int updateDianliangDay(DianliangDay dianliangDay);

    /**
     * 删除每日电量
     *
     * @param id 每日电量主键
     * @return 结果
     */
    public int deleteDianliangDayById(Long id);

    /**
     * 批量删除每日电量
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDianliangDayByIds(Long[] ids);
}
