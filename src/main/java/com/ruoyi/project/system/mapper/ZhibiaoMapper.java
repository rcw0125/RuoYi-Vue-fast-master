package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Zhibiao;

/**
 * 指标记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public interface ZhibiaoMapper 
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
     * 删除指标记录
     * 
     * @param id 指标记录ID
     * @return 结果
     */
    public int deleteZhibiaoById(Long id);

    /**
     * 批量删除指标记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhibiaoByIds(Long[] ids);
}
