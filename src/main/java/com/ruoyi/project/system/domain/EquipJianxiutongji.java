package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设备检修统计对象 equip_jianxiutongji
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public class EquipJianxiutongji extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 登记单位 */
    @Excel(name = "登记单位")
    private String djdw;

    /** 月份 */
    @Excel(name = "月份")
    private String logtime;

    /** 周 */
    @Excel(name = "周")
    private String zhou;

    /** 时间段 */
    @Excel(name = "时间段")
    private String sjd;

    /** 申报数量 */
    @Excel(name = "申报数量")
    private Long sbsl;

    /** 实际数量 */
    @Excel(name = "实际数量")
    private Long sjsl;

    /** 兑现率 */
    @Excel(name = "兑现率")
    private Long rate;

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
    public void setDjdw(String djdw) 
    {
        this.djdw = djdw;
    }

    public String getDjdw() 
    {
        return djdw;
    }
    public void setLogtime(String logtime) 
    {
        this.logtime = logtime;
    }

    public String getLogtime() 
    {
        return logtime;
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
    public void setSbsl(Long sbsl) 
    {
        this.sbsl = sbsl;
    }

    public Long getSbsl() 
    {
        return sbsl;
    }
    public void setSjsl(Long sjsl) 
    {
        this.sjsl = sjsl;
    }

    public Long getSjsl() 
    {
        return sjsl;
    }
    public void setRate(Long rate) 
    {
        this.rate = rate;
    }

    public Long getRate() 
    {
        return rate;
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
            .append("djdw", getDjdw())
            .append("logtime", getLogtime())
            .append("zhou", getZhou())
            .append("sjd", getSjd())
            .append("sbsl", getSbsl())
            .append("sjsl", getSjsl())
            .append("rate", getRate())
            .append("ts", getTs())
            .toString();
    }
}
