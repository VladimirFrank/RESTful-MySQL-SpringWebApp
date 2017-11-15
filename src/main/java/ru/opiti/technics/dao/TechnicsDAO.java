package ru.opiti.technics.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    // TODO TEST IT!
    // TODO добавить поиск по части ФИО (по фамилии, например)
    // получение списка техники по ФИО держателя
    public List<Technics> findTechnicsByFio(String fio){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("FROM Technics WHERE holder like :fio");
            query.setParameter("fio", "%" + fio + "%");
            List queryList = query.list();
            if(queryList == null && queryList.isEmpty()){
                return null;
            } else{
                System.out.println("list " + queryList);
                System.out.println(queryList.size());
                return (List<Technics>) queryList;
            }
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    // TODO TEST IT!
    // TODO добавить поиск по части серийного номера
    // Получение списка техники по серийному номеру (возможно несколько позиций)
    public List<Technics> findTechnicsBySerialNumber(String sn){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("FROM Technics WHERE serialNumber = :sn");
            query.setParameter("serialNumber", sn);
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

    public void updateTechnics(Technics technics){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            session.saveOrUpdate(technics);
            session.flush();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Technics addTechnics(Technics technics){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session: " + session);
            transaction = session.beginTransaction();
            session.save(technics);
            transaction.commit();
            return technics;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteTechnics(int id){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Technics t where t.id =: id");
            createQuery.setParameter("id", id);
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


}
