package io.github.kduferreira.mscartoes.application.representation;

import io.github.kduferreira.mscartoes.domain.ClienteCartao;
import io.github.kduferreira.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {


    private final ClienteCartaoRepository repository;


    public List<ClienteCartao> listCartoesByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
