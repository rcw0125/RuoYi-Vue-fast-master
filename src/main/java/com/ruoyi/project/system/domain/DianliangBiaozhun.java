package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 电量标准对象 dianliang_biaozhun
 * 
 * @author ruoyi
 * @date 2022-01-12
 */
public class DianliangBiaozhun extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** 车间 */
    @Excel(name = "车间")
    private String dept;

    /** 标准电耗 */
    @Excel(name = "标准电耗")
    private BigDecimal val;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setVal(BigDecimal val) 
    {
        this.val = val;
    }

    public BigDecimal getVal() 
    {
        return val;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dept", getDept())
            .append("val", getVal())
            .toString();
    }
}
