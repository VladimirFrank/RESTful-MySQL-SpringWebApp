package ru.opiti.technics.dao;

import org.hibernate.Query;
import org.hibernate.ReplicationMode;
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
    // Возможно оно и не нужно
    // Получение списка техники по серийному номеру (возможно несколько позиций)
    public List<Technics> findTechnicsBySerialNumber(String sn){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("FROM Technics WHERE serialNumber LIKE :sn");
            query.setParameter("serialNumber", "%" + sn + "%");
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

    /**
     * Make changes in @param object and UPDATE that element in data base.
     * @param technics
     */
    public void updateTechnics(Technics technics){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            transaction.setTimeout(5);
            session.saveOrUpdate(technics);
            transaction.commit();
        } catch(RuntimeException ex){
            try{
                transaction.rollback();
            } catch (RuntimeException rbe){
                System.out.println("Couldn't roll back transaction" + rbe);
            }
            throw ex;
        } finally {
            session.close();
        }
    }

    /**
     * Add element 'technics' in data base.
     * @param technics
     * @return 'true' if successful or 'false' not.
     */
    public boolean addTechnics(Technics technics){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session: " + session);
            transaction = session.beginTransaction();
            session.save(technics);
            transaction.commit();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Delete element from data base by id.
     * @param id
     * @return 'true' if successful or 'false' if element not deleted.
     */
    public boolean deleteTechnics(int id){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Technics t where t.id = :id");
            createQuery.setParameter("id", id);
            createQuery.executeUpdate();
            beginTransaction.commit();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Filtering methods
     */


    /**
     * Find and return one element from data base by ID
     * @param id
     * @return Technics or null if element not exist.
     */
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

    /**
     * Find one or many element that match or contain 'fio'.
     * @param fio
     * @return List Technics or null
     */
    public List<Technics> findTechnicsByFio(String fio){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("FROM Technics WHERE holder LIKE :fio");
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

    // TODO Сделать универсальный метод для выборки по всем столбцам, кроме ID.
    public List<Technics> findTechnics(String paramToFind, String searchItem){
        StringBuffer queryStringBuffer = new StringBuffer();

    }

    private String createQueryForTechnicsFilter(String paramToFind){
        if(paramToFind.equals("deviceType")){
            return "FROM Technics WHERE device_type LIKE :deviceType";
        }
    }


    public List<Technics> findTechnicsByDeviceType(String deviceType){
        Session session = null;
        try{
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("FROM Technics WHERE device_type LIKE :deviceType");
            query.setParameter("deviceType", "%" + deviceType + "%");
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
}
