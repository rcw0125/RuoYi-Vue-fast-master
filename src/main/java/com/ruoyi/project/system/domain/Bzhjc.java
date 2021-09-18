package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 标准化检查对象 bzhjc
 *
 * @author ruoyi
 * @date 2021-04-13
 */
public class Bzhjc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 检查人 */
    @Excel(name = "检查人")
    private String checkperson;

    /** 检查人账号 */
    @Excel(name = "检查人账号")
    private String checkaccount;

    /** 检查单位 */
    @Excel(name = "检查单位")
    private String checkdept;

    /** 检查时间 */
    @Excel(name = "检查时间")
    private String checkdate;

    /** 检查内容 */
    @Excel(name = "检查内容")
    private String checkcontent;

    /** 验证结果 */
    @Excel(name = "验证结果")
    private String confirmresult;

    /** 验证时间 */
    @Excel(name = "验证时间")
    private String confirmdate;

    /** 验证详情 */
    @Excel(name = "验证详情")
    private String confirmcontent;

    /** 检查属性 */
    @Excel(name = "检查属性")
    private String checkprop;

    /** 整改时间 */
    @Excel(name = "整改时间")
    private String checkmoddate;

    /** 检查图片 */
    @Excel(name = "检查图片")
    private String checkpicture;

    /** 整改单位id */
    @Excel(name = "整改单位id")
    private String moddeptid;

    /** 整改单位 */
    @Excel(name = "整改单位")
    private String moddept;

    /** 整改完成时间 */
    @Excel(name = "整改完成时间")
    private String moddonedate;

    /** 整改结果 */
    @Excel(name = "整改结果")
    private String modresult;

    /** 原因分析 */
    @Excel(name = "原因分析")
    private String modreason;

    /** 整改内容 */
    @Excel(name = "整改内容")
    private String modcontent;

    /** 整改人 */
    @Excel(name = "整改人")
    private String modperson;

    /** 整改图片 */
    @Excel(name = "整改图片")
    private String modpicture;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCheckperson(String checkperson)
    {
        this.checkperson = checkperson;
    }

    public String getCheckperson()
    {
        return checkperson;
    }
    public void setCheckaccount(String checkdeptid)
    {
        this.checkaccount = checkdeptid;
    }

    public String getCheckaccount()
    {
        return checkaccount;
    }
    public void setCheckdept(String checkdept)
    {
        this.checkdept = checkdept;
    }

    public String getCheckdept()
    {
        return checkdept;
    }
    public void setCheckdate(String checkdate)
    {
        this.checkdate = checkdate;
    }

    public String getCheckdate()
    {
        return checkdate;
    }
    public void setCheckcontent(String checkcontent)
    {
        this.checkcontent = checkcontent;
    }

    public String getCheckcontent()
    {
        return checkcontent;
    }
    public void setConfirmresult(String confirmresult)
    {
        this.confirmresult = confirmresult;
    }

    public String getConfirmresult()
    {
        return confirmresult;
    }
    public void setConfirmdate(String confirmdate)
    {
        this.confirmdate = confirmdate;
    }

    public String getConfirmdate()
    {
        return confirmdate;
    }
    public void setConfirmcontent(String confirmcontent)
    {
        this.confirmcontent = confirmcontent;
    }

    public String getConfirmcontent()
    {
        return confirmcontent;
    }
    public void setCheckprop(String checkprop)
    {
        this.checkprop = checkprop;
    }

    public String getCheckprop()
    {
        return checkprop;
    }
    public void setCheckmoddate(String checkmoddate)
    {
        this.checkmoddate = checkmoddate;
    }

    public String getCheckmoddate()
    {
        return checkmoddate;
    }
    public void setCheckpicture(String checkpicture)
    {
        this.checkpicture = checkpicture;
    }

    public String getCheckpicture()
    {
        return checkpicture;
    }
    public void setModdeptid(String moddeptid)
    {
        this.moddeptid = moddeptid;
    }

    public String getModdeptid()
    {
        return moddeptid;
    }
    public void setModdept(String moddept)
    {
        this.moddept = moddept;
    }

    public String getModdept()
    {
        return moddept;
    }
    public void setModdonedate(String moddonedate)
    {
        this.moddonedate = moddonedate;
    }

    public String getModdonedate()
    {
        return moddonedate;
    }
    public void setModresult(String modresult)
    {
        this.modresult = modresult;
    }

    public String getModresult()
    {
        return modresult;
    }
    public void setModreason(String modreason)
    {
        this.modreason = modreason;
    }

    public String getModreason()
    {
        return modreason;
    }
    public void setModcontent(String modcontent)
    {
        this.modcontent = modcontent;
    }

    public String getModcontent()
    {
        return modcontent;
    }
    public void setModperson(String modperson)
    {
        this.modperson = modperson;
    }

    public String getModperson()
    {
        return modperson;
    }
    public void setModpicture(String modpicture)
    {
        this.modpicture = modpicture;
    }

    public String getModpicture()
    {
        return modpicture;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("checkperson", getCheckperson())
            .append("checkaccount", getCheckaccount())
            .append("checkdept", getCheckdept())
            .append("checkdate", getCheckdate())
            .append("checkcontent", getCheckcontent())
            .append("confirmresult", getConfirmresult())
            .append("confirmdate", getConfirmdate())
            .append("confirmcontent", getConfirmcontent())
            .append("checkprop", getCheckprop())
            .append("checkmoddate", getCheckmoddate())
            .append("checkpicture", getCheckpicture())
            .append("moddeptid", getModdeptid())
            .append("moddept", getModdept())
            .append("moddonedate", getModdonedate())
            .append("modresult", getModresult())
            .append("modreason", getModreason())
            .append("modcontent", getModcontent())
            .append("modperson", getModperson())
            .append("modpicture", getModpicture())
            .append("status", getStatus())
            .toString();
    }
}
