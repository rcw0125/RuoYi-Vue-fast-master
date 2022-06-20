package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MesMingzhongmingxiMapper;
import com.ruoyi.project.system.domain.MesMingzhongmingxi;
import com.ruoyi.project.system.service.IMesMingzhongmingxiService;

/**
 * 成分命中明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
@Service
public class MesMingzhongmingxiServiceImpl implements IMesMingzhongmingxiService 
{
    @Autowired
    private MesMingzhongmingxiMapper mesMingzhongmingxiMapper;

    /**
     * 查询成分命中明细
     * 
     * @param id 成分命中明细主键
     * @return 成分命中明细
     */
    @Override
    public MesMingzhongmingxi selectMesMingzhongmingxiById(Long id)
    {
        return mesMingzhongmingxiMapper.selectMesMingzhongmingxiById(id);
    }

    /**
     * 查询成分命中明细列表
     * 
     * @param mesMingzhongmingxi 成分命中明细
     * @return 成分命中明细
     */
    @Override
    public List<MesMingzhongmingxi> selectMesMingzhongmingxiList(MesMingzhongmingxi mesMingzhongmingxi)
    {
        return mesMingzhongmingxiMapper.selectMesMingzhongmingxiList(mesMingzhongmingxi);
    }

    /**
     * 新增成分命中明细
     * 
     * @param mesMingzhongmingxi 成分命中明细
     * @return 结果
     */
    @Override
    public int insertMesMingzhongmingxi(MesMingzhongmingxi mesMingzhongmingxi)
    {
        return mesMingzhongmingxiMapper.insertMesMingzhongmingxi(mesMingzhongmingxi);
    }

    /**
     * 修改成分命中明细
     * 
     * @param mesMingzhongmingxi 成分命中明细
     * @return 结果
     */
    @Override
    public int updateMesMingzhongmingxi(MesMingzhongmingxi mesMingzhongmingxi)
    {
        return mesMingzhongmingxiMapper.updateMesMingzhongmingxi(mesMingzhongmingxi);
    }

    /**
     * 批量删除成分命中明细
     * 
     * @param ids 需要删除的成分命中明细主键
     * @return 结果
     */
    @Override
    public int deleteMesMingzhongmingxiByIds(Long[] ids)
    {
        return mesMingzhongmingxiMapper.deleteMesMingzhongmingxiByIds(ids);
    }

    /**
     * 删除成分命中明细信息
     * 
     * @param id 成分命中明细主键
     * @return 结果
     */
    @Override
    public int deleteMesMingzhongmingxiById(Long id)
    {
        return mesMingzhongmingxiMapper.deleteMesMingzhongmingxiById(id);
    }
}
