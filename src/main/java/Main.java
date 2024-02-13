import entity.Department;
import jakarta.persistence.*;

import java.io.Serializable;

/*
Jakarta version = 9.1
MySQL version = 8.0.36
 */

public class Main implements Serializable {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default"); //this space in <persistence-unit name="default">
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            Department department = new Department(6,"dadadada");
            //department.setId();
            //entityManager.persist(department);
            entityManager.merge(department);     //can be used for PersistenceException
            Query countID= entityManager.createNativeQuery("SELECT name FROM department"); //"SELECT COUNT(ID) FROM DEPARTMENT" (getSingleResult())
            System.out.println(countID.getResultList());
            transaction.commit();
        } finally {
            if(transaction.isActive())
                transaction.rollback();
        }
    }
}
