package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipGuzhang;

/**
 * 故障报修Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public interface EquipGuzhangMapper 
{
    /**
     * 查询故障报修
     * 
     * @param id 故障报修主键
     * @return 故障报修
     */
    public EquipGuzhang selectEquipGuzhangById(Long id);

    /**
     * 查询故障报修列表
     * 
     * @param equipGuzhang 故障报修
     * @return 故障报修集合
     */
    public List<EquipGuzhang> selectEquipGuzhangList(EquipGuzhang equipGuzhang);

    /**
     * 新增故障报修
     * 
     * @param equipGuzhang 故障报修
     * @return 结果
     */
    public int insertEquipGuzhang(EquipGuzhang equipGuzhang);

    /**
     * 修改故障报修
     * 
     * @param equipGuzhang 故障报修
     * @return 结果
     */
    public int updateEquipGuzhang(EquipGuzhang equipGuzhang);

    /**
     * 删除故障报修
     * 
     * @param id 故障报修主键
     * @return 结果
     */
    public int deleteEquipGuzhangById(Long id);

    /**
     * 批量删除故障报修
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipGuzhangByIds(Long[] ids);
}
