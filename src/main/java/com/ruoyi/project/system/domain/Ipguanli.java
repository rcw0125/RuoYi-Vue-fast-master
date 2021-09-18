package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * IP管理对象 ipguanli
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
public class Ipguanli extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** IP */
    @Excel(name = "IP")
    private String ip;

    /** 部门 */
    @Excel(name = "部门")
    private String dept;

    /** 安装位置 */
    @Excel(name = "安装位置")
    private String weizhi;

    /** 负责人 */
    @Excel(name = "负责人")
    private String fzr;

    /** 厂家 */
    @Excel(name = "厂家")
    private String changjia;

    /** 型号 */
    @Excel(name = "型号")
    private String xinghao;

    /** 备注 */
    @Excel(name = "备注")
    private String beizhu;

    /** 是否在用 */
    @Excel(name = "是否在用")
    private String shifouzaiyong;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setWeizhi(String weizhi) 
    {
        this.weizhi = weizhi;
    }

    public String getWeizhi() 
    {
        return weizhi;
    }
    public void setFzr(String fzr) 
    {
        this.fzr = fzr;
    }

    public String getFzr() 
    {
        return fzr;
    }
    public void setChangjia(String changjia) 
    {
        this.changjia = changjia;
    }

    public String getChangjia() 
    {
        return changjia;
    }
    public void setXinghao(String xinghao) 
    {
        this.xinghao = xinghao;
    }

    public String getXinghao() 
    {
        return xinghao;
    }
    public void setBeizhu(String beizhu) 
    {
        this.beizhu = beizhu;
    }

    public String getBeizhu() 
    {
        return beizhu;
    }
    public void setShifouzaiyong(String shifouzaiyong) 
    {
        this.shifouzaiyong = shifouzaiyong;
    }

    public String getShifouzaiyong() 
    {
        return shifouzaiyong;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ip", getIp())
            .append("dept", getDept())
            .append("weizhi", getWeizhi())
            .append("fzr", getFzr())
            .append("changjia", getChangjia())
            .append("xinghao", getXinghao())
            .append("beizhu", getBeizhu())
            .append("shifouzaiyong", getShifouzaiyong())
            .toString();
    }
}
