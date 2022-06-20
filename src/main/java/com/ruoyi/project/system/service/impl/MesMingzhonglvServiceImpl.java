package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MesMingzhonglvMapper;
import com.ruoyi.project.system.domain.MesMingzhonglv;
import com.ruoyi.project.system.service.IMesMingzhonglvService;

/**
 * 成分命中率Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-23
 */
@Service
public class MesMingzhonglvServiceImpl implements IMesMingzhonglvService
{
    @Autowired
    private MesMingzhonglvMapper mesMingzhonglvMapper;

    /**
     * 查询成分命中率
     *
     * @param id 成分命中率主键
     * @return 成分命中率
     */
    @Override
    public MesMingzhonglv selectMesMingzhonglvById(Long id)
    {
        return mesMingzhonglvMapper.selectMesMingzhonglvById(id);
    }

    @Override
    public MesMingzhonglv selectLeijiMingzhonglvBylogtime(String logtime)
    {
        return mesMingzhonglvMapper.selectLeijiMingzhonglvBylogtime(logtime);
    }
    /**
     * 查询成分命中率列表
     *
     * @param mesMingzhonglv 成分命中率
     * @return 成分命中率
     */
    @Override
    public List<MesMingzhonglv> selectMesMingzhonglvList(MesMingzhonglv mesMingzhonglv)
    {
        return mesMingzhonglvMapper.selectMesMingzhonglvList(mesMingzhonglv);
    }

    /**
     * 新增成分命中率
     *
     * @param mesMingzhonglv 成分命中率
     * @return 结果
     */
    @Override
    public int insertMesMingzhonglv(MesMingzhonglv mesMingzhonglv)
    {
        return mesMingzhonglvMapper.insertMesMingzhonglv(mesMingzhonglv);
    }

    /**
     * 修改成分命中率
     *
     * @param mesMingzhonglv 成分命中率
     * @return 结果
     */
    @Override
    public int updateMesMingzhonglv(MesMingzhonglv mesMingzhonglv)
    {
        return mesMingzhonglvMapper.updateMesMingzhonglv(mesMingzhonglv);
    }

    /**
     * 批量删除成分命中率
     *
     * @param ids 需要删除的成分命中率主键
     * @return 结果
     */
    @Override
    public int deleteMesMingzhonglvByIds(Long[] ids)
    {
        return mesMingzhonglvMapper.deleteMesMingzhonglvByIds(ids);
    }

    /**
     * 删除成分命中率信息
     *
     * @param id 成分命中率主键
     * @return 结果
     */
    @Override
    public int deleteMesMingzhonglvById(Long id)
    {
        return mesMingzhonglvMapper.deleteMesMingzhonglvById(id);
    }
}
