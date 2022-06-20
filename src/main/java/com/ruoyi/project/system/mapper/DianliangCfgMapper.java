package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.DianliangCfg;

/**
 * 电量配置Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-11
 */
public interface DianliangCfgMapper 
{
    /**
     * 查询电量配置
     * 
     * @param id 电量配置主键
     * @return 电量配置
     */
    public DianliangCfg selectDianliangCfgById(Long id);

    /**
     * 查询电量配置列表
     * 
     * @param dianliangCfg 电量配置
     * @return 电量配置集合
     */
    public List<DianliangCfg> selectDianliangCfgList(DianliangCfg dianliangCfg);

    /**
     * 新增电量配置
     * 
     * @param dianliangCfg 电量配置
     * @return 结果
     */
    public int insertDianliangCfg(DianliangCfg dianliangCfg);

    /**
     * 修改电量配置
     * 
     * @param dianliangCfg 电量配置
     * @return 结果
     */
    public int updateDianliangCfg(DianliangCfg dianliangCfg);

    /**
     * 删除电量配置
     * 
     * @param id 电量配置主键
     * @return 结果
     */
    public int deleteDianliangCfgById(Long id);

    /**
     * 批量删除电量配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDianliangCfgByIds(Long[] ids);
}
