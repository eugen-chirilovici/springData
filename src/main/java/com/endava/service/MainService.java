package com.endava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MainService {

    private final InsertEntitiesService insertEntitiesService;

    @PostConstruct
    void letsGo() {
        insertEntitiesService.insertEntities();
    }

}
