package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Client extends BaseEntity {

    @Column
    @Digits(fraction = 0, integer = 10)
    @ApiModelProperty(value = "Identification Number", example = "35060456", required = true, position = 1)
    private String idNumber;

    @Column
    @NotEmpty
    @ApiModelProperty(value = "First name", example = "John", required = true, position = 2)
    private String firstName;

    @Column
    @NotEmpty
    @ApiModelProperty(value = "Last name", example = "Salchichon", required = true, position = 3)
    private String lastName;

    @Column
    @Digits(fraction = 0, integer = 10)
    @ApiModelProperty(value = "Phone Number", example = "3624000000", position = 4)
    private String phoneNumber;

    @Column
    @Email
    @ApiModelProperty(value = "Email address", example = "john@salchichon.com", position = 5)
    private String email;
}
