package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.CmsCaidanMapper;
import com.ruoyi.project.system.domain.CmsCaidan;
import com.ruoyi.project.system.service.ICmsCaidanService;

/**
 * 新闻菜单Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-29
 */
@Service
public class CmsCaidanServiceImpl implements ICmsCaidanService
{
    @Autowired
    private CmsCaidanMapper cmsCaidanMapper;

    /**
     * 查询新闻菜单
     *
     * @param id 新闻菜单ID
     * @return 新闻菜单
     */
    @Override
    public CmsCaidan selectCmsCaidanById(Long id)
    {
        return cmsCaidanMapper.selectCmsCaidanById(id);
    }

    /**
     * 查询新闻菜单列表
     *
     * @param cmsCaidan 新闻菜单
     * @return 新闻菜单
     */
    @Override
    public List<CmsCaidan> selectCmsCaidanList(CmsCaidan cmsCaidan)
    {
        return cmsCaidanMapper.selectCmsCaidanList(cmsCaidan);
    }

    /**
     * 新增新闻菜单
     *
     * @param cmsCaidan 新闻菜单
     * @return 结果
     */
    @Override
    public int insertCmsCaidan(CmsCaidan cmsCaidan)
    {
        /** 查询父id项目**/
        CmsCaidan  info=cmsCaidanMapper.selectCmsCaidanById(cmsCaidan.getParentId());
        /** 将关联字段设置为   父项目的关联字段+ 当前的项目的父id**/
        cmsCaidan.setAncestors(info.getAncestors() + "," + cmsCaidan.getParentId());
        cmsCaidan.setCreateTime(DateUtils.getNowDate());
        return cmsCaidanMapper.insertCmsCaidan(cmsCaidan);
    }

    /**
     * 修改新闻菜单
     *
     * @param cmsCaidan 新闻菜单
     * @return 结果
     */
    @Override
    public int updateCmsCaidan(CmsCaidan cmsCaidan)
    {
        /** 查询新父id项目**/
        CmsCaidan  newParentQuyu=cmsCaidanMapper.selectCmsCaidanById(cmsCaidan.getParentId());
        CmsCaidan  oldQuyu=cmsCaidanMapper.selectCmsCaidanById(cmsCaidan.getId());
        if (StringUtils.isNotNull(newParentQuyu) && StringUtils.isNotNull(oldQuyu)) {
            String newAncestors = newParentQuyu.getAncestors() + "," + newParentQuyu.getId();
            String oldAncestors = oldQuyu.getAncestors();
            /** 设置当前项目的关联字段**/
            cmsCaidan.setAncestors(newAncestors);
            updateCaidanChildren(cmsCaidan.getId(), newAncestors, oldAncestors);
        }
        cmsCaidan.setUpdateTime(DateUtils.getNowDate());
        return cmsCaidanMapper.updateCmsCaidan(cmsCaidan);
    }

    /**
     * 修改子元素关系
     *
     * @param Id 被修改的部区域ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateCaidanChildren(Long Id, String newAncestors, String oldAncestors)
    {
        List<CmsCaidan> children = cmsCaidanMapper.selectChildrenCaidanById(Id);
        for (CmsCaidan child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            cmsCaidanMapper.updateCaidanChildren(children);
        }
    }

    /**
     * 批量删除新闻菜单
     *
     * @param ids 需要删除的新闻菜单ID
     * @return 结果
     */
    @Override
    public int deleteCmsCaidanByIds(Long[] ids)
    {
        return cmsCaidanMapper.deleteCmsCaidanByIds(ids);
    }

    /**
     * 删除新闻菜单信息
     *
     * @param id 新闻菜单ID
     * @return 结果
     */
    @Override
    public int deleteCmsCaidanById(Long id)
    {
        return cmsCaidanMapper.deleteCmsCaidanById(id);
    }
}
