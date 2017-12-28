package com.pchat.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainClass {
	public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
       try{
    	   Stock stock = new Stock();
       
        
        stock.setStockCode("4715");
        stock.setStockName("GENM");
        
      
        session.save(stock);
        tx.commit();
       } catch(Exception e){
        	tx.rollback();
        }finally{
        	session.close();
        }
        
    }
}
