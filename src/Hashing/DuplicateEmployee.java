package Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateEmployee {


    static class Employee {
        String firstName;
        String lastName;

        String employeeID;

        public Employee(String firstName, String lastName, String employeeID) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.employeeID = employeeID;
        }

        @Override
        public boolean equals(Object obj){
            if(obj == null ||  obj.getClass() != this.getClass()) return false;
            if(obj == this) return true;
            Employee employee = (Employee) obj;
            return employee.lastName != null && this.lastName != null && employee.lastName.equals(this.lastName);
        }

        @Override
        public int hashCode(){
            int prime = 31;
            return prime+ this.lastName.hashCode();
        }
    }


    public static void main(String[] args) {
        Employee employee1 = new Employee("deshraj", "thakur", "123");
        Employee employee2 = new Employee("raj", "thakur", "23");
        Employee employee3 = new Employee("chandraj", "thakur", "456");
        Employee employee4 = new Employee("ram", "Dangi", "4563");
        Employee employee5 = new Employee("misty", "Dangi", "1432123");
        int duplicateCount = duplicateCount(Arrays.asList(employee1, employee2, employee3, employee4, employee5));
        System.out.println(duplicateCount);
    }

    public static int duplicateCount(List<Employee> employeeList){
        Set<Employee> employeeSet = new HashSet<>();
        int count = 0;
        for(Employee employee : employeeList){
            if(employeeSet.contains(employee)){
                count++;
            }else {
                employeeSet.add(employee);
            }
        }
        return count;
    }
}
