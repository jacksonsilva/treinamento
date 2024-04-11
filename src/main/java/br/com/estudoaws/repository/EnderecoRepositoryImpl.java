package br.com.estudoaws.repository;

import br.com.estudoaws.model.Cliente;
import br.com.estudoaws.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    Map<Long, Endereco> databaseInMemory = new HashMap<>();

    public Endereco salvar(Endereco cliente){
        Endereco _cliente = databaseInMemory.get(cliente.getId());
        //if (_cliente == null) {
        databaseInMemory.remove(cliente.getId());
        databaseInMemory.put(cliente.getId(), cliente);
        //}
        return cliente;
    }

    public Endereco recupera(Long id) {
        Endereco _endereco = databaseInMemory.get(id);
        return _endereco;
    }
}
