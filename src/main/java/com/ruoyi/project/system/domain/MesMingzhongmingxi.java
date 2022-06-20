package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 成分命中明细对象 mes_mingzhongmingxi
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public class MesMingzhongmingxi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 炉号 */
    @Excel(name = "炉号")
    private String heatid;

    /** 精炼 */
    @Excel(name = "精炼")
    private String lfid;

    /** 班组 */
    @Excel(name = "班组")
    private String team;

    /** Si */
    @Excel(name = "Si")
    private String si;

    /** Mn */
    @Excel(name = "Mn")
    private String mn;

    /** Cr */
    @Excel(name = "Cr")
    private String cr;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLogtime(String logtime) 
    {
        this.logtime = logtime;
    }

    public String getLogtime() 
    {
        return logtime;
    }
    public void setHeatid(String heatid) 
    {
        this.heatid = heatid;
    }

    public String getHeatid() 
    {
        return heatid;
    }
    public void setLfid(String lfid) 
    {
        this.lfid = lfid;
    }

    public String getLfid() 
    {
        return lfid;
    }
    public void setTeam(String team) 
    {
        this.team = team;
    }

    public String getTeam() 
    {
        return team;
    }
    public void setSi(String si) 
    {
        this.si = si;
    }

    public String getSi() 
    {
        return si;
    }
    public void setMn(String mn) 
    {
        this.mn = mn;
    }

    public String getMn() 
    {
        return mn;
    }
    public void setCr(String cr) 
    {
        this.cr = cr;
    }

    public String getCr() 
    {
        return cr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("logtime", getLogtime())
            .append("heatid", getHeatid())
            .append("lfid", getLfid())
            .append("team", getTeam())
            .append("si", getSi())
            .append("mn", getMn())
            .append("cr", getCr())
            .toString();
    }
}
