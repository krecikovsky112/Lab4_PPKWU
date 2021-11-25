package com.example.demo;

import org.json.JSONObject;

public class ConverterString {
    public static String convert(String from, String to, String res) {
        if(to.equals("txt")){
            res = convertToFormatTXT(res);
        }
        else if(to.equals("csv")){

        }
        else if(to.equals("json")){

        }
        else if(to.equals("xml")){

        }

        return res;
    }

    private static String convertToFormatTXT(String res) {
        JSONObject json = new JSONObject(res);
        Object lowerCase = json.get("lowerCase");
        Object upperCase = json.get("upperCase");
        Object numbers = json.get("numbers");
        Object whiteSpaces = json.get("whiteSpaces");
        Object specialCharacters = json.get("specialCharacters");

        res = "lowerCase: " + lowerCase + "\n" +
                "upperCase: " + upperCase + "\n" +
                "whitespaces: " + whiteSpaces + "\n" +
                "numbers: " + numbers + "\n" +
                "specialCharacters: " + specialCharacters + "\n";
        return res;
    }
}
