import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;



public class ClientForSave {
 
    public static void main(String[] args)
    {
        // test commit 2
        // test commit 2

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());

        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

//        Configuration cfg = new Configuration().configure();
//        cfg.configure("hibernate.cfg.xml");
//
//       // SessionFactory factory = cfg.buildSessionFactory()
//
//        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Product p=new Product();

        p.setProductId(105);
        p.setProName("BC");
        p.setPrice(15000);

        Transaction tx = session.beginTransaction();
        session.save(p);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
    }
 
}
