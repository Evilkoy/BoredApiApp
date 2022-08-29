package com.makson.BoredBase.service.client;

import com.makson.BoredBase.dto.BoredDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoredClient {
    private static final String BORED_URL = "http://www.boredapi.com/api/activity";

    private final RestTemplate restTemplate;

    public Optional<BoredDto> getBored() {
        return Optional.ofNullable(restTemplate.getForEntity(BORED_URL, BoredDto.class).getBody());
    }
}
