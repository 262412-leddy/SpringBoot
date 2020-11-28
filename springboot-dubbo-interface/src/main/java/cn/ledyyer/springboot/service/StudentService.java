package cn.ledyyer.springboot.service;

import cn.ledyyer.springboot.bean.Student;

import java.util.List;

public interface StudentService {
    public Student queryStudentById(Integer id);
    public List<Student> queryAllStudent();
}
