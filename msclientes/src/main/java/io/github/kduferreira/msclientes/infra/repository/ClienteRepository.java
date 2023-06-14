package io.github.kduferreira.msclientes.infra.repository;

import io.github.kduferreira.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findBycpf(String cpf);
}
