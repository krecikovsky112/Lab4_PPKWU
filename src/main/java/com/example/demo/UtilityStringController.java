package com.example.demo;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "string_utility_controller/")
public class UtilityStringController {
    String urlApi3 = "http://localhost:8081/string_utility_controller/string/";

    @GetMapping(value = "/{from}/txt/{text}", produces = {MediaType.TEXT_PLAIN_VALUE})
    String getTxtString(@PathVariable String from, @PathVariable String text) {
        String res =  new RestTemplate().getForObject(urlApi3 + text + "/" +  from , String.class);
        return ConverterString.convert(from,"txt",res);
    }

    @GetMapping(value = "/{from}/csv/{text}", produces = {MediaType.TEXT_PLAIN_VALUE})
    String getCsvString(@PathVariable String from, @PathVariable String text) {
        String res =  new RestTemplate().getForObject(urlApi3 + text + "/" +  from , String.class);
        return ConverterString.convert(from,"csv",res);
    }

    @GetMapping(value = "/{from}/json/{text}", produces = {MediaType.APPLICATION_JSON_VALUE})
    String getJsonString(@PathVariable String from, @PathVariable String text) {
        String res =  new RestTemplate().getForObject(urlApi3 + text + "/" +  from , String.class);
        return ConverterString.convert(from,"json",res);
    }

    @GetMapping(value = "/{from}/xml/{text}", produces = {MediaType.APPLICATION_XML_VALUE})
    String getXmlString(@PathVariable String from, @PathVariable String text) {
        String res =  new RestTemplate().getForObject(urlApi3 + text + "/" +  from , String.class);
        return ConverterString.convert(from,"xml",res);
    }
}
