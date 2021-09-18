package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.SysCarInfo;

/**
 * 用车台账Service接口
 * 
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ISysCarInfoService 
{
    /**
     * 查询用车台账
     * 
     * @param id 用车台账ID
     * @return 用车台账
     */
    public SysCarInfo selectSysCarInfoById(Long id);

    /**
     * 查询用车台账列表
     * 
     * @param sysCarInfo 用车台账
     * @return 用车台账集合
     */
    public List<SysCarInfo> selectSysCarInfoList(SysCarInfo sysCarInfo);

    /**
     * 新增用车台账
     * 
     * @param sysCarInfo 用车台账
     * @return 结果
     */
    public int insertSysCarInfo(SysCarInfo sysCarInfo);

    /**
     * 修改用车台账
     * 
     * @param sysCarInfo 用车台账
     * @return 结果
     */
    public int updateSysCarInfo(SysCarInfo sysCarInfo);

    /**
     * 批量删除用车台账
     * 
     * @param ids 需要删除的用车台账ID
     * @return 结果
     */
    public int deleteSysCarInfoByIds(Long[] ids);

    /**
     * 删除用车台账信息
     * 
     * @param id 用车台账ID
     * @return 结果
     */
    public int deleteSysCarInfoById(Long id);
}
