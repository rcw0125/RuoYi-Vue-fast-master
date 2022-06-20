package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 电量明细对象 dianliang_mingxi
 *
 * @author ruoyi
 * @date 2022-01-13
 */
public class DianliangMingxi extends BaseEntity
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

    /** 描述 */
    @Excel(name = "描述")
    private String miaoshu;

    /** 总 */
    @Excel(name = "总")
    private BigDecimal total;

    /** 尖峰 */
    @Excel(name = "尖峰")
    private BigDecimal jianfeng;

    /** 高峰 */
    @Excel(name = "高峰")
    private BigDecimal gaofeng;

    /** 平 */
    @Excel(name = "平")
    private BigDecimal ping;

    /** 谷 */
    @Excel(name = "谷")
    private BigDecimal gu;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 类别 */
    @Excel(name = "类别")
    private String leibie;

    /** 车间 */
    @Excel(name = "车间")
    private String dept;

    /** 来源 */
    @Excel(name = "来源")
    private String laiyuan;

    /** 排序 */
    @Excel(name = "排序")
    private Integer ordernum;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 01:00电量 */
    @Excel(name = "01:00电量")
    private BigDecimal s1;

    /** 02:00电量 */
    @Excel(name = "02:00电量")
    private BigDecimal s2;

    /** 03:00电量 */
    @Excel(name = "03:00电量")
    private BigDecimal s3;

    /** 04:00电量 */
    @Excel(name = "04:00电量")
    private BigDecimal s4;

    /** 05:00电量 */
    @Excel(name = "05:00电量")
    private BigDecimal s5;

    /** 06:00电量 */
    @Excel(name = "06:00电量")
    private BigDecimal s6;

    /** 07:00电量 */
    @Excel(name = "07:00电量")
    private BigDecimal s7;

    /** 08:00电量 */
    @Excel(name = "08:00电量")
    private BigDecimal s8;

    /** 09:00电量 */
    @Excel(name = "09:00电量")
    private BigDecimal s9;

    /** 10:00电量 */
    @Excel(name = "10:00电量")
    private BigDecimal s10;

    /** 11:00电量 */
    @Excel(name = "11:00电量")
    private BigDecimal s11;

    /** 12:00电量 */
    @Excel(name = "12:00电量")
    private BigDecimal s12;

    /** 13:00电量 */
    @Excel(name = "13:00电量")
    private BigDecimal s13;

    /** 14:00电量 */
    @Excel(name = "14:00电量")
    private BigDecimal s14;

    /** 15:00电量 */
    @Excel(name = "15:00电量")
    private BigDecimal s15;

    /** 16:00电量 */
    @Excel(name = "16:00电量")
    private BigDecimal s16;

    /** 17:00电量 */
    @Excel(name = "17:00电量")
    private BigDecimal s17;

    /** 18:00电量 */
    @Excel(name = "18:00电量")
    private BigDecimal s18;

    /** 19:00电量 */
    @Excel(name = "19:00电量")
    private BigDecimal s19;

    /** 20:00电量 */
    @Excel(name = "20:00电量")
    private BigDecimal s20;

    /** 21:00电量 */
    @Excel(name = "21:00电量")
    private BigDecimal s21;

    /** 22:00电量 */
    @Excel(name = "22:00电量")
    private BigDecimal s22;

    /** 23:00电量 */
    @Excel(name = "23:00电量")
    private BigDecimal s23;

    /** 24:00电量 */
    @Excel(name = "24:00电量")
    private BigDecimal s24;

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
    public void setMiaoshu(String miaoshu)
    {
        this.miaoshu = miaoshu;
    }

    public String getMiaoshu()
    {
        return miaoshu;
    }
    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }

    public BigDecimal getTotal()
    {
        return total;
    }
    public void setJianfeng(BigDecimal jianfeng)
    {
        this.jianfeng = jianfeng;
    }

    public BigDecimal getJianfeng()
    {
        return jianfeng;
    }
    public void setGaofeng(BigDecimal gaofeng)
    {
        this.gaofeng = gaofeng;
    }

    public BigDecimal getGaofeng()
    {
        return gaofeng;
    }
    public void setPing(BigDecimal ping)
    {
        this.ping = ping;
    }

    public BigDecimal getPing()
    {
        return ping;
    }
    public void setGu(BigDecimal gu)
    {
        this.gu = gu;
    }

    public BigDecimal getGu()
    {
        return gu;
    }
    public void setLogtime(String logtime)
    {
        this.logtime = logtime;
    }

    public String getLogtime()
    {
        return logtime;
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
    public void setS1(BigDecimal s1)
    {
        this.s1 = s1;
    }

    public BigDecimal getS1()
    {
        return s1;
    }
    public void setS2(BigDecimal s2)
    {
        this.s2 = s2;
    }

    public BigDecimal getS2()
    {
        return s2;
    }
    public void setS3(BigDecimal s3)
    {
        this.s3 = s3;
    }

    public BigDecimal getS3()
    {
        return s3;
    }
    public void setS4(BigDecimal s4)
    {
        this.s4 = s4;
    }

    public BigDecimal getS4()
    {
        return s4;
    }
    public void setS5(BigDecimal s5)
    {
        this.s5 = s5;
    }

    public BigDecimal getS5()
    {
        return s5;
    }
    public void setS6(BigDecimal s6)
    {
        this.s6 = s6;
    }

    public BigDecimal getS6()
    {
        return s6;
    }
    public void setS7(BigDecimal s7)
    {
        this.s7 = s7;
    }

    public BigDecimal getS7()
    {
        return s7;
    }
    public void setS8(BigDecimal s8)
    {
        this.s8 = s8;
    }

    public BigDecimal getS8()
    {
        return s8;
    }
    public void setS9(BigDecimal s9)
    {
        this.s9 = s9;
    }

    public BigDecimal getS9()
    {
        return s9;
    }
    public void setS10(BigDecimal s10)
    {
        this.s10 = s10;
    }

    public BigDecimal getS10()
    {
        return s10;
    }
    public void setS11(BigDecimal s11)
    {
        this.s11 = s11;
    }

    public BigDecimal getS11()
    {
        return s11;
    }
    public void setS12(BigDecimal s12)
    {
        this.s12 = s12;
    }

    public BigDecimal getS12()
    {
        return s12;
    }
    public void setS13(BigDecimal s13)
    {
        this.s13 = s13;
    }

    public BigDecimal getS13()
    {
        return s13;
    }
    public void setS14(BigDecimal s14)
    {
        this.s14 = s14;
    }

    public BigDecimal getS14()
    {
        return s14;
    }
    public void setS15(BigDecimal s15)
    {
        this.s15 = s15;
    }

    public BigDecimal getS15()
    {
        return s15;
    }
    public void setS16(BigDecimal s16)
    {
        this.s16 = s16;
    }

    public BigDecimal getS16()
    {
        return s16;
    }
    public void setS17(BigDecimal s17)
    {
        this.s17 = s17;
    }

    public BigDecimal getS17()
    {
        return s17;
    }
    public void setS18(BigDecimal s18)
    {
        this.s18 = s18;
    }

    public BigDecimal getS18()
    {
        return s18;
    }
    public void setS19(BigDecimal s19)
    {
        this.s19 = s19;
    }

    public BigDecimal getS19()
    {
        return s19;
    }
    public void setS20(BigDecimal s20)
    {
        this.s20 = s20;
    }

    public BigDecimal getS20()
    {
        return s20;
    }
    public void setS21(BigDecimal s21)
    {
        this.s21 = s21;
    }

    public BigDecimal getS21()
    {
        return s21;
    }
    public void setS22(BigDecimal s22)
    {
        this.s22 = s22;
    }

    public BigDecimal getS22()
    {
        return s22;
    }
    public void setS23(BigDecimal s23)
    {
        this.s23 = s23;
    }

    public BigDecimal getS23()
    {
        return s23;
    }
    public void setS24(BigDecimal s24)
    {
        this.s24 = s24;
    }

    public BigDecimal getS24()
    {
        return s24;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bianhao", getBianhao())
                .append("beilv", getBeilv())
                .append("miaoshu", getMiaoshu())
                .append("total", getTotal())
                .append("jianfeng", getJianfeng())
                .append("gaofeng", getGaofeng())
                .append("ping", getPing())
                .append("gu", getGu())
                .append("logtime", getLogtime())
                .append("name", getName())
                .append("leibie", getLeibie())
                .append("dept", getDept())
                .append("laiyuan", getLaiyuan())
                .append("ordernum", getOrdernum())
                .append("note", getNote())
                .append("s1", getS1())
                .append("s2", getS2())
                .append("s3", getS3())
                .append("s4", getS4())
                .append("s5", getS5())
                .append("s6", getS6())
                .append("s7", getS7())
                .append("s8", getS8())
                .append("s9", getS9())
                .append("s10", getS10())
                .append("s11", getS11())
                .append("s12", getS12())
                .append("s13", getS13())
                .append("s14", getS14())
                .append("s15", getS15())
                .append("s16", getS16())
                .append("s17", getS17())
                .append("s18", getS18())
                .append("s19", getS19())
                .append("s20", getS20())
                .append("s21", getS21())
                .append("s22", getS22())
                .append("s23", getS23())
                .append("s24", getS24())
                .toString();
    }
}
