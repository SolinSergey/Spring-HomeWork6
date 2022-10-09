package HomeWorkSpring.dao;

import HomeWorkSpring.config.ConnectManager;
import HomeWorkSpring.entities.Product;
import HomeWorkSpring.entities.Purchase;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseDAO {
    ConnectManager connectManager;

    @Autowired
    public void setConnectManager (ConnectManager connectManager){
        this.connectManager=connectManager;
    }

    public PurchaseDAO() {
    }

    public Purchase getPurchaseById(Long idPurchase){
        Purchase purchase=null;
        try(Session session=connectManager.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            purchase=session.get(Purchase.class,idPurchase);
            session.getTransaction().commit();
        }
        return purchase;
    }
    public List<Purchase> getAllPurchase(){
        List<Purchase> list;
        try(Session session=connectManager.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            list=session.createQuery("from Purchase").getResultList();
            session.getTransaction().commit();
        }
        return list;
    }

    public List<Purchase> getCostAllPurchases(Long idBuyer, Long idProduct){
        List<Purchase> list;

        try(Session session=connectManager.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            list=session.createQuery("from Purchase p where id_buyer="+idBuyer.toString()+" and id_product="+idProduct.toString()).getResultList();
            session.getTransaction().commit();
        }
        return list;
    }

}
