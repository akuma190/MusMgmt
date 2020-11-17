package museum.model;

public class Employee {
    int empid;
    String empname;
    String deptname;

    public Employee(int empid, String empname, String deptname) {
        this.empid = empid;
        this.empname = empname;
        this.deptname = deptname;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEmpname() {
        return empname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
