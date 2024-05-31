package slash.slash_application.controller;

import slash.slash_application.entity.UserTweetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slash.slash_application.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

//    @Autowired
//    public UserController userController;

    @Autowired
    private UserService userService;

    @PostMapping("/new/user")
    public ResponseEntity<String> newUser(@RequestParam("email") String email,
                                          @RequestParam("password") String password) {
        return new ResponseEntity<String>(userService.newUser(email.trim(), password.trim()), HttpStatus.OK);
    }

    @GetMapping("/user/details/valid")
    public ResponseEntity<Boolean> userValid(@RequestParam("emailid") String phoneNumber,
                                             @RequestParam("password") String emailId ) {
        return new ResponseEntity<Boolean>(userService.userValid(phoneNumber, emailId), HttpStatus.OK);
    }

    @PostMapping("/user/details")
    public ResponseEntity<Boolean> userDetails(@RequestParam("userid") Long userId,
                                               @RequestParam("name") String name,
                                               @RequestParam("dateofbirth") String dateOfBirth,
                                               @RequestParam("phonenumber") String phoneNumber,
                                               @RequestParam("gender") String gender) {
        return new ResponseEntity<Boolean>(userService.userDetails(userId, name.toLowerCase(), dateOfBirth, phoneNumber, gender.toLowerCase()), HttpStatus.OK);
    }

    @PostMapping("/user/tweet")
    public ResponseEntity<Boolean> userTweet(@RequestParam("userid") Long userId,
                                      @RequestParam("tweet") String tweet){
        return new ResponseEntity<Boolean>(userService.userTweet(userId, tweet), HttpStatus.OK);
    }

    @GetMapping("user/fetch/tweet")
    public ResponseEntity <List<UserTweetEntity>> userFetchTweet(@RequestParam("userid") Long userId){
        return new ResponseEntity <>(userService.userFetchTweet(userId), HttpStatus.OK);
    }
}
