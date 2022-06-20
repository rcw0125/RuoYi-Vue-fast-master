package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.MesMingzhonglv;

/**
 * 成分命中率Service接口
 *
 * @author ruoyi
 * @date 2022-05-23
 */
public interface IMesMingzhonglvService
{
    /**
     * 查询成分命中率
     *
     * @param id 成分命中率主键
     * @return 成分命中率
     */
    public MesMingzhonglv selectMesMingzhonglvById(Long id);

    public MesMingzhonglv selectLeijiMingzhonglvBylogtime(String logtime);

    /**
     * 查询成分命中率列表
     *
     * @param mesMingzhonglv 成分命中率
     * @return 成分命中率集合
     */
    public List<MesMingzhonglv> selectMesMingzhonglvList(MesMingzhonglv mesMingzhonglv);

    /**
     * 新增成分命中率
     *
     * @param mesMingzhonglv 成分命中率
     * @return 结果
     */
    public int insertMesMingzhonglv(MesMingzhonglv mesMingzhonglv);

    /**
     * 修改成分命中率
     *
     * @param mesMingzhonglv 成分命中率
     * @return 结果
     */
    public int updateMesMingzhonglv(MesMingzhonglv mesMingzhonglv);

    /**
     * 批量删除成分命中率
     *
     * @param ids 需要删除的成分命中率主键集合
     * @return 结果
     */
    public int deleteMesMingzhonglvByIds(Long[] ids);

    /**
     * 删除成分命中率信息
     *
     * @param id 成分命中率主键
     * @return 结果
     */
    public int deleteMesMingzhonglvById(Long id);
}
