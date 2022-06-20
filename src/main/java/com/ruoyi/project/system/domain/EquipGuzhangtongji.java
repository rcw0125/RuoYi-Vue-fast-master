package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设备故障统计对象 equip_guzhangtongji
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public class EquipGuzhangtongji extends BaseEntity
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

    /** 登记数量 */
    @Excel(name = "登记数量")
    private Integer djsl;

    /** 应接收数量 */
    @Excel(name = "应接收数量")
    private Integer yjssl;

    /** 接收数量 */
    @Excel(name = "接收数量")
    private Integer jssl;

    /** 处理数量 */
    @Excel(name = "处理数量")
    private Integer clsl;

    /** 待处理数量 */
    @Excel(name = "待处理数量")
    private Integer dclsl;

    /** 应验证数量 */
    @Excel(name = "应验证数量")
    private Integer yyzsl;

    /** 验证数量 */
    @Excel(name = "验证数量")
    private Integer yzsl;

    /** 验证率 */
    @Excel(name = "验证率")
    private BigDecimal yzrate;

    /** 延误数量 */
    @Excel(name = "延误数量")
    private Integer ywsl;

    /** 延误率 */
    @Excel(name = "延误率")
    private BigDecimal ywrate;

    /** 接收率 */
    @Excel(name = "接收率")
    private BigDecimal jsrate;

    /** 处理率 */
    @Excel(name = "处理率")
    private BigDecimal clrate;

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
    public void setDjsl(Integer djsl) 
    {
        this.djsl = djsl;
    }

    public Integer getDjsl() 
    {
        return djsl;
    }
    public void setYjssl(Integer yjssl) 
    {
        this.yjssl = yjssl;
    }

    public Integer getYjssl() 
    {
        return yjssl;
    }
    public void setJssl(Integer jssl) 
    {
        this.jssl = jssl;
    }

    public Integer getJssl() 
    {
        return jssl;
    }
    public void setClsl(Integer clsl) 
    {
        this.clsl = clsl;
    }

    public Integer getClsl() 
    {
        return clsl;
    }
    public void setDclsl(Integer dclsl) 
    {
        this.dclsl = dclsl;
    }

    public Integer getDclsl() 
    {
        return dclsl;
    }
    public void setYyzsl(Integer yyzsl) 
    {
        this.yyzsl = yyzsl;
    }

    public Integer getYyzsl() 
    {
        return yyzsl;
    }
    public void setYzsl(Integer yzsl) 
    {
        this.yzsl = yzsl;
    }

    public Integer getYzsl() 
    {
        return yzsl;
    }
    public void setYzrate(BigDecimal yzrate) 
    {
        this.yzrate = yzrate;
    }

    public BigDecimal getYzrate() 
    {
        return yzrate;
    }
    public void setYwsl(Integer ywsl) 
    {
        this.ywsl = ywsl;
    }

    public Integer getYwsl() 
    {
        return ywsl;
    }
    public void setYwrate(BigDecimal ywrate) 
    {
        this.ywrate = ywrate;
    }

    public BigDecimal getYwrate() 
    {
        return ywrate;
    }
    public void setJsrate(BigDecimal jsrate) 
    {
        this.jsrate = jsrate;
    }

    public BigDecimal getJsrate() 
    {
        return jsrate;
    }
    public void setClrate(BigDecimal clrate) 
    {
        this.clrate = clrate;
    }

    public BigDecimal getClrate() 
    {
        return clrate;
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
            .append("djdw", getDjdw())
            .append("logtime", getLogtime())
            .append("djsl", getDjsl())
            .append("yjssl", getYjssl())
            .append("jssl", getJssl())
            .append("clsl", getClsl())
            .append("dclsl", getDclsl())
            .append("yyzsl", getYyzsl())
            .append("yzsl", getYzsl())
            .append("yzrate", getYzrate())
            .append("ywsl", getYwsl())
            .append("ywrate", getYwrate())
            .append("jsrate", getJsrate())
            .append("clrate", getClrate())
            .append("zhou", getZhou())
            .append("sjd", getSjd())
            .append("ts", getTs())
            .toString();
    }
}
