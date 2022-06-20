package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.DianliangBiaozhun;

/**
 * 电量标准Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-12
 */
public interface DianliangBiaozhunMapper 
{
    /**
     * 查询电量标准
     * 
     * @param id 电量标准主键
     * @return 电量标准
     */
    public DianliangBiaozhun selectDianliangBiaozhunById(Integer id);

    /**
     * 查询电量标准列表
     * 
     * @param dianliangBiaozhun 电量标准
     * @return 电量标准集合
     */
    public List<DianliangBiaozhun> selectDianliangBiaozhunList(DianliangBiaozhun dianliangBiaozhun);

    /**
     * 新增电量标准
     * 
     * @param dianliangBiaozhun 电量标准
     * @return 结果
     */
    public int insertDianliangBiaozhun(DianliangBiaozhun dianliangBiaozhun);

    /**
     * 修改电量标准
     * 
     * @param dianliangBiaozhun 电量标准
     * @return 结果
     */
    public int updateDianliangBiaozhun(DianliangBiaozhun dianliangBiaozhun);

    /**
     * 删除电量标准
     * 
     * @param id 电量标准主键
     * @return 结果
     */
    public int deleteDianliangBiaozhunById(Integer id);

    /**
     * 批量删除电量标准
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDianliangBiaozhunByIds(Integer[] ids);
}
