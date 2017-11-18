import model.Order;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;

import java.time.LocalDate;

/**
 * Created by jan on 2017-11-18.
 */
public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setName("Kawa");

        Product product2 = new Product();
        product2.setName("Herbata");

        Order order1= new Order();
        order1.setTime(LocalDate.now());

        Order order2 = new Order();
        order1.setTime(LocalDate.now());

//        product1.getOrders().add(order1);
//        product1.getOrders().add(order2);
//
//        product2.getOrders().add(order1);
//        product2.getOrders().add(order2);

        order1.getProducts().add(product1);
        order1.getProducts().add(product2);
        order2.getProducts().add(product2);

        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();

        session.save(order1);
        session.save(order2);

        session.getTransaction().commit();
        session.close();

    }
}
