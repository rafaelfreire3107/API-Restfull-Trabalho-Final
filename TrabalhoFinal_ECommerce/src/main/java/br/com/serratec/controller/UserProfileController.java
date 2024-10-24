package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.model.UserProfile;
import br.com.serratec.service.UserProfileService;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public List<UserProfile> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public UserProfile getProfileById(@PathVariable Long id) {
        return userProfileService.getProfileById(id);
    }

    @PostMapping
    public UserProfile createProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createProfile(userProfile);
    }

    @PutMapping("/{id}")
    public UserProfile updateProfile(@PathVariable Long id, @RequestBody UserProfile updatedProfile) {
        return userProfileService.updateProfile(id, updatedProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        userProfileService.deleteProfile(id);
    }
}
