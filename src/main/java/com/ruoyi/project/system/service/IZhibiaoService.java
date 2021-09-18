package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Zhibiao;

/**
 * 指标记录Service接口
 *
 * @author ruoyi
 * @date 2021-04-15
 */
public interface IZhibiaoService
{
    /**
     * 查询指标记录
     *
     * @param id 指标记录ID
     * @return 指标记录
     */
    public Zhibiao selectZhibiaoById(Long id);

    /**
     * 查询指标记录列表
     *
     * @param zhibiao 指标记录
     * @return 指标记录集合
     */
    public List<Zhibiao> selectZhibiaoList(Zhibiao zhibiao);

    /**
     * 新增指标记录
     *
     * @param zhibiao 指标记录
     * @return 结果
     */
    public int insertZhibiao(Zhibiao zhibiao);

    /**
     * 修改指标记录
     *
     * @param zhibiao 指标记录
     * @return 结果
     */
    public int updateZhibiao(Zhibiao zhibiao);

    /**
     * 批量删除指标记录
     *
     * @param ids 需要删除的指标记录ID
     * @return 结果
     */
    public int deleteZhibiaoByIds(Long[] ids);

    /**
     * 删除指标记录信息
     *
     * @param id 指标记录ID
     * @return 结果
     */
    public int deleteZhibiaoById(Long id);
    /**
     * 导入用户数据
     *
     * @param zhibiaoList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importZhibiao(List<Zhibiao> zhibiaoList, Boolean isUpdateSupport, String operName);
}
