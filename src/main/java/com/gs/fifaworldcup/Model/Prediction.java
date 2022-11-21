package com.gs.fifaworldcup.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Prediction {

    @Id
    private String kerb;

    private String GroupATopper;
    private String GroupARunnerUp;

    private String GroupBTopper;
    private String GroupBRunnerUp;

    private String GroupCTopper;
    private String GroupCRunnerUp;

    private String GroupDTopper;
    private String GroupDRunnerUp;

    private String GroupETopper;
    private String GroupERunnerUp;

    private String GroupFTopper;
    private String GroupFRunnerUp;

    private String GroupGTopper;
    private String GroupGRunnerUp;

    private String GroupHTopper;
    private String GroupHRunnerUp;

    private String QF1Winner;
    private String QF2Winner;
    private String QF3Winner;
    private String QF4Winner;

    private String SF1Winner;
    private String SF2Winner;

    private String Champion;

}
