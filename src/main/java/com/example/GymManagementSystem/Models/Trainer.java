package com.example.GymManagementSystem.Models;

import com.example.GymManagementSystem.Models.Gym;
import com.example.GymManagementSystem.Models.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<Member> memberList;

    @JsonIgnore
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
