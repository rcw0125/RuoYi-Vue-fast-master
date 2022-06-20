package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 点检分类统计对象 equip_dianjianfenlei
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public class EquipDianjianfenlei extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 月份 */
    @Excel(name = "月份")
    private String logtime;

    /** 点检类别 */
    @Excel(name = "点检类别")
    private String djfl;

    /** 点检数量 */
    @Excel(name = "点检数量")
    private Long djsl;

    /** 问题数量 */
    @Excel(name = "问题数量")
    private Long wtsl;

    /** 周 */
    @Excel(name = "周")
    private String zhou;

    /** 时间段 */
    @Excel(name = "时间段")
    private String sjd;

    /** 时间点 */
    @Excel(name = "时间点")
    private String ts;

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
    public void setDjfl(String djfl) 
    {
        this.djfl = djfl;
    }

    public String getDjfl() 
    {
        return djfl;
    }
    public void setDjsl(Long djsl) 
    {
        this.djsl = djsl;
    }

    public Long getDjsl() 
    {
        return djsl;
    }
    public void setWtsl(Long wtsl) 
    {
        this.wtsl = wtsl;
    }

    public Long getWtsl() 
    {
        return wtsl;
    }
    public void setZhou(String zhou) 
    {
        this.zhou = zhou;
    }

    public String getZhou() 
    {
        return zhou;
    }
    public void setSjd(String sjd) 
    {
        this.sjd = sjd;
    }

    public String getSjd() 
    {
        return sjd;
    }
    public void setTs(String ts) 
    {
        this.ts = ts;
    }

    public String getTs() 
    {
        return ts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("logtime", getLogtime())
            .append("djfl", getDjfl())
            .append("djsl", getDjsl())
            .append("wtsl", getWtsl())
            .append("zhou", getZhou())
            .append("sjd", getSjd())
            .append("ts", getTs())
            .toString();
    }
}
