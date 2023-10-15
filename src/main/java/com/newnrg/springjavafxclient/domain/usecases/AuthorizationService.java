package com.newnrg.springjavafxclient.domain.usecases;

import com.newnrg.springjavafxclient.data.User;
import com.newnrg.springjavafxclient.data.UserMapper;
import com.newnrg.springjavafxclient.domain.models.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
@Slf4j
public class AuthorizationService extends BaseClient {

    @Autowired
    public AuthorizationService(@Value("${newnrg-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    public User authorization(UserDto userDto) {
        log.info("Authorization user {}",  userDto);
        ResponseEntity<Object> response = post("/authorization", null, userDto);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Result {}", response.getBody().toString());
            return UserMapper.toUser(response.getBody(), userDto.getLogin());
        } else {

            //Error
            return null;
        }
    }
}
