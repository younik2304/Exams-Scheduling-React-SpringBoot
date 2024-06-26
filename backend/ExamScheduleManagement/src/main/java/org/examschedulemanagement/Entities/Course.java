package org.examschedulemanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private int nbrStudents ;
    private Grade grade;
    private TypeElement typeElement;
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Exam> examList;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Professor teacher;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Professor supervisor;



}