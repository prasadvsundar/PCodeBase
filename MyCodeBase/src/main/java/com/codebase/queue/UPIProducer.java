package com.codebase.queue;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class UPIProducer {
	/**
	 * @author Rohan Kamat(EmpId:1015)
	 * @version 1.0
	 * @organization NanoBi Analytics
	 * @Date Sept 27, 2017
	 */
	
	// Set the stream and topic to publish to.
	public static String topic;

	// Declare a new producer
	public static KafkaProducer<String, String> producer;

	public static void main(String[] args) throws SQLException {

		// initialize variables
		UPIProducer dataproducer = new UPIProducer();
		String outputTopic ="UPI";
		String brokerSocket ="localhost:9092";
		String fileName="/home/dev/Downloads/DATA_UPI_FIN.csv";
	//	long sleepTime = Long.parseLong("200");
		long sleepTime = 0l; 
		
		configureProducer(brokerSocket);
		topic = outputTopic;

		try {
			dataproducer.produceNpciData(sleepTime,fileName);
		} catch (IOException exception) {

		} catch (InterruptedException exception) {

		} finally {
			producer.close();
			producer = null;
		}

	}

	public static void configureProducer(String brokerSocket) {
		Properties props = new Properties();
		props.put("bootstrap.servers", brokerSocket);
		props.put("key.serializer", StringSerializer.class.getName());
		props.put("value.serializer", StringSerializer.class.getName());
		producer = new KafkaProducer<String, String>(props);
	}

	public void produceNpciData(long sleepTime, String fileName) throws IOException, InterruptedException, SQLException {
		List<String> numericcolumn= new ArrayList<String>(Arrays.asList("payee_requested_amount,payee_settlement_amount,payer_requested_amount,payer_settlement_amount"
				.split(",")));
		
		while (true) {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileName))
				//	new InputStreamReader(ClassLoader.getSystemResourceAsStream("UPI_FIN.csv"))
					);
			String line;
			String cvsSplitBy = ",";
			int i = 0;
			DB db = new DB();
			String[] columnNames = null;
			while ((line = reader.readLine()) != null) {

				if (i == 0) {
					columnNames = line.split(cvsSplitBy);
				//System.out.println(line);
				}else {
					StringBuilder transactionBuilder = new StringBuilder();
					String[] transactionValues = line.split(cvsSplitBy);
					for (int j = 0; j < columnNames.length; j++) {
						String columnName = columnNames[j];
						
						String columnValue = transactionValues[j];
						//String columnValue = line;

						if (columnName.equalsIgnoreCase("txn_id"))
							// transactionBuilder.append(columnName + "=UPI" +
							// generateTransactionId() + ",");
							transactionBuilder.append("\'UPI" + generateTransactionId() + "\', ");
						else if (columnName.equalsIgnoreCase("txn_init_timestamp"))
							// transactionBuilder.append(columnName + "=" +
							// getTransactionInit() + ",");
							transactionBuilder.append("\'" + getTransactionInit() + "\', ");
						else if (columnName.equalsIgnoreCase("txn_comp_timestamp"))
							// transactionBuilder.append(columnName + "=" +
							// getTransactionEnd(getTransactionInit()) + ",");
							transactionBuilder.append("\'" + getTransactionEnd(getTransactionInit()) + "\', ");
						else if (numericcolumn.contains(columnName))
							// transactionBuilder.append(columnName + "=" +
							// getTransactionEnd(getTransactionInit()) + ",");
							transactionBuilder.append("\'" + randInt(1000, 10000) + "\', ");
						else
							// transactionBuilder.append(columnName + "=" +
							// columnValue + ",");
							transactionBuilder.append("\'" + columnValue.trim() + "\', ");
						
						
					}
					StringBuilder b = new StringBuilder();
					List<String> wordlist = new ArrayList<String>(
                            Arrays.asList((transactionBuilder.toString()).split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?")));
                    for (int k = wordlist.size(); k <= 60; k++) {
                        wordlist.add(k, "null");
                    }
                   /* System.out.println(transactionBuilder);
                    for(String val : transactionBuilder.toString().split(",")) {
                    	b.append("'").append(val).append("',");
                    }*/
                    String sql = "insert into testLoad(txn_id, txn_init_timestamp, txn_comp_timestamp, txn_type, txn_subtype, initiating_channel, multiple_payee, txn_status, error_code, respcd_payer, respcd_payee, reversal_respcode_payer, reversal_respcode_payee, payer_psp, payer_seqnum, payee_seqnum, payee_psp, remitter_bank, beneficiary_bank, payer_bin, payer_ifsc, payer_mmid, payee_bin, payee_ifsc, payee_mmid, payer_address, payee_address, payee_requested_amount, payee_settlement_amount, client, port, payer_location, payee_location, payer_geocode, payee_geocode, payer_os_type, payee_os_type, riskscore, windowid, payer_auth_respcd, payee_auth_respcd, payer_requested_amount, imps, payer_mobilenumber, payee_mobilenumber, beneficiary_mcc_code, remitter_mcc_code, debit_rrn, credit_rrn, custref, payer_account_number, payee_account_number, payer_aadhar_number, payee_aadhar_number, mis_crtn_ts, payer_settlement_amount, payee_verified_name, payer_device_id, payee_device_id, cred_type, cred_subtype) values (";
                    String query = sql+transactionBuilder.toString().replaceAll("\"", "")+")";
                    query = query.replace(", )", ")");
                   // System.out.println(query);
                    
                    try {
                    	db.insertData(query);
                    }catch(Exception e) {
                    	e.printStackTrace();
                    	System.out.println("Error : "+query);
                    }
                    
				//	System.out.println(transactionBuilder);
					// use comma as separator

					/*ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,
							transactionBuilder.substring(0, transactionBuilder.length() - 1));
					
					System.out.println();*/
					//producer.send(record);
					//NPCIData npci =new NPCIData(transactionBuilder.toString().split(""));
					//NPCIData npci =new NPCIData(wordlist.get(0),wordlist.get(1),wordlist.get(2),wordlist.get(3),wordlist.get(4),wordlist.get(5),wordlist.get(6),wordlist.get(7),wordlist.get(8),wordlist.get(9),wordlist.get(10),wordlist.get(11),wordlist.get(12),wordlist.get(13),wordlist.get(14),wordlist.get(15),wordlist.get(16),wordlist.get(17),wordlist.get(18),wordlist.get(19),wordlist.get(20),wordlist.get(21),wordlist.get(22),wordlist.get(23),wordlist.get(24),wordlist.get(25),wordlist.get(26),wordlist.get(27),wordlist.get(28),wordlist.get(29),wordlist.get(30),wordlist.get(31),wordlist.get(32),wordlist.get(33),wordlist.get(34),wordlist.get(35),wordlist.get(36),wordlist.get(37),wordlist.get(38),wordlist.get(39),wordlist.get(40),wordlist.get(41),wordlist.get(42),wordlist.get(43),wordlist.get(44),wordlist.get(45),wordlist.get(46),wordlist.get(47),wordlist.get(48),wordlist.get(49),wordlist.get(50),wordlist.get(51),wordlist.get(52),wordlist.get(53),wordlist.get(54),wordlist.get(55),wordlist.get(56),wordlist.get(57),wordlist.get(58),wordlist.get(59),wordlist.get(60));
					
					
                    
                    
                   // return npci;
					Thread.sleep(sleepTime);
				}
				i++;
			}

		}

	}

	public static String generateTransactionId() {
		return UUID.randomUUID().toString();

	}
	

	public static String getTransactionInit() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public static String getTransactionEnd(String time) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
		Date now = new Date();
		now.setSeconds(now.getSeconds() + randInt(3, 20));
		String strDate = sdfDate.format(now);

		return strDate;
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}