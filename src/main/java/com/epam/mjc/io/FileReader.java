package com.epam.mjc.io;

import java.io.*;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String fileContent = readFileIntoString(file);
        if (fileContent != null) {
            String[] keyValues = parseFileContentForKeyValue(fileContent);
            return mapDataToProfileObject(keyValues);
        } else return null;
    }

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
                default:
                    try {
                        throw new IOException("Such field does not exist.");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        return null;
                    }
            }
        }
        return p;
    }

    private String[] parseFileContentForKeyValue(String fileContent) {
        return fileContent.split("\\n");
    }

    private String readFileIntoString(File file) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br =
                     new BufferedReader(new java.io.FileReader(file.getPath()))) {

            String buffer = null;
            while ((buffer = br.readLine()) != null) {
                content.append(buffer).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
        return content.toString().strip();
    }
}
