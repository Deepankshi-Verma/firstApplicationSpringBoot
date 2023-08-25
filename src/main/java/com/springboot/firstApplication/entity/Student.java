package com.springboot.firstApplication.entity;

import com.fasterxml.jackson.annotation.*;
import com.springboot.firstApplication.enums.GenderEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter// used for lombok, generating the getter and setters.
@NoArgsConstructor
@AllArgsConstructor
@Builder // used so that we don't have to write different constructors
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String name;

    @NotNull
    private LocalDate dob;

    @ColumnTransformer(read = "gender::varchar", write = "?::gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String address;

    @JsonManagedReference(value = "course")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

 }