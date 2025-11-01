package advanceds.leaderboardproblem;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        // BAD: comparator ignores name → treats Alice(30) and Bob(30) as same
        Comparator<Person> badComparator = (a, b) -> Integer.compare(a.age, b.age);
        TreeSet<Person> badSet = new TreeSet<>(badComparator);

        badSet.add(new Person("Alice", 30));
        badSet.add(new Person("Bob", 30)); // disappears!
        System.out.println("Bad set: " + badSet); // [Alice(30)] ← Bob lost

        // GOOD: comparator considers both age and name
        Comparator<Person> goodComparator = Comparator.comparingInt((Person p) -> p.age)
                .thenComparing(p -> p.name);
        TreeSet<Person> goodSet = new TreeSet<>(goodComparator);

        goodSet.add(new Person("Alice", 30));
        goodSet.add(new Person("Bob", 30));
        System.out.println("Good set: " + goodSet); // [Alice(30), Bob(30)]
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) { this.name = name; this.age = age; }

    @Override
    public String toString() { return name + "(" + age + ")"; }
}

