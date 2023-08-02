package com.technical.bank.infrastructure.adapters.input.rest.cliente;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.technical.bank.infrastructure.adapters.input.rest.TestUtil;
import com.technical.bank.infrastructure.adapters.input.rest.cliente.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteRestAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void validarCrearClienteYEliminarCliente() throws Exception {
        MvcResult response = mockMvc.perform(
                        MockMvcRequestBuilders.post("/cliente")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("[\n" +
                                        "    {\n" +
                                        "        \"identificacion\": \"9999\",\n" +
                                        "        \"nombres\": \"Jose Pedro\",\n" +
                                        "        \"genero\": \"Masculino\",\n" +
                                        "        \"edad\": 24,\n" +
                                        "        \"direccion\": \"Otavalo sn y principal \",\n" +
                                        "        \"telefono\": \"098254785\",\n" +
                                        "        \"contrasena\": \"1234\",\n" +
                                        "        \"estado\": true\n" +
                                        "    }\n" +
                                        "]")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponde = response.getResponse().getContentAsString();
        JsonArray jsonElements = new JsonParser().parse(jsonResponde).getAsJsonArray();

        String clienteId = jsonElements.get(0).getAsJsonObject().get("clienteId").getAsString();

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setClienteId(clienteId);

        List<ClienteDTO> clienteDTOS = Collections.singletonList(clienteDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/cliente")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.asJsonString(clienteDTOS))
                )
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}