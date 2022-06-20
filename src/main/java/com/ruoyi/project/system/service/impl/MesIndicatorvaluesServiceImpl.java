package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MesIndicatorvaluesMapper;
import com.ruoyi.project.system.domain.MesIndicatorvalues;
import com.ruoyi.project.system.service.IMesIndicatorvaluesService;

/**
 * 能源指标值Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
@Service
public class MesIndicatorvaluesServiceImpl implements IMesIndicatorvaluesService 
{
    @Autowired
    private MesIndicatorvaluesMapper mesIndicatorvaluesMapper;

    /**
     * 查询能源指标值
     * 
     * @param code 能源指标值主键
     * @return 能源指标值
     */
    @Override
    public MesIndicatorvalues selectMesIndicatorvaluesByCode(String code)
    {
        return mesIndicatorvaluesMapper.selectMesIndicatorvaluesByCode(code);
    }

    /**
     * 查询能源指标值列表
     * 
     * @param mesIndicatorvalues 能源指标值
     * @return 能源指标值
     */
    @Override
    public List<MesIndicatorvalues> selectMesIndicatorvaluesList(MesIndicatorvalues mesIndicatorvalues)
    {
        return mesIndicatorvaluesMapper.selectMesIndicatorvaluesList(mesIndicatorvalues);
    }

    /**
     * 新增能源指标值
     * 
     * @param mesIndicatorvalues 能源指标值
     * @return 结果
     */
    @Override
    public int insertMesIndicatorvalues(MesIndicatorvalues mesIndicatorvalues)
    {
        return mesIndicatorvaluesMapper.insertMesIndicatorvalues(mesIndicatorvalues);
    }

    /**
     * 修改能源指标值
     * 
     * @param mesIndicatorvalues 能源指标值
     * @return 结果
     */
    @Override
    public int updateMesIndicatorvalues(MesIndicatorvalues mesIndicatorvalues)
    {
        return mesIndicatorvaluesMapper.updateMesIndicatorvalues(mesIndicatorvalues);
    }

    /**
     * 批量删除能源指标值
     * 
     * @param codes 需要删除的能源指标值主键
     * @return 结果
     */
    @Override
    public int deleteMesIndicatorvaluesByCodes(String[] codes)
    {
        return mesIndicatorvaluesMapper.deleteMesIndicatorvaluesByCodes(codes);
    }

    /**
     * 删除能源指标值信息
     * 
     * @param code 能源指标值主键
     * @return 结果
     */
    @Override
    public int deleteMesIndicatorvaluesByCode(String code)
    {
        return mesIndicatorvaluesMapper.deleteMesIndicatorvaluesByCode(code);
    }
}
