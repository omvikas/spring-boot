package com.keeperCE.model;

import com.keeperCE.constants.RoleConstants;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
public class CustomUser implements UserDetails {
   private Users user;

   public CustomUser(Users user){
        this.user=user;
    }


    @Override
public Collection<? extends GrantedAuthority> getAuthorities() {

       return user.getRoles().stream().map(role->{
        return  new SimpleGrantedAuthority(RoleConstants.ROLE.getStringValues()+role.getRole());
    }).collect(Collectors.toList());
}

    @Override
    public String getUsername() {
        return user.getFirst_name();
    }
    @Override
     public String getPassword() {
        return user.getPassword();
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
}
