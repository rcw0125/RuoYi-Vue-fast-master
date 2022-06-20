package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 能源介质配置对象 ems_equip_cfg
 *
 * @author ruoyi
 * @date 2022-01-11
 */
public class EmsEquipCfg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbname;

    /** 开启时限 */
    @Excel(name = "开启时限")
    private BigDecimal runtime;

    /** 停止时限 */
    @Excel(name = "停止时限")
    private BigDecimal stoptime;

    /** 类型（风机、水泵） */
    @Excel(name = "类型", readConverterExp = "风=机、水泵")
    private String type;

    /** 变量id */
    @Excel(name = "变量id")
    private Long opctagid;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String status;

    /** 变化时刻 */
    @Excel(name = "变化时刻")
    private String changetime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSbname(String sbname)
    {
        this.sbname = sbname;
    }

    public String getSbname()
    {
        return sbname;
    }
    public void setRuntime(BigDecimal runtime)
    {
        this.runtime = runtime;
    }

    public BigDecimal getRuntime()
    {
        return runtime;
    }
    public void setStoptime(BigDecimal stoptime)
    {
        this.stoptime = stoptime;
    }

    public BigDecimal getStoptime()
    {
        return stoptime;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setOpctagid(Long opctagid)
    {
        this.opctagid = opctagid;
    }

    public Long getOpctagid()
    {
        return opctagid;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setChangetime(String changetime)
    {
        this.changetime = changetime;
    }

    public String getChangetime()
    {
        return changetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sbname", getSbname())
                .append("runtime", getRuntime())
                .append("stoptime", getStoptime())
                .append("type", getType())
                .append("opctagid", getOpctagid())
                .append("status", getStatus())
                .append("changetime", getChangetime())
                .toString();
    }
}
