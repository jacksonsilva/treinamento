package br.com.estudoaws.controller;

import br.com.estudoaws.model.Cliente;
import br.com.estudoaws.model.Endereco;
import br.com.estudoaws.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping(path = "/endereco/{id}")
    public ResponseEntity<Endereco> consultar(@PathVariable("id") Long id) throws Exception {
        Endereco _endereco = enderecoRepository.recupera(id);
        if (_endereco == null) {
            throw new Exception("Endereco não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(_endereco);
    }

    @PutMapping(path = "/endereco/{id}")
    public ResponseEntity<Endereco> consultar(@PathVariable("id") Long id, @RequestBody Endereco endereco) throws Exception {
        Endereco _endereco = enderecoRepository.recupera(id);
        if (_endereco == null) {
            throw new Exception("Endereco não encontrado!");
        }
        _endereco = enderecoRepository.salvar(endereco);
        return ResponseEntity.status(HttpStatus.OK).body(_endereco);
    }
}
