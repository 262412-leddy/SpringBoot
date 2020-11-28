package cn.ledyyer.springboot.controller;

import cn.ledyyer.springboot.bean.Student;
import cn.ledyyer.springboot.service.StudentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping(value = "/student/detail")
    public String studentDetail(Model model,Integer id){
        Student student =  studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "studentDetail";
    }

    @RequestMapping(value = "/student/all")
    public String studentAll(Model model){
        List<Student> studentList = studentService.queryAllStudent();
        model.addAttribute("studentList",studentList);
        return "studentAll";
    }

    @RequestMapping(value = "student")
    public String student(){
        return "student";
    }
}
