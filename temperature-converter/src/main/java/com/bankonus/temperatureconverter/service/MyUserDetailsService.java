package com.bankonus.temperatureconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankonus.temperatureconverter.dao.UserRepository;
import com.bankonus.temperatureconverter.model.Users;

/**
 * 
 * @author setubauva
 *
 *         Service class to load users
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("User not found");

        return new UserPrincipal(user);
    }

}
