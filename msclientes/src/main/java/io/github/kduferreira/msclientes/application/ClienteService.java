package io.github.kduferreira.msclientes.application;

import io.github.kduferreira.msclientes.domain.Cliente;
import io.github.kduferreira.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    public Optional<Cliente> getByCPF(String cpf) {
        return repository.findBycpf(cpf);
    }
}
