package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 员工自主改善对象 zizhugaishan
 *
 * @author ruoyi
 * @date 2021-04-21
 */
public class Zizhugaishan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Integer id;

    /** 项目编号 */
    private String xmcode;

    /** 项目改善点 */
    @Excel(name = "项目改善点")
    private String xmgsd;

    /** 项目分类 */
    @Excel(name = "项目分类")
    private String xmfl;

    /** 提出人编码 */
    @Excel(name = "提出人编码")
    private String tcrcode;

    /** 提出人 */
    @Excel(name = "提出人")
    private String tcr;

    /** 提出单位 */
    @Excel(name = "提出单位")
    private String tcrdw;

    /** 录入日期 */
    @Excel(name = "录入日期")
    private String tctime;

    /** 完成日期 */
    @Excel(name = "完成日期")
    private String wctime;


    /** 车间审核人 */
    @Excel(name = "车间审核人")
    private String cjsh;

    /** 车间审核日期 */
    @Excel(name = "车间审核日期")
    private String shtime;

    /** 车间不同意原因 */
    @Excel(name = "车间不同意原因")
    private String reason;

    /** 审核科室 */
    @Excel(name = "审核科室")
    private String shks;

    /** 科室审核人 */
    @Excel(name = "科室审核人")
    private String pjr;

    /** 科室审核日期 */
    @Excel(name = "科室审核日期")
    private String pjtime;

    /** 科室不同意原因 */
    @Excel(name = "科室不同意原因")
    private String ksreason;

    /** 改善前照片 */
    @Excel(name = "改善前照片")
    private String photoBefore;

    /** 改善后照片 */
    @Excel(name = "改善后照片")
    private String photoAfter;

    /** 改善后 */
    @Excel(name = "改善后")
    private String commentAfter;

    /** 改善过程 */
    @Excel(name = "改善过程")
    private String commentProcess;

    /** 改善前 */
    @Excel(name = "改善前")
    private String commentBefore;

    /** 改善人1 */
    @Excel(name = "改善人1")
    private String gsrname1;

    /** 改善人2 */
    @Excel(name = "改善人2")
    private String gsrname2;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String status;



    /** 精益办分级 */
//    @Excel(name = "精益办分级")
    private String jybfj;

    /** 属性 */
    @Excel(name = "属性")
    private String shuxing;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setXmcode(String xmcode)
    {
        this.xmcode = xmcode;
    }

    public String getXmcode()
    {
        return xmcode;
    }
    public void setXmgsd(String xmgsd)
    {
        this.xmgsd = xmgsd;
    }

    public String getXmgsd()
    {
        return xmgsd;
    }
    public void setXmfl(String xmfl)
    {
        this.xmfl = xmfl;
    }

    public String getXmfl()
    {
        return xmfl;
    }
    public void setTctime(String tctime)
    {
        this.tctime = tctime;
    }

    public String getTctime()
    {
        return tctime;
    }
    public void setTcrcode(String tcrcode)
    {
        this.tcrcode = tcrcode;
    }

    public String getTcrcode()
    {
        return tcrcode;
    }
    public void setTcr(String tcr)
    {
        this.tcr = tcr;
    }

    public String getTcr()
    {
        return tcr;
    }
    public void setTcrdw(String tcrdw)
    {
        this.tcrdw = tcrdw;
    }

    public String getTcrdw()
    {
        return tcrdw;
    }
    public void setWctime(String wctime)
    {
        this.wctime = wctime;
    }

    public String getWctime()
    {
        return wctime;
    }
    public void setShtime(String shtime)
    {
        this.shtime = shtime;
    }

    public String getShtime()
    {
        return shtime;
    }
    public void setShr(String shr)
    {
        this.cjsh = shr;
    }

    public String getShr()
    {
        return cjsh;
    }
    public void setPjtime(String pjtime)
    {
        this.pjtime = pjtime;
    }

    public String getPjtime()
    {
        return pjtime;
    }
    public void setPjr(String pjr)
    {
        this.pjr = pjr;
    }

    public String getPjr()
    {
        return pjr;
    }
    public void setPhotoBefore(String photoBefore)
    {
        this.photoBefore = photoBefore;
    }

    public String getPhotoBefore()
    {
        return photoBefore;
    }
    public void setPhotoAfter(String photoAfter)
    {
        this.photoAfter = photoAfter;
    }

    public String getPhotoAfter()
    {
        return photoAfter;
    }
    public void setCommentAfter(String commentAfter)
    {
        this.commentAfter = commentAfter;
    }

    public String getCommentAfter()
    {
        return commentAfter;
    }
    public void setCommentProcess(String commentProcess)
    {
        this.commentProcess = commentProcess;
    }

    public String getCommentProcess()
    {
        return commentProcess;
    }
    public void setCommentBefore(String commentBefore)
    {
        this.commentBefore = commentBefore;
    }

    public String getCommentBefore()
    {
        return commentBefore;
    }
    public void setGsrname1(String gsrname1)
    {
        this.gsrname1 = gsrname1;
    }

    public String getGsrname1()
    {
        return gsrname1;
    }
    public void setGsrname2(String gsrname2)
    {
        this.gsrname2 = gsrname2;
    }

    public String getGsrname2()
    {
        return gsrname2;
    }

    public void setShuxing(String shuxing)
    {
        this.shuxing = shuxing;
    }

    public String getShuxing()
    {
        return shuxing;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }

    public void setKsreason(String ksreason)
    {
        this.ksreason = ksreason;
    }

    public String getKsreason()
    {
        return ksreason;
    }
    public void setShks(String shks)
    {
        this.shks = shks;
    }

    public String getShks()
    {
        return shks;
    }
    public void setJybfj(String jybfj)
    {
        this.jybfj = jybfj;
    }

    public String getJybfj()
    {
        return jybfj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("xmcode", getXmcode())
                .append("xmgsd", getXmgsd())
                .append("xmfl", getXmfl())
                .append("tctime", getTctime())
                .append("tcrcode", getTcrcode())
                .append("tcr", getTcr())
                .append("tcrdw", getTcrdw())
                .append("wctime", getWctime())
                .append("shtime", getShtime())
                .append("cjsh", getShr())
                .append("pjtime", getPjtime())
                .append("pjr", getPjr())
                .append("photoBefore", getPhotoBefore())
                .append("photoAfter", getPhotoAfter())
                .append("commentAfter", getCommentAfter())
                .append("commentProcess", getCommentProcess())
                .append("commentBefore", getCommentBefore())
                .append("gsrname1", getGsrname1())
                .append("gsrname2", getGsrname2())
                .append("shuxing", getShuxing())
                .append("status", getStatus())
                .append("reason", getReason())
                .append("ksreason", getKsreason())
                .append("shks", getShks())
                .append("jybfj", getJybfj())
                .toString();
    }
}
