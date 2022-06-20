package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.MesLuci;

/**
 * 导入MES炉次Service接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface IMesLuciService
{
    public void ceshi();
    /**
     * 查询导入MES炉次
     *
     * @param gongxu 导入MES炉次主键
     * @return 导入MES炉次
     */
    public MesLuci selectMesLuciByGongxu(String gongxu);

    /**
     * 查询导入MES炉次列表
     *
     * @param mesLuci 导入MES炉次
     * @return 导入MES炉次集合
     */
    public List<MesLuci> selectMesLuciList(MesLuci mesLuci);

    /**
     * 新增导入MES炉次
     *
     * @param mesLuci 导入MES炉次
     * @return 结果
     */
    public int insertMesLuci(MesLuci mesLuci);

    /**
     * 修改导入MES炉次
     *
     * @param mesLuci 导入MES炉次
     * @return 结果
     */
    public int updateMesLuci(MesLuci mesLuci);

    /**
     * 批量删除导入MES炉次
     *
     * @param gongxus 需要删除的导入MES炉次主键集合
     * @return 结果
     */
    public int deleteMesLuciByGongxus(String[] gongxus);

    /**
     * 删除导入MES炉次信息
     *
     * @param gongxu 导入MES炉次主键
     * @return 结果
     */
    public int deleteMesLuciByGongxu(String gongxu);
}
