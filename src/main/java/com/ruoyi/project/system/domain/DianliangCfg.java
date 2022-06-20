package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 电量配置对象 dianliang_cfg
 *
 * @author ruoyi
 * @date 2022-01-11
 */
public class DianliangCfg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 断路器编号 */
    @Excel(name = "断路器编号")
    private String bianhao;

    /** 倍率 */
    @Excel(name = "倍率")
    private String beilv;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 类别 */
    @Excel(name = "类别")
    private String leibie;

    /** 车间 */
    @Excel(name = "车间")
    private String dept;

    /** 值 */
    @Excel(name = "值")
    private BigDecimal val;

    /** 数据来源 */
    @Excel(name = "数据来源")
    private String laiyuan;

    /** 排序 */
    @Excel(name = "排序")
    private Integer ordernum;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 描述 */
    @Excel(name = "描述")
    private String miaoshu;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBianhao(String bianhao)
    {
        this.bianhao = bianhao;
    }

    public String getBianhao()
    {
        return bianhao;
    }
    public void setBeilv(String beilv)
    {
        this.beilv = beilv;
    }

    public String getBeilv()
    {
        return beilv;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setLeibie(String leibie)
    {
        this.leibie = leibie;
    }

    public String getLeibie()
    {
        return leibie;
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
    public void setLaiyuan(String laiyuan)
    {
        this.laiyuan = laiyuan;
    }

    public String getLaiyuan()
    {
        return laiyuan;
    }
    public void setOrdernum(Integer ordernum)
    {
        this.ordernum = ordernum;
    }

    public Integer getOrdernum()
    {
        return ordernum;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setMiaoshu(String miaoshu)
    {
        this.miaoshu = miaoshu;
    }

    public String getMiaoshu()
    {
        return miaoshu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bianhao", getBianhao())
                .append("beilv", getBeilv())
                .append("name", getName())
                .append("leibie", getLeibie())
                .append("dept", getDept())
                .append("val", getVal())
                .append("laiyuan", getLaiyuan())
                .append("ordernum", getOrdernum())
                .append("note", getNote())
                .append("miaoshu", getMiaoshu())
                .toString();
    }
}
