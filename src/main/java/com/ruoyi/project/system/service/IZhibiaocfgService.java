package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Zhibiaocfg;

/**
 * 指标配置Service接口
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public interface IZhibiaocfgService 
{
    /**
     * 查询指标配置
     * 
     * @param id 指标配置ID
     * @return 指标配置
     */
    public Zhibiaocfg selectZhibiaocfgById(Long id);

    /**
     * 查询指标配置列表
     * 
     * @param zhibiaocfg 指标配置
     * @return 指标配置集合
     */
    public List<Zhibiaocfg> selectZhibiaocfgList(Zhibiaocfg zhibiaocfg);

    /**
     * 新增指标配置
     * 
     * @param zhibiaocfg 指标配置
     * @return 结果
     */
    public int insertZhibiaocfg(Zhibiaocfg zhibiaocfg);

    /**
     * 修改指标配置
     * 
     * @param zhibiaocfg 指标配置
     * @return 结果
     */
    public int updateZhibiaocfg(Zhibiaocfg zhibiaocfg);

    /**
     * 批量删除指标配置
     * 
     * @param ids 需要删除的指标配置ID
     * @return 结果
     */
    public int deleteZhibiaocfgByIds(Long[] ids);

    /**
     * 删除指标配置信息
     * 
     * @param id 指标配置ID
     * @return 结果
     */
    public int deleteZhibiaocfgById(Long id);
}
