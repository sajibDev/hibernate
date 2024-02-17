package com.sajib.hibernate;

import com.sajib.hibernate.model.*;
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

          /*  Instructor instructor = new Instructor();
            instructor.setFirstName("Tahmid");
            instructor.setLastName("Ahmed");
            instructor.setEmail("mdsajib@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail();
            instructorDetail.setYoutubeChannel("dailyCodeBuffer");
            instructorDetail.setHobby("coding");

            instructorDetail.setInstructor(instructor);
            instructor.setInstructorDetail(instructorDetail);*/
     /*     InstructorDetail instructorDetail = session.get(InstructorDetail.class,5);
            instructorDetail.getInstructor().setInstructorDetail(null);*/

           /* Course c1 = new Course();
            c1.setTitle("CSE");

            Course c2 = new Course();
            c2.setTitle("EEE");

            Course c3 = new Course();
            c3.setTitle("ECE");*/

           /* Instructor instructor = session.get(Instructor.class,5);

           for(Course course:instructor.getCourses()) System.err.println(course);*/
       /*     instructor.add(c1).add(c2).add(c3);*/
     /*       Review review1 = new Review();
            review1.setUserComment("Excellent course.");
            Review review2 = new Review();
            review2.setUserComment("good course.");
            Review review3 = new Review();
            review3.setUserComment("not beginner friendly course.");

            Course course = new Course();
            Instructor instructor = session.get(Instructor.class,1);
            course.setTitle("TLE");
            course.setInstructor(instructor);
            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);*/
            Review review = session.get(Review.class,5);


   /*         course.getReviews().forEach(review -> review.setCourse(course));*/

            transaction = session.beginTransaction();
            session.remove(review);
            transaction.commit();


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (session != null && session.isOpen()) session.close();

            if (transaction != null && transaction.isActive()) transaction.rollback();

        }
    }

}
