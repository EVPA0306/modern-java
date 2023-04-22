package com.evpa.mj.chs.eleven;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Insurance {
    @NonNull
    private String name;
}
