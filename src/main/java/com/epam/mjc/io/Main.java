package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File f = new File("I:\\mjc-school\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");

        FileReader fr = new FileReader();

        Profile profile = fr.getDataFromFile(f);

        System.err.println(profile);
    }
}
