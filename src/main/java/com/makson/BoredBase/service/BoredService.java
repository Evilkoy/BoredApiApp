package com.makson.BoredBase.service;

import com.makson.BoredBase.dto.BoredDto;
import com.makson.BoredBase.service.client.BoredClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoredService {
    private final BoredClient boredClient;

    public List<BoredDto> getActivities(int activitiesCount) {
        List<BoredDto> activitiesList = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            boredClient.getDto().ifPresent(activitiesList::add);
        }
        return activitiesList;
    }

    public Optional<BoredDto> getBoredDto() {
        return boredClient.getDto();
    }
}
