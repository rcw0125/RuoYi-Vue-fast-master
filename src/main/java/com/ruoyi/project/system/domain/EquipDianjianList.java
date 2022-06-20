package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 点检记录对象 equip_dianjian_list
 *
 * @author ruoyi
 * @date 2021-09-23
 */
public class EquipDianjianList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private Long sbid;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbname;


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

    /** 点检人 */
    @Excel(name = "点检人")
    private String djr;

    /** 点检结果 */
    @Excel(name = "点检结果")
    private String djresult;

    /** 点检内容 */
    @Excel(name = "点检内容")
    private String djcontent;

    /** 点检时刻 */
    @Excel(name = "点检时刻", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date djtime;

    /** 点检图片 */
    @Excel(name = "点检图片")
    private String pic;

    /** 标准id */
    @Excel(name = "标准id")
    private Long bzhid;

    /** 标准内容 */
    @Excel(name = "标准内容")
    private String biaozhun;


    /** 周应点检次数 */
    @Excel(name = "周应点检次数")
    private String zhoucishu;
    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 是否可以点检 */

    private Integer flag;

    /** 点检日期 */
    @Excel(name = "点检日期")
    private String djrq;
    /** 标准备注 */
    @Excel(name = "标准备注")
    private String bzhnote;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ip;

    /** 来源(电脑或手机) */
    @Excel(name = "来源(电脑或手机)")
    private String laiyuan;
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
    public void setBzhid(Long bzhid)
    {
        this.bzhid = bzhid;
    }

    public Long getBzhid()
    {
        return bzhid;
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
    public void setBzhnote(String bzhnote)
    {
        this.bzhnote = bzhnote;
    }

    public String getBzhnote()
    {
        return bzhnote;
    }
    public void setZhoucishu(String zhoucishu)
    {
        this.zhoucishu = zhoucishu;
    }

    public String getZhoucishu()
    {
        return zhoucishu;
    }
    public void setDjr(String djr)
    {
        this.djr = djr;
    }

    public String getDjr()
    {
        return djr;
    }
    public void setDjresult(String djresult)
    {
        this.djresult = djresult;
    }

    public String getDjresult()
    {
        return djresult;
    }
    public void setDjcontent(String djcontent)
    {
        this.djcontent = djcontent;
    }

    public String getDjcontent()
    {
        return djcontent;
    }
    public void setDjtime(Date djtime)
    {
        this.djtime = djtime;
    }

    public Date getDjtime()
    {
        return djtime;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    public Integer getFlag()
    {
        return flag;
    }
    public void setDjrq(String djrq)
    {
        this.djrq = djrq;
    }

    public String getDjrq()
    {
        return djrq;
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
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setLaiyuan(String laiyuan)
    {
        this.laiyuan = laiyuan;
    }

    public String getLaiyuan()
    {
        return laiyuan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sbid", getSbid())
            .append("sbname", getSbname())
            .append("bzhid", getBzhid())
            .append("biaozhun", getBiaozhun())
            .append("dept", getDept())
            .append("team", getTeam())
            .append("leibie", getLeibie())
            .append("zhouqi", getZhouqi())
            .append("bzhnote", getBzhnote())
            .append("zhoucishu", getZhoucishu())
            .append("djr", getDjr())
            .append("djresult", getDjresult())
            .append("djcontent", getDjcontent())
            .append("djtime", getDjtime())
            .append("note", getNote())
            .append("flag", getFlag())
            .append("djrq", getDjrq())
                .append("yxcs", getYxcs())
                .append("fenji", getFenji())
                .append("pic", getPic())
                .append("ip", getIp())
                .append("laiyuan", getLaiyuan())
            .toString();
    }
}
