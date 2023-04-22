package com.evpa.mj.chs.eleven;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Optional;

@Builder
@Getter
@ToString
public class Person {

    @NonNull
    private String name;

    private Optional<Car> car;
}
