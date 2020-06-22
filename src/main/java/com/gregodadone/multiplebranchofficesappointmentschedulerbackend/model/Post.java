package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    @ApiModelProperty(value = "Post Type", required = true, position = 1)
    private PostType type;

    @Column
    @NotNull
    @ApiModelProperty(value = "How many posts of this type there are", example = "3", required = true, position = 2)
    private int amountAvailable;

    @Column
    @NotNull
    @ApiModelProperty(value = "How many posts are enabled", example = "3", required = true, position = 3)
    private int amountEnabled;

    @Column
    @NotNull
    @ApiModelProperty(value = "Turn duration in minutes", example = "30", required = true, position = 4)
    private int turnDuration; //minutes

    @ManyToOne
    @JoinColumn(name = "office_id")
    @ApiModelProperty(value = "Branch Office this post belongs to", required = true, position = 5)
    private BranchOffice branchOffice;
}
