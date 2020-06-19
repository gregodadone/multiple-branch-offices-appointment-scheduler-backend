package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private PostType type;
    private int amountAvailable;
    private int amountEnabled;
    private int turnDuration;
    private BranchOffice branchOffice;
}
