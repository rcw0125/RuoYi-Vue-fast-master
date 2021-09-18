package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工作日志模板对象 daynotecfg
 *
 * @author ruoyi
 * @date 2021-06-22
 */
public class Daynotecfg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    /** 单位 */
    @Excel(name = "单位")
    private String dept;
    /** 岗位 */
    @Excel(name = "岗位")
    private String code;

    /** 是否白班 */
    @Excel(name = "是否白班")
    private String baiban;

    /** 模板 */
    private String note;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setBaiban(String baiban)
    {
        this.baiban = baiban;
    }

    public String getBaiban()
    {
        return baiban;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
                .append("dept", getDept())
            .append("baiban", getBaiban())
            .append("note", getNote())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
