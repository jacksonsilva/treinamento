package br.com.estudoaws.repository;

import br.com.estudoaws.model.Cliente;

public interface ClienteRepository {

    Cliente salvar(Cliente cliente);
    Cliente recupera(Long id);
}
