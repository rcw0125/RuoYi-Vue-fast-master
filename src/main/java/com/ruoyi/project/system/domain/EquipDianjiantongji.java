package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 月点检统计对象 equip_dianjiantongji
 *
 * @author ruoyi
 * @date 2022-05-17
 */
public class EquipDianjiantongji extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 时间 */
    @Excel(name = "时间")
    private String logtime;

    /** 周 */
    @Excel(name = "周")
    private String zhou;

    /** 时间段 */
    @Excel(name = "时间段")
    private String sjd;

    /** 点检单位 */
    @Excel(name = "点检单位")
    private String djdw;

    /** 应点检数量 */
    @Excel(name = "应点检数量")
    private Long ydjsl;

    /** 实际点检数量 */
    @Excel(name = "实际点检数量")
    private Long sdjsl;

    /** 点检率 */
    @Excel(name = "点检率")
    private double djrate;

    /** 车间指标 */
    @Excel(name = "车间指标")
    private Long cjzb;

    /** 问题数量 */
    @Excel(name = "问题数量")
    private Long wtsl;

    /** 管理问题数量 */
    @Excel(name = "管理问题数量")
    private Long glwtsl;

    /** 管理问题数量累计 */
    @Excel(name = "管理问题数量累计")
    private Long glwtsllj;

    /** 问题率 */
    @Excel(name = "问题率")
    private BigDecimal wtrate;

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
    public void setDjdw(String djdw)
    {
        this.djdw = djdw;
    }

    public String getDjdw()
    {
        return djdw;
    }
    public void setYdjsl(Long ydjsl)
    {
        this.ydjsl = ydjsl;
    }

    public Long getYdjsl()
    {
        return ydjsl;
    }
    public void setSdjsl(Long sdjsl)
    {
        this.sdjsl = sdjsl;
    }

    public Long getSdjsl()
    {
        return sdjsl;
    }
    public void setDjrate(double djrate)
    {
        this.djrate = djrate;
    }

    public double getDjrate()
    {
        return djrate;
    }
    public void setCjzb(Long cjzb)
    {
        this.cjzb = cjzb;
    }

    public Long getCjzb()
    {
        return cjzb;
    }
    public void setWtsl(Long wtsl)
    {
        this.wtsl = wtsl;
    }

    public Long getWtsl()
    {
        return wtsl;
    }
    public void setGlwtsl(Long glwtsl)
    {
        this.glwtsl = glwtsl;
    }

    public Long getGlwtsl()
    {
        return glwtsl;
    }
    public void setGlwtsllj(Long glwtsllj)
    {
        this.glwtsllj = glwtsllj;
    }

    public Long getGlwtsllj()
    {
        return glwtsllj;
    }
    public void setWtrate(BigDecimal wtrate)
    {
        this.wtrate = wtrate;
    }

    public BigDecimal getWtrate()
    {
        return wtrate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("logtime", getLogtime())
            .append("zhou", getZhou())
            .append("sjd", getSjd())
            .append("djdw", getDjdw())
            .append("ydjsl", getYdjsl())
            .append("sdjsl", getSdjsl())
            .append("djrate", getDjrate())
            .append("cjzb", getCjzb())
            .append("wtsl", getWtsl())
            .append("glwtsl", getGlwtsl())
            .append("glwtsllj", getGlwtsllj())
            .append("wtrate", getWtrate())
            .toString();
    }
}
