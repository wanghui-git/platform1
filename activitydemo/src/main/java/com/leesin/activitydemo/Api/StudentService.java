package com.leesin.activitydemo.Api;

import com.leesin.activitydemo.Entiy.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    /**
     * 新增学生
     */
    String save(Student student);

    /**
     * 根据ID查找
     * @return
     */
    Optional<Student> findOne(long id);

    List<Student> findAll();

}
