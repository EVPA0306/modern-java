package com.evpa.mj.chs.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;
import java.util.function.Consumer;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private int salary;

    public static <T> T getFirst(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {
        Employee mike = new Employee("Mike",2000);
        Employee louise = new Employee("Louise", 2500);

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        Comparator<Employee> byNameWithNulls = Comparator.nullsLast(byName);

        System.out.println(byName.compare(mike, louise));
        System.out.println(byNameWithNulls.compare(mike,null));

        Comparator<String> byNameLength = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };

        System.out.println(byNameLength.compare(mike.getName(), louise.getName()));

        Comparator<Employee> byNameLmbd = (a, b) -> a.getName().compareTo(b.getName());

        System.out.println(byNameLmbd.compare(mike,louise));

        Employee[] employees = new Employee[]{new Employee("Eugene", 1000)
                , new Employee("Marina", 2000)};

        System.out.println(getFirst(employees));

        Consumer<String> stringConsumer = s -> System.out.println(s.length());
        stringConsumer.accept("Mike");
    }
}
