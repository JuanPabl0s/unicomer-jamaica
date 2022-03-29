package com.unicomer.domain;

import com.unicomer.enumerations.Gender;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private Gender gender;
    private String cellphone;
    private String homePhone;
    private String addressHome;
    private String profession;
    private Double incomes;
}
