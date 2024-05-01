package practice_1;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<List<Student>, Map<String, List<Student>>> getGroupedStudents = (List<Student> students) -> {
            Map<String, List<Student>> groups = new HashMap<String, List<Student>>();
            for (Student student : students) {
                if (!groups.containsKey(student.group)) {
                    groups.put(student.group, new ArrayList<Student>());
                }
                groups.get(student.group).add(student);
            }
            return groups;
        };
        
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Ivanov", "IKBO-01-22"));
        students.add(new Student("Petrov", "IKBO-02-22"));
        students.add(new Student("Sokolov", "IKBO-01-22"));
        Map<String, List<Student>> newmap = getGroupedStudents.apply(students);
        for (String group : newmap.keySet()) {
            System.out.println(group + ":");
            for (Student student : newmap.get(group)) {
                System.out.println(student.name);
            }
        }
    }
}
