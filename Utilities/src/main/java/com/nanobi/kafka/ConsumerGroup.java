package com.nanobi.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerGroup implements Runnable {
	  private final KafkaConsumer<String, String> consumer;
	  private final List<String> topics;
	  private final int id;

	  public ConsumerGroup(int id,
	                      String groupId, 
	                      List<String> topics) {
	    this.id = id;
	    this.topics = topics;
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092");
	    props.put("group.id", groupId);
	    props.put("key.deserializer", StringDeserializer.class.getName());
	    props.put("value.deserializer", StringDeserializer.class.getName());
	    this.consumer = new KafkaConsumer<>(props);
	  }
	 
	  @Override
	  public void run() {
	    try {
	      consumer.subscribe(topics);

	      while (true) {
	        ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
	        for (ConsumerRecord<String, String> record : records) {
	          Map<String, Object> data = new HashMap<>();
	          data.put("partition", record.partition());
	          data.put("offset", record.offset());
	          data.put("value", record.value());
	          System.out.println(this.id + ": " + data);
	        }
	      }
	    } catch (WakeupException e) {
	    } finally {
	      consumer.close();
	    }
	  }

	  public void shutdown() {
	    consumer.wakeup();
	  } /*{
   public static void main(String[] args) throws Exception {
      
      String topic = "TutorialTopic1";
     // String group = args[1].toString();
      Properties props = new Properties();
      props.put("bootstrap.servers", "172.16.0.21:9092");
    //  props.put("group.id", group);
      props.put("enable.auto.commit", "true");
      props.put("auto.commit.interval.ms", "1000");
      props.put("session.timeout.ms", "30000");
      props.put("key.deserializer",          
         "kafka.serializer.StringEncoder");
      props.put("value.deserializer", 
         "kafka.serializer.StringEncoder");
     // props.put("serializer.class", "kafka.serializer.StringEncoder");
      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
      
      consumer.subscribe(Arrays.asList(topic));
      System.out.println("Subscribed to topic " + topic);
      int i = 0;
         
      while (true) {
         ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
               System.out.printf("offset = %d, key = %s, value = %s\n", 
               record.offset(), record.key(), record.value());
      } 
   }*/
}