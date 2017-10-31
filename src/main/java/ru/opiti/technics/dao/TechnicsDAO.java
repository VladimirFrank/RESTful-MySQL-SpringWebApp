package ru.opiti.technics.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.opiti.technics.dbConfig.HibernateConnector;
import ru.opiti.technics.model.Technics;

import java.util.List;

public class TechnicsDAO {

    public List<Technics> listTechnics(){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Technics t");

            List queryList = query.list();
            if(queryList == null && queryList.isEmpty()){
                return null;
            } else{
                System.out.println("list " + queryList);
                return (List<Technics>) queryList;
            }
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Technics findTechnicsById(int id){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Technics t where t.id = :id");
            query.setParameter("id", id);

            List queryList = query.list();
            if(queryList == null && queryList.isEmpty()){
                return null;
            } else{
                return (Technics) queryList.get(0);
            }
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
