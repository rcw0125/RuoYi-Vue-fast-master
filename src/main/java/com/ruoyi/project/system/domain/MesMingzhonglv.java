package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 成分命中率对象 mes_mingzhonglv
 *
 * @author ruoyi
 * @date 2022-05-24
 */
public class MesMingzhonglv extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 精炼 */
    @Excel(name = "精炼")
    private String lfid;

    /** 班组 */

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


    /** Si命中炉数 */
    @Excel(name = "Si命中炉数")
    private Integer sicount;

    /** Si总炉数 */
    @Excel(name = "Si总炉数")
    private Integer sitotal;


    /** Mn命中炉数 */
    @Excel(name = "Mn命中炉数")
    private Integer mncount;

    /** Mn总炉数 */
    @Excel(name = "Mn总炉数")
    private Integer mntotal;



    /** Cr命中炉数 */
    @Excel(name = "Cr命中炉数")
    private Integer crcount;

    /** Cr总炉数 */
    @Excel(name = "Cr总炉数")
    private Integer crtotal;





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
    public void setSicount(Integer sicount)
    {
        this.sicount = sicount;
    }

    public Integer getSicount()
    {
        return sicount;
    }
    public void setSitotal(Integer sitotal)
    {
        this.sitotal = sitotal;
    }

    public Integer getSitotal()
    {
        return sitotal;
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
    public void setMncount(Integer mncount)
    {
        this.mncount = mncount;
    }

    public Integer getMncount()
    {
        return mncount;
    }
    public void setCr(String cr)
    {
        this.cr = cr;
    }

    public String getCr()
    {
        return cr;
    }
    public void setMntotal(Integer mntotal)
    {
        this.mntotal = mntotal;
    }

    public Integer getMntotal()
    {
        return mntotal;
    }
    public void setCrcount(Integer crcount)
    {
        this.crcount = crcount;
    }

    public Integer getCrcount()
    {
        return crcount;
    }
    public void setCrtotal(Integer crtotal)
    {
        this.crtotal = crtotal;
    }

    public Integer getCrtotal()
    {
        return crtotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("logtime", getLogtime())
                .append("lfid", getLfid())
                .append("team", getTeam())
                .append("sicount", getSicount())
                .append("sitotal", getSitotal())
                .append("si", getSi())
                .append("mn", getMn())
                .append("mncount", getMncount())
                .append("cr", getCr())
                .append("mntotal", getMntotal())
                .append("crcount", getCrcount())
                .append("crtotal", getCrtotal())
                .toString();
    }
}
