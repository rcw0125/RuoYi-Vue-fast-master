package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.EmsJizhi;

/**
 * 介质停送记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-22
 */
public interface EmsJizhiMapper 
{
    /**
     * 查询介质停送记录
     * 
     * @param id 介质停送记录主键
     * @return 介质停送记录
     */
    public EmsJizhi selectEmsJizhiById(Long id);

    /**
     * 查询介质停送记录列表
     * 
     * @param emsJizhi 介质停送记录
     * @return 介质停送记录集合
     */
    public List<EmsJizhi> selectEmsJizhiList(EmsJizhi emsJizhi);

    /**
     * 新增介质停送记录
     * 
     * @param emsJizhi 介质停送记录
     * @return 结果
     */
    public int insertEmsJizhi(EmsJizhi emsJizhi);

    /**
     * 修改介质停送记录
     * 
     * @param emsJizhi 介质停送记录
     * @return 结果
     */
    public int updateEmsJizhi(EmsJizhi emsJizhi);

    /**
     * 删除介质停送记录
     * 
     * @param id 介质停送记录主键
     * @return 结果
     */
    public int deleteEmsJizhiById(Long id);

    /**
     * 批量删除介质停送记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmsJizhiByIds(Long[] ids);
}
