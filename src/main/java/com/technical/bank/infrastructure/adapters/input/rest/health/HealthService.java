package com.technical.bank.infrastructure.adapters.input.rest.health;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthService {

    @GetMapping
    public boolean getHealthStatua(){
        return Boolean.TRUE;
    }
}
