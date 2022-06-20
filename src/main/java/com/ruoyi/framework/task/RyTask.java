package com.ruoyi.framework.task;

import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.mapper.EquipDianjianBiaozhunMapper;
import com.ruoyi.project.system.mapper.EquipDianjiantongjiMapper;
import com.ruoyi.project.system.mapper.MesMingzhongmingxiMapper;
import com.ruoyi.project.system.service.IMesMingzhonglvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 定时任务调度测试
 *
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    @Autowired
    private EquipDianjianBiaozhunMapper equipDianjianBiaozhunMapper;
    @Autowired
    private EquipDianjiantongjiMapper equipDianjiantongjiMapper;

    @Autowired
    private IMesMingzhonglvService mesMingzhonglvService;
    @Autowired
    private MesMingzhongmingxiMapper mesMingzhongmingxiMapper;
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
    public int  calDianjianDeptRate(String month)
    {
        if(month.length()!=7){
            month= LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        }
        EquipDianjianBiaozhun biaozhun=new EquipDianjianBiaozhun();
        biaozhun.setNote(month);
        System.out.print("月份为："+biaozhun.getName());
        List<EquipDianjianBiaozhun> list=equipDianjianBiaozhunMapper.selectDianjianDeptRate(biaozhun);
        for(EquipDianjianBiaozhun item :list){
            EquipDianjiantongji equipDianjiantongji=new EquipDianjiantongji();
            equipDianjiantongji.setLogtime(month);
            equipDianjiantongji.setDjdw(item.getDept());
            equipDianjiantongji.setYdjsl(Long.valueOf(item.getZhoucishu()));
            equipDianjiantongji.setSdjsl(Long.valueOf(item.getDjcs()));
            DecimalFormat df=new DecimalFormat("######0.0");
            equipDianjiantongji.setDjrate(Double.valueOf(df.format(equipDianjiantongji.getSdjsl()*1.0/equipDianjiantongji.getYdjsl())));
            equipDianjiantongjiMapper.insertEquipDianjiantongji(equipDianjiantongji);
        }

        return 0;
    }

    public int  calChengfenMingxi(String curday)
    {
        if(curday.length()!=10){
            curday= LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        MesMingzhongmingxi mesMingzhongmingxi=new MesMingzhongmingxi();
        mesMingzhongmingxi.setLogtime(curday);
        /******1、删除当天存在的信息******/
        List<MesMingzhongmingxi> delList=mesMingzhongmingxiMapper.selectMesMingzhongmingxiList(mesMingzhongmingxi);
        if(delList.size()>0){
            for(MesMingzhongmingxi item:delList){
                mesMingzhongmingxiMapper.deleteMesMingzhongmingxiById(item.getId());
            }
        }
        /**********2、从MES数据库读取，写入到mysql数据库**************/
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<MesMingzhongmingxi> list=mesMingzhongmingxiMapper.selectMesChengfenMingzhongmingxiList(mesMingzhongmingxi);
        DynamicDataSourceContextHolder.clearDataSourceType();
        for(MesMingzhongmingxi item:list){
            mesMingzhongmingxiMapper.insertMesMingzhongmingxi(item);
        }

        /******3、查询当天生成的信息******/
        List<MesMingzhongmingxi> curList=mesMingzhongmingxiMapper.selectMesMingzhongmingxiList(mesMingzhongmingxi);



        MesMingzhonglv mesMingzhonglv1=new MesMingzhonglv();
        mesMingzhonglv1.setLogtime(curday);
        mesMingzhonglv1.setLfid("1#LF");
        mesMingzhonglv1.setSi(calmingzhonglv(curList,"si","1#LF",mesMingzhonglv1));
        mesMingzhonglv1.setMn(calmingzhonglv(curList,"mn","1#LF",mesMingzhonglv1));
        mesMingzhonglv1.setCr(calmingzhonglv(curList,"cr","1#LF",mesMingzhonglv1));
        mesMingzhonglvService.insertMesMingzhonglv(mesMingzhonglv1);

        MesMingzhonglv mesMingzhonglv2=new MesMingzhonglv();
        mesMingzhonglv2.setLogtime(curday);
        mesMingzhonglv2.setLfid("2#LF");
        mesMingzhonglv2.setSi(calmingzhonglv(curList,"si","2#LF",mesMingzhonglv2));
        mesMingzhonglv2.setMn(calmingzhonglv(curList,"mn","2#LF",mesMingzhonglv2));
        mesMingzhonglv2.setCr(calmingzhonglv(curList,"cr","2#LF",mesMingzhonglv2));
        mesMingzhonglvService.insertMesMingzhonglv(mesMingzhonglv2);

        MesMingzhonglv mesMingzhonglv3=new MesMingzhonglv();
        mesMingzhonglv3.setLogtime(curday);
        mesMingzhonglv3.setLfid("3#LF");
        mesMingzhonglv3.setSi(calmingzhonglv(curList,"si","3#LF",mesMingzhonglv3));
        mesMingzhonglv3.setMn(calmingzhonglv(curList,"mn","3#LF",mesMingzhonglv3));
        mesMingzhonglv3.setCr(calmingzhonglv(curList,"cr","3#LF",mesMingzhonglv3));
        mesMingzhonglvService.insertMesMingzhonglv(mesMingzhonglv3);

        MesMingzhonglv mesMingzhonglv=new MesMingzhonglv();
        mesMingzhonglv.setLogtime(curday);
        mesMingzhonglv.setLfid("合计");
        mesMingzhonglv.setSi(calmingzhonglv(curList,"si","",mesMingzhonglv));
        mesMingzhonglv.setMn(calmingzhonglv(curList,"mn","",mesMingzhonglv));
        mesMingzhonglv.setCr(calmingzhonglv(curList,"cr","",mesMingzhonglv));
        mesMingzhonglvService.insertMesMingzhonglv(mesMingzhonglv);

        MesMingzhonglv leiji=mesMingzhonglvService.selectLeijiMingzhonglvBylogtime(curday);
        if(StringUtils.isNotNull(leiji)){
            DecimalFormat df=new DecimalFormat("######0.0");
            if(leiji.getSitotal()>0){
                leiji.setSi(df.format(leiji.getSicount()*100.0/leiji.getSitotal()));
            }else {
                leiji.setSi("-");
            }
            if(leiji.getMntotal()>0){
                leiji.setMn(df.format(leiji.getMncount()*100.0/leiji.getMntotal()));
            }else {
                leiji.setMn("-");
            }
            if(leiji.getCrtotal()>0){
                leiji.setCr(df.format(leiji.getCrcount()*100.0/leiji.getCrtotal()));
            }else {
                leiji.setCr("-");
            }
            leiji.setLogtime(curday);
            leiji.setLfid("累计");
            mesMingzhonglvService.insertMesMingzhonglv(leiji);
        }

        return 0;
    }

    public String calmingzhonglv(List<MesMingzhongmingxi> curList,String element,String lfid,MesMingzhonglv mingzhonglv){
        String mzl="-";
        int total=0,mingzhong=0;
        if(curList.size()>0){
            for(MesMingzhongmingxi item:curList){
                if(element.equals("mn")){
                    if(lfid.equals("")){
                        if(item.getMn().equals("1")){
                            mingzhong++;
                        }
                        total++;
                    }else {
                        if(item.getLfid().equals(lfid)){
                            if(item.getMn().equals("1")){
                                mingzhong++;
                            }
                            total++;
                        }
                    }
                }else  if(element.equals("si"))
                {
                    if(lfid.equals("")){
                        if(item.getSi().equals("1")||item.getSi().equals("0")){
                            total++;
                            if(item.getSi().equals("1")){
                                mingzhong++;
                            }
                        }

                    }else {
                        if(item.getLfid().equals(lfid)){
                            if(item.getSi().equals("1")||item.getSi().equals("0")){
                                total++;
                                if(item.getSi().equals("1")){
                                    mingzhong++;
                                }
                            }
                        }
                    }
                }else  if(element.equals("cr"))
                {
                    if(lfid.equals("")){
                        if(item.getCr().equals("1")||item.getCr().equals("0")){
                            total++;
                            if(item.getCr().equals("1")){
                                mingzhong++;
                            }
                        }

                    }else {
                        if(item.getLfid().equals(lfid)){
                            if(item.getCr().equals("1")||item.getCr().equals("0")){
                                total++;
                                if(item.getCr().equals("1")){
                                    mingzhong++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(total>0){
            DecimalFormat df=new DecimalFormat("######0.0");
            mzl=df.format(mingzhong*100.0/total);
        }
        if(element.equals("si")){
            mingzhonglv.setSicount(mingzhong);
            mingzhonglv.setSitotal(total);
        }else  if(element.equals("mn")){
            mingzhonglv.setMncount(mingzhong);
            mingzhonglv.setMntotal(total);
        }else if(element.equals("cr")){
            mingzhonglv.setCrcount(mingzhong);
            mingzhonglv.setCrtotal(total);
        }

       return mzl;
    }

}
