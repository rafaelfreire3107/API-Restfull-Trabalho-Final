package br.com.serratec.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.model.UserProfile;
import br.com.serratec.repository.UserProfileRepository;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }

    public UserProfile getProfileById(Long id) {
        return userProfileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public UserProfile createProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateProfile(Long id, UserProfile updatedProfile) {
        UserProfile userProfile = getProfileById(id);
        userProfile.setName(updatedProfile.getName());
        userProfile.setEmail(updatedProfile.getEmail());
        userProfile.setAddress(updatedProfile.getAddress());
        return userProfileRepository.save(userProfile);
    }

    public void deleteProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
