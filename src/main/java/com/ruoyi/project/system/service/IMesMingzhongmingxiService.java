package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.MesMingzhongmingxi;

/**
 * 成分命中明细Service接口
 * 
 * @author ruoyi
 * @date 2022-05-23
 */
public interface IMesMingzhongmingxiService 
{
    /**
     * 查询成分命中明细
     * 
     * @param id 成分命中明细主键
     * @return 成分命中明细
     */
    public MesMingzhongmingxi selectMesMingzhongmingxiById(Long id);

    /**
     * 查询成分命中明细列表
     * 
     * @param mesMingzhongmingxi 成分命中明细
     * @return 成分命中明细集合
     */
    public List<MesMingzhongmingxi> selectMesMingzhongmingxiList(MesMingzhongmingxi mesMingzhongmingxi);

    /**
     * 新增成分命中明细
     * 
     * @param mesMingzhongmingxi 成分命中明细
     * @return 结果
     */
    public int insertMesMingzhongmingxi(MesMingzhongmingxi mesMingzhongmingxi);

    /**
     * 修改成分命中明细
     * 
     * @param mesMingzhongmingxi 成分命中明细
     * @return 结果
     */
    public int updateMesMingzhongmingxi(MesMingzhongmingxi mesMingzhongmingxi);

    /**
     * 批量删除成分命中明细
     * 
     * @param ids 需要删除的成分命中明细主键集合
     * @return 结果
     */
    public int deleteMesMingzhongmingxiByIds(Long[] ids);

    /**
     * 删除成分命中明细信息
     * 
     * @param id 成分命中明细主键
     * @return 结果
     */
    public int deleteMesMingzhongmingxiById(Long id);
}
