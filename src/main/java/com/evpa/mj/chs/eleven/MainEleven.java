package com.evpa.mj.chs.eleven;

import java.util.Optional;
import java.util.Properties;

public class MainEleven {

    public static void main(String[] args) {
        Person person = Person.builder()
                .name("Eugene")
                .car(Optional.ofNullable(Car.builder()
                                .model("MB GL450")
                                .insurance(Optional.ofNullable(Insurance.builder()
                                        .name("Geico").build()))
                        .build()))
                .build();
        System.out.println(person);

        System.out.println(Optional.of(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("NOT_FOUND"));

        Properties props = new Properties();
        props.put("amount","42");

        System.out.println(readDurationDeclarative(props, "amount"));
    }

    private static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        }
        return 0;
    }

    private static int readDurationDeclarative(Properties props, String name) {
        return Optional.ofNullable(props.get(name))
                .map(str -> Integer.parseInt((String) str))
                .orElse(0);
    }
}
