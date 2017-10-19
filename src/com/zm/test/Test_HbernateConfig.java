package com.zm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.zm.mode.User;

public class Test_HbernateConfig {


		private static SessionFactory sessionfactory;
	    private static Session session;
	    public static void main(String[] args){
	        //��ȡĬ�������ļ��� hibernate.cfg.xml
	        //���Ҫָ���ļ�����ֻ��Ҫ��new Configuration().configure("ָ���ļ���·��");
	        Configuration config = new Configuration().configure();
	        //ע�����
	        ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties())
	                .buildServiceRegistry();
	        //ʵ����һ��session����
	        sessionfactory = config.buildSessionFactory(service);
	        //��hibernate��session��ִ�в���
	        session = sessionfactory.openSession();
	        
	        //��� 
	        add();
	        
	        //��ѯ
	        sel();
	        
	        //�޸�    
	        //update();
	        
	        //ɾ��
	        //delete();
	    }
	    //���
	    public static void add(){
	        Transaction transaction = session.beginTransaction();
	        User s = new User();
	        s.setSname("��g");
	        s.setSage(20);
	        session.save(s);
	        transaction.commit();
	    
	        //ע�⣺���session�رյĻ�����Ҫָ����
	    }
	    //��ѯ
	    public static void sel(){
	    	User s = (User) session.get(User.class, 1);
	        System.out.println(s.getSname());
	        
	    }
	    //�޸�����
	    public static  void update(){
	    	User s = new User();
	        s.setSname("����");
	        s.setSage(30);
	        
	        Transaction transaction = session.beginTransaction();
	        //��ȡ���ݿ��еı�
	        User s1 = (User) session.get(User.class,1);
	        transaction.commit();
	        s1.setSname("��˼˼");
	        transaction = session.beginTransaction();
	        session.update(s1);
	        transaction.commit();
	    }
	    public static void delete(){
	        
	        Transaction transaction = session.beginTransaction();
	        User s = (User) session.get(User.class, 1);
	        session.delete(s);
	        transaction.commit();
	        
	    }

	}


