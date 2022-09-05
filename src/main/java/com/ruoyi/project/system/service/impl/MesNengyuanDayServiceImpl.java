package com.ruoyi.project.system.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MesNengyuanDayMapper;
import com.ruoyi.project.system.domain.MesNengyuanDay;
import com.ruoyi.project.system.service.IMesNengyuanDayService;

/**
 * 能源数据Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-21
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class MesNengyuanDayServiceImpl implements IMesNengyuanDayService
{
    @Autowired
    private MesNengyuanDayMapper mesNengyuanDayMapper;

    /**
     * 查询能源数据
     *
     * @param logtime 能源数据主键
     * @return 能源数据
     */
    @Override
    public MesNengyuanDay selectMesNengyuanDayByLogtime(String logtime)
    {
        return mesNengyuanDayMapper.selectMesNengyuanDayByLogtime(logtime);
    }

    /**
     * 查询能源数据列表
     *
     * @param mesNengyuanDay 能源数据
     * @return 能源数据
     */
    @Override
    public List<MesNengyuanDay> selectMesNengyuanDayList(MesNengyuanDay mesNengyuanDay)
    {
        return mesNengyuanDayMapper.selectMesNengyuanDayList(mesNengyuanDay);
    }


    @Override
    public List<MesNengyuanDay> selectMesNengyuanDayLastList(MesNengyuanDay mesNengyuanDay)
    {
        return mesNengyuanDayMapper.selectMesNengyuanDayLastList(mesNengyuanDay);
    }

    @Override
    public int shengchengMesNengyuanDay(String logtime)
    {
        /**如果日期长度不等于10，即不是标准日期，则默认日期为前一天*/
        if(logtime.length()!=10)
        {
            logtime= LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        System.out.println("测试任务"+logtime);
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        int i= mesNengyuanDayMapper.shengchengMesNengyuanDay(logtime);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return i;
    }
    /**
     * 新增能源数据
     *
     * @param mesNengyuanDay 能源数据
     * @return 结果
     */
    @Override
    public int insertMesNengyuanDay(MesNengyuanDay mesNengyuanDay)
    {
        return mesNengyuanDayMapper.insertMesNengyuanDay(mesNengyuanDay);
    }


    /**
     * 修改能源数据
     *
     * @param mesNengyuanDay 能源数据
     * @return 结果
     */
    @Override
    public int updateMesNengyuanDay(MesNengyuanDay mesNengyuanDay)
    {
        return mesNengyuanDayMapper.updateMesNengyuanDay(mesNengyuanDay);
    }

    /**
     * 批量删除能源数据
     *
     * @param logtimes 需要删除的能源数据主键
     * @return 结果
     */
    @Override
    public int deleteMesNengyuanDayByLogtimes(String[] logtimes)
    {
        return mesNengyuanDayMapper.deleteMesNengyuanDayByLogtimes(logtimes);
    }

    /**
     * 删除能源数据信息
     *
     * @param logtime 能源数据主键
     * @return 结果
     */
    @Override
    public int deleteMesNengyuanDayByLogtime(String logtime)
    {
        return mesNengyuanDayMapper.deleteMesNengyuanDayByLogtime(logtime);
    }
}
