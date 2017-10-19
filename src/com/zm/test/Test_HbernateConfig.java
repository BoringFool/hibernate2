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
	        //读取默认配置文件名 hibernate.cfg.xml
	        //如果要指定文件名，只需要在new Configuration().configure("指定文件的路径");
	        Configuration config = new Configuration().configure();
	        //注册服务
	        ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties())
	                .buildServiceRegistry();
	        //实例化一个session工厂
	        sessionfactory = config.buildSessionFactory(service);
	        //打开hibernate的session，执行操作
	        session = sessionfactory.openSession();
	        
	        //添加 
	        add();
	        
	        //查询
	        sel();
	        
	        //修改    
	        //update();
	        
	        //删除
	        //delete();
	    }
	    //添加
	    public static void add(){
	        Transaction transaction = session.beginTransaction();
	        User s = new User();
	        s.setSname("张g");
	        s.setSage(20);
	        session.save(s);
	        transaction.commit();
	    
	        //注意：如果session关闭的话，需要指定打开
	    }
	    //查询
	    public static void sel(){
	    	User s = (User) session.get(User.class, 1);
	        System.out.println(s.getSname());
	        
	    }
	    //修改数据
	    public static  void update(){
	    	User s = new User();
	        s.setSname("李四");
	        s.setSage(30);
	        
	        Transaction transaction = session.beginTransaction();
	        //获取数据库中的表
	        User s1 = (User) session.get(User.class,1);
	        transaction.commit();
	        s1.setSname("李思思");
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


