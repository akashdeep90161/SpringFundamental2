package com.akash.autowiring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.List;


public class App {
        public static void main(String[] args)
        {
                ApplicationContext context= new
                        FileSystemXmlApplicationContext("src/main/java/com/akash/autowiring/example/beans/beans.xml");
               // ApplicationContext context= new ClassPathXmlApplicationContext("com/akash/autowiring/example/beans/beans.xml");
               /* Logger logger=(Logger) context.getBean("logger");
                logger.writeConsole("Hello Autowiring");
                logger.writeFile("Hi again");*/

             /*  Robot robot= (Robot) context.getBean("robot");
               robot.speak();*/

            OffersDAO offerDao=(OffersDAO) context.getBean("offersDao");

        /*    try {*/

                Offers offers1=new Offers("aman","aman@gmail.com","dsfsf");
                Offers offers2=new Offers("ankur","ankr@gmail.com","dsfsf");
                if(offerDao.create(offers1))
                {
                    System.out.println("Offer1 created");
                }
                if(offerDao.create(offers2))
                {
                    System.out.println("Offer2 created");
                }

                List<Offers> offers = offerDao.getOffers();
                for (Offers offer : offers) {
                    System.out.println(offer);
                }

                /*System.out.println(offerDao.getOffer(1));
                System.out.println(offerDao.getOffer(1));*/
           // }
           /* catch (CannotGetJdbcConnectionException ex)
            {
                System.out.println("JDBC connection failed");
            }
            catch (DataAccessException ex)
            {
                System.out.println(ex.getMessage());
            }*/

                ((FileSystemXmlApplicationContext) context).close();
        }
}
