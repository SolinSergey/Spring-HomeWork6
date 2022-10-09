package HomeWorkSpring.dao;

import HomeWorkSpring.config.ConnectManager;
import HomeWorkSpring.entities.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {
    ConnectManager connectManager;

    @Autowired
    public void setConnectManager(ConnectManager connectManager) {
        this.connectManager = connectManager;
    }

    public Product getProductById(Long idProduct) {
        Product product = null;
        try (Session session = connectManager.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, idProduct);
            session.getTransaction().commit();
        }
        return product;
    }

    public List<Product> getAllProduct() {
        List<Product> list;
        try (Session session = connectManager.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            list = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
        }
        return list;
    }

    public List<Product> getAllBuyerByIdProduct(Long idBuyer) {
        List<Product> list;
        try (Session session = connectManager.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            list = session.createQuery("select p.product.title from Purchase p where id_buyer=" + idBuyer.toString()).getResultList();
            session.getTransaction().commit();
        }
        return list;
    }
}
