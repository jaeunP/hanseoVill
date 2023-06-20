package project.hanseovill.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.hanseovill.domain.Owner;
import project.hanseovill.domain.Role;

import java.util.ArrayList;
import java.util.Collection;

public class CustomOwner implements UserDetails {

    private final Owner owner;

    public CustomOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String getPassword() {
        return owner.getPassword();
    }

    @Override
    public String getUsername() {
        return owner.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role userRole = owner.getRole();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.toString());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        return authorities;
    }
}
