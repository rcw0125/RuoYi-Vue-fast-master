package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.IpguanliMapper;
import com.ruoyi.project.system.domain.Ipguanli;
import com.ruoyi.project.system.service.IIpguanliService;

/**
 * IP管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
@Service
public class IpguanliServiceImpl implements IIpguanliService 
{
    @Autowired
    private IpguanliMapper ipguanliMapper;

    /**
     * 查询IP管理
     * 
     * @param id IP管理ID
     * @return IP管理
     */
    @Override
    public Ipguanli selectIpguanliById(Long id)
    {
        return ipguanliMapper.selectIpguanliById(id);
    }

    /**
     * 查询IP管理列表
     * 
     * @param ipguanli IP管理
     * @return IP管理
     */
    @Override
    public List<Ipguanli> selectIpguanliList(Ipguanli ipguanli)
    {
        return ipguanliMapper.selectIpguanliList(ipguanli);
    }

    /**
     * 新增IP管理
     * 
     * @param ipguanli IP管理
     * @return 结果
     */
    @Override
    public int insertIpguanli(Ipguanli ipguanli)
    {
        return ipguanliMapper.insertIpguanli(ipguanli);
    }

    /**
     * 修改IP管理
     * 
     * @param ipguanli IP管理
     * @return 结果
     */
    @Override
    public int updateIpguanli(Ipguanli ipguanli)
    {
        return ipguanliMapper.updateIpguanli(ipguanli);
    }

    /**
     * 批量删除IP管理
     * 
     * @param ids 需要删除的IP管理ID
     * @return 结果
     */
    @Override
    public int deleteIpguanliByIds(Long[] ids)
    {
        return ipguanliMapper.deleteIpguanliByIds(ids);
    }

    /**
     * 删除IP管理信息
     * 
     * @param id IP管理ID
     * @return 结果
     */
    @Override
    public int deleteIpguanliById(Long id)
    {
        return ipguanliMapper.deleteIpguanliById(id);
    }
}
