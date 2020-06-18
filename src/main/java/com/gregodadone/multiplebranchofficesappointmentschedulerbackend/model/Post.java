package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.Minutes;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private PostType type;
    private int amountAvailable;
    private int amountEnabled;
    private Minutes turnDuration;
    private BranchOffice branchOffice;
}
