package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.L1opcTag;

/**
 * opctagService接口
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
public interface IL1opcTagService 
{
    /**
     * 查询opctag
     * 
     * @param id opctagID
     * @return opctag
     */
    public L1opcTag selectL1opcTagById(Long id);

    /**
     * 查询opctag列表
     * 
     * @param l1opcTag opctag
     * @return opctag集合
     */
    public List<L1opcTag> selectL1opcTagList(L1opcTag l1opcTag);

    /**
     * 新增opctag
     * 
     * @param l1opcTag opctag
     * @return 结果
     */
    public int insertL1opcTag(L1opcTag l1opcTag);

    /**
     * 修改opctag
     * 
     * @param l1opcTag opctag
     * @return 结果
     */
    public int updateL1opcTag(L1opcTag l1opcTag);

    /**
     * 批量删除opctag
     * 
     * @param ids 需要删除的opctagID
     * @return 结果
     */
    public int deleteL1opcTagByIds(Long[] ids);

    /**
     * 删除opctag信息
     * 
     * @param id opctagID
     * @return 结果
     */
    public int deleteL1opcTagById(Long id);
}
