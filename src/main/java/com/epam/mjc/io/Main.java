package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        String s = File.separator;

        String relativePath =
                "src" + s + "main" + s + "resources" + s + "Profile.txt"; // valid

        Profile profile = new FileReader().getDataFromFile(new File(relativePath));

        System.err.println(profile);
    }
}