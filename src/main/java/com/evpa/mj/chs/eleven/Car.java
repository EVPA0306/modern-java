package com.evpa.mj.chs.eleven;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Optional;

@Builder
@Data
public class Car {
    @NonNull
    private String model;

    private Optional<Insurance> insurance;
}
