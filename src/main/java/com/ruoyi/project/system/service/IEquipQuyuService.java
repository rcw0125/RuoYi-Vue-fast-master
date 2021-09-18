package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EquipQuyu;

/**
 * 设备区域Service接口
 * 
 * @author ruoyi
 * @date 2021-06-29
 */
public interface IEquipQuyuService 
{
    /**
     * 查询设备区域
     * 
     * @param id 设备区域ID
     * @return 设备区域
     */
    public EquipQuyu selectEquipQuyuById(Long id);

    /**
     * 查询设备区域列表
     * 
     * @param equipQuyu 设备区域
     * @return 设备区域集合
     */
    public List<EquipQuyu> selectEquipQuyuList(EquipQuyu equipQuyu);

    /**
     * 新增设备区域
     * 
     * @param equipQuyu 设备区域
     * @return 结果
     */
    public int insertEquipQuyu(EquipQuyu equipQuyu);

    /**
     * 修改设备区域
     * 
     * @param equipQuyu 设备区域
     * @return 结果
     */
    public int updateEquipQuyu(EquipQuyu equipQuyu);

    /**
     * 批量删除设备区域
     * 
     * @param ids 需要删除的设备区域ID
     * @return 结果
     */
    public int deleteEquipQuyuByIds(Long[] ids);

    /**
     * 删除设备区域信息
     * 
     * @param id 设备区域ID
     * @return 结果
     */
    public int deleteEquipQuyuById(Long id);
}
