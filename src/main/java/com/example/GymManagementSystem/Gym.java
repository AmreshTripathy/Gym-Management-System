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
public class Gym {
    private int gymId;
    private String location;
    private List<Member> memberList;
    private List<Trainer> trainerList;

    public Gym() {
        memberList = new ArrayList<>();
        trainerList = new ArrayList<>();
    }

    public Gym(int gymId, String location, List<Member> memberList, List<Trainer> trainerList) {
        this.gymId = gymId;
        this.location = location;
        this.memberList = memberList;
        this.trainerList = trainerList;
    }
}
