package com.codebase.neo4j;

import org.json.JSONObject;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import com.cognitive.Taxonomy;
import com.google.gson.JsonObject;

public class Neo4j {
	public static void main(String[] args) {

		/*
		 * Driver driver = GraphDatabase.driver("bolt://172.16.0.201:7687",
		 * AuthTokens.basic("neo4j", "neo4j")); Session session =
		 * driver.session();
		 * 
		 * session.run("CREATE (a:Person {name:'Arthur1', title:'King1'})");
		 * 
		 * StatementResult result = session .run(
		 * "MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title"
		 * ); while (result.hasNext()) { Record record = result.next();
		 * System.out.println(record.get("title").asString() + " " +
		 * record.get("name").asString()); }
		 * 
		 * session.close(); driver.close();
		 */
		Neo4j nb = new Neo4j();
		JSONObject obj = new JSONObject();
		obj.put("name", "prasad");
		obj.put("l_name", "vs");
		nb.insertIntoNode("Person", nb.jsonToNeo4jMap(obj));
		//nb.insertIntoNode("Person",obj);
		//JSONObject obj = new JSONObject();
		//obj.put("name", "prasad");
		//obj.put("l_name", "vs");
		//System.out.println(nb.jsonToNeo4jMap(obj));
	}

	Session getConnnection() {
		Driver driver = GraphDatabase.driver("bolt://172.16.0.201:7687",
				AuthTokens.basic("neo4j", "neo4j"));
		Session session = driver.session();
		driver.close();
		return session;
	}

	void insertIntoNode(String nodeName, String data) {
		Session session = getConnnection();
		StatementResult s = session.run("CREATE (a:" + nodeName + " " + data
				+ ")");
	}

	void insertRecentlyUsedDesc(String desc, JSONObject obj) {
		String taxonomyString;
		try {
			Taxonomy t = new Taxonomy();
			taxonomyString = t.getTaxonomylist(desc).toString();
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			taxonomyString = "No Lable";
		}
		insertIntoNode("Person", jsonToNeo4jMap(obj));
	}

	String jsonToNeo4jMap(JSONObject obj) {
		StringBuilder neo4jString = new StringBuilder();
		neo4jString.append("{");
		for (String key : obj.keySet()) {
			neo4jString.append(key).append(":").append("'")
					.append(obj.get(key)).append("'").append(",");
		}
		if (neo4jString.length() > 0) {
			neo4jString = new StringBuilder(neo4jString.substring(0,
					neo4jString.length() - 1).toString());
			neo4jString.append("}");
			return neo4jString.toString();
		} else {
			return "";
		}
	}
}
