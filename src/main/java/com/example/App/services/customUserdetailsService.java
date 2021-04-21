package com.example.App.services;

import com.example.App.Entities.User;
import com.example.App.repositories.UserRepository;
import com.example.App.util.customUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class customUserdetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =null;
          user =this.userRepository.findByUsername(s);

          if(user==null)
          {
              throw new UsernameNotFoundException("user 404");
          }
        return new customUserDetails(user);
    }

}
