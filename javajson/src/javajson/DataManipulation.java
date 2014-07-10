/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javajson;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author root
 */
public class DataManipulation {
  
    
    
  public Map<String, Integer> getDataMap(ArrayList<String> arraylist ){
      String[] stockArr = new String[arraylist.size()];
      stockArr = arraylist.toArray(stockArr);
List<String> asList = Arrays.asList(stockArr);
        Map<String, Integer> map= new HashMap<String, Integer>();
        for(String s: stockArr){
            map.put(s,Collections.frequency(asList,s));
        }
       
      return map;
  
  }
  
  private static final Ordering<Multiset.Entry<?>> ASCENDING_COUNT_ORDERING = new Ordering<Multiset.Entry<?>>() {
    @Override
    public int compare(Multiset.Entry<?> left, Multiset.Entry<?> right) {
        return Ints.compare(left.getCount(), right.getCount());
    }
};
  
  public Multimap<String, String> sortedByDescendingFrequency(Multimap<String, String> multimap) {
    // ImmutableMultimap.Builder preserves key/value order
    ImmutableMultimap.Builder<String, String> result = ImmutableMultimap.builder();
    for (Multiset.Entry<String> entry : DESCENDING_COUNT_ORDERING.sortedCopy(multimap.keys().entrySet())) {
        result.putAll(entry.getElement(), multimap.get(entry.getElement()));
    }
    return result.build();
}
   public Multimap<String, String> sortedByAscendingFrequency(Multimap<String, String> multimap) {
    // ImmutableMultimap.Builder preserves key/value order
    ImmutableMultimap.Builder<String, String> result = ImmutableMultimap.builder();
    for (Multiset.Entry<String> entry : ASCENDING_COUNT_ORDERING.sortedCopy(multimap.keys().entrySet())) {
        result.putAll(entry.getElement(), multimap.get(entry.getElement()));
    }
    return result.build();
}
  
    private static final Ordering<Multiset.Entry<?>> DESCENDING_COUNT_ORDERING = ASCENDING_COUNT_ORDERING.reverse();

}

