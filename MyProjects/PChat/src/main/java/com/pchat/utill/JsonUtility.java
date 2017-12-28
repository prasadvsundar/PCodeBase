/*************************************************************************
 * 
 * NANOBI CONFIDENTIAL
 * ___________________
 * 
 *  (C) 2012 - 2013 NanoBI Data & Analytics Pvt Ltd
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of NanoBI Data & Analytics Pvt Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary may be covered by India and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from NanoBI Data & Analytics Pvt Ltd.
 */

package com.pchat.utill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
public class JsonUtility {
	
	
	public static Map<String, Object> convertStringToMap(String input_json) {
		Map<String, Object> output_map = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			output_map = mapper.readValue(input_json,  new TypeReference<Map<String, Object>>() {});
		} catch (JsonParseException e) {
			
		} catch (JsonMappingException e) {
		
		} catch (IOException e) {
		
		}
		return output_map; 
	}
	
	public static List<Map<String, Object>> convertStringToListOfMap(
			String input_json) {
		List<Map<String, Object>> output_map = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			output_map = mapper.readValue(input_json,
					new TypeReference<List<Map<String, Object>>>() {
					});
		} catch (JsonParseException e) {
		
			// e.printStackTrace();
		} catch (JsonMappingException e) {
		
			// e.printStackTrace();
		} catch (IOException e) {
			
			// e.printStackTrace();
		}
		return output_map;
	}
	public static String convertMapToString(Map<String, Object> input_map) {
		String output_json_string = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			output_json_string = mapper.writeValueAsString(input_map);
		} catch (JsonGenerationException e) {
			
			
		} catch (JsonMappingException e) {
			
			
		} catch (IOException e) {
			
		}
		return output_json_string;
	}
	
	public static String convertMapToMartJsonString(Map<String, Object> input_map) {
		Map<String, Object> opt = new HashMap<String, Object>();
		List<List<Object>> rows = new ArrayList<List<Object>>();
		List<Object> row = new ArrayList<Object>();
		Set<String> keys = input_map.keySet();
		for(String key:keys){
			row.add(input_map.get(key));
		}
		rows.add(row);
		opt.put("columns", keys);
		opt.put("rows", rows);
		return convertMapToString(opt);
	}
	
	public static String listmap_to_json_string(List<Map<String, Object>> list)
	{       
	    JSONArray json_arr=new JSONArray();
	    for (Map<String, Object> map : list) {
	        JSONObject json_obj=new JSONObject();
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            try {
	                json_obj.put(key,value);
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }                           
	        }
	        json_arr.put(json_obj);
	    }
	    return json_arr.toString();
	}

}
