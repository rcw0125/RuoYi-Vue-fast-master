package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.CmsCaidan;

/**
 * 新闻菜单Service接口
 * 
 * @author ruoyi
 * @date 2021-06-29
 */
public interface ICmsCaidanService 
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
     * 批量删除新闻菜单
     * 
     * @param ids 需要删除的新闻菜单ID
     * @return 结果
     */
    public int deleteCmsCaidanByIds(Long[] ids);

    /**
     * 删除新闻菜单信息
     * 
     * @param id 新闻菜单ID
     * @return 结果
     */
    public int deleteCmsCaidanById(Long id);
}
