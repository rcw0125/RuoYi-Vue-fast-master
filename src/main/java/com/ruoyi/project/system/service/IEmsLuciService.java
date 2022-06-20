package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.EmsLuci;

/**
 * 能源介质最新炉号Service接口
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
public interface IEmsLuciService 
{
    /**
     * 查询能源介质最新炉号
     * 
     * @param id 能源介质最新炉号主键
     * @return 能源介质最新炉号
     */
    public EmsLuci selectEmsLuciById(Integer id);

    /**
     * 查询能源介质最新炉号列表
     * 
     * @param emsLuci 能源介质最新炉号
     * @return 能源介质最新炉号集合
     */
    public List<EmsLuci> selectEmsLuciList(EmsLuci emsLuci);

    /**
     * 新增能源介质最新炉号
     * 
     * @param emsLuci 能源介质最新炉号
     * @return 结果
     */
    public int insertEmsLuci(EmsLuci emsLuci);

    /**
     * 修改能源介质最新炉号
     * 
     * @param emsLuci 能源介质最新炉号
     * @return 结果
     */
    public int updateEmsLuci(EmsLuci emsLuci);

    /**
     * 批量删除能源介质最新炉号
     * 
     * @param ids 需要删除的能源介质最新炉号主键集合
     * @return 结果
     */
    public int deleteEmsLuciByIds(Integer[] ids);

    /**
     * 删除能源介质最新炉号信息
     * 
     * @param id 能源介质最新炉号主键
     * @return 结果
     */
    public int deleteEmsLuciById(Integer id);
}
