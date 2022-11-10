package com.workers.userdetails;

import com.workers.presenters.models.UserInputImpl;
import com.workers.presenters.models.UserOutputImpl;
import com.workers.usecase.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserService userService;

    public UserDetailsServiceImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInputImpl impl = new UserInputImpl(username, null);
        UserOutputImpl output = (UserOutputImpl ) userService.findByEmail(impl);

        UserDetails user = User.withUsername(output.getEmail()).password(output.getPassword()).authorities("USER").build();

        return user;

    }
}
