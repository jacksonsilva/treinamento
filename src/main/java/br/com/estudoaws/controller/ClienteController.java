package br.com.estudoaws.controller;

import br.com.estudoaws.error.CustomErrorResponse;
import br.com.estudoaws.model.Cliente;
import br.com.estudoaws.repository.ClienteRepository;
import br.com.estudoaws.repository.ClienteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(path = "/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> consultar(@PathVariable("id") Long id) throws Exception {
        Cliente _cliente = clienteRepository.recupera(id);
        if (_cliente == null) {
            throw new Exception("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(_cliente);
    }

    @PutMapping(path = "/cliente/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> consultar(@PathVariable("id") Long id, @RequestBody Cliente cliente) throws Exception {

        Cliente _cliente = clienteRepository.recupera(cliente.getId());
        if (_cliente == null) {
            throw new Exception("Cliente não encontrado!");
        }
        _cliente = clienteRepository.salvar(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(_cliente);
    }

    @PostMapping(path = "/cliente/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultar(@RequestBody Cliente cliente) throws Exception {

        Cliente _cliente;
        _cliente = clienteRepository.recupera(cliente.getId());
        if (_cliente == null) {
            _cliente = clienteRepository.salvar(cliente);
        }
        return ResponseEntity.ok("OK");
    }


}