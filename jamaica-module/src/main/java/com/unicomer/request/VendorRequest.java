package com.unicomer.request;

import com.unicomer.enumerations.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -3377234228219491233L;
    @Schema(description = "first name")
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
