package com.springboot.firstApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.firstApplication.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Faculty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "faculty_seq")
    @SequenceGenerator(name = "faculty_seq", sequenceName = "faculty_sequence", allocationSize = 1)
    private int facultyId;

    private String name;

    @ColumnTransformer(read = "gender::varchar", write = "?::gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private BigDecimal salary;

    @JsonIgnore
    @JsonManagedReference(value = "course")
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course  course;

}
