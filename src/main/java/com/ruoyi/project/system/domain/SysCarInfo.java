package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 用车台账对象 sys_car_info
 *
 * @author ruoyi
 * @date 2021-09-13
 */
public class SysCarInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 车号 */
    @Excel(name = "车号")
    private String carno;

    /** 日期 */
    @Excel(name = "使用日期")
    private String logtime;

    /** 车型 */
    @Excel(name = "车型")
    private String cartype;

    /** 单位 */
    @Excel(name = "用车单位")
    private String dept;

    /** 作业开始时间 */
    @Excel(name = "作业开始时间")
    private String begintime;

    /** 作业结束时间 */
    @Excel(name = "作业结束时间")
    private String endtime;

    /** 用车时长(小时) */
    @Excel(name = "用车时长(小时)")
    private BigDecimal totaltime;

    /** 作业量 */
    @Excel(name = "作业量")
    private BigDecimal zuoyeliang;

    /** 用车费用 */
    @Excel(name = "用车费用")
    private BigDecimal feiyong;

    /** 使用地点 */
    @Excel(name = "使用地点")
    private String didian;

    /** 用车事由 */
    @Excel(name = "用车事由")
    private String shiyou;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 收费方式 */
    @Excel(name = "收费方式")
    private String shoufeifangshi;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal danjia;

    /** 收费说明 */
    @Excel(name = "收费说明")
    private String beizhu;

    /** 用车人 */

    private String yongcheren;

    /** 记录人 */
    @Excel(name = "记录人")
    private String logren;

    /** 当前日期 */

    private String timespan;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCarno(String carno)
    {
        this.carno = carno;
    }

    public String getCarno()
    {
        return carno;
    }
    public void setLogtime(String logtime)
    {
        this.logtime = logtime;
    }

    public String getLogtime()
    {
        return logtime;
    }
    public void setCartype(String cartype)
    {
        this.cartype = cartype;
    }

    public String getCartype()
    {
        return cartype;
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept()
    {
        return dept;
    }
    public void setBegintime(String begintime)
    {
        this.begintime = begintime;
    }

    public String getBegintime()
    {
        return begintime;
    }
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    public String getEndtime()
    {
        return endtime;
    }
    public void setTotaltime(BigDecimal totaltime)
    {
        this.totaltime = totaltime;
    }

    public BigDecimal getTotaltime()
    {
        return totaltime;
    }
    public void setZuoyeliang(BigDecimal zuoyeliang)
    {
        this.zuoyeliang = zuoyeliang;
    }

    public BigDecimal getZuoyeliang()
    {
        return zuoyeliang;
    }
    public void setFeiyong(BigDecimal feiyong)
    {
        this.feiyong = feiyong;
    }

    public BigDecimal getFeiyong()
    {
        return feiyong;
    }
    public void setDidian(String didian)
    {
        this.didian = didian;
    }

    public String getDidian()
    {
        return didian;
    }
    public void setShiyou(String shiyou)
    {
        this.shiyou = shiyou;
    }

    public String getShiyou()
    {
        return shiyou;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
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
    public void setYongcheren(String yongcheren)
    {
        this.yongcheren = yongcheren;
    }

    public String getYongcheren()
    {
        return yongcheren;
    }
    public void setLogren(String logren)
    {
        this.logren = logren;
    }

    public String getLogren()
    {
        return logren;
    }
    public void setTimespan(String timespan)
    {
        this.timespan = timespan;
    }

    public String getTimespan()
    {
        return timespan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("carno", getCarno())
                .append("logtime", getLogtime())
                .append("cartype", getCartype())
                .append("dept", getDept())
                .append("begintime", getBegintime())
                .append("endtime", getEndtime())
                .append("totaltime", getTotaltime())
                .append("zuoyeliang", getZuoyeliang())
                .append("feiyong", getFeiyong())
                .append("didian", getDidian())
                .append("shiyou", getShiyou())
                .append("note", getNote())
                .append("shoufeifangshi", getShoufeifangshi())
                .append("danjia", getDanjia())
                .append("beizhu", getBeizhu())
                .append("yongcheren", getYongcheren())
                .append("logren", getLogren())
                .append("timespan", getTimespan())
                .toString();
    }
}
