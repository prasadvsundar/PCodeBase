package com.pchat.websocket;

/**
 * ChatServerEndPoint.java
 * http://programmingforliving.com
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;





/**
 * ChatServer
 * @author Prasad VS
 */
@ServerEndpoint(value="/chat/{name}", configurator=ChatServerEndPointConfigurator.class)
public class ChatServerEndPoint {
   
    private Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());
    private Set<Session> securedSessions = Collections.synchronizedSet(new HashSet<Session>());

    /**
     * Callback hook for Connection open events. This method will be invoked when a 
     * client requests for a WebSocket connection.
     * @param userSession the userSession which is opened.
     */
    @OnOpen
    public void onOpen(Session userSession, @PathParam("name") String name) {
    	//System.out.println(userSession.getQueryString());
    	System.out.println(name);
    	System.out.println("Session "+userSession.getId());
    	if (name.equalsIgnoreCase("Prasad")
				|| name.equalsIgnoreCase("Pooja")) {
    		 userSessions.add(userSession);
    	}else{
    		
    	}
    }
    
    /**
     * Callback hook for Connection close events. This method will be invoked when a
     * client closes a WebSocket connection.
     * @param userSession the userSession which is opened.
     */
    @OnClose
    public void onClose(Session userSession, @PathParam("name") String name) {
    	System.out.println("Closed "+name);
        userSessions.remove(userSession);
    }
    
    /**
     * Callback hook for Message Events. This method will be invoked when a client
     * send a message.
     * @param message The text message
     * @param userSession The session of the client
     * @throws JSONException 
     */
    @OnMessage
	public void onMessage(String message, Session userSession)
			throws JSONException {

		System.out.println("Message Received: " + message);
		try {
			Map<String, Object> userMap = JsonUtility
					.convertStringToMap(message);
			if (userMap.get("user").toString().equalsIgnoreCase("Prasad")
					|| userMap.get("user").toString().equalsIgnoreCase("Pooja")) {
				securedSessions.add(userSession);
			} else {
				JSONObject errorObj = new JSONObject();
				errorObj.put("user", userMap.get("user").toString());
				errorObj.put("message", "Heyyyyy Goooo...!");
				userSession.getAsyncRemote().sendText(errorObj.toString());
			}
			for (Session session : securedSessions) {
				System.out.println("Sending to " + session.getId());
				session.getAsyncRemote().sendText(message);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    /*private void sendClient(String str) {
        try {
            this.session.getRemote().sendString(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

   /* private void sendError(String err) {
        this.sendClient(String.format("{\"msg\": \"error\", \"error\": \"%s\"}", err));
    }*/
    
    
}
