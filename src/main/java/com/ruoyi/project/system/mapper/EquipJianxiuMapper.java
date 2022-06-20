package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipJianxiu;

/**
 * 计划检修Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public interface EquipJianxiuMapper 
{
    /**
     * 查询计划检修
     * 
     * @param id 计划检修主键
     * @return 计划检修
     */
    public EquipJianxiu selectEquipJianxiuById(Long id);

    /**
     * 查询计划检修列表
     * 
     * @param equipJianxiu 计划检修
     * @return 计划检修集合
     */
    public List<EquipJianxiu> selectEquipJianxiuList(EquipJianxiu equipJianxiu);

    /**
     * 新增计划检修
     * 
     * @param equipJianxiu 计划检修
     * @return 结果
     */
    public int insertEquipJianxiu(EquipJianxiu equipJianxiu);

    /**
     * 修改计划检修
     * 
     * @param equipJianxiu 计划检修
     * @return 结果
     */
    public int updateEquipJianxiu(EquipJianxiu equipJianxiu);

    /**
     * 删除计划检修
     * 
     * @param id 计划检修主键
     * @return 结果
     */
    public int deleteEquipJianxiuById(Long id);

    /**
     * 批量删除计划检修
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipJianxiuByIds(Long[] ids);
}
