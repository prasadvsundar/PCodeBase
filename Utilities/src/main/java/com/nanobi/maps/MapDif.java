package com.nanobi.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;

public class MapDif {
public static void main(String[] args) throws ParseException {
	
	
	String oldString = "{\"nanomart_tables\":[{\"name\":\"dept_ew1\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"dept_e1\",\"columnName\":\"deptno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e1\",\"columnName\":\"dname\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e1\",\"columnName\":\"loc\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"dept_e2\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"dept_e2\",\"columnName\":\"deptno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e2\",\"columnName\":\"dname\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e2\",\"columnName\":\"loc\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"dept_e4\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"dept_e4\",\"columnName\":\"deptno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e4\",\"columnName\":\"dname\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e4\",\"columnName\":\"loc\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"emp_e1\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"empno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"ename\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"job\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"mgr\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"date\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"hiredate\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"sal\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"comm\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"deptno\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"emp_e2\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"empno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"ename\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"job\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"mgr\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"date\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"hiredate\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"sal\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"comm\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"deptno\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"emp_e4\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"empno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"ename\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"job\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"mgr\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"date\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"hiredate\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"sal\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"comm\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"deptno\",\"collationName\":null}],\"is_fact\":\"no\"}]}";
	
	String newString = "{\"nanomart_tables\":[{\"name\":\"dept_e1\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"dept_e1\",\"columnName\":\"deptno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e1\",\"columnName\":\"dname\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e1\",\"columnName\":\"loc\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"dept_e2\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"dept_e2\",\"columnName\":\"deptno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e2\",\"columnName\":\"dname\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e2\",\"columnName\":\"loc\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"dept_e4\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"dept_e4\",\"columnName\":\"deptno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e4\",\"columnName\":\"dname\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"dept_e4\",\"columnName\":\"loc\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"emp_e1\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"empno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"ename\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"job\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"mgr\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"date\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"hiredate\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"sal\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"comm\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e1\",\"columnName\":\"deptno\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"emp_e2\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"empno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"ename\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"job\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"mgr\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"date\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"hiredate\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"sal\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"comm\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e2\",\"columnName\":\"deptno\",\"collationName\":null}],\"is_fact\":\"no\"},{\"name\":\"emp_e4\",\"column\":[{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"empno\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"ename\",\"collationName\":null},{\"charMaxlength\":\"200\",\"is_nullable\":true,\"dataType\":\"varchar\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"job\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"mgr\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":false,\"dataType\":\"date\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"hiredate\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"sal\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"comm\",\"collationName\":null},{\"charMaxlength\":null,\"is_nullable\":true,\"dataType\":\"int\",\"is_mis_date\":false,\"tableName\":\"emp_e4\",\"columnName\":\"deptno\",\"collationName\":null}],\"is_fact\":\"no\"}]}";
	
	JSONParser parser = new JSONParser();
	
	JSONObject oldObj = (JSONObject) parser.parse(oldString);
	
	JSONObject newObj = (JSONObject) parser.parse(newString);
	
	System.out.println("Old "+oldObj);
//	System.out.println("New "+newObj);
	
	JSONObject nmTableResultMap = new JSONObject();
	JSONArray nmTableArray = (JSONArray) oldObj.get("nanomart_tables");
	for(Object obj : nmTableArray){
		JSONObject table =  (JSONObject) obj;
		nmTableResultMap.put(table.get("name"), table);
	}
	System.out.println(nmTableResultMap);
	//getTableDif(oldObj, newObj);
	/*
	  Map<String, Object> firstMap = new HashMap<String, Object>();
	// firstMap.put("p", "p");
	  List<Map<String, Object>> l1 = new ArrayList< Map<String, Object>>();
	  Map<String, Object> p1 = new HashMap<String, Object>();
	  p1.put("p1", "pv1");
	  l1.add(p1);
	  //firstMap.put("list", l1);
	  Map<String, Object> p3 = new HashMap<String, Object>();
	  p3.put("p1", "po1");
	  l1.add(p3);
	  firstMap.put("list", l1);
	  
	  Map<String, Object> secondMap = new HashMap<String, Object>();
	//  secondMap.put("p", "s");
	  List< Map<String, Object>> l2 = new ArrayList< Map<String, Object>>();
	  Map<String, Object> p2 = new HashMap<String, Object>();
	  p2.put("p1", "po1");
	  l2.add(p2);
	  secondMap.put("list", l2);
	  
	  System.out.println(firstMap);
	  System.out.println(secondMap);
	  Equivalence valueEquivalence = Equivalence.equals();
	  MapDifference<String, Object> diff = Maps.difference(firstMap, secondMap, valueEquivalence);
	  Map<String, ValueDifference<Object>> diffrenceMap = diff.entriesDiffering();
	 
	  Map<String, Object> finalDiffMap =  new HashMap<String, Object>();
	  for(String key : diffrenceMap.keySet()){
		  ValueDifference<Object> diffObject = diffrenceMap.get(key);
		  finalDiffMap.put(key,diffObject);
		 // System.out.println("key"+""+diffObject.leftValue());
	  }
	  System.out.println(finalDiffMap);*/
	  
	 /* Map<String, Object> finalDiffMap =  new HashMap<String, Object>();
	  for(String key : diffrenceMap.keySet()){
		  ValueDifference<Object> diffObject = diffrenceMap.get(key);
		  finalDiffMap.put(key,diffObject.rightValue());
	  }
	  finalDiffMap.putAll(diff.entriesOnlyOnRight());*/
}

	public static JSONObject getTableDif(JSONObject firstObj, JSONObject secondObj){
		Map<String, Object> firstMap = firstObj;
		Map<String, Object> secondMap = secondObj;
		Equivalence valueEquivalence = Equivalence.equals();
		MapDifference<String, Object> diff = Maps.difference(firstMap, secondMap, valueEquivalence);
		Map<String, ValueDifference<Object>> diffrenceMap = diff.entriesDiffering();
		  
	    Map<String, Object> finalDiffMap =  new HashMap<String, Object>();
	    for(String key : diffrenceMap.keySet()){
		   ValueDifference<Object> diffObject = diffrenceMap.get(key);
		   System.out.println("R "+diffObject.rightValue());
		   System.out.println("L "+diffObject.leftValue());
		   finalDiffMap.put(key,diffObject.rightValue());
		 // System.out.println("key"+""+diffObject.leftValue());
	   }
		System.out.println(finalDiffMap);
		return null;
	}
}
