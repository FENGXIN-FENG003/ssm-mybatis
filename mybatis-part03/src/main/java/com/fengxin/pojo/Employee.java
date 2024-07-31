package com.fengxin.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author FENGXIN
 * @date 2024/7/30
 **/
// 若有注解，则别名为其注解值
@Alias ("emp")
public class Employee {
    private Integer empId;
    
    private String empName;
    
    private Double empSalary;
    
    @Override
    public String toString () {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
    
    public Integer getEmpId () {
        return empId;
    }
    
    public void setEmpId (Integer empId) {
        this.empId = empId;
    }
    
    public String getEmpName () {
        return empName;
    }
    
    public void setEmpName (String empName) {
        this.empName = empName;
    }
    
    public Double getEmpSalary () {
        return empSalary;
    }
    
    public void setEmpSalary (Double empSalary) {
        this.empSalary = empSalary;
    }
}
