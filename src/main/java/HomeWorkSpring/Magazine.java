package HomeWorkSpring;


import HomeWorkSpring.config.AppConfig;
import HomeWorkSpring.dao.BuyerDAO;
import HomeWorkSpring.dao.ProductDAO;
import HomeWorkSpring.dao.PurchaseDAO;
import HomeWorkSpring.entities.Purchase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Magazine {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductDAO productDAO = context.getBean(ProductDAO.class);

        BuyerDAO buyerDAO = context.getBean(BuyerDAO.class);

        PurchaseDAO purchaseDAO = context.getBean(PurchaseDAO.class);

        Long idBuyer = 1L;
        Long idProduct = 2L;

        System.out.println(buyerDAO.getBuyerById(idBuyer));
        System.out.println(productDAO.getAllBuyerByIdProduct(idBuyer));

        System.out.println();

        System.out.println(productDAO.getProductById(idProduct));
        System.out.println(buyerDAO.getAllBuyerByIdProduct(idProduct));

        System.out.println();

        List<Purchase> list = purchaseDAO.getCostAllPurchases(idBuyer, idProduct);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).getBuyer().getName() + " ");
                System.out.print(list.get(i).getProduct().getTitle() + " ");
                System.out.print(list.get(i).getDate() + " ");
                System.out.println(list.get(i).getCost());
            }
        } else System.out.println("Покупки не найдены");
    }
}
