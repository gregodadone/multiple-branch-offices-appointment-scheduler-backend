package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City extends NamedEntity {
    @ManyToOne
    private Province province;
}
