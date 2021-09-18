package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Kaohe;

/**
 * 考核单Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-08
 */
public interface KaoheMapper 
{
    /**
     * 查询考核单
     * 
     * @param kaoheId 考核单ID
     * @return 考核单
     */
    public Kaohe selectKaoheById(Long kaoheId);

    /**
     * 查询考核单列表
     * 
     * @param kaohe 考核单
     * @return 考核单集合
     */
    public List<Kaohe> selectKaoheList(Kaohe kaohe);

    /**
     * 新增考核单
     * 
     * @param kaohe 考核单
     * @return 结果
     */
    public int insertKaohe(Kaohe kaohe);

    /**
     * 修改考核单
     * 
     * @param kaohe 考核单
     * @return 结果
     */
    public int updateKaohe(Kaohe kaohe);

    /**
     * 删除考核单
     * 
     * @param kaoheId 考核单ID
     * @return 结果
     */
    public int deleteKaoheById(Long kaoheId);

    /**
     * 批量删除考核单
     * 
     * @param kaoheIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteKaoheByIds(Long[] kaoheIds);
}
