package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.EmsLuciMapper;
import com.ruoyi.project.system.domain.EmsLuci;
import com.ruoyi.project.system.service.IEmsLuciService;

/**
 * 能源介质最新炉号Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
@Service
public class EmsLuciServiceImpl implements IEmsLuciService 
{
    @Autowired
    private EmsLuciMapper emsLuciMapper;

    /**
     * 查询能源介质最新炉号
     * 
     * @param id 能源介质最新炉号主键
     * @return 能源介质最新炉号
     */
    @Override
    public EmsLuci selectEmsLuciById(Integer id)
    {
        return emsLuciMapper.selectEmsLuciById(id);
    }

    /**
     * 查询能源介质最新炉号列表
     * 
     * @param emsLuci 能源介质最新炉号
     * @return 能源介质最新炉号
     */
    @Override
    public List<EmsLuci> selectEmsLuciList(EmsLuci emsLuci)
    {
        return emsLuciMapper.selectEmsLuciList(emsLuci);
    }

    /**
     * 新增能源介质最新炉号
     * 
     * @param emsLuci 能源介质最新炉号
     * @return 结果
     */
    @Override
    public int insertEmsLuci(EmsLuci emsLuci)
    {
        return emsLuciMapper.insertEmsLuci(emsLuci);
    }

    /**
     * 修改能源介质最新炉号
     * 
     * @param emsLuci 能源介质最新炉号
     * @return 结果
     */
    @Override
    public int updateEmsLuci(EmsLuci emsLuci)
    {
        return emsLuciMapper.updateEmsLuci(emsLuci);
    }

    /**
     * 批量删除能源介质最新炉号
     * 
     * @param ids 需要删除的能源介质最新炉号主键
     * @return 结果
     */
    @Override
    public int deleteEmsLuciByIds(Integer[] ids)
    {
        return emsLuciMapper.deleteEmsLuciByIds(ids);
    }

    /**
     * 删除能源介质最新炉号信息
     * 
     * @param id 能源介质最新炉号主键
     * @return 结果
     */
    @Override
    public int deleteEmsLuciById(Integer id)
    {
        return emsLuciMapper.deleteEmsLuciById(id);
    }
}
