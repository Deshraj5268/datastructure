package arrays.sortingsearching;

import java.util.*;

public class JavaInternalSorting {


    public static void main(String[] args) {

        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("employeeId","23445");
        map1.put("employeeName","Deshraj Thakur");

        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("employeeId","23425");
        map2.put("employeeName","Adarsh2");

        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("employeeId","23405");
        map3.put("employeeName","Adarsh2");

        HashMap<String,Object> map4 = new HashMap<>();
        map4.put("employeeId","287405");
        map4.put("employeeName","Chandraj");

        List<HashMap<String,Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        System.out.println("list before sorting "+list.toString());

        Collections.sort(list, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                return (o2.get("employeeName").toString().compareTo(o1.get("employeeName").toString()));
            }
        });

        System.out.println("list after sorting decreasing "+list.toString());
        Collections.sort(list, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                return (o1.get("employeeName").toString().compareTo(o2.get("employeeName").toString()));
            }
        });


        System.out.println("list after  sorting increasing "+list.toString());





    }
}

