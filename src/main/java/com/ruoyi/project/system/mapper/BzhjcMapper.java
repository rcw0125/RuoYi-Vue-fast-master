package com.ruoyi.project.system.mapper;

import java.util.List;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.system.domain.Bzhjc;

/**
 * 标准化检查Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-13
 */
public interface BzhjcMapper
{
    /**
     * 查询标准化检查
     *
     * @param id 标准化检查ID
     * @return 标准化检查
     */
    public Bzhjc selectBzhjcById(Long id);

    /**
     * 查询标准化检查列表
     *
     * @param bzhjc 标准化检查
     * @return 标准化检查集合
     */
    public List<Bzhjc> selectBzhjcList(Bzhjc bzhjc);

    /**
     * 新增标准化检查
     *
     * @param bzhjc 标准化检查
     * @return 结果
     */
    public int insertBzhjc(Bzhjc bzhjc);

    /**
     * 修改标准化检查
     *
     * @param bzhjc 标准化检查
     * @return 结果
     */
    public int updateBzhjc(Bzhjc bzhjc);

    /**
     * 删除标准化检查
     *
     * @param id 标准化检查ID
     * @return 结果
     */
    public int deleteBzhjcById(Long id);

    /**
     * 批量删除标准化检查
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBzhjcByIds(Long[] ids);
}
