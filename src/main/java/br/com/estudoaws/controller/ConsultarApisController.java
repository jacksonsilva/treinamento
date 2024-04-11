package br.com.estudoaws.controller;

import br.com.estudoaws.model.Cep;
import br.com.estudoaws.model.Cliente;
import br.com.estudoaws.model.Estados;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ConsultarApisController {

    @GetMapping(path = "/api/cep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cep> consultaCep(@PathVariable("cep") String cep) throws Exception {
        String uri = String.format("https://viacep.com.br/ws/%s/json/", cep);
        RestTemplate restTemplate = new RestTemplate();

        //ResponseEntity<Cep> _cep = restTemplate.exchange(uri, HttpMethod.GET, null, Cep.class);
        Cep _cep = restTemplate.getForObject(uri, Cep.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(_cep);
    }

    @GetMapping(path = "/api/estados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estados>> listarEstados() throws Exception {
        String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
        RestTemplate restTemplate = new RestTemplate();

        Estados[] estados = restTemplate.getForEntity(uri, Estados[].class).getBody();
        List<Estados> result = Arrays.asList(estados);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
