package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.DianliangMingxi;

/**
 * 电量明细Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public interface DianliangMingxiMapper 
{
    /**
     * 查询电量明细
     * 
     * @param id 电量明细主键
     * @return 电量明细
     */
    public DianliangMingxi selectDianliangMingxiById(Long id);

    /**
     * 查询电量明细列表
     * 
     * @param dianliangMingxi 电量明细
     * @return 电量明细集合
     */
    public List<DianliangMingxi> selectDianliangMingxiList(DianliangMingxi dianliangMingxi);

    /**
     * 新增电量明细
     * 
     * @param dianliangMingxi 电量明细
     * @return 结果
     */
    public int insertDianliangMingxi(DianliangMingxi dianliangMingxi);

    /**
     * 修改电量明细
     * 
     * @param dianliangMingxi 电量明细
     * @return 结果
     */
    public int updateDianliangMingxi(DianliangMingxi dianliangMingxi);

    /**
     * 删除电量明细
     * 
     * @param id 电量明细主键
     * @return 结果
     */
    public int deleteDianliangMingxiById(Long id);

    /**
     * 批量删除电量明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDianliangMingxiByIds(Long[] ids);
}
