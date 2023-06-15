package com.example.GymManagementSystem;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amresh Tripathy
 */

@Getter
@Setter
public class Trainer {
    private int trainerId;
    private List<Member> memberList;
    private List<Gym> gymList;

    public Trainer() {
        this.trainerId = 0;
        this.memberList = new ArrayList<>();
        this.gymList = new ArrayList<>();
    }

    public Trainer(int trainerId, List<Member> memberList, List<Gym> gymList) {
        this.trainerId = trainerId;
        this.memberList = memberList;
        this.gymList = gymList;
    }
}
