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

    // Getters and setters are not required for this example.
    // GSON sets the fields directly using reflection.

    @Override
    public String toString() { 
        addWaterPointConditions(water_point_condition);
        addWaterPointIds(water_point_id);
        addCommunitiesVillages(communities_villages);
        return  water_point_id + " - " + water_point_condition+ " - "+communities_villages+ "\n";
    }
    
    //add value of water point conditions to arraylist
    private void addWaterPointConditions(String waterpointcondition){
    Data.waterpointcondition.add(waterpointcondition);
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

    public int getWaterPointsFunctional(){
        int countfunctional=0;
    for (int i = 0; i < this.getWaterPointCondition().size(); i++) {
         if(this.getWaterPointCondition().get(i).equals("functioning")){
         countfunctional++;
            }
               }
        return countfunctional;
    
    }
    
    public String getPopularElement(ArrayList<String> a)
{
  int count = 1, tempCount;
  String popular = a.get(0);
  String temp = "";
  for (int i = 0; i < (a.size() - 1); i++)
  {
    a.set(i, a.get(i));
    tempCount = 0;
    for (int j = 1; j < a.size(); j++)
    {
      if (temp.equals(a.get(j)))
        tempCount++;
    }
    if (tempCount > count)
    {
      popular = temp;
      count = tempCount;
    }
  }
  return popular;
}
    
}
