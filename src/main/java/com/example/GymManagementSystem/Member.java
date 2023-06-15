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
public class Member {
    private int memberId;
    private List<Trainer> trainerList;
    private Gym gym;

    public Member() {
        this.trainerList = new ArrayList<>();
        this.gym = new Gym();
    }

    public Member(int memberId, List<Trainer> trainerList, Gym gym) {
        this.memberId = memberId;
        this.trainerList = trainerList;
        this.gym = gym;
    }
}
