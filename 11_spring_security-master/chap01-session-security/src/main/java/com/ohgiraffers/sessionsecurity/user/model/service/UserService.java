package com.ohgiraffers.sessionsecurity.user.model.service;

import com.ohgiraffers.sessionsecurity.common.UserRole;
import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import com.ohgiraffers.sessionsecurity.user.model.entity.User;
import com.ohgiraffers.sessionsecurity.user.model.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public int regist(SignupDTO signupDTO) {
        try {
            User user = new User();
            user.setUsername(signupDTO.getUserId());
            user.setName(signupDTO.getUserName());
            user.setPassword(passwordEncoder.encode(signupDTO.getUserPass()));
            user.setRole(UserRole.valueOf(signupDTO.getRole()));
            
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public LoginUserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
            
        return new LoginUserDTO(
            user.getId(),
            user.getUsername(),
            user.getName(),
            user.getPassword(),
            user.getRole()
        );
    }
}
