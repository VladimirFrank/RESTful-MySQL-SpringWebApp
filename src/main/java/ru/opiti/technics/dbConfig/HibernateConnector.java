package ru.opiti.technics.dbConfig;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

    private static HibernateConnector me;
    private Configuration configuration;
    private SessionFactory sessionFactory;

    private HibernateConnector() throws HibernateException{
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

    }

    public static synchronized HibernateConnector getInstance(){
        if(me == null){
            me = new HibernateConnector();
        }
        return me;
    }

    public Session getSession() throws HibernateException{
        Session session = sessionFactory.openSession();
        if(!session.isConnected()){
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException{
        this.sessionFactory = configuration.buildSessionFactory();
    }

}
