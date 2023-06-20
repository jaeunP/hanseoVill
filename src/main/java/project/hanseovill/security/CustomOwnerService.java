package project.hanseovill.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.hanseovill.domain.Owner;
import project.hanseovill.repository.OwnerRepository;

@RequiredArgsConstructor
@Service
public class CustomOwnerService implements UserDetailsService {

    private final OwnerRepository ownerRepository;

    public CustomOwner loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner owner = ownerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "이 존재하지 않습니다."));

        return new CustomOwner(owner);
    }
}
