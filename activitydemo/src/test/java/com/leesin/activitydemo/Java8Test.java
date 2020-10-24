package com.leesin.activitydemo;

import com.leesin.activitydemo.Entiy.Student;
import org.junit.Test;
import org.springframework.cache.interceptor.NameMatchCacheOperationSource;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *  java8新特性学习验证
 * @author wh
 * @date 2020/9/4
 */
public class Java8Test {

    private Student student;

    /**
     * 功能描述: lambda表达式测试<br>
     * 〈〉
     * @Param: []
     * @Return: void
     * @Author: wh
     * @Date: 2020/9/4 16:26
     */
    //用法一：删除集合中的某个元素
    @Test
    public void lam(){
        List<String> a = new ArrayList();
        a.add("a");
        a.add("b");
        a.add("c");
        a.forEach(System.out::println);
        a.removeIf(t->t=="a");//移除值为a的集合
        a.forEach(System.out::println);
    }

    //方法二：集合内元素排序
    @Test
    public void lam1(){
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(4);
        i.add(2);
        i.add(3);
        i.sort((i1,i2) -> i2 - i1);
        System.out.println(i);
    }

    /**
     * 功能描述: Stream 生成流<br>
     * 〈〉
     * @Param: []
     * @Return: void
     * @Author: wh
     * @Date: 2020/9/4 17:36
     */
    @Test
    public void stre(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    /**
     * 功能描述: java8集合流形式的扩展操作<br>
     * 〈〉
     * @Param: []
     * @Return: void
     * @Author: wh
     * @Date: 2020/9/21 21:49
     */
    @Test
    public void java8(){
        List<Student> list= new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setName("张三"+i+"号");
            list.add(student);
        }
        List<String> studentList = list.stream()   //集合流操作
                .filter(x->x.getAge()>2)           //过滤  此处条件为年龄大于2的学生
                .sorted(Comparator.comparing(Student::getAge).reversed())   // 排序器  倒序
                .map(Student::getName)         //  获取相应学生名称
                .collect(Collectors.toList());       //  流转回集合形式
        System.out.println(studentList);
    }
    
    /**
     * 功能描述:java8 时间处理类 Calendar  <br>
     * 〈〉
     * @Param: 
     * @Return: 
     * @Author: wh
     * @Date: 2020/10/24 10:58
     */
    @Test
    public void calen(){
//        Date date1 = new Date();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date2 = new Date();
        Date date1 = null;
        Date date2 =null;
        if (date1==null){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)-1);
            date1 = calendar.getTime();
            System.out.println("开始时间+++++"+date1);
        }
        if (date2==null){
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(Calendar.YEAR,calendar2.get(Calendar.YEAR)+10);
            date2 = calendar2.getTime();
            System.out.println("结束时间+++++"+date2);
        }
    }

}
