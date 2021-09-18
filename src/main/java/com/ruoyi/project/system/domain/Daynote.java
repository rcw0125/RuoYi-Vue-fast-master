package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工作日志对象 daynote
 *
 * @author ruoyi
 * @date 2021-06-23
 */
public class Daynote extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String logtime;

    /** 单位 */
    @Excel(name = "单位")
    private String dept;

    /** 岗位 */
    @Excel(name = "岗位")
    private String post;

    /** 记录人 */
    @Excel(name = "记录人")
    private String name;

    /** 内容 */
    @Excel(name = "内容")
    private String note;

    /** 班次 */
    @Excel(name = "班次")
    private String team;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    @Override
    public Date getUpdateTime() {
        return UpdateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    /** 交班时间 */
    @Excel(name = "交班时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date  UpdateTime;

    @Override
    public Date getCreateTime() {
        return CreateTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    /** 接班时间 */
    @Excel(name = "接班时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date  CreateTime;

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
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept()
    {
        return dept;
    }
    public void setPost(String post)
    {
        this.post = post;
    }

    public String getPost()
    {
        return post;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getTeam()
    {
        return team;
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
            .append("logtime", getLogtime())
            .append("dept", getDept())
            .append("post", getPost())
            .append("name", getName())
            .append("note", getNote())
            .append("team", getTeam())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())

            .toString();
    }
}
