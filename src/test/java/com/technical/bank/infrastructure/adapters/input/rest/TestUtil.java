package com.technical.bank.infrastructure.adapters.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface TestUtil {

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
