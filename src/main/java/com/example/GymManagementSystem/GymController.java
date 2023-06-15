package com.example.GymManagementSystem;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amresh Tripathy
 */


@RestController
public class GymController {

    GymService gymService = new GymService();

    @PostMapping("/addGym")
    public String addGym(@RequestBody Gym gym) {
        try {
            gymService.addGym(gym);
            return "Gym at location " + gym.getLocation() + " with id " + gym.getGymId() + " is added successfully.";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/getAllGym")
    public List<String> getAllGym() {
        return gymService.getAllGym();
    }

    @PostMapping("/addMember")
    public String addMember(@RequestParam int memberId, @RequestParam int trainerId, @RequestParam String location) {
        try {
            gymService.addMember(memberId, trainerId, location);
            return "A new member with id " + memberId + " is added successfully at " + location + " gym.";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/getAllMember")
    public List<Integer> getAllMember() {
        return gymService.getAllMember();
    }

    @PostMapping("/addTrainer")
    public String addTrainer(@RequestParam Integer trainerId, @RequestParam String location) {
        try {
            gymService.addTrainer(trainerId, location);
            return "New Trainer with id " + trainerId + " is added successfully to " + location + " gym.";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }

    @GetMapping("/getAllTrainer")
    public List<Integer> getAllTrainer() {
        return gymService.getAllTrainer();
    }

    @GetMapping("/getMemberHaveMaximumTrainer")
    public int getMemberHaveMaximumTrainer() {
        return gymService.getMemberHaveMaximumTrainer();
    }

    @GetMapping("/getTrainersWithGymMoreThan5")
    public int getTrainersWithGymMoreThan5() {
        return gymService.getTrainersWithGymMoreThan5();
    }
}
