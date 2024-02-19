package com.sajib.hibernate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY,cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
    @JoinTable(
            name ="course_student",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public void addReview(Review review){

        if(reviews==null) reviews = new ArrayList<>();
        reviews.add(review);

    }

    public void addStudents(Student student){

        if(students==null) students = new ArrayList<>();
        students.add(student);
        //student.getCourses().add(this);

    }

    @Override
    public String toString() {

        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor_id='"+instructor.getId()+"'"+
                '}';

    }
}
