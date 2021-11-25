package com.example.demo;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class ConverterString {
    public static String convert(String from, String to, String res) {
        res = convertToJSON(from,res);

        if (to.equals("txt")) {
            res = convertFromJSONtoTXT(res);
        } else if (to.equals("csv")) {
        } else if (to.equals("json")) {

        } else if (to.equals("xml")) {
            JSONObject json = new JSONObject(res);
            res = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><stats>";
            res  += XML.toString(json) + "</stats>";
        }

        return res;
    }

    private static String convertToJSON(String from, String res) {
        if(from.equals("txt")){
            JSONObject jsonObject = new JSONObject();
            for(int i = 0 ;i<5;i++) {
                int index = res.indexOf(":");
                String key = res.substring(0, index);
                res = res.substring(index + 1);
                index = res.indexOf("\n");
                String value = res.substring(0, index);
                jsonObject.put(key, value);
                res = res.substring(index + 1);
            }
            res = jsonObject.toString();
        }
        else if(from.equals("csv")){
            JSONArray jsonArray = CDL.toJSONArray(res);
            res = jsonArray.get(0).toString();
        }
        else if(from.equals("xml")){
            JSONObject jsonObject = XML.toJSONObject(res);
            res = jsonObject.getJSONObject("stats").toString();
        }

        return res;
    }

    private static String convertFromJSONtoTXT(String res) {
        JSONObject json = new JSONObject(res);
        Object lowerCase = json.get("lowercase");
        Object upperCase = json.get("uppercase");
        Object numbers = json.get("numbers");
        Object whiteSpaces = json.get("whitespaces");
        Object specialCharacters = json.get("specialCharacters");

        res = "lowerCase: " + lowerCase + "\n" +
                "upperCase: " + upperCase + "\n" +
                "whitespaces: " + whiteSpaces + "\n" +
                "numbers: " + numbers + "\n" +
                "specialCharacters: " + specialCharacters + "\n";
        return res;
    }
}
