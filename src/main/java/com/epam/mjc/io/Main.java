package com.epam.mjc.io;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        String s = File.separator;

        String relativePath =
                "src" + s + "main" + s + "resources" + s + "Profile.txt"; // valid

        Profile profile = new FileReader().getDataFromFile(new File(relativePath));

        logger.log(Level.INFO, profile.toString());
    }
}