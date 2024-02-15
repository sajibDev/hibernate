package com.sajib.hibernate;

import com.sajib.hibernate.model.Instructor;
import com.sajib.hibernate.model.InstructorDetail;
import com.sajib.hibernate.model.Prescription;
import com.sajib.hibernate.model.Student;
import com.sajib.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Transaction transaction = null;

        try {

            session = HibernateUtil.getSessionFactory("hibernate").openSession();

            Instructor instructor = new Instructor();
            instructor.setFirstName("Tahmid");
            instructor.setLastName("Ahmed");
            instructor.setEmail("mdsajib@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail();
            instructorDetail.setYoutubeChannel("dailyCodeBuffer");
            instructorDetail.setHobby("coding");

            instructor.setInstructorDetailId(instructorDetail);

            transaction = session.beginTransaction();
            session.persist(instructor);
            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (session != null && session.isOpen()) session.close();

            if (transaction != null && transaction.isActive()) transaction.rollback();

        }
    }

}
