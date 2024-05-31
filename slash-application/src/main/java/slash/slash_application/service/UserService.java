package slash.slash_application.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import slash.slash_application.entity.UserEntity;
import slash.slash_application.entity.UserTweetEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slash.slash_application.repository.IUserRepository;
import slash.slash_application.repository.IUserTweetRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private static final List<String> GENDERS = Arrays.asList("male", "female");

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserTweetRepository iUserTweetRepository;

    @Transactional
    public String newUser(String email, String password) {
        if (isInputValid(email, password)) {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(email);
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptPwd = bcrypt.encode(password);
            userEntity.setPassword(encryptPwd);
            iUserRepository.save(userEntity);
            return "details are saved";
        }
        return "not saved";
    }

    private boolean isInputValid(String emailId, String password) {
        return true;
    }

    private boolean isDetailsValid(String name, String dateOfBirth, String phoneNumber, String gender) {
        if (!GENDERS.contains(gender)) {
            return false;
        }
        if (name.trim().isEmpty() || !name.replaceAll("\\s", "").matches("[a-zA-Z]+")) {
            return false;
        }
        if (!phoneNumber.matches("\\d+") || phoneNumber.length() != 10) {
            return false;
        }
        return true;
    }

    public Boolean userDetails(Long userId, String name, String dateOfBirth, String phoneNumber, String gender) {
        UserEntity byUserId = iUserRepository.findByUserId(userId);
        if (userId != null) {
            byUserId.setName(name);
            byUserId.setDateOfBirth(dateOfBirth);
            byUserId.setPhoneNumber(phoneNumber);
            byUserId.setGender(gender);
            iUserRepository.save(byUserId);
            return true;
        } else {
            return false;
        }
    }

    public Boolean userValid(String email, String password) {
        UserEntity byEmail = iUserRepository.findByEmail(email);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (bcrypt.matches(password, byEmail.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean userTweet(Long userId, String tweet) {
        if (userId != null) {
            UserTweetEntity userTweetEntity = new UserTweetEntity();
            userTweetEntity.setUserId(userId);
            userTweetEntity.setTweet(tweet);
            iUserTweetRepository.save(userTweetEntity);
            return true;
        }
        return false;
    }

    public List<UserTweetEntity> userFetchTweet(Long userId) {
        List<UserTweetEntity> response = new ArrayList<>();
        List<UserTweetEntity> userTweetEntity = iUserTweetRepository.findByUserId(userId);
        for (UserTweetEntity tweet : userTweetEntity){
            response.add(tweet);
        }
        return response;
    }
}
