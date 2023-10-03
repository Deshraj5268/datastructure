package leetcode.intervieweraskedques;

import javafx.util.Pair;

import java.util.*;

public class StudentCourseMapping {

   static class StudentCourses {
       String id;
       String courserName;

       public StudentCourses(String id, String courserName) {
           this.id = id;
           this.courserName = courserName;
       }
   }

    public static void main(String[] args) {

    }


   /* public List<Pair<List<String>, List<String>>> groupingStudentWithCourses(List<StudentCourses> lists){
       Map<String, Set<String>> courseMapping = new HashMap<>();
       Set<String> coursesSet = new HashSet<>();
       for(StudentCourses studentCourses : lists){
           coursesSet = courseMapping.computeIfAbsent(studentCourses.id,k->new HashSet<>());
           coursesSet.add(studentCourses.courserName);
       }
       List<String> studentIds = new ArrayList<>(courseMapping.keySet());
       Pair<List<String>,List<String>>  newPair;
       for (int i=0;i<studentIds.size();i++){
           List<String> pairIds = new ArrayList<>();
           pairIds.add(studentIds.get(i));
           Set<String> pairedCourses = new HashSet<>();
           Set<String> coursesWrtStudentId = courseMapping.get(pairIds.get(0));
           for(int j=i+1;j<studentIds.size();j++){

               Set<String> mappedCourses = courseMapping.get(studentIds.get(j));
               for(String course : mappedCourses){
                   if(coursesWrtStudentId.contains(course)){
                       pairedCourses.add(course);
                   }
               }
           }
       }
        newPair = new
    }*/
}
