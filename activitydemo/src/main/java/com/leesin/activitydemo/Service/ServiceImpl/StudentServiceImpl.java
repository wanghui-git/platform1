package com.leesin.activitydemo.Service.ServiceImpl;

import com.leesin.activitydemo.Api.StudentService;
import com.leesin.activitydemo.Entiy.Student;
import com.leesin.activitydemo.Service.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String save(Student student) {
        try {
            studentRepository.save(student);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "False";
        }
    }

    @Override
    public Optional<Student> findOne(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            System.out.println("--------"+student.get().getName());
        }else{
            System.out.println("-------查询结果为空");
        }
        return student;
    }

    @Override
    public List<Student> findAll(){
        List<Student> students = studentRepository.findAll();
        return students;
    }
}
