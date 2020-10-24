package com.leesin.activitydemo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.util.Date;

/**
 * TODO
 *
 * @author wh
 * @date 2020/10/23
 */
public class HutoolUtilTest {

    /**
     * 功能描述: 类型转换<br>
     * 〈〉
     * @Author: wh
     * @Date: 2020/10/23 17:23
     */
    @Test
    public void parse(){
        String param = "10";
        int paramInt = Convert.toInt(param);
        String param2 = "a";
        int paramInt2 = Convert.toInt(param2,0);
//        System.out.println("----"+paramInt+"------"+paramInt2);
        String dateStr = "2020年09月29日";
        Date date = Convert.toDate(dateStr);
//        System.out.println("----"+date+"------");

//        Date date1 = new Date();
//        String datastr1 = Convert.toStr(date1,"2020-09-10");
//        System.out.println(datastr1);
//        Date date2 = DateUtil.date();
//        System.out.println("---"+date2);

//        格式化时间差
        String dateStr1 = "2020-09-29 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2020-10-01 23:34:27";
        Date date2 = DateUtil.parse(dateStr2);

        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
    }

    @Test
    public void log(){
        int [] ints = {1,2,3,4};
        // 打印数组
        Console.log(ints);
    }

}
