package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 用车台账对象 sys_car_cfg
 * 
 * @author ruoyi
 * @date 2021-09-11
 */
public class SysCarCfg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 车型 */
    @Excel(name = "车型")
    private String cartype;

    /** 收费方式 */
    @Excel(name = "收费方式")
    private String shoufeifangshi;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal danjia;

    /** 备注 */
    @Excel(name = "备注")
    private String beizhu;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCartype(String cartype) 
    {
        this.cartype = cartype;
    }

    public String getCartype() 
    {
        return cartype;
    }
    public void setShoufeifangshi(String shoufeifangshi) 
    {
        this.shoufeifangshi = shoufeifangshi;
    }

    public String getShoufeifangshi() 
    {
        return shoufeifangshi;
    }
    public void setDanjia(BigDecimal danjia) 
    {
        this.danjia = danjia;
    }

    public BigDecimal getDanjia() 
    {
        return danjia;
    }
    public void setBeizhu(String beizhu) 
    {
        this.beizhu = beizhu;
    }

    public String getBeizhu() 
    {
        return beizhu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cartype", getCartype())
            .append("shoufeifangshi", getShoufeifangshi())
            .append("danjia", getDanjia())
            .append("beizhu", getBeizhu())
            .toString();
    }
}
