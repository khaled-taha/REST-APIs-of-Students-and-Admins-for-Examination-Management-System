package com.OnlineExaminationSystem.App.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "student", schema = "examinationsystem")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@DiscriminatorValue("student")
public class Student extends User implements Serializable {

    @Range(min = 1, max = 4)
    @Column(name = "year")
    @NotNull
    private byte year;


}
