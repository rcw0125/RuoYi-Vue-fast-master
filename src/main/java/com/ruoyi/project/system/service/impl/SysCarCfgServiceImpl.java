package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.SysCarCfgMapper;
import com.ruoyi.project.system.domain.SysCarCfg;
import com.ruoyi.project.system.service.ISysCarCfgService;

/**
 * 用车台账Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class SysCarCfgServiceImpl implements ISysCarCfgService 
{
    @Autowired
    private SysCarCfgMapper sysCarCfgMapper;

    /**
     * 查询用车台账
     * 
     * @param id 用车台账ID
     * @return 用车台账
     */
    @Override
    public SysCarCfg selectSysCarCfgById(Long id)
    {
        return sysCarCfgMapper.selectSysCarCfgById(id);
    }

    /**
     * 查询用车台账列表
     * 
     * @param sysCarCfg 用车台账
     * @return 用车台账
     */
    @Override
    public List<SysCarCfg> selectSysCarCfgList(SysCarCfg sysCarCfg)
    {
        return sysCarCfgMapper.selectSysCarCfgList(sysCarCfg);
    }

    /**
     * 新增用车台账
     * 
     * @param sysCarCfg 用车台账
     * @return 结果
     */
    @Override
    public int insertSysCarCfg(SysCarCfg sysCarCfg)
    {
        return sysCarCfgMapper.insertSysCarCfg(sysCarCfg);
    }

    /**
     * 修改用车台账
     * 
     * @param sysCarCfg 用车台账
     * @return 结果
     */
    @Override
    public int updateSysCarCfg(SysCarCfg sysCarCfg)
    {
        return sysCarCfgMapper.updateSysCarCfg(sysCarCfg);
    }

    /**
     * 批量删除用车台账
     * 
     * @param ids 需要删除的用车台账ID
     * @return 结果
     */
    @Override
    public int deleteSysCarCfgByIds(Long[] ids)
    {
        return sysCarCfgMapper.deleteSysCarCfgByIds(ids);
    }

    /**
     * 删除用车台账信息
     * 
     * @param id 用车台账ID
     * @return 结果
     */
    @Override
    public int deleteSysCarCfgById(Long id)
    {
        return sysCarCfgMapper.deleteSysCarCfgById(id);
    }
}
