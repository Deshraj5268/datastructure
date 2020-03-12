package arrays.others;

import java.util.*;

public class AvgScoreOfStndt {

    public static Student maxScoredStudent(List<Student> studentData){
        if(studentData == null || studentData.isEmpty()){
            return new Student();
        }
        HashMap resultMap = new HashMap<String,Student>();
        Student resultStudentData=null;
        String studentName;
        int studentMarks;

        Iterator <Student >itr = studentData.listIterator();
        while (itr.hasNext()){
            Student st = itr.next();
            studentName = st.getName();
            studentMarks = st.getTotalMarks();
            if(resultMap.get(studentName)== null){
                Student newStudent = new Student();
                newStudent.setName(studentName);
                newStudent.setNoOfSub(1);
                newStudent.setTotalMarks(studentMarks);
                newStudent.setAvgMarks(studentMarks);
                resultMap.put(studentName,newStudent);
            }else{
                Student existingStudent = (Student)resultMap.get(studentName);
                existingStudent.setTotalMarks(existingStudent.getTotalMarks()+studentMarks);
                existingStudent.setNoOfSub(existingStudent.getNoOfSub()+1);
                existingStudent.setAvgMarks(Float.valueOf(String.format("%.2f",Float.valueOf((float)(existingStudent.getTotalMarks())/existingStudent.getNoOfSub()))));
                resultMap.put(studentName,existingStudent);
            }


        }

        Set<Map.Entry> set = resultMap.entrySet();
        float max=Float.MIN_VALUE;
        float currentMax=Float.MIN_VALUE;
        for(Map.Entry<String,Student> entry : set){
            currentMax = entry.getValue().getAvgMarks();
           if(currentMax>max){
               max = currentMax;
               resultStudentData = (Student) entry.getValue();
           }
        }
        return resultStudentData;
    }

    public static void main(String[] args) {

        LinkedList listOfStudent = new LinkedList<Student>();
        listOfStudent.add(new Student("John", 100));
        listOfStudent.add(new Student("Charlie", 99));
        listOfStudent.add(new Student("John", 80));
        listOfStudent.add(new Student("Bob", 100));
        listOfStudent.add(new Student("Bob", 96));


        Student student = maxScoredStudent(listOfStudent);

        float a= (float) 199/2;
        System.out.println(String.format("%.2f",Float.valueOf(a)));
        System.out.println(student.toString());

        //{},{“, 60},{John, 70},{,100}

    }

}

class Student {
    private String name;
    private int totalMarks;
    private float avgMarks;
    private int noOfSub;

    public Student(String name, int totalMarks) {
        this.name = name;
        this.totalMarks = totalMarks;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getNoOfSub() {
        return noOfSub;
    }

    public void setNoOfSub(int noOfSub) {
        this.noOfSub = noOfSub;
    }

    public float getAvgMarks() {
        return avgMarks;
    }

    public void setAvgMarks(float avgMarks) {
        this.avgMarks = avgMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", totalMarks=" + totalMarks +
                ", avgMarks=" + avgMarks +
                ", noOfSub=" + noOfSub +
                '}';
    }
}
