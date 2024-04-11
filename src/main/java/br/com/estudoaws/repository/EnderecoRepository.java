package br.com.estudoaws.repository;

import br.com.estudoaws.model.Cliente;
import br.com.estudoaws.model.Endereco;

public interface EnderecoRepository {
    Endereco salvar(Endereco endereco);
    Endereco recupera(Long id);
}
