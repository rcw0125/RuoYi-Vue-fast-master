package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EquipQuyu;
import org.apache.ibatis.annotations.Param;

/**
 * 设备区域Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-29
 */
public interface EquipQuyuMapper
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
     * 修改子元素关系
     *
     * @param equips 子元素
     * @return 结果
     */
    public int updateQuyuChildren(@Param("equips") List<EquipQuyu> equips);
    /**
     * 根据ID查询所有子设备区域
     *
     * @param Id 设备区域ID
     * @return 设备区域列表
     */
    public List<EquipQuyu> selectChildrenQuyuById(Long Id);

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
     * 删除设备区域
     *
     * @param id 设备区域ID
     * @return 结果
     */
    public int deleteEquipQuyuById(Long id);

    /**
     * 批量删除设备区域
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquipQuyuByIds(Long[] ids);
}
