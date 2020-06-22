package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PostType type;

    @Column
    private int amountAvailable;

    @Column
    private int amountEnabled;

    @Column
    private int turnDuration;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private BranchOffice branchOffice;
}
