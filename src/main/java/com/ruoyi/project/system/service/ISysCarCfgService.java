package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.SysCarCfg;

/**
 * 用车台账Service接口
 * 
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ISysCarCfgService 
{
    /**
     * 查询用车台账
     * 
     * @param id 用车台账ID
     * @return 用车台账
     */
    public SysCarCfg selectSysCarCfgById(Long id);

    /**
     * 查询用车台账列表
     * 
     * @param sysCarCfg 用车台账
     * @return 用车台账集合
     */
    public List<SysCarCfg> selectSysCarCfgList(SysCarCfg sysCarCfg);

    /**
     * 新增用车台账
     * 
     * @param sysCarCfg 用车台账
     * @return 结果
     */
    public int insertSysCarCfg(SysCarCfg sysCarCfg);

    /**
     * 修改用车台账
     * 
     * @param sysCarCfg 用车台账
     * @return 结果
     */
    public int updateSysCarCfg(SysCarCfg sysCarCfg);

    /**
     * 批量删除用车台账
     * 
     * @param ids 需要删除的用车台账ID
     * @return 结果
     */
    public int deleteSysCarCfgByIds(Long[] ids);

    /**
     * 删除用车台账信息
     * 
     * @param id 用车台账ID
     * @return 结果
     */
    public int deleteSysCarCfgById(Long id);
}
