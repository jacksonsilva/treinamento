package br.com.estudoaws.repository;

import br.com.estudoaws.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    Map<Long, Cliente> databaseInMemory = new HashMap<>();

    public Cliente salvar(Cliente cliente){
        Cliente _cliente = databaseInMemory.get(cliente.getId());
        //if (_cliente == null) {
            databaseInMemory.remove(cliente.getId());
            databaseInMemory.put(cliente.getId(), cliente);
        //}
        return cliente;
    }

    public Cliente recupera(Long id) {
        Cliente _cliente = databaseInMemory.get(id);

        return _cliente;
    }
}
