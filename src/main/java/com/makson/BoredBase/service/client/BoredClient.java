package com.makson.BoredBase.service.client;

import com.makson.BoredBase.dto.BoredDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoredClient {
    private final WebClient webClient = WebClient.create();

    public Optional<BoredDto> getDto() {
        return Optional.ofNullable(webClient
                .get()
                .uri("https://www.boredapi.com/api/activity")
                .retrieve()
                .bodyToMono(BoredDto.class)
                .block());
    }
}
