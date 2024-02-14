package com.sajib.hibernate;

import com.sajib.hibernate.model.Prescription;
import com.sajib.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan("com.sajib.hibernate.model")
@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {

        SpringApplication.run(HibernateApplication.class, args);
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory("hibernate").openSession();
			List<Prescription> patientBeans = session.createQuery("  from Prescription ", Prescription.class).getResultList();

			for(Prescription patientBean:patientBeans){

				System.err.println(patientBean);

			}

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (session != null && session.isOpen()) {

                session.close();

            }

        }
    }

}
