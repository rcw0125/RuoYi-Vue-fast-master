package com.ruoyi.project.system.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备区域对象 equip_quyu
 *
 * @author ruoyi
 * @date 2021-06-29
 */
public class EquipQuyu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备区域id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 部件 */
    @Excel(name = "部件")
    private String note;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 分级 */
    @Excel(name = "分级")
    private String fenji;

    /** 关注参数 */
    @Excel(name = "关注参数")
    private String yxcs;

    /** 包保人 */
    @Excel(name = "包保人")
    private String baobaoren;

    /** 汇总 */
    @Excel(name = "汇总")
    private String huizong;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /** 父部门ID */
    private Long parentId;

    /** 祖级列表 */
    private String ancestors;
    /** 显示顺序 */
    private String orderNum;


    public List<EquipQuyu> getChildren() {
        return children;
    }

    public void setChildren(List<EquipQuyu> children) {
        this.children = children;
    }

    /** 子菜单 */
private List<EquipQuyu> children = new ArrayList<EquipQuyu>();

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setFenji(String fenji)
    {
        this.fenji = fenji;
    }

    public String getFenji()
    {
        return fenji;
    }
    public void setYxcs(String yxcs)
    {
        this.yxcs = yxcs;
    }

    public String getYxcs()
    {
        return yxcs;
    }
    public void setBaobaoren(String baobaoren)
    {
        this.baobaoren = baobaoren;
    }

    public String getBaobaoren()
    {
        return baobaoren;
    }
    public void setHuizong(String huizong)
    {
        this.huizong = huizong;
    }

    public String getHuizong()
    {
        return huizong;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("name", getName())
            .append("orderNum", getOrderNum())
            .append("note", getNote())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
                .append("fenji", getFenji())
                .append("yxcs", getYxcs())
                .append("baobaoren", getBaobaoren())
                .append("huizong", getHuizong())
            .toString();
    }
}
