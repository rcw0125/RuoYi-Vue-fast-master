package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 介质停送记录对象 ems_jizhi
 *
 * @author ruoyi
 * @date 2021-10-22
 */
public class EmsJizhi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 工位 */
    @Excel(name = "工位")
    private String gongxu;

    /** 介质类型 */
    @Excel(name = "介质类型")
    private String jztype;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbname;

    /** 操作类型 */
    @Excel(name = "操作类型")
    private String opertype;

    /** 炉号 */
    @Excel(name = "炉号")
    private String heatid;

    /** 炉次结束时间 */
    @Excel(name = "炉次结束时间")
    private String heatendtime;

    /** 岗位人员签字 */
    @Excel(name = "岗位人员签字")
    private String gongxuren;

    /** 调度 */
    @Excel(name = "调度")
    private String diaodu;

    /** 炼钢签字时间 */
    @Excel(name = "炼钢签字时间")
    private String lgqztime;

    /** 异常描述 */
    @Excel(name = "异常描述")
    private String exceptnote;

    /** 指令人 */
    @Excel(name = "指令人")
    private String zhilingren;

    /** 指令内容 */
    @Excel(name = "指令内容")
    private String zhilingnote;

    /** 接准备指令时间 */
    @Excel(name = "接准备指令时间")
    private String zhunbeitime;

    /** 接操作指令时间 */
    @Excel(name = "接操作指令时间")
    private String caozuotime;

    /** 设备最新动作时间 */
    @Excel(name = "设备最新动作时间")
    private String sbdongzuotime;

    /** 执行完毕时间 */
    @Excel(name = "执行完毕时间")
    private String wanbitime;

    /** 执行人 */
    @Excel(name = "执行人")
    private String zhixingren;

    /** 备注 */
    @Excel(name = "备注")
    private String dlnote;

    /** 指令状态 */
    @Excel(name = "指令状态")
    private String status;

    /** 判定 */
    @Excel(name = "判定")
    private String panding;

    /** 标准时间 */
    @Excel(name = "标准时间")
    private BigDecimal biaozhuntime;

    /** 实际用时 */
    @Excel(name = "实际用时")
    private BigDecimal shijitime;

    /** 启停详情 */
    @Excel(name = "启停详情")
    private String dongzuonote;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLogtime(String logtime)
    {
        this.logtime = logtime;
    }

    public String getLogtime()
    {
        return logtime;
    }
    public void setGongxu(String gongxu)
    {
        this.gongxu = gongxu;
    }

    public String getGongxu()
    {
        return gongxu;
    }
    public void setJztype(String jztype)
    {
        this.jztype = jztype;
    }

    public String getJztype()
    {
        return jztype;
    }
    public void setSbname(String sbname)
    {
        this.sbname = sbname;
    }

    public String getSbname()
    {
        return sbname;
    }
    public void setOpertype(String opertype)
    {
        this.opertype = opertype;
    }

    public String getOpertype()
    {
        return opertype;
    }
    public void setHeatid(String heatid)
    {
        this.heatid = heatid;
    }

    public String getHeatid()
    {
        return heatid;
    }
    public void setHeatendtime(String heatendtime)
    {
        this.heatendtime = heatendtime;
    }

    public String getHeatendtime()
    {
        return heatendtime;
    }
    public void setGongxuren(String gongxuren)
    {
        this.gongxuren = gongxuren;
    }

    public String getGongxuren()
    {
        return gongxuren;
    }
    public void setDiaodu(String diaodu)
    {
        this.diaodu = diaodu;
    }

    public String getDiaodu()
    {
        return diaodu;
    }
    public void setLgqztime(String lgqztime)
    {
        this.lgqztime = lgqztime;
    }

    public String getLgqztime()
    {
        return lgqztime;
    }
    public void setExceptnote(String exceptnote)
    {
        this.exceptnote = exceptnote;
    }

    public String getExceptnote()
    {
        return exceptnote;
    }
    public void setZhilingren(String zhilingren)
    {
        this.zhilingren = zhilingren;
    }

    public String getZhilingren()
    {
        return zhilingren;
    }
    public void setZhilingnote(String zhilingnote)
    {
        this.zhilingnote = zhilingnote;
    }

    public String getZhilingnote()
    {
        return zhilingnote;
    }
    public void setZhunbeitime(String zhunbeitime)
    {
        this.zhunbeitime = zhunbeitime;
    }

    public String getZhunbeitime()
    {
        return zhunbeitime;
    }
    public void setCaozuotime(String caozuotime)
    {
        this.caozuotime = caozuotime;
    }

    public String getCaozuotime()
    {
        return caozuotime;
    }
    public void setSbdongzuotime(String sbdongzuotime)
    {
        this.sbdongzuotime = sbdongzuotime;
    }

    public String getSbdongzuotime()
    {
        return sbdongzuotime;
    }
    public void setWanbitime(String wanbitime)
    {
        this.wanbitime = wanbitime;
    }

    public String getWanbitime()
    {
        return wanbitime;
    }
    public void setZhixingren(String zhixingren)
    {
        this.zhixingren = zhixingren;
    }

    public String getZhixingren()
    {
        return zhixingren;
    }
    public void setDlnote(String dlnote)
    {
        this.dlnote = dlnote;
    }

    public String getDlnote()
    {
        return dlnote;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setPanding(String panding)
    {
        this.panding = panding;
    }

    public String getPanding()
    {
        return panding;
    }
    public void setBiaozhuntime(BigDecimal biaozhuntime)
    {
        this.biaozhuntime = biaozhuntime;
    }

    public BigDecimal getBiaozhuntime()
    {
        return biaozhuntime;
    }
    public void setShijitime(BigDecimal shijitime)
    {
        this.shijitime = shijitime;
    }

    public BigDecimal getShijitime()
    {
        return shijitime;
    }

    public void setDongzuonote(String dongzuonote)
    {
        this.dongzuonote = dongzuonote;
    }

    public String getDongzuonote()
    {
        return dongzuonote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("logtime", getLogtime())
            .append("gongxu", getGongxu())
            .append("jztype", getJztype())
            .append("sbname", getSbname())
            .append("opertype", getOpertype())
            .append("heatid", getHeatid())
            .append("heatendtime", getHeatendtime())
            .append("gongxuren", getGongxuren())
            .append("diaodu", getDiaodu())
            .append("lgqztime", getLgqztime())
            .append("exceptnote", getExceptnote())
            .append("zhilingren", getZhilingren())
            .append("zhilingnote", getZhilingnote())
            .append("zhunbeitime", getZhunbeitime())
            .append("caozuotime", getCaozuotime())
            .append("sbdongzuotime", getSbdongzuotime())
            .append("wanbitime", getWanbitime())
            .append("zhixingren", getZhixingren())
            .append("dlnote", getDlnote())
            .append("status", getStatus())
            .append("panding", getPanding())
            .append("biaozhuntime", getBiaozhuntime())
            .append("shijitime", getShijitime())
                .append("dongzuonote", getDongzuonote())
            .toString();
    }
}
