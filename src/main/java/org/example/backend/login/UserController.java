package org.example.backend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginForm form) {
        String username = form.getUsername();
        String password = form.getPassword();
        Optional<User> user = userRepository.findByLoginId(username);
        System.out.println(user.get());
        return ResponseEntity.ok(user.get());
    }

    @GetMapping("/hi")
    public String hi(){

        return "signup";
    }



    // 로그인 폼을 위한 DTO 클래스
    public static class LoginForm {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        // getter, setter 생략
    }
}