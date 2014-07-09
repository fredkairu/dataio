/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////
///**
// *
// * @author fred kairu
     
// */
package javajson;

import java.io.FileReader;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseJsonFromFileOrUrl{

    public static File file;
    public static String s;
    public static ArrayList<String> myArray = new ArrayList<>();
    
    private static final String FilePath = "/home/stl-horizon/Documents/dataio-master/javajson/resources/water_points.json"; //path to file

    /*@param File (Resource)
    @return buffered String
    */
    public static String deserializeString(File file) throws IOException {
        int len;
        char[] chr = new char[4096];
        final StringBuffer buffer = new StringBuffer();
        try (FileReader reader = new FileReader(file)) {
            while ((len = reader.read(chr)) > 0) {
                buffer.append(chr, 0, len);
            }
        }
        return buffer.toString();
    }
    
    

    public static void main(String[] args) throws IOException {
        file = new File(FilePath);
        s = deserializeString(file);
        ArrayList<Data> yourArray = new Gson().fromJson(s, new TypeToken<List<Data>>() {
        }.getType());
          System.out.println("Water Point Id - " + "Water Point Condition - " + "Community Village" + "\n");
        System.out.println("******************************************************************" + "\n");
        for (int i = 0; i < yourArray.size(); i++) {
            System.out.println((i+1)+") "+yourArray.get(i));
        }
Data d=new Data();
System.out.println("----------------Functional Water Points-----------------------\n");
System.out.println("\t\t\t"+d.getWaterPointsFunctional()+"\n");
System.out.println("--------------------------------------------------------------\n");

System.out.println("----------------Number Of Water Points/Community-----------------------\n");
//count values using a HashMap
String[] stockArr = new String[d.getCommunitiesVillages().size()];
stockArr = d.getCommunitiesVillages().toArray(stockArr);
List<String> asList = Arrays.asList(stockArr);
        Map<String, Integer> map= new HashMap<String, Integer>();
        for(String s: stockArr){
            map.put(s,Collections.frequency(asList,s));
        }
        System.out.println(map);
System.out.println("--------------------------------------------------------------\n");
    }
}

