package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 故障报修对象 equip_guzhang
 *
 * @author ruoyi
 * @date 2021-09-28
 */
public class EquipGuzhang extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private Long sbid;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbname;

    /** 登记车间 */
    @Excel(name = "登记车间")
    private String djdept;

    /** 登记人 */
    @Excel(name = "登记人")
    private String djr;

    /** 登记时刻 */
    @Excel(name = "登记时刻")
    private String djsk;

    /** 故障内容 */
    @Excel(name = "故障内容")
    private String djcontent;

    /** 责任车间 */
    @Excel(name = "责任车间")
    private String djwxdept;

    /** 登记人电话 */
    @Excel(name = "登记人电话")
    private String djrphone;

    /** 接收人 */
    @Excel(name = "接收人")
    private String jsr;

    /** 故障初步分析 */
    @Excel(name = "故障初步分析")
    private String jscontent;

    /** 预计处理时间(天) */
    @Excel(name = "预计处理时间(天)")
    private Long jsclsj;

    /** 故障大类 */
    @Excel(name = "故障大类")
    private String jsclfl;

    /** 接收时刻 */
    @Excel(name = "接收时刻")
    private String jssk;

    /** 接收用时 */
    @Excel(name = "接收用时")
    private BigDecimal jsys;

    /** 处理人 */
    @Excel(name = "处理人")
    private String clr;

    /** 故障处理过程 */
    @Excel(name = "故障处理过程")
    private String clcontent;

    /** 故障小类 */
    @Excel(name = "故障小类")
    private String clgzfenlei;

    /** 处理时刻 */
    @Excel(name = "处理时刻")
    private String clsk;

    /** 处理用时 */
    @Excel(name = "处理用时")
    private BigDecimal clys;

    /** 处理人电话 */
    @Excel(name = "处理人电话")
    private String clrphone;

    /** 验证人 */
    @Excel(name = "验证人")
    private String yzr;

    /** 验证结果 */
    @Excel(name = "验证结果")
    private String yzresult;

    /** 验证内容 */
    @Excel(name = "验证内容")
    private String yzcontent;

    /** 验证时刻 */
    @Excel(name = "验证时刻")
    private String yzsk;

    /** 验证用时 */
    @Excel(name = "验证用时")
    private BigDecimal yzys;

    /** 总用时 */
    @Excel(name = "总用时")
    private BigDecimal totalys;

    /** 是否维修标志，0 否  1是 */
    @Excel(name = "是否维修标志，0 否  1是")
    private Integer flag;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 完成标志，0，未完成，1，完成。 */
    @Excel(name = "完成标志，0，未完成，1，完成。")
    private Integer locked;

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
    public void setDjdept(String djdept)
    {
        this.djdept = djdept;
    }

    public String getDjdept()
    {
        return djdept;
    }
    public void setDjr(String djr)
    {
        this.djr = djr;
    }

    public String getDjr()
    {
        return djr;
    }
    public void setDjsk(String djsk)
    {
        this.djsk = djsk;
    }

    public String getDjsk()
    {
        return djsk;
    }
    public void setDjcontent(String djcontent)
    {
        this.djcontent = djcontent;
    }

    public String getDjcontent()
    {
        return djcontent;
    }
    public void setDjwxdept(String djwxdept)
    {
        this.djwxdept = djwxdept;
    }

    public String getDjwxdept()
    {
        return djwxdept;
    }
    public void setDjrphone(String djrphone)
    {
        this.djrphone = djrphone;
    }

    public String getDjrphone()
    {
        return djrphone;
    }
    public void setJsr(String jsr)
    {
        this.jsr = jsr;
    }

    public String getJsr()
    {
        return jsr;
    }
    public void setJscontent(String jscontent)
    {
        this.jscontent = jscontent;
    }

    public String getJscontent()
    {
        return jscontent;
    }
    public void setJsclsj(Long jsclsj)
    {
        this.jsclsj = jsclsj;
    }

    public Long getJsclsj()
    {
        return jsclsj;
    }
    public void setJsclfl(String jsclfl)
    {
        this.jsclfl = jsclfl;
    }

    public String getJsclfl()
    {
        return jsclfl;
    }
    public void setJssk(String jssk)
    {
        this.jssk = jssk;
    }

    public String getJssk()
    {
        return jssk;
    }
    public void setJsys(BigDecimal jsys)
    {
        this.jsys = jsys;
    }

    public BigDecimal getJsys()
    {
        return jsys;
    }
    public void setClr(String clr)
    {
        this.clr = clr;
    }

    public String getClr()
    {
        return clr;
    }
    public void setClcontent(String clcontent)
    {
        this.clcontent = clcontent;
    }

    public String getClcontent()
    {
        return clcontent;
    }
    public void setClgzfenlei(String clgzfenlei)
    {
        this.clgzfenlei = clgzfenlei;
    }

    public String getClgzfenlei()
    {
        return clgzfenlei;
    }
    public void setClsk(String clsk)
    {
        this.clsk = clsk;
    }

    public String getClsk()
    {
        return clsk;
    }
    public void setClys(BigDecimal clys)
    {
        this.clys = clys;
    }

    public BigDecimal getClys()
    {
        return clys;
    }
    public void setClrphone(String clrphone)
    {
        this.clrphone = clrphone;
    }

    public String getClrphone()
    {
        return clrphone;
    }
    public void setYzr(String yzr)
    {
        this.yzr = yzr;
    }

    public String getYzr()
    {
        return yzr;
    }
    public void setYzresult(String yzresult)
    {
        this.yzresult = yzresult;
    }

    public String getYzresult()
    {
        return yzresult;
    }
    public void setYzcontent(String yzcontent)
    {
        this.yzcontent = yzcontent;
    }

    public String getYzcontent()
    {
        return yzcontent;
    }
    public void setYzsk(String yzsk)
    {
        this.yzsk = yzsk;
    }

    public String getYzsk()
    {
        return yzsk;
    }
    public void setYzys(BigDecimal yzys)
    {
        this.yzys = yzys;
    }

    public BigDecimal getYzys()
    {
        return yzys;
    }
    public void setTotalys(BigDecimal totalys)
    {
        this.totalys = totalys;
    }

    public BigDecimal getTotalys()
    {
        return totalys;
    }
    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    public Integer getFlag()
    {
        return flag;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setLocked(Integer locked)
    {
        this.locked = locked;
    }

    public Integer getLocked()
    {
        return locked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sbid", getSbid())
                .append("sbname", getSbname())
                .append("djdept", getDjdept())
                .append("djr", getDjr())
                .append("djsk", getDjsk())
                .append("djcontent", getDjcontent())
                .append("djwxdept", getDjwxdept())
                .append("djrphone", getDjrphone())
                .append("jsr", getJsr())
                .append("jscontent", getJscontent())
                .append("jsclsj", getJsclsj())
                .append("jsclfl", getJsclfl())
                .append("jssk", getJssk())
                .append("jsys", getJsys())
                .append("clr", getClr())
                .append("clcontent", getClcontent())
                .append("clgzfenlei", getClgzfenlei())
                .append("clsk", getClsk())
                .append("clys", getClys())
                .append("clrphone", getClrphone())
                .append("yzr", getYzr())
                .append("yzresult", getYzresult())
                .append("yzcontent", getYzcontent())
                .append("yzsk", getYzsk())
                .append("yzys", getYzys())
                .append("totalys", getTotalys())
                .append("flag", getFlag())
                .append("status", getStatus())
                .append("locked", getLocked())
                .toString();
    }
}
