package com.workers.userdetails;

import com.workers.presenters.models.user.UserInputImpl;
import com.workers.presenters.models.user.UserOutputImpl;
import com.workers.usecase.UserUseCase;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserUseCase userUseCase;

    public UserDetailsServiceImpl(UserUseCase userUseCase){
        this.userUseCase = userUseCase;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInputImpl impl = new UserInputImpl (null, username, null);
        UserOutputImpl output = (UserOutputImpl) userUseCase.findByEmail(impl);

        if (output.isError()) {
            throw new UsernameNotFoundException(output.getMessage());
        }

        UserDetails user = User.withUsername(output.getEmail()).password(output.getPassword()).authorities("USER").build();

        return user;

    }
}
