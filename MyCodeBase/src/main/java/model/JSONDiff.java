package src.main.java.model;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONDiff {
	public static void main(String[] args) {
		  String json1 = "{\"name\":\"ABC\", \"city\":\"XYZ\", \"state\":\"CA\"}";
		  String json2 = "{\"city\":\"XYZt\", \"state\":\"123 anyplace\", \"name\":\"ABC\",  \"name1\":\"ABC\"}";

		  Gson g = new Gson();
		  Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
		  Map<String, Object> firstMap = g.fromJson(json1, mapType);
		  Map<String, Object> secondMap = g.fromJson(json2, mapType);
		  
		  //Arrays.sort(a, c);
		  //Collections.sort(list, c);
		//  System.out.println(compareKeysAndValues(firstMap, firstMap));
		  
		  
		  Equivalence valueEquivalence = Equivalence.equals();
		  MapDifference<String, Object> diff = Maps.difference(firstMap, secondMap, valueEquivalence);
		  Map<String, ValueDifference<Object>> diffrenceMap = diff.entriesDiffering();
		  Map<String, Object> finalDiffMap =  new HashMap<String, Object>();
		  for(String key : diffrenceMap.keySet()){
			  ValueDifference<Object> diffObject = diffrenceMap.get(key);
			  finalDiffMap.put(key,diffObject.rightValue());
		  }
		  //System.out.println(diff.entriesDiffering());
		  finalDiffMap.putAll(diff.entriesOnlyOnRight());
		  System.out.println(finalDiffMap);
		}
	
	/*public static <K extends Comparable<? super K>, V>
    Map<K, Boolean> compareKeysAndValues(final Map<K, V> map1,
        final Map<K, V> map2){
        final Collection<K> allKeys = new HashSet<K>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        final Map<K, Boolean> result = new TreeMap<K, Boolean>();
        for(final K key : allKeys){
            result.put(key,
                map1.containsKey(key) == map2.containsKey(key) &&
                Boolean.valueOf(equal(map1.get(key), map2.get(key))));
        }
        return result;
    }
	*/
/*  public static String equal(Object obj1, Object obj2){
	  
	  if(obj1 instanceof String && obj2 instanceof String){
		  String s1 = (String) obj1;
		  String s2 = (String) obj2;
		  return ""+s1.equals(s2);
	  }
	  
	  if(obj1 instanceof Map && obj2 instanceof Map){
		  Map<String, Object> map1 = (Map<String, Object>) obj1;
		  Map<String, Object> map2 = (Map<String, Object>) obj2;
		  return ""+Maps.difference(map1, map2).areEqual();
	  }
	  
	  if(obj1 instanceof List && obj2 instanceof List){
		  ArrayList map1 =  (ArrayList) obj1;
		  ArrayList map2 =  (ArrayList) obj2;
		  map1.removeAll(map2);
		  if(map1.size()>0)
			  return "false";
		  
	  }
	   return "false";
  }*/
}
