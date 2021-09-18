package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * opctag对象 l1opc_tag
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
public class L1opcTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 序号 */
    @Excel(name = "序号")
    private Integer xuhao;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 变量名称 */
    @Excel(name = "变量名称")
    private String l1name;

    /** 读取频率  */
    @Excel(name = "读取频率 ")
    private Integer scanrate;

    /** 数据类型  */
    @Excel(name = "数据类型 ")
    private Integer datatype;

    /** 动作  */
    @Excel(name = "动作 ")
    private Integer action;

    /** 是否使用 */
    @Excel(name = "是否使用")
    private Integer used;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "类型", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ts;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setXuhao(Integer xuhao) 
    {
        this.xuhao = xuhao;
    }

    public Integer getXuhao() 
    {
        return xuhao;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setL1name(String l1name) 
    {
        this.l1name = l1name;
    }

    public String getL1name() 
    {
        return l1name;
    }
    public void setScanrate(Integer scanrate) 
    {
        this.scanrate = scanrate;
    }

    public Integer getScanrate() 
    {
        return scanrate;
    }
    public void setDatatype(Integer datatype) 
    {
        this.datatype = datatype;
    }

    public Integer getDatatype() 
    {
        return datatype;
    }
    public void setAction(Integer action) 
    {
        this.action = action;
    }

    public Integer getAction() 
    {
        return action;
    }
    public void setUsed(Integer used) 
    {
        this.used = used;
    }

    public Integer getUsed() 
    {
        return used;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setTs(Date ts) 
    {
        this.ts = ts;
    }

    public Date getTs() 
    {
        return ts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("xuhao", getXuhao())
            .append("name", getName())
            .append("l1name", getL1name())
            .append("scanrate", getScanrate())
            .append("datatype", getDatatype())
            .append("action", getAction())
            .append("used", getUsed())
            .append("type", getType())
            .append("ts", getTs())
            .toString();
    }
}
