package com.example.demo.controler;

import com.example.demo.services.ElkService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ElkController {


        private final ElkService service;


        public ElkController(ElkService service) {
            this.service = service;
        }

        @GetMapping(value = "/hello")
        public String helloWorld() {
            log.info("Inside Hello World Function");
            String response = "Hello World! " + new Date();
            log.info("Response => {}",response);
            return response;
        }

        @GetMapping(value = "/Food-Details")
        public JSONArray foodDetails() {
            log.info("Inside Food Detail Function");
            return service.getAllFoodDetails();
        }
}
