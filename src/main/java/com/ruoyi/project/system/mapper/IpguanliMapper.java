package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Ipguanli;

/**
 * IP管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
public interface IpguanliMapper 
{
    /**
     * 查询IP管理
     * 
     * @param id IP管理ID
     * @return IP管理
     */
    public Ipguanli selectIpguanliById(Long id);

    /**
     * 查询IP管理列表
     * 
     * @param ipguanli IP管理
     * @return IP管理集合
     */
    public List<Ipguanli> selectIpguanliList(Ipguanli ipguanli);

    /**
     * 新增IP管理
     * 
     * @param ipguanli IP管理
     * @return 结果
     */
    public int insertIpguanli(Ipguanli ipguanli);

    /**
     * 修改IP管理
     * 
     * @param ipguanli IP管理
     * @return 结果
     */
    public int updateIpguanli(Ipguanli ipguanli);

    /**
     * 删除IP管理
     * 
     * @param id IP管理ID
     * @return 结果
     */
    public int deleteIpguanliById(Long id);

    /**
     * 批量删除IP管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIpguanliByIds(Long[] ids);
}
