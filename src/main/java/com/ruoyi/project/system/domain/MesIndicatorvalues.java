package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 能源指标值对象 mes_indicatorvalues
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
public class MesIndicatorvalues extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 指标编码 */
    @Excel(name = "指标编码")
    private String code;

    /** 指标值 */
    @Excel(name = "指标值")
    private Double value;

    /** 业务日期 */
    @Excel(name = "业务日期")
    private String bizdate;

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setValue(Double value) 
    {
        this.value = value;
    }

    public Double getValue() 
    {
        return value;
    }
    public void setBizdate(String bizdate) 
    {
        this.bizdate = bizdate;
    }

    public String getBizdate() 
    {
        return bizdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("code", getCode())
            .append("value", getValue())
            .append("bizdate", getBizdate())
            .toString();
    }
}
