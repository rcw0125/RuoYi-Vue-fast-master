package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EmsJizhi;

/**
 * 介质停送记录Service接口
 * 
 * @author ruoyi
 * @date 2021-10-22
 */
public interface IEmsJizhiService 
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
     * 批量删除介质停送记录
     * 
     * @param ids 需要删除的介质停送记录主键集合
     * @return 结果
     */
    public int deleteEmsJizhiByIds(Long[] ids);

    /**
     * 删除介质停送记录信息
     * 
     * @param id 介质停送记录主键
     * @return 结果
     */
    public int deleteEmsJizhiById(Long id);
}
