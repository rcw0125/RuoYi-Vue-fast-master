package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.CmsCaidan;
import org.apache.ibatis.annotations.Param;

/**
 * 新闻菜单Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-29
 */
public interface CmsCaidanMapper
{
    /**
     * 查询新闻菜单
     *
     * @param id 新闻菜单ID
     * @return 新闻菜单
     */
    public CmsCaidan selectCmsCaidanById(Long id);

    /**
     * 查询新闻菜单列表
     *
     * @param cmsCaidan 新闻菜单
     * @return 新闻菜单集合
     */
    public List<CmsCaidan> selectCmsCaidanList(CmsCaidan cmsCaidan);

    /**
     * 修改子元素关系
     *
     * @param caidans 子元素
     * @return 结果
     */
    public int updateCaidanChildren(@Param("caidans") List<CmsCaidan> caidans);
    /**
     * 根据ID查询所有子新闻菜单
     *
     * @param Id 新闻菜单ID
     * @return 新闻菜单列表
     */
    public List<CmsCaidan> selectChildrenCaidanById(Long Id);
    /**
     * 新增新闻菜单
     *
     * @param cmsCaidan 新闻菜单
     * @return 结果
     */
    public int insertCmsCaidan(CmsCaidan cmsCaidan);

    /**
     * 修改新闻菜单
     *
     * @param cmsCaidan 新闻菜单
     * @return 结果
     */
    public int updateCmsCaidan(CmsCaidan cmsCaidan);

    /**
     * 删除新闻菜单
     *
     * @param id 新闻菜单ID
     * @return 结果
     */
    public int deleteCmsCaidanById(Long id);

    /**
     * 批量删除新闻菜单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsCaidanByIds(Long[] ids);
}
