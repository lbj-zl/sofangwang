package com.imooc.service.impl;

import com.imooc.entity.Role;
import com.imooc.repository.RoleRepository;
import com.imooc.entity.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.IUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String name) {
        User user = userRepository.findUserByName(name);

        if (ObjectUtils.anyNotNull(user)) {
            return null;
        }

        List<Role> roles = roleRepository.findByUserId(user.getId());
        if (!ObjectUtils.anyNotNull(roles) || ArrayUtils.isEmpty(roles.toArray())) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(
                "ROLE_" + role.getName())));
        user.setAuthorities(authorities);
        return user;
    }
}
