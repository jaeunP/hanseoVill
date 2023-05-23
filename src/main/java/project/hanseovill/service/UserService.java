package project.hanseovill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.hanseovill.domain.User;
import project.hanseovill.domain.authority.UserAuthority;
import project.hanseovill.repository.UserRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        validateUser(user);

        user.setAuthority(UserAuthority.ADMIN);

        return user.getId();
    }

    
    // user의 유효성 검증
    private void validateUser(User user) {
        List<User> findMembers = userRepository.findByUserId(user.getUserId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

}
