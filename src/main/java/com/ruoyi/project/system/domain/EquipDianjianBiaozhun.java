package com.ruoyi.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 点检标准对象 equip_dianjian_biaozhun
 *
 * @author ruoyi
 * @date 2021-09-22
 */
public class EquipDianjianBiaozhun extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long sbid;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbname;

    /** 点检路线 */
    @Excel(name = "点检路线")
    private String name;

    /** 点检标准 */
    private String biaozhun;

    /** 点检单位 */
    @Excel(name = "点检单位")
    private String dept;

    /** 点检班组 */
    @Excel(name = "点检班组")
    private String team;

    /** 点检类别 */
    @Excel(name = "点检类别")
    private String leibie;

    /** 点检周期 */
    @Excel(name = "点检周期")
    private String zhouqi;

    /** 关注参数 */
    @Excel(name = "关注参数")
    private String yxcs;

    /** 点检等级 */
    @Excel(name = "点检等级")
    private String fenji;
    /** 备注 */
    private String note;

    /** 应点检次数 */
    @Excel(name = "应点检次数")
    private String zhoucishu;


    /** 上次点检时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "点检时刻", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date lasttime;

    /** 是否可以点检标志 */
    @Excel(name = "是否可以点检标志")
    private Integer flag;

    /** 顺序 */
    @Excel(name = "顺序")
    private Integer ordernum;

    /** 实际点检次数 */
    @Excel(name = "实际点检次数")
    private Integer djcs;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSbid(Long sbid)
    {
        this.sbid = sbid;
    }

    public Long getSbid()
    {
        return sbid;
    }
    public void setSbname(String sbname)
    {
        this.sbname = sbname;
    }

    public String getSbname()
    {
        return sbname;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setBiaozhun(String biaozhun)
    {
        this.biaozhun = biaozhun;
    }

    public String getBiaozhun()
    {
        return biaozhun;
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept()
    {
        return dept;
    }
    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getTeam()
    {
        return team;
    }
    public void setLeibie(String leibie)
    {
        this.leibie = leibie;
    }

    public String getLeibie()
    {
        return leibie;
    }
    public void setZhouqi(String zhouqi)
    {
        this.zhouqi = zhouqi;
    }

    public String getZhouqi()
    {
        return zhouqi;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setZhoucishu(String zhoucishu)
    {
        this.zhoucishu = zhoucishu;
    }

    public String getZhoucishu()
    {
        return zhoucishu;
    }

    public void setLasttime(Date lasttime)
    {
        this.lasttime = lasttime;
    }

    public Date getLasttime()
    {
        return lasttime;
    }
    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    public Integer getFlag()
    {
        return flag;
    }

    public void setOrdernum(Integer ordernum)
    {
        this.ordernum = ordernum;
    }

    public Integer getOrdernum()
    {
        return ordernum;
    }
    public void setDjcs(Integer djcs)
    {
        this.djcs = djcs;
    }

    public Integer getDjcs()
    {
        return djcs;
    }

    public void setYxcs(String yxcs)
    {
        this.yxcs = yxcs;
    }

    public String getYxcs()
    {
        return yxcs;
    }
    public void setFenji(String fenji)
    {
        this.fenji = fenji;
    }

    public String getFenji()
    {
        return fenji;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sbid", getSbid())
                .append("sbname", getSbname())
                .append("name", getName())
                .append("biaozhun", getBiaozhun())
                .append("dept", getDept())
                .append("team", getTeam())
                .append("leibie", getLeibie())
                .append("zhouqi", getZhouqi())
                .append("note", getNote())
                .append("zhoucishu", getZhoucishu())
                .append("lasttime", getLasttime())
                .append("flag", getFlag())
                .append("ordernum", getOrdernum())
                .append("djcs", getDjcs())
                .append("yxcs", getYxcs())
                .append("fenji", getFenji())
                .toString();
    }
}
