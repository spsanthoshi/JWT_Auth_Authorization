package com.neuron.admin_server.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.neuron.admin_server.domain.User;
import com.neuron.admin_server.domain.User_Role_Mapping;
import com.neuron.admin_server.repository.UserRepository;
import com.neuron.admin_server.service.UserRoleBusinessService;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    
    @Autowired
    private UserRoleBusinessService userRoleBussinessService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByEmail(username);
        if(userInfo.isPresent()) {
         List<User_Role_Mapping> userRoles = userRoleBussinessService.findByUserId(userInfo.get().getId());
          User user = userInfo.get();
         // user.setPassword(passwordEncoder.encode(user.getPassword()));
          user.setRoleNameList(new ArrayList<>());
          for(User_Role_Mapping userRole:userRoles) {
            user.getRoleNameList().add(userRole.getRole().getRoleName());
            return new UserInfoUserDetails(user);
          }
          
        }
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
