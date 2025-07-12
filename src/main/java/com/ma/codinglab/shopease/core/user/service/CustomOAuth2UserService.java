package com.ma.codinglab.shopease.core.user.service;


import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.repository.IUserRepository;
import com.ma.codinglab.shopease.core.util.user.EUserAuthProvider;
import com.ma.codinglab.shopease.core.util.user.EUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final IUserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");

        Users user = userRepository.findByEmail(email).orElseGet(() -> {
            Users newUser = new Users();
            newUser.setEmail(email);
            newUser.setFirstname(oAuth2User.getAttribute("given_name"));
            newUser.setLastname(oAuth2User.getAttribute("family_name"));
            newUser.setAuthProvider(EUserAuthProvider.GOOGLE);
            newUser.setUserRole(EUserRole.CUSTOMER);
            return userRepository.save(newUser);
        });

        return new DefaultOAuth2User(
                Set.of(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name())),
                oAuth2User.getAttributes(),
                "email"
        );
    }

}
