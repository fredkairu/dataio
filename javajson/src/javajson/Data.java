/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javajson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.common.collect.*;
/**
 *
 * @author paul-pc
 */
public class Data implements Serializable {
    private String water_point_condition;
    private String water_point_id;
    private String communities_villages;
    public static ArrayList<String> waterpointcondition = new ArrayList<>();
    public static ArrayList<String> waterpointids= new ArrayList<>();
     public static ArrayList<String> communityvillage= new ArrayList<>();
    //private static HashMap<String, String> hmap= new HashMap<String, String>();
  private static  Multimap<String, String> multimap = ArrayListMultimap.create();


    // Getters and setters are not required for this example.
    // GSON sets the fields directly using reflection.

    @Override
    public String toString() { 
        addWaterPointConditions(water_point_condition);
        addWaterPointIds(water_point_id);
        addCommunitiesVillages(communities_villages);
        if(water_point_condition.equals("broken")){
        addWaterPointAndCommunity(communities_villages,water_point_condition);
        }
        return   water_point_id + " - " + water_point_condition+ " - "+communities_villages+ "\n";
    }
    
    //add value of water point conditions to arraylist
    private void addWaterPointConditions(String waterpointcondition){
    Data.waterpointcondition.add(waterpointcondition);
    } 
    
//String value stored along with the key value in hash map
    public void addWaterPointAndCommunity(String key,String value){
         multimap.put(key,value);
     }
 //get community water points and their status
    public Multimap<String, String> getWaterPointAndCommunity(){
    return Data.multimap;
}
    
     //add value of water point conditions to arraylist
    private void addWaterPointIds(String waterpointids){
    Data.waterpointids.add(waterpointids);
    } 
    
     //add value of communities to arraylist
    private void addCommunitiesVillages(String communityvillage){
    Data.communityvillage.add(communityvillage);
    } 
    //return an arraylist of water point conditions
    public ArrayList<String> getWaterPointCondition(){
        return Data.waterpointcondition;
    }
    //return an array list of water points
    public ArrayList<String> getWaterPointIds(){
        return Data.waterpointids;
    }
    
    //return an array list of water points
    public ArrayList<String> getCommunitiesVillages(){
        return Data.communityvillage;
    }
    //return the water point id
    public String getwaterpointid(){
    return this.water_point_id;
    }
    

    public int getWaterPointsCharacteristic(String condition){
        int countfunctional=0;
    for (int i = 0; i < this.getWaterPointCondition().size(); i++) {
         if(this.getWaterPointCondition().get(i).equals(condition)){
         countfunctional++;
            }
               }
        return countfunctional;
    
    }

    
}
