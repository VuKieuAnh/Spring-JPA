package com.codegym.student.service.user;

import com.codegym.student.model.AppUser;
import com.codegym.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(AppUser model) {
        userRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.getUserByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) appUser.getRoles());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(appUser.getName(), appUser.getPassword(), authorities);
        return userDetails;
    }
}
