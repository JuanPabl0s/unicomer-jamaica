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
    @Schema(description = "Id of Vendor")
    private Long id;
    @Schema(description = "First name of Vendor")
    private String firstName;
    @Schema(description = "Last name")
    private String lastName;
    @Schema(description = "Birthday")
    private String birthDay;
    @Schema(description = "Gender")
    private Gender gender;
    @Schema(description = "Cellphone number")
    private String cellphone;
    @Schema(description = "Home number")
    private String homePhone;
    @Schema(description = "Address")
    private String addressHome;
    @Schema(description = "Ocupation")
    private String profession;
    @Schema(description = "incomes amount")
    private Double incomes;

}
