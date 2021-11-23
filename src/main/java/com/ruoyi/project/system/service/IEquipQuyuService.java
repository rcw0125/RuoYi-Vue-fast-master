package com.ruoyi.project.system.service;

import java.util.List;

import com.ruoyi.framework.web.domain.TreeSelect;
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
     * 构建前端所需要树结构
     *
     * @param quyus 部门列表
     * @return 树结构列表
     */
    public List<EquipQuyu> buildTree(List<EquipQuyu> quyus);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param quyus 部门列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildQuyuTreeSelect(List<EquipQuyu> quyus);
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
