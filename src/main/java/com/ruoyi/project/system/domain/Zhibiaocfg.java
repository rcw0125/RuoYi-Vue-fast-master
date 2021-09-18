package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 指标配置对象 zhibiaocfg
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public class Zhibiaocfg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 指标项目 */
    @Excel(name = "指标项目")
    private String name;

    /** 车间 */
    @Excel(name = "车间")
    private String dept;

    /** 计划值 */
    @Excel(name = "计划值")
    private BigDecimal planval;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dept", getDept())
            .append("planval", getPlanval())
            .toString();
    }
}
