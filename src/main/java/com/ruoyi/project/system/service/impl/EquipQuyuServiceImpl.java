package com.ruoyi.project.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.TreeSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EquipQuyuMapper;
import com.ruoyi.project.system.domain.EquipQuyu;
import com.ruoyi.project.system.service.IEquipQuyuService;

/**
 * 设备区域Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-29
 */
@Service
public class EquipQuyuServiceImpl implements IEquipQuyuService
{
    @Autowired
    private EquipQuyuMapper equipQuyuMapper;

    /**
     * 查询设备区域
     *
     * @param id 设备区域ID
     * @return 设备区域
     */
    @Override
    public EquipQuyu selectEquipQuyuById(Long id)
    {
        return equipQuyuMapper.selectEquipQuyuById(id);
    }

    /**
     * 查询设备区域列表
     *
     * @param equipQuyu 设备区域
     * @return 设备区域
     */
    @Override
    public List<EquipQuyu> selectEquipQuyuList(EquipQuyu equipQuyu)
    {
        return equipQuyuMapper.selectEquipQuyuList(equipQuyu);
    }

    /**
     * 新增设备区域
     *
     * @param equipQuyu 设备区域
     * @return 结果
     */
    @Override
    public int insertEquipQuyu(EquipQuyu equipQuyu)
    {
        /** 查询父id项目**/
        EquipQuyu  info=equipQuyuMapper.selectEquipQuyuById(equipQuyu.getParentId());
        /** 将关联字段设置为   父项目的关联字段+ 当前的项目的父id**/
        equipQuyu.setAncestors(info.getAncestors() + "," + equipQuyu.getParentId());
        /** 根目录 设备名称为本身的设备部件名称，子目录为父设备名称+本身的部件名称*/
        if(equipQuyu.getParentId()==0){
            equipQuyu.setName(equipQuyu.getNote());
        }
        else {
            equipQuyu.setName(info.getName()+"-"+equipQuyu.getNote());
        }
        equipQuyu.setCreateTime(DateUtils.getNowDate());
        return equipQuyuMapper.insertEquipQuyu(equipQuyu);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param quyus 部门列表
     * @return 树结构列表
     */
    @Override
    public List<EquipQuyu> buildTree(List<EquipQuyu>  quyus)
    {
        List<EquipQuyu> returnList = new ArrayList<EquipQuyu>();
        List<Long> tempList = new ArrayList<Long>();
        for (EquipQuyu dept : quyus)
        {
            tempList.add(dept.getId());
        }
        for (Iterator<EquipQuyu> iterator = quyus.iterator(); iterator.hasNext();)
        {
            EquipQuyu dept = (EquipQuyu) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId()))
            {
                recursionFn(quyus, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = quyus;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<EquipQuyu> list, EquipQuyu t)
    {
        // 得到子节点列表
        List<EquipQuyu> childList = getChildList(list, t);

        t.setChildren(childList);
        for (EquipQuyu tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<EquipQuyu> getChildList(List<EquipQuyu> list, EquipQuyu t)
    {
        List<EquipQuyu> tlist = new ArrayList<EquipQuyu>();
        Iterator<EquipQuyu> it = list.iterator();
        while (it.hasNext())
        {
            EquipQuyu n = (EquipQuyu) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<EquipQuyu> list, EquipQuyu t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
    /**
     * 构建前端所需要下拉树结构
     *
     * @param quyus 部门列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildQuyuTreeSelect(List<EquipQuyu> quyus)
    {
        List<EquipQuyu> deptTrees = buildTree(quyus);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }
    /**
     * 修改设备区域
     *
     * @param equipQuyu 设备区域
     * @return 结果
     */
    @Override
    public int updateEquipQuyu(EquipQuyu equipQuyu)
    {

        /** 查询新父id项目**/
        EquipQuyu  newParentQuyu=equipQuyuMapper.selectEquipQuyuById(equipQuyu.getParentId());
        EquipQuyu  oldQuyu=equipQuyuMapper.selectEquipQuyuById(equipQuyu.getId());
        if (StringUtils.isNotNull(newParentQuyu) && StringUtils.isNotNull(oldQuyu)) {
            String newAncestors = newParentQuyu.getAncestors() + "," + newParentQuyu.getId();
            String oldAncestors = oldQuyu.getAncestors();
            /** 设置当前项目的关联字段**/
            equipQuyu.setAncestors(newAncestors);

            /** 新设备名称**/
            String newName = newParentQuyu.getName() + "-" + equipQuyu.getNote();
            String oldName = oldQuyu.getName();
            equipQuyu.setName(newName);
            updateQuyuChildren(equipQuyu.getId(), newAncestors, oldAncestors,newName,oldName);
        }

        if (StringUtils.isNull(newParentQuyu) && StringUtils.isNotNull(oldQuyu)) {
            /** 新设备名称**/
            String newName = equipQuyu.getNote();
            String oldName = oldQuyu.getName();
            equipQuyu.setName(newName);
            updateQuyuChildren(equipQuyu.getId(), "", "",newName,oldName);
        }

        equipQuyu.setUpdateTime(DateUtils.getNowDate());
        return equipQuyuMapper.updateEquipQuyu(equipQuyu);
    }

    /**
     * 修改子元素关系
     *
     * @param Id 被修改的部区域ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateQuyuChildren(Long Id, String newAncestors, String oldAncestors,String newName, String oldName)
    {
        List<EquipQuyu> children = equipQuyuMapper.selectChildrenQuyuById(Id);
        for (EquipQuyu child : children)
        {
            if(StringUtils.isNotEmpty(newAncestors)||StringUtils.isNotEmpty(oldAncestors)){
                child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
            }
            child.setName(child.getName().replace(oldName, newName));
        }
        if (children.size() > 0)
        {
            equipQuyuMapper.updateQuyuChildren(children);
        }
    }


    /**
     * 批量删除设备区域
     *
     * @param ids 需要删除的设备区域ID
     * @return 结果
     */
    @Override
    public int deleteEquipQuyuByIds(Long[] ids)
    {
        return equipQuyuMapper.deleteEquipQuyuByIds(ids);
    }

    /**
     * 删除设备区域信息
     *
     * @param id 设备区域ID
     * @return 结果
     */
    @Override
    public int deleteEquipQuyuById(Long id)
    {
        return equipQuyuMapper.deleteEquipQuyuById(id);
    }
}
