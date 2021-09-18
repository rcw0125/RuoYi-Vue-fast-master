package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ZizhugaishanMapper;
import com.ruoyi.project.system.domain.Zizhugaishan;
import com.ruoyi.project.system.service.IZizhugaishanService;

/**
 * 员工自主改善Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
@Service
public class ZizhugaishanServiceImpl implements IZizhugaishanService 
{
    @Autowired
    private ZizhugaishanMapper zizhugaishanMapper;

    /**
     * 查询员工自主改善
     * 
     * @param id 员工自主改善ID
     * @return 员工自主改善
     */
    @Override
    public Zizhugaishan selectZizhugaishanById(Integer id)
    {
        return zizhugaishanMapper.selectZizhugaishanById(id);
    }

    /**
     * 查询员工自主改善列表
     * 
     * @param zizhugaishan 员工自主改善
     * @return 员工自主改善
     */
    @Override
    public List<Zizhugaishan> selectZizhugaishanList(Zizhugaishan zizhugaishan)
    {
        return zizhugaishanMapper.selectZizhugaishanList(zizhugaishan);
    }

    /**
     * 新增员工自主改善
     * 
     * @param zizhugaishan 员工自主改善
     * @return 结果
     */
    @Override
    public int insertZizhugaishan(Zizhugaishan zizhugaishan)
    {
        return zizhugaishanMapper.insertZizhugaishan(zizhugaishan);
    }

    /**
     * 修改员工自主改善
     * 
     * @param zizhugaishan 员工自主改善
     * @return 结果
     */
    @Override
    public int updateZizhugaishan(Zizhugaishan zizhugaishan)
    {
        return zizhugaishanMapper.updateZizhugaishan(zizhugaishan);
    }

    /**
     * 批量删除员工自主改善
     * 
     * @param ids 需要删除的员工自主改善ID
     * @return 结果
     */
    @Override
    public int deleteZizhugaishanByIds(Integer[] ids)
    {
        return zizhugaishanMapper.deleteZizhugaishanByIds(ids);
    }

    /**
     * 删除员工自主改善信息
     * 
     * @param id 员工自主改善ID
     * @return 结果
     */
    @Override
    public int deleteZizhugaishanById(Integer id)
    {
        return zizhugaishanMapper.deleteZizhugaishanById(id);
    }
}
