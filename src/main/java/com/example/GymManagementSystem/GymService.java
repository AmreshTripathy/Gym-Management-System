package com.example.GymManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amresh Tripathy
 */
public class GymService {

    GymRepository gymRepository = new GymRepository();

    public void addGym(Gym gym) throws Exception{
        if (isAlreadyPresent(gym))
            throw new Exception("At " + gym.getLocation() + " location already a gym with id " + gym.getGymId() + " is present. Please give a another id!");

        gymRepository.getGymList().add(gym);
    }

    private boolean isAlreadyPresent(Gym gym) {
        for (Gym gym1 : gymRepository.getGymList()) {
            if (gym.getGymId() == gym1.getGymId() && gym.getLocation().equals(gym1.getLocation()))
                return true;
        }

        return false;
    }


    public List<String> getAllGym() {
        List<String> locations = new ArrayList<>();
        for (Gym gym : gymRepository.getGymList())
            locations.add(gym.getLocation());

        return locations;
    }

    public void addMember(int memberId, int trainerId, String location) throws Exception {
        Gym gym = getGymByLocation(location);

        if (gym == null)
            throw new Exception("Gym at location " + location + " is not present.");

        Trainer trainer = getTrainerById(trainerId, gym.getTrainerList());

        if (trainer == null)
            throw new Exception("Trainer with id " + trainerId + " is not present at " + location + " gym.");

        Member member = getMemberWithIdAndGym(memberId, location, gymRepository.getMemberList(), trainer);
        if (member == null) {
            Member member1 = new Member();
            member1.setMemberId(memberId);
            member1.getTrainerList().add(trainer);
            member1.setGym(gym);
            gymRepository.getMemberList().add(member1);

            setMemberAtGym(location, member1);
        }

    }

    private void setMemberAtGym(String location, Member member1) {
        for (Gym gym : gymRepository.getGymList()) {
            if (gym.getLocation().equals(location)) {
                gym.getMemberList().add(member1);
            }
        }
    }

    private Member getMemberWithIdAndGym(int memberId, String location, List<Member> memberList, Trainer trainer) {
        for (Member member : memberList) {
            if (member.getMemberId() == memberId && member.getGym().getLocation().equals(location)) {
                member.getTrainerList().add(trainer);
                return member;
            }
        }
        return null;
    }

    private Trainer getTrainerById(int trainerId, List<Trainer> trainerList) {
        for (Trainer trainer : trainerList) {
            if (trainer.getTrainerId() == trainerId)
                return trainer;
        }
        return null;
    }

    private Gym getGymByLocation(String location) {
        for (Gym gym : gymRepository.getGymList()) {
            if (gym.getLocation().equals(location)) {
                return gym;
            }
        }
        return null;
    }

    public List<Integer> getAllMember() {
        List<Integer> ids = new ArrayList<>();
        for (Member member : gymRepository.getMemberList())
            ids.add(member.getMemberId());

        return ids;
    }

    public void addTrainer(int trainerId, String location) throws Exception {
        Gym gym = getGymByLocation(location);
        if (gym == null)
            throw new Exception("No Gym present at location " + location);

        if (trainerExist(trainerId, gym)) {
            return;
        }

        Trainer trainer = new Trainer();
        trainer.setTrainerId(trainerId);
        trainer.getGymList().add(gym);
        gymRepository.getTrainerList().add(trainer);

        setTrainerAtGym(location, trainer);
    }

    private boolean trainerExist(int trainerId, Gym gym) {
        for (Trainer trainer : gymRepository.getTrainerList()) {
            if (trainer.getTrainerId() == trainerId) {
                trainer.getGymList().add(gym);
                setTrainerAtGym(gym.getLocation(), trainer);
                return true;
            }
        }
        return false;
    }

    private void setTrainerAtGym(String location, Trainer trainer) {
        for (Gym gym : gymRepository.getGymList()) {
            if (gym.getLocation().equals(location))
                gym.getTrainerList().add(trainer);
        }
    }


    public List<Integer> getAllTrainer() {
        List<Integer> ids = new ArrayList<>();
        for (Trainer trainer : gymRepository.getTrainerList())
            ids.add(trainer.getTrainerId());

        return ids;
    }

    public int getMemberHaveMaximumTrainer() {
        int size = 0;
        Member member = new Member();

        for (Member member1 : gymRepository.getMemberList()) {
            if (member1.getTrainerList().size() > size) {
                member = member1;
                size = member1.getTrainerList().size();
            }
        }

        return member.getMemberId();
    }


    public int getTrainersWithGymMoreThan5() {
        int count = 0;

        for (Trainer trainer : gymRepository.getTrainerList()) {
            if (trainer.getGymList().size() > 5)
                count++;
        }

        return count;
    }
}
