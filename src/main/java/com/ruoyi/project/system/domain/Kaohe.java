package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 考核单对象 kaohe
 *
 * @author ruoyi
 * @date 2021-04-08
 */
public class Kaohe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long kaoheId;

    /** 被考核人编码 */
    @Excel(name = "被考核人编码")
    private String useraccount;

    /** 被考核人 */
    @Excel(name = "被考核人")
    private String nickname;

    /** 被考核单位 */
    @Excel(name = "被考核单位")
    private String deptname;

    /** 绩效扣分 */
    @Excel(name = "考核金额(元)")
    private BigDecimal jxkf;

    /** 安全扣分 */
    private BigDecimal aqkf;

    /** 班组 */
    @Excel(name = "班组")
    private String team;

    /** 考核等级 */
    @Excel(name = "考核等级")
    private String khdj;

    /** 考核性质 */
    @Excel(name = "考核性质")
    private String khxz;

    /** 考核种类 */
    @Excel(name = "考核种类")
    private String khzl;

    /** 日期 */
    @Excel(name = "日期")
    private String khrq;

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    /**记录日期 */

    private String logtime;

    /** 考核内容 */
    @Excel(name = "考核内容")
    private String khnote;

    /** 考核人编码 */
    @Excel(name = "考核人编码")
    private String leaderaccount;

    /** 考核人 */
    @Excel(name = "考核人")
    private String leadername;

    /** 考核单位 */
    @Excel(name = "考核单位")
    private String leaderdept;



    /** 考核属性 0 科室考评 1 内部考评  2 相关方考评 */

    /** 考核类型 */
    @Excel(name = "考核类型")
    private String khtype;

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    /** 结束时间， 只用于查询 */
    private String endtime;


    public void setKaoheId(Long kaoheId)
    {
        this.kaoheId = kaoheId;
    }

    public Long getKaoheId()
    {
        return kaoheId;
    }
    public void setUseraccount(String useraccount)
    {
        this.useraccount = useraccount;
    }

    public String getUseraccount()
    {
        return useraccount;
    }
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
    public void setDeptname(String deptname)
    {
        this.deptname = deptname;
    }

    public String getDeptname()
    {
        return deptname;
    }
    public void setJxkf(BigDecimal jxkf)
    {
        this.jxkf = jxkf;
    }

    public BigDecimal getJxkf()
    {
        return jxkf;
    }
    public void setAqkf(BigDecimal aqkf)
    {
        this.aqkf = aqkf;
    }

    public BigDecimal getAqkf()
    {
        return aqkf;
    }
    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getTeam()
    {
        return team;
    }
    public void setKhdj(String khdj)
    {
        this.khdj = khdj;
    }

    public String getKhdj()
    {
        return khdj;
    }
    public void setKhxz(String khxz)
    {
        this.khxz = khxz;
    }

    public String getKhxz()
    {
        return khxz;
    }
    public void setKhzl(String khzl)
    {
        this.khzl = khzl;
    }

    public String getKhzl()
    {
        return khzl;
    }
    public void setKhrq(String khrq)
    {
        this.khrq = khrq;
    }

    public String getKhrq()
    {
        return khrq;
    }
    public void setKhnote(String khnote)
    {
        this.khnote = khnote;
    }

    public String getKhnote()
    {
        return khnote;
    }
    public void setLeaderaccount(String leaderaccount)
    {
        this.leaderaccount = leaderaccount;
    }

    public String getLeaderaccount()
    {
        return leaderaccount;
    }
    public void setLeadername(String leadername)
    {
        this.leadername = leadername;
    }

    public String getLeadername()
    {
        return leadername;
    }
    public void setLeaderdept(String leaderdept)
    {
        this.leaderdept = leaderdept;
    }

    public String getLeaderdept()
    {
        return leaderdept;
    }


    public void setKhtype(String khtype)
    {
        this.khtype = khtype;
    }

    public String getKhtype()
    {
        return khtype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("kaoheId", getKaoheId())
            .append("useraccount", getUseraccount())
            .append("nickname", getNickname())
            .append("deptname", getDeptname())
            .append("jxkf", getJxkf())
            .append("aqkf", getAqkf())
            .append("team", getTeam())
            .append("khdj", getKhdj())
            .append("khxz", getKhxz())
            .append("khzl", getKhzl())
            .append("khrq", getKhrq())
                .append("logtime", getLogtime())
            .append("khnote", getKhnote())
            .append("leaderaccount", getLeaderaccount())
            .append("leadername", getLeadername())
            .append("leaderdept", getLeaderdept())
                .append("khtype", getKhtype())
            .toString();
    }
}
