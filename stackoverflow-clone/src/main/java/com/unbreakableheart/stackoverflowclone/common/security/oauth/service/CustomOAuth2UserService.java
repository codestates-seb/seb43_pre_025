package com.unbreakableheart.stackoverflowclone.common.security.oauth.service;

import com.unbreakableheart.stackoverflowclone.common.security.oauth.CustomOAuth2User;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.OAuthAttributes;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.userinfo.ProviderType;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("CustomOAuth2UserSerivce.loadUser() 실행 - OAuth2 로그인 요청 진입");

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String provider = userRequest.getClientRegistration()
                .getRegistrationId();
        ProviderType providerType = getProviderType(provider);
        String providerId = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        log.info("provider : {} ", provider);
        log.info("providerId : {}", providerId);

        OAuthAttributes oAuthAttributes = OAuthAttributes.of(providerType, providerId, attributes);

        log.info("username : {}", oAuthAttributes.getOAuth2UserInfo().getName());
        log.info("email : {}", oAuthAttributes.getOAuth2UserInfo().getEmail());

        User user = getUser(oAuthAttributes, providerType);

        log.info("CustomOAuth2UserSerivce.loadUser() 종료");
        return CustomOAuth2User.of(user, attributes, oAuthAttributes);
    }

    private ProviderType getProviderType(String provider) {
        if (provider.equals("naver")) {
            return ProviderType.NAVER;
        }
        if (provider.equals("kakao")) {
            return ProviderType.KAKAO;
        }
        return ProviderType.GOOGLE;
    }

    private User getUser(OAuthAttributes attributes, ProviderType providerType) {
        return userRepository.findByEmail(attributes.getOAuth2UserInfo().getEmail())
                .orElseGet(() -> createUser(attributes, providerType));
    }

    private User createUser(OAuthAttributes attributes, ProviderType providerType) {
        User user = attributes.toEntity(providerType,
                attributes.getOAuth2UserInfo(),
                passwordEncoder);
        return userRepository.save(user);
    }
}
