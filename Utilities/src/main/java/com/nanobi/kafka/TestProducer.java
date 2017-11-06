package com.nanobi.kafka;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
 
public class TestProducer {
	
	protected native Object clone();

    public static void main(String[] args) {
    	
    	//HashSet s = new HashSet<String>();
    //	s.add(e)
    	
        long events = 2;
        //Random rnd = new Random();
        
       // HashMap  m = new HashMap<String,String>();
       // m.put(key, value)
 
        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "com.nanobi.kafka.SimplePartitioner");
        props.put("request.required.acks", "1");
 
        ProducerConfig config = new ProducerConfig(props);
 
        Producer<String, String> producer = new Producer<String, String>(config);
 
        for (long nEvents = 0; nEvents < events; nEvents++) { 
               long runtime = new Date().getTime();  
               String ip = "localhost"; 
               String msg =  "Hi Nanobi.. "; 
               List<KeyedMessage<String, String>> data = new ArrayList<KeyedMessage<String, String>>();
               
               data.add(new KeyedMessage<String, String>("TutorialTopic", ip, msg));
               data.add(new KeyedMessage<String, String>("TutorialTopic", ip, msg));
               producer.send(data);
        }
        System.out.println("sent");
        producer.close();
    }
}