package com.evpa.mj.chs.misc;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class WorkWithFonts {

    private static final String CONSTANT = "CONSTANT";


    public static void main(String[] args) throws IOException, FontFormatException {

        //GraphicsEnvironment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                new File("/Users/epavlenko/Downloads/nimbus-sans-l/NimbusSanL-RegIta.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                new File("/Users/epavlenko/Downloads/nimbus-sans-l/NimbusSanL-Reg.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                new File("/Users/epavlenko/Downloads/nimbus-sans-l/NimbusSanL-BolIta.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                new File("/Users/epavlenko/Downloads/nimbus-sans-l/NimbusSanL-Bol.ttf")));

        Arrays.stream(ge.getAvailableFontFamilyNames())
                .filter(str -> str.contains("Nimbus"))
                .forEach(System.out::println);

        System.out.println(CONSTANT);
    }
}
