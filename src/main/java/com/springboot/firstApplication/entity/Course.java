package com.springboot.firstApplication.entity;

import com.fasterxml.jackson.annotation.*;
import com.springboot.firstApplication.enums.CourseName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_name_seq")
    @SequenceGenerator(name = "course_name_seq", sequenceName = "sequence", allocationSize = 1)
    private int id;

    @ColumnTransformer(read = "course_name::varchar", write = "?::name")
    @Enumerated(EnumType.STRING)
    private CourseName courseName;

    private BigDecimal fee;

    @JsonBackReference(value = "course")// loop hatane ke liye use kiya tha
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
     private List<Student>  student;


    @JsonBackReference(value = "course")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
    private Faculty faculty;

}
