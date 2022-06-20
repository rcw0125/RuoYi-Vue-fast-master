package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 每日电量对象 dianliang_day
 *
 * @author ruoyi
 * @date 2022-01-18
 */
public class DianliangDay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 单位 */
    @Excel(name = "单位")
    private String dept;

    /** 电量 */
    @Excel(name = "电量")
    private BigDecimal dianliang;

    /** 产量 */
    @Excel(name = "产量")
    private BigDecimal chanliang;

    /** 电耗 */
    @Excel(name = "电耗")
    private BigDecimal dianhao;

    /** 标准电耗 */
    @Excel(name = "标准电耗")
    private BigDecimal biaozhun;

    /** 差值 */
    @Excel(name = "差值")
    private BigDecimal chazhi;

    /** 昨日 */
    @Excel(name = "昨日")
    private BigDecimal zuori;

    /** 昨日差值 */
    @Excel(name = "昨日差值")
    private BigDecimal zuorichazhi;

    /** 排序 */
    @Excel(name = "排序")
    private Integer ordernum;

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
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept()
    {
        return dept;
    }
    public void setDianliang(BigDecimal dianliang)
    {
        this.dianliang = dianliang;
    }

    public BigDecimal getDianliang()
    {
        return dianliang;
    }
    public void setChanliang(BigDecimal chanliang)
    {
        this.chanliang = chanliang;
    }

    public BigDecimal getChanliang()
    {
        return chanliang;
    }
    public void setDianhao(BigDecimal dianhao)
    {
        this.dianhao = dianhao;
    }

    public BigDecimal getDianhao()
    {
        return dianhao;
    }
    public void setBiaozhun(BigDecimal biaozhun)
    {
        this.biaozhun = biaozhun;
    }

    public BigDecimal getBiaozhun()
    {
        return biaozhun;
    }
    public void setChazhi(BigDecimal chazhi)
    {
        this.chazhi = chazhi;
    }

    public BigDecimal getChazhi()
    {
        return chazhi;
    }
    public void setZuori(BigDecimal zuori)
    {
        this.zuori = zuori;
    }

    public BigDecimal getZuori()
    {
        return zuori;
    }
    public void setZuorichazhi(BigDecimal zuorichazhi)
    {
        this.zuorichazhi = zuorichazhi;
    }

    public BigDecimal getZuorichazhi()
    {
        return zuorichazhi;
    }
    public void setOrdernum(Integer ordernum)
    {
        this.ordernum = ordernum;
    }

    public Integer getOrdernum()
    {
        return ordernum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("logtime", getLogtime())
                .append("dept", getDept())
                .append("dianliang", getDianliang())
                .append("chanliang", getChanliang())
                .append("dianhao", getDianhao())
                .append("biaozhun", getBiaozhun())
                .append("chazhi", getChazhi())
                .append("zuori", getZuori())
                .append("zuorichazhi", getZuorichazhi())
                .append("ordernum", getOrdernum())
                .toString();
    }
}
