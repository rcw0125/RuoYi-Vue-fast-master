package com.ruoyi.project.system.domain;

import java.math.BigDecimal;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 能源数据对象 mes_nengyuan_day
 *
 * @author ruoyi
 * @date 2022-01-21
 */
@DataSource(value = DataSourceType.SLAVE)
public class MesNengyuanDay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 产量 */
    @Excel(name = "产量")
    private BigDecimal tg;

    /** 水耗 */
    @Excel(name = "水耗")
    private BigDecimal shuihao;

    /** 电耗 */
    @Excel(name = "电耗")
    private BigDecimal dianhao;

    /** 焦炉煤气 */
    @Excel(name = "焦炉煤气")
    private BigDecimal jiaolumeiqi;

    /** 转炉煤气 */
    @Excel(name = "转炉煤气")
    private BigDecimal zhuanlumeiqi;

    /** 氮气 */
    @Excel(name = "氮气")
    private BigDecimal danqi;

    /** 氧气 */
    @Excel(name = "氧气")
    private BigDecimal yangqi;

    /** 氩气 */
    @Excel(name = "氩气")
    private BigDecimal yaqi;

    /** 蒸汽外供 */
    @Excel(name = "蒸汽外供")
    private BigDecimal zhengqiwaigong;

    /** 煤气回收 */
    @Excel(name = "煤气回收")
    private BigDecimal meiqihuishou;

    public void setLogtime(String logtime)
    {
        this.logtime = logtime;
    }

    public String getLogtime()
    {
        return logtime;
    }
    public void setTg(BigDecimal tg)
    {
        this.tg = tg;
    }

    public BigDecimal getTg()
    {
        return tg;
    }
    public void setShuihao(BigDecimal shuihao)
    {
        this.shuihao = shuihao;
    }

    public BigDecimal getShuihao()
    {
        return shuihao;
    }
    public void setDianhao(BigDecimal dianhao)
    {
        this.dianhao = dianhao;
    }

    public BigDecimal getDianhao()
    {
        return dianhao;
    }
    public void setJiaolumeiqi(BigDecimal jiaolumeiqi)
    {
        this.jiaolumeiqi = jiaolumeiqi;
    }

    public BigDecimal getJiaolumeiqi()
    {
        return jiaolumeiqi;
    }
    public void setZhuanlumeiqi(BigDecimal zhuanlumeiqi)
    {
        this.zhuanlumeiqi = zhuanlumeiqi;
    }

    public BigDecimal getZhuanlumeiqi()
    {
        return zhuanlumeiqi;
    }
    public void setDanqi(BigDecimal danqi)
    {
        this.danqi = danqi;
    }

    public BigDecimal getDanqi()
    {
        return danqi;
    }
    public void setYangqi(BigDecimal yangqi)
    {
        this.yangqi = yangqi;
    }

    public BigDecimal getYangqi()
    {
        return yangqi;
    }
    public void setYaqi(BigDecimal yaqi)
    {
        this.yaqi = yaqi;
    }

    public BigDecimal getYaqi()
    {
        return yaqi;
    }
    public void setZhengqiwaigong(BigDecimal zhengqiwaigong)
    {
        this.zhengqiwaigong = zhengqiwaigong;
    }

    public BigDecimal getZhengqiwaigong()
    {
        return zhengqiwaigong;
    }
    public void setMeiqihuishou(BigDecimal meiqihuishou)
    {
        this.meiqihuishou = meiqihuishou;
    }

    public BigDecimal getMeiqihuishou()
    {
        return meiqihuishou;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logtime", getLogtime())
            .append("tg", getTg())
            .append("shuihao", getShuihao())
            .append("dianhao", getDianhao())
            .append("jiaolumeiqi", getJiaolumeiqi())
            .append("zhuanlumeiqi", getZhuanlumeiqi())
            .append("danqi", getDanqi())
            .append("yangqi", getYangqi())
            .append("yaqi", getYaqi())
            .append("zhengqiwaigong", getZhengqiwaigong())
            .append("meiqihuishou", getMeiqihuishou())
            .toString();
    }
}
