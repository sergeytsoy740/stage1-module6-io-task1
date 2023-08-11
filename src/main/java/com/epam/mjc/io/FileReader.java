package com.epam.mjc.io;

import java.io.*;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String fileContent = readFileIntoString(file);
        System.out.println(fileContent);
        String[] keyValues = parseFileContentForKeyValue(fileContent);
        System.out.println(Arrays.toString(keyValues));
        return mapDataToProfileObject(keyValues);
    }

    // Create Profile
    private Profile mapDataToProfileObject(String[] keyValues) {
        Profile p = new Profile();
        String[] pair;
        for (int i = 0; i < keyValues.length; i++) {
            pair = keyValues[i].split("\\s");
            switch (pair[0]) {
                case "Name:":
                    p.setName(pair[1]);
                    break;
                case "Age:":
                    p.setAge(Integer.valueOf(pair[1]));
                    break;
                case "Email:":
                    p.setEmail(pair[1]);
                    break;
                case "Phone:":
                    p.setPhone(Long.valueOf(pair[1]));
                    break;
            }
        }
        return p;
    }

    // Parse this string for key-value pairs
    private String[] parseFileContentForKeyValue(String fileContent) {
        String[] pairs = fileContent.split("\\n");
        return pairs;
    }

    // Reading file data into string
    private String readFileIntoString(File file) {
        String content = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new java.io.FileReader(file.getPath()));
            String buffer = "";
            while ((buffer = br.readLine()) != null) {
                // buffer = br.readLine();
                content = content + buffer.strip() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.strip();
    }
}
