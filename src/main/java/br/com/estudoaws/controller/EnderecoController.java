package br.com.estudoaws.controller;

import br.com.estudoaws.model.Cliente;
import br.com.estudoaws.model.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnderecoController {

    @GetMapping(path = "/endereco/{id}")
    public ResponseEntity<Endereco> consultar(@PathVariable("id") Long id) {
        Endereco endereco = new Endereco();
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @PutMapping(path = "/endereco/{id}")
    public ResponseEntity<Endereco> consultar(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }
}
