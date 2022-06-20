package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.MesIndicatorvalues;

/**
 * 能源指标值Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
public interface MesIndicatorvaluesMapper 
{
    /**
     * 查询能源指标值
     * 
     * @param code 能源指标值主键
     * @return 能源指标值
     */
    public MesIndicatorvalues selectMesIndicatorvaluesByCode(String code);

    /**
     * 查询能源指标值列表
     * 
     * @param mesIndicatorvalues 能源指标值
     * @return 能源指标值集合
     */
    public List<MesIndicatorvalues> selectMesIndicatorvaluesList(MesIndicatorvalues mesIndicatorvalues);

    /**
     * 新增能源指标值
     * 
     * @param mesIndicatorvalues 能源指标值
     * @return 结果
     */
    public int insertMesIndicatorvalues(MesIndicatorvalues mesIndicatorvalues);

    /**
     * 修改能源指标值
     * 
     * @param mesIndicatorvalues 能源指标值
     * @return 结果
     */
    public int updateMesIndicatorvalues(MesIndicatorvalues mesIndicatorvalues);

    /**
     * 删除能源指标值
     * 
     * @param code 能源指标值主键
     * @return 结果
     */
    public int deleteMesIndicatorvaluesByCode(String code);

    /**
     * 批量删除能源指标值
     * 
     * @param codes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesIndicatorvaluesByCodes(String[] codes);
}
