package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.SysCarInfoMapper;
import com.ruoyi.project.system.domain.SysCarInfo;
import com.ruoyi.project.system.service.ISysCarInfoService;

/**
 * 用车台账Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class SysCarInfoServiceImpl implements ISysCarInfoService 
{
    @Autowired
    private SysCarInfoMapper sysCarInfoMapper;

    /**
     * 查询用车台账
     * 
     * @param id 用车台账ID
     * @return 用车台账
     */
    @Override
    public SysCarInfo selectSysCarInfoById(Long id)
    {
        return sysCarInfoMapper.selectSysCarInfoById(id);
    }

    /**
     * 查询用车台账列表
     * 
     * @param sysCarInfo 用车台账
     * @return 用车台账
     */
    @Override
    public List<SysCarInfo> selectSysCarInfoList(SysCarInfo sysCarInfo)
    {
        return sysCarInfoMapper.selectSysCarInfoList(sysCarInfo);
    }

    /**
     * 新增用车台账
     * 
     * @param sysCarInfo 用车台账
     * @return 结果
     */
    @Override
    public int insertSysCarInfo(SysCarInfo sysCarInfo)
    {
        return sysCarInfoMapper.insertSysCarInfo(sysCarInfo);
    }

    /**
     * 修改用车台账
     * 
     * @param sysCarInfo 用车台账
     * @return 结果
     */
    @Override
    public int updateSysCarInfo(SysCarInfo sysCarInfo)
    {
        return sysCarInfoMapper.updateSysCarInfo(sysCarInfo);
    }

    /**
     * 批量删除用车台账
     * 
     * @param ids 需要删除的用车台账ID
     * @return 结果
     */
    @Override
    public int deleteSysCarInfoByIds(Long[] ids)
    {
        return sysCarInfoMapper.deleteSysCarInfoByIds(ids);
    }

    /**
     * 删除用车台账信息
     * 
     * @param id 用车台账ID
     * @return 结果
     */
    @Override
    public int deleteSysCarInfoById(Long id)
    {
        return sysCarInfoMapper.deleteSysCarInfoById(id);
    }
}
