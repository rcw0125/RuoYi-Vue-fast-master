package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Daynotecfg;

/**
 * 工作日志模板Service接口
 * 
 * @author ruoyi
 * @date 2021-06-22
 */
public interface IDaynotecfgService 
{
    /**
     * 查询工作日志模板
     * 
     * @param id 工作日志模板ID
     * @return 工作日志模板
     */
    public Daynotecfg selectDaynotecfgById(Long id);

    /**
     * 查询工作日志模板列表
     * 
     * @param daynotecfg 工作日志模板
     * @return 工作日志模板集合
     */
    public List<Daynotecfg> selectDaynotecfgList(Daynotecfg daynotecfg);

    /**
     * 新增工作日志模板
     * 
     * @param daynotecfg 工作日志模板
     * @return 结果
     */
    public int insertDaynotecfg(Daynotecfg daynotecfg);

    /**
     * 修改工作日志模板
     * 
     * @param daynotecfg 工作日志模板
     * @return 结果
     */
    public int updateDaynotecfg(Daynotecfg daynotecfg);

    /**
     * 批量删除工作日志模板
     * 
     * @param ids 需要删除的工作日志模板ID
     * @return 结果
     */
    public int deleteDaynotecfgByIds(Long[] ids);

    /**
     * 删除工作日志模板信息
     * 
     * @param id 工作日志模板ID
     * @return 结果
     */
    public int deleteDaynotecfgById(Long id);
}
