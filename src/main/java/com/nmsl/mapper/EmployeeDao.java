package com.nmsl.mapper;

import com.nmsl.pojo.Department;
import com.nmsl.pojo.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    private @Resource DepartmentDao departmentDao ;
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"帅帅张","a@qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(1002,new Employee(1002,"丑丑王","b@qq.com",1,new Department(102,"市场部"),new Date()));
        employees.put(1003,new Employee(1003,"丑丑罗","c@qq.com",0,new Department(103,"教研部"),new Date()));
        employees.put(1004,new Employee(1004,"丑丑陈","d@qq.com",1,new Department(104,"运营部"),new Date()));
        employees.put(1005,new Employee(1005,"丑丑大陈","e@qq.com",0,new Department(105,"后勤部"),new Date()));
    }

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void add(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> selectAll(){
        return employees.values();
    }

    //通过ID查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void deleteById(Integer id){
        employees.remove(id);
    }

}
