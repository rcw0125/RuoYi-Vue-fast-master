package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.MesNengyuanDay;

/**
 * 能源数据Service接口
 *
 * @author ruoyi
 * @date 2022-01-21
 */
public interface IMesNengyuanDayService
{
    /**
     * 查询能源数据
     *
     * @param logtime 能源数据主键
     * @return 能源数据
     */
    public MesNengyuanDay selectMesNengyuanDayByLogtime(String logtime);

    /**
     * 查询能源数据列表
     *
     * @param mesNengyuanDay 能源数据
     * @return 能源数据集合
     */
    public List<MesNengyuanDay> selectMesNengyuanDayList(MesNengyuanDay mesNengyuanDay);

    /**
     * 新增能源数据
     *
     * @param mesNengyuanDay 能源数据
     * @return 结果
     */
    public int insertMesNengyuanDay(MesNengyuanDay mesNengyuanDay);

    public int shengchengMesNengyuanDay(String logtime);

    /**
     * 修改能源数据
     *
     * @param mesNengyuanDay 能源数据
     * @return 结果
     */
    public int updateMesNengyuanDay(MesNengyuanDay mesNengyuanDay);

    /**
     * 批量删除能源数据
     *
     * @param logtimes 需要删除的能源数据主键集合
     * @return 结果
     */
    public int deleteMesNengyuanDayByLogtimes(String[] logtimes);

    /**
     * 删除能源数据信息
     *
     * @param logtime 能源数据主键
     * @return 结果
     */
    public int deleteMesNengyuanDayByLogtime(String logtime);
}
