package com.example.GymManagementSystem.Repository;

import com.example.GymManagementSystem.Models.Member;
import com.example.GymManagementSystem.Models.Gym;
import com.example.GymManagementSystem.Models.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amresh Tripathy
 */
public class GymRepository {
    private List<Gym> gymList;
    private List<Member> memberList;
    private List<Trainer> trainerList;

    public GymRepository() {
        gymList = new ArrayList<>();
        memberList = new ArrayList<>();
        trainerList = new ArrayList<>();
    }

    public List<Gym> getGymList() {
        return gymList;
    }

    public void setGymList(List<Gym> gymList) {
        this.gymList = gymList;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }
}
