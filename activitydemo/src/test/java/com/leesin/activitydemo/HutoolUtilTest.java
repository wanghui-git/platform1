package com.leesin.activitydemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    //时间测试
    @Test
    public void timeTest(){

        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());

//        System.out.println(System.currentTimeMillis());

//        System.out.println(date);
//        System.out.println(date2);
//        System.out.println(date3);

        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();

        //new方式创建
        DateTime time = new DateTime(date);
        Console.log(time);

        //of方式创建
        Date date1 = new Date();
        DateTime now1 = DateTime.now();
        DateTime dt = DateTime.of(date1);
        Console.log("This is Console log for {}.", now1);
    }

    @Test
    /*    Calendar.HOUR_OF_DAY     24小时制
    Calendar.HOUR     12小时制*/
    //calendar能获取指定时间
    //获取当天0点时间
    public void getDate1(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
    }

}
