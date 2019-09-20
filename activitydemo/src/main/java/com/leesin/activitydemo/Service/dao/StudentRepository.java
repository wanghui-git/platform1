package com.leesin.activitydemo.Service.dao;

import com.leesin.activitydemo.Entiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student>
{

}
