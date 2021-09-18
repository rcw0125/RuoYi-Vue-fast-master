package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Daynote;

/**
 * 工作日志Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public interface DaynoteMapper 
{
    /**
     * 查询工作日志
     * 
     * @param id 工作日志ID
     * @return 工作日志
     */
    public Daynote selectDaynoteById(Long id);

    /**
     * 查询工作日志列表
     * 
     * @param daynote 工作日志
     * @return 工作日志集合
     */
    public List<Daynote> selectDaynoteList(Daynote daynote);

    /**
     * 新增工作日志
     * 
     * @param daynote 工作日志
     * @return 结果
     */
    public int insertDaynote(Daynote daynote);

    /**
     * 修改工作日志
     * 
     * @param daynote 工作日志
     * @return 结果
     */
    public int updateDaynote(Daynote daynote);

    /**
     * 删除工作日志
     * 
     * @param id 工作日志ID
     * @return 结果
     */
    public int deleteDaynoteById(Long id);

    /**
     * 批量删除工作日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDaynoteByIds(Long[] ids);
}
