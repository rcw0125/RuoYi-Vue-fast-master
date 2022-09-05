package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 收坯统计对象 mes_shoupi
 *
 * @author ruoyi
 * @date 2022-05-19
 */
@DataSource(value = DataSourceType.SLAVE)
public class MesShoupi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 铸机 */
    @Excel(name = "铸机")
    private String ccmid;

    /** 炉号 */
    @Excel(name = "炉号")
    private String heatid;

    /** 炉座 */
    @Excel(name = "炉座")
    private String bofid;

    /** 开吹时间 */
    @Excel(name = "开吹时间")
    private String blowstart;

    /** 钢种 */
    @Excel(name = "钢种")
    private String steelgrade;

    /** 包次 */
    @Excel(name = "包次")
    private String baocihao;

    /** 生产日期 */
    @Excel(name = "生产日期")
    private String productiondate;

    /** 铁水 */
    @Excel(name = "铁水")
    private Double ironweight;

    /** 废钢 */
    @Excel(name = "废钢")
    private Double scrapweight;

    /** 铁块 */
    @Excel(name = "铁块")
    private Double pigironweight;

    /** 压块 */
    @Excel(name = "压块")
    private Double ykweight;

    /** 钢水 */
    @Excel(name = "钢水")
    private Double steelweight;

    /** 收坯 */
    @Excel(name = "收坯")
    private Double bloomweight;

    /** 铁耗 */
    @Excel(name = "铁耗")
    private Double tiehao;

    /** 氧气消耗 */
    @Excel(name = "氧气消耗")
    private Double yangqi;

    /** 转炉石灰 */
    @Excel(name = "转炉石灰")
    private Double bofshihui;

    /** 精炼石灰 */
    @Excel(name = "精炼石灰")
    private Double lfshihui;

    public Double getShaojiefankuang() {
        return shaojiefankuang;
    }

    public void setShaojiefankuang(Double shaojiefankuang) {
        this.shaojiefankuang = shaojiefankuang;
    }

    /** 烧结返矿 */
    @Excel(name = "烧结返矿")
    private Double shaojiefankuang;

    /** 转炉合金 */
    @Excel(name = "转炉合金")
    private Double bofalloy;

    /** 精炼合金 */
    @Excel(name = "精炼合金")
    private Double lfalloy;

    /** 铁水温度 */
    @Excel(name = "铁水温度")
    private Double irontemp;

    /** NC标志 */
    @Excel(name = "NC标志")
    private String ncflag;

    /** 石灰石 */
    @Excel(name = "石灰石")
    private Double shihuishi;

    /** 留渣 */
    @Excel(name = "留渣")
    private long liuzha;

    /** 炉龄 */
    @Excel(name = "炉龄")
    private long luling;

    /** 冶炼周期 */
    @Excel(name = "冶炼周期")
    private String zhouqi;

    /** 轻烧白云石 */
    @Excel(name = "轻烧白云石")
    private Double qingshaobaiyunshi;

    /** 炼钢白云灰 */
    @Excel(name = "炼钢白云灰")
    private Double lgbaiyunshi;

    /** 拉碳温度 */
    @Excel(name = "拉碳温度")
    private Long lactemp;

    /** 顶渣灰 */
    @Excel(name = "顶渣灰")
    private Double dingzhahui;

    /** 补吹次数 */
    @Excel(name = "补吹次数")
    private Long reblowCount;

    /** 补吹判定 */
    @Excel(name = "补吹判定")
    private String blowjudge;

    /** 转炉生产日期 */
    @Excel(name = "转炉生产日期")
    private String boftime;

    public void setCcmid(String ccmid)
    {
        this.ccmid = ccmid;
    }

    public String getCcmid()
    {
        return ccmid;
    }
    public void setHeatid(String heatid)
    {
        this.heatid = heatid;
    }

    public String getHeatid()
    {
        return heatid;
    }
    public void setBofid(String bofid)
    {
        this.bofid = bofid;
    }

    public String getBofid()
    {
        return bofid;
    }
    public void setBlowstart(String blowstart)
    {
        this.blowstart = blowstart;
    }

    public String getBlowstart()
    {
        return blowstart;
    }
    public void setSteelgrade(String steelgrade)
    {
        this.steelgrade = steelgrade;
    }

    public String getSteelgrade()
    {
        return steelgrade;
    }
    public void setBaocihao(String baocihao)
    {
        this.baocihao = baocihao;
    }

    public String getBaocihao()
    {
        return baocihao;
    }
    public void setProductiondate(String productiondate)
    {
        this.productiondate = productiondate;
    }

    public String getProductiondate()
    {
        return productiondate;
    }
    public void setIronweight(Double ironweight)
    {
        this.ironweight = ironweight;
    }

    public Double getIronweight()
    {
        return ironweight;
    }
    public void setScrapweight(Double scrapweight)
    {
        this.scrapweight = scrapweight;
    }

    public Double getScrapweight()
    {
        return scrapweight;
    }
    public void setPigironweight(Double pigironweight)
    {
        this.pigironweight = pigironweight;
    }

    public Double getPigironweight()
    {
        return pigironweight;
    }
    public void setYkweight(Double ykweight)
    {
        this.ykweight = ykweight;
    }

    public Double getYkweight()
    {
        return ykweight;
    }
    public void setSteelweight(Double steelweight)
    {
        this.steelweight = steelweight;
    }

    public Double getSteelweight()
    {
        return steelweight;
    }
    public void setBloomweight(Double bloomweight)
    {
        this.bloomweight = bloomweight;
    }

    public Double getBloomweight()
    {
        return bloomweight;
    }
    public void setYangqi(Double yangqi)
    {
        this.yangqi = yangqi;
    }

    public Double getYangqi()
    {
        return yangqi;
    }
    public void setBofshihui(Double bofshihui)
    {
        this.bofshihui = bofshihui;
    }

    public Double getBofshihui()
    {
        return bofshihui;
    }
    public void setLfshihui(Double lfshihui)
    {
        this.lfshihui = lfshihui;
    }

    public Double getLfshihui()
    {
        return lfshihui;
    }
    public void setBofalloy(Double bofalloy)
    {
        this.bofalloy = bofalloy;
    }

    public Double getBofalloy()
    {
        return bofalloy;
    }
    public void setLfalloy(Double lfalloy)
    {
        this.lfalloy = lfalloy;
    }

    public Double getLfalloy()
    {
        return lfalloy;
    }
    public void setIrontemp(Double irontemp)
    {
        this.irontemp = irontemp;
    }

    public Double getIrontemp()
    {
        return irontemp;
    }
    public void setNcflag(String ncflag)
    {
        this.ncflag = ncflag;
    }

    public String getNcflag()
    {
        return ncflag;
    }
    public void setShihuishi(Double shihuishi)
    {
        this.shihuishi = shihuishi;
    }

    public Double getShihuishi()
    {
        return shihuishi;
    }
    public void setLiuzha(long liuzha)
    {
        this.liuzha = liuzha;
    }

    public long getLiuzha()
    {
        return liuzha;
    }
    public void setLuling(long luling)
    {
        this.luling = luling;
    }

    public long getLuling()
    {
        return luling;
    }
    public void setZhouqi(String zhouqi)
    {
        this.zhouqi = zhouqi;
    }

    public String getZhouqi()
    {
        return zhouqi;
    }
    public void setQingshaobaiyunshi(Double qingshaobaiyunshi)
    {
        this.qingshaobaiyunshi = qingshaobaiyunshi;
    }

    public Double getQingshaobaiyunshi()
    {
        return qingshaobaiyunshi;
    }
    public void setLgbaiyunshi(Double lgbaiyunshi)
    {
        this.lgbaiyunshi = lgbaiyunshi;
    }

    public Double getLgbaiyunshi()
    {
        return lgbaiyunshi;
    }
    public void setLactemp(Long lactemp)
    {
        this.lactemp = lactemp;
    }

    public Long getLactemp()
    {
        return lactemp;
    }
    public void setDingzhahui(Double dingzhahui)
    {
        this.dingzhahui = dingzhahui;
    }

    public Double getDingzhahui()
    {
        return dingzhahui;
    }
    public void setReblowCount(Long reblowCount)
    {
        this.reblowCount = reblowCount;
    }

    public Long getReblowCount()
    {
        return reblowCount;
    }
    public void setBlowjudge(String blowjudge)
    {
        this.blowjudge = blowjudge;
    }

    public String getBlowjudge()
    {
        return blowjudge;
    }
    public void setBoftime(String boftime)
    {
        this.boftime = boftime;
    }

    public String getBoftime()
    {
        return boftime;
    }

    public void setTiehao(Double tiehao)
    {
        this.tiehao = tiehao;
    }

    public Double getTiehao()
    {
        return tiehao;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("ccmid", getCcmid())
                .append("heatid", getHeatid())
                .append("bofid", getBofid())
                .append("blowstart", getBlowstart())
                .append("steelgrade", getSteelgrade())
                .append("baocihao", getBaocihao())
                .append("productiondate", getProductiondate())
                .append("ironweight", getIronweight())
                .append("scrapweight", getScrapweight())
                .append("pigironweight", getPigironweight())
                .append("ykweight", getYkweight())
                .append("steelweight", getSteelweight())
                .append("bloomweight", getBloomweight())
                .append("yangqi", getYangqi())
                .append("bofshihui", getBofshihui())
                .append("lfshihui", getLfshihui())
                .append("bofalloy", getBofalloy())
                .append("lfalloy", getLfalloy())
                .append("irontemp", getIrontemp())
                .append("ncflag", getNcflag())
                .append("shihuishi", getShihuishi())
                .append("liuzha", getLiuzha())
                .append("luling", getLuling())
                .append("zhouqi", getZhouqi())
                .append("qingshaobaiyunshi", getQingshaobaiyunshi())
                .append("lgbaiyunshi", getLgbaiyunshi())
                .append("lactemp", getLactemp())
                .append("dingzhahui", getDingzhahui())
                .append("reblowCount", getReblowCount())
                .append("blowjudge", getBlowjudge())
                .append("boftime", getBoftime())
                .append("tiehao", getTiehao())
                .append("shaojiefankuang", getShaojiefankuang())
                .toString();
    }
}
