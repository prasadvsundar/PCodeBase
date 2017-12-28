package com.codebase.queue;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LoadQueue {
	volatile Integer count=0;
public static void main(String[] args) {
	LoadQueue l = new LoadQueue();
	l.runJob();
}

void runJob(){
	ConcurrentLinkedQueue<Map<String, Object>> queue = new ConcurrentLinkedQueue<Map<String, Object>>();
	
    Thread producer = new Thread(new Producer(queue, count));
    Thread consumer = new Thread(new Consumer(queue, count));
    producer.start();
    consumer.start();
}
}
//the producer puts strings on the queue 
class Producer implements Runnable {
	 
	   ConcurrentLinkedQueue<Map<String, Object>> queue;
	   Integer count;
	   Producer(ConcurrentLinkedQueue<Map<String, Object>> queue, Integer count){
	      this.queue = queue;
	      this.count = count;
	   }
	   public void run() {
	      try {
	    	  DB db = new DB();
		      System.out.println("Producer Started");
		      Statement stmt = db.getConnection().createStatement();
		      stmt.setFetchSize(200);
		      String[] columnNames = "txn_id, txn_init_timestamp, txn_comp_timestamp, txn_type, txn_subtype, initiating_channel, multiple_payee, txn_status, error_code, respcd_payer, respcd_payee, reversal_respcode_payer, reversal_respcode_payee, payer_psp, payer_seqnum, payee_seqnum, payee_psp, remitter_bank, beneficiary_bank, payer_bin, payer_ifsc, payer_mmid, payee_bin, payee_ifsc, payee_mmid, payer_address, payee_address, payee_requested_amount, payee_settlement_amount, client, port, payer_location, payee_location, payer_geocode, payee_geocode, payer_os_type, payee_os_type, riskscore, windowid, payer_auth_respcd, payee_auth_respcd, payer_requested_amount, imps, payer_mobilenumber, payee_mobilenumber, beneficiary_mcc_code, remitter_mcc_code, debit_rrn, credit_rrn, custref, payer_account_number, payee_account_number, payer_aadhar_number, payee_aadhar_number, mis_crtn_ts, payer_settlement_amount, payee_verified_name, payer_device_id, payee_device_id, cred_type, cred_subtype".split(",");
		      ResultSet rs = stmt.executeQuery("select txn_id, txn_init_timestamp, txn_comp_timestamp, txn_type, txn_subtype, initiating_channel, multiple_payee, txn_status, error_code, respcd_payer, respcd_payee, reversal_respcode_payer, reversal_respcode_payee, payer_psp, payer_seqnum, payee_seqnum, payee_psp, remitter_bank, beneficiary_bank, payer_bin, payer_ifsc, payer_mmid, payee_bin, payee_ifsc, payee_mmid, payer_address, payee_address, payee_requested_amount, payee_settlement_amount, client, port, payer_location, payee_location, payer_geocode, payee_geocode, payer_os_type, payee_os_type, riskscore, windowid, payer_auth_respcd, payee_auth_respcd, payer_requested_amount, imps, payer_mobilenumber, payee_mobilenumber, beneficiary_mcc_code, remitter_mcc_code, debit_rrn, credit_rrn, custref, payer_account_number, payee_account_number, payer_aadhar_number, payee_aadhar_number, mis_crtn_ts, payer_settlement_amount, payee_verified_name, payer_device_id, payee_device_id, cred_type, cred_subtype from dbo.testLoad");
		    
		      while (rs.next()) {
		    	  while(queue.size()>=30000) {
		    		  synchronized(this) {
						   wait(2000);
					   }
		    	  }
		    	  Map<String, Object> row = new HashMap<String, Object>();
		    	  for(int i=0; i<columnNames.length; i++) {
		    		  row.put(columnNames[i].trim(), rs.getObject(columnNames[i].trim()));
		    	  }
		          queue.add(row);
		      }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	   }
	}
	 
	// the consumer removes strings from the queue
	class Consumer implements Runnable {
		//MapSqlParameterSource
	   ConcurrentLinkedQueue<Map<String, Object>> queue;
	   Integer count;
	   Consumer(ConcurrentLinkedQueue<Map<String, Object>> queue, Integer count){
	      this.queue = queue;
	      this.count = count;
	   }

	public void run() {
		System.out.println("Consumer Started");
		while (queue.size() < 30000) {
			System.out.println("Consumer read count no " + queue.size());
			try {
				synchronized (this) {
					wait(2000);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer read count no " + queue.size());
		Map<String, Object> str;
		while ((str = queue.poll()) != null) {
			System.out.println("Removed: " + str);
		}
	}

}
	