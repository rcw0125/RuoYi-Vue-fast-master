package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Zizhugaishan;

/**
 * 员工自主改善Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
public interface ZizhugaishanMapper 
{
    /**
     * 查询员工自主改善
     * 
     * @param id 员工自主改善ID
     * @return 员工自主改善
     */
    public Zizhugaishan selectZizhugaishanById(Integer id);

    /**
     * 查询员工自主改善列表
     * 
     * @param zizhugaishan 员工自主改善
     * @return 员工自主改善集合
     */
    public List<Zizhugaishan> selectZizhugaishanList(Zizhugaishan zizhugaishan);

    /**
     * 新增员工自主改善
     * 
     * @param zizhugaishan 员工自主改善
     * @return 结果
     */
    public int insertZizhugaishan(Zizhugaishan zizhugaishan);

    /**
     * 修改员工自主改善
     * 
     * @param zizhugaishan 员工自主改善
     * @return 结果
     */
    public int updateZizhugaishan(Zizhugaishan zizhugaishan);

    /**
     * 删除员工自主改善
     * 
     * @param id 员工自主改善ID
     * @return 结果
     */
    public int deleteZizhugaishanById(Integer id);

    /**
     * 批量删除员工自主改善
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZizhugaishanByIds(Integer[] ids);
}
