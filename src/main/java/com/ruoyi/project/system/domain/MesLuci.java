package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 导入MES炉次对象 mes_luci
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@DataSource(value = DataSourceType.SLAVE)
public class MesLuci extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工序 */
    @Excel(name = "工序")
    private String gongxu;

    /** 炉号 */
    @Excel(name = "炉号")
    private String heatid;

    /** 生产开始时间 */
    @Excel(name = "生产开始时间")
    private String begintime;

    /** 生产结束时间 */
    @Excel(name = "生产结束时间")
    private String endtime;

    public void setGongxu(String gongxu)
    {
        this.gongxu = gongxu;
    }

    public String getGongxu()
    {
        return gongxu;
    }
    public void setHeatid(String heatid)
    {
        this.heatid = heatid;
    }

    public String getHeatid()
    {
        return heatid;
    }
    public void setBegintime(String begintime)
    {
        this.begintime = begintime;
    }

    public String getBegintime()
    {
        return begintime;
    }
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    public String getEndtime()
    {
        return endtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gongxu", getGongxu())
            .append("heatid", getHeatid())
            .append("begintime", getBegintime())
            .append("endtime", getEndtime())
            .toString();
    }
}
