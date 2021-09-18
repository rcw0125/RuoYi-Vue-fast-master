package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 指标记录对象 zhibiao
 *
 * @author ruoyi
 * @date 2021-04-15
 */
public class Zhibiao extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 项目 */
    @Excel(name = "项目")
    private String name;

    /** 所属单位 */
    @Excel(name = "所属单位")
    private String dept;

    /** 计划值 */
    @Excel(name = "计划值")
    private BigDecimal planval;

    /** 完成值 */
    @Excel(name = "完成值")
    private BigDecimal val;

    /** 影响原因 */
    @Excel(name = "影响原因")
    private String reason;

    /** 采取措施 */
    @Excel(name = "采取措施")
    private String cuoshi;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 增加人 */
    @Excel(name = "增加人")
    private String logperson;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateperson;

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
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept()
    {
        return dept;
    }
    public void setPlanval(BigDecimal planval)
    {
        this.planval = planval;
    }

    public BigDecimal getPlanval()
    {
        return planval;
    }
    public void setVal(BigDecimal val)
    {
        this.val = val;
    }

    public BigDecimal getVal()
    {
        return val;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }
    public void setCuoshi(String cuoshi)
    {
        this.cuoshi = cuoshi;
    }

    public String getCuoshi()
    {
        return cuoshi;
    }
    public void setLogtime(String logtime)
    {
        this.logtime = logtime;
    }

    public String getLogtime()
    {
        return logtime;
    }
    public void setLogperson(String logperson)
    {
        this.logperson = logperson;
    }

    public String getLogperson()
    {
        return logperson;
    }
    public void setUpdateperson(String updateperson)
    {
        this.updateperson = updateperson;
    }

    public String getUpdateperson()
    {
        return updateperson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dept", getDept())
            .append("planval", getPlanval())
            .append("val", getVal())
            .append("reason", getReason())
            .append("cuoshi", getCuoshi())
            .append("logtime", getLogtime())
            .append("logperson", getLogperson())
            .append("updateperson", getUpdateperson())
            .toString();
    }
}
