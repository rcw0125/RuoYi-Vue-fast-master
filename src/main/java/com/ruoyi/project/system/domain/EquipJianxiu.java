package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 计划检修对象 equip_jianxiu
 *
 * @author ruoyi
 * @date 2021-12-09
 */
public class EquipJianxiu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    /** 设备ID */
    @Excel(name = "ID")
    private Long id;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long sbid;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbname;

    /** 检修单位 */
    @Excel(name = "检修单位")
    private String dept;

    /** 检修班组 */
    @Excel(name = "检修班组")
    private String team;

    /** 计划人 */
    @Excel(name = "计划人")
    private String jhr;

    /** 计划日期 */
    @Excel(name = "计划日期")
    private String jhrq;

    /** 登记时间 */
    @Excel(name = "登记时间")
    private String djtime;

    /** 计划项目 */
    @Excel(name = "检修内容")
    private String jxnr;

    /** 检修描述 */
    @Excel(name = "检修描述")
    private String jxms;

    /** 检修时间 */
    @Excel(name = "检修时间")
    private String jxtime;

    /** 状态(等待检修、检修完成、异常结束) */
    @Excel(name = "状态(等待检修、检修完成、异常结束)")
    private String status;

    /** 检修人 */
    @Excel(name = "检修人")
    private String jxr;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSbid(Long sbid)
    {
        this.sbid = sbid;
    }

    public Long getSbid()
    {
        return sbid;
    }
    public void setSbname(String sbname)
    {
        this.sbname = sbname;
    }

    public String getSbname()
    {
        return sbname;
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
    public void setJhr(String jhr)
    {
        this.jhr = jhr;
    }

    public String getJhr()
    {
        return jhr;
    }
    public void setJhrq(String jhrq)
    {
        this.jhrq = jhrq;
    }

    public String getJhrq()
    {
        return jhrq;
    }
    public void setDjtime(String djtime)
    {
        this.djtime = djtime;
    }

    public String getDjtime()
    {
        return djtime;
    }
    public void setJxnr(String jxnr)
    {
        this.jxnr = jxnr;
    }

    public String getJxnr()
    {
        return jxnr;
    }
    public void setJxms(String jxms)
    {
        this.jxms = jxms;
    }

    public String getJxms()
    {
        return jxms;
    }
    public void setJxtime(String jxtime)
    {
        this.jxtime = jxtime;
    }

    public String getJxtime()
    {
        return jxtime;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setJxr(String jxr)
    {
        this.jxr = jxr;
    }

    public String getJxr()
    {
        return jxr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sbid", getSbid())
            .append("sbname", getSbname())
            .append("dept", getDept())
            .append("team", getTeam())
            .append("jhr", getJhr())
            .append("jhrq", getJhrq())
            .append("djtime", getDjtime())
            .append("jxnr", getJxnr())
            .append("jxms", getJxms())
            .append("jxtime", getJxtime())
            .append("status", getStatus())
                .append("jxr", getJxr())
            .toString();
    }
}
