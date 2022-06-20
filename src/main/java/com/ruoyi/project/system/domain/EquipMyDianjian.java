package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 配置我的点检对象 equip_my_dianjian
 * 
 * @author ruoyi
 * @date 2022-06-15
 */
public class EquipMyDianjian extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 标准id */
    @Excel(name = "标准id")
    private Long bzid;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String username;

    /** 单位 */
    @Excel(name = "单位")
    private String dept;

    /** 班组 */
    @Excel(name = "班组")
    private String team;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBzid(Long bzid) 
    {
        this.bzid = bzid;
    }

    public Long getBzid() 
    {
        return bzid;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setTeam(String team) 
    {
        this.team = team;
    }

    public String getTeam() 
    {
        return team;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bzid", getBzid())
            .append("username", getUsername())
            .append("dept", getDept())
            .append("team", getTeam())
            .toString();
    }
}
