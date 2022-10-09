package HomeWorkSpring.dao;

import HomeWorkSpring.config.ConnectManager;
import HomeWorkSpring.entities.Buyer;
import HomeWorkSpring.entities.Product;
import HomeWorkSpring.entities.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuyerDAO {

    ConnectManager connectManager;

    @Autowired
    public void setConnectManager (ConnectManager connectManager){
        this.connectManager=connectManager;
    }

    public BuyerDAO() {
    }

    public Buyer getBuyerById(Long idBuyer){
        Buyer buyer=null;
        try(Session session=connectManager.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            buyer=session.get(Buyer.class,idBuyer);
            session.getTransaction().commit();
        }
        return buyer;
    }
    public List<Buyer> getAllBuyer(){
        List<Buyer> list;
        try(Session session=connectManager.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            list=session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
        }
        return list;
    }

    public List<Buyer> getAllBuyerByIdProduct(Long idProduct){
        List<Buyer> list;

        try(Session session=connectManager.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            list=session.createQuery("select p.buyer.name from Purchase p where id_product="+idProduct.toString()).getResultList();
            session.getTransaction().commit();
        }
        return list;
    }
}
