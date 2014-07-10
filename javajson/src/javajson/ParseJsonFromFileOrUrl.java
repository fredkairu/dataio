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

import com.google.common.collect.Multimap;
import java.io.FileReader;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

System.out.print(yourArray);
          //System.out.println("Water Point Id - " + "Water Point Condition - " + "Community Village" + "\n");
       // System.out.println("******************************************************************" + "\n");
        for (int i = 0; i < yourArray.size(); i++) {
            yourArray.get(i);
            //System.out.println((i+1)+") "+yourArray.get(i));
      
        }
             Data d=new Data(); //instantiate Data class
DataManipulation  dm=new DataManipulation(); //instantiate Data class   

System.out.println("-------------------------Water Point and Condition------------------------ \n");
Multimap<String, String> mymap=dm.sortedByAscendingFrequency(d.getWaterPointAndCommunity());
//Multimap<String, String> mymap=d.getWaterPointAndCommunity();
double totalbroken=(double) mymap.size();
int broken;
double brokenpercommunity;

Set keySet = mymap.keySet( );  
    Iterator keyIterator = keySet.iterator();
    while( keyIterator.hasNext( ) ) {  
        Object key = keyIterator.next();  
        broken=(int)mymap.keys().count((String) key); //get count of each key
        brokenpercommunity=broken /totalbroken *100.0; //get total broken as a percentage
        System.out.print( "Community: " + key +"  Broken count:"+brokenpercommunity+ "\n" );
    }
System.out.println("--------------------------------------------------------------\n");

System.out.println("----------------Functional Water Points-----------------------\n");
System.out.println("\t\t\t"+d.getWaterPointsCharacteristic("functioning")+"\n");
System.out.println("--------------------------------------------------------------\n");

System.out.println("----------------Broken Water Points-----------------------\n");
System.out.println("\t\t\t"+d.getWaterPointsCharacteristic("broken")+"\n");
System.out.println("--------------------------------------------------------------\n");

System.out.println("----------------Number Of Water Points/Community-----------------------\n");
System.out.println(dm.getDataMap(d.getCommunitiesVillages()));
System.out.println("--------------------------------------------------------------\n");
  
    

       }
}

