package com.nmsl.controller;

import com.nmsl.mapper.DepartmentDao;
import com.nmsl.mapper.EmployeeDao;
import com.nmsl.pojo.Department;
import com.nmsl.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        System.out.println("成功添加了成员");
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加成员 forword
        System.out.println("save===>"+ employee);
        employeeDao.add(employee);  //调用底层业务方法保存员工信息
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        model.addAttribute("emp", employee);
        return "emp/update";
    }


    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee , Model model){
        employeeDao.add(employee);
        return "redirect:/emps";
    }


    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id, Model model){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }
}
