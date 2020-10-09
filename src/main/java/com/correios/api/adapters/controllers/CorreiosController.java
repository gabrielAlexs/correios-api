package com.correios.api.adapters.controllers;


import com.correios.api.domain.ports.CorreiosPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/entregas")
public class CorreiosController {

    @Autowired
    CorreiosPort correiosService;

    @Autowired
    ModelMapper mapper;

    @GetMapping
    public ResponseEntity<String> retornarDataMaxima(@RequestBody LinkedHashMap<String,String> dados){

        MaxDeliveryDateRequest apiRequest = mapper.map(dados,MaxDeliveryDateRequest.class);

        String maxDeliveryDate = correiosService.getMaxDeliveryDate(apiRequest);

        return new ResponseEntity<>("Data máxima de entrega do CEP " + apiRequest.getsCepOrigem() +
                 " ao " + apiRequest.getsCepDestino() + ": " + maxDeliveryDate,HttpStatus.OK);
    }
}
