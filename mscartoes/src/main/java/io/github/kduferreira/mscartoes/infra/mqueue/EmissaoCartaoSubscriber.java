package io.github.kduferreira.mscartoes.infra.mqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import io.github.kduferreira.mscartoes.domain.Cartao;
import io.github.kduferreira.mscartoes.domain.ClienteCartao;
import io.github.kduferreira.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import io.github.kduferreira.mscartoes.infra.repository.CartaoRepository;
import io.github.kduferreira.mscartoes.infra.repository.ClienteCartaoRepository;
import org.springframework.messaging.handler.annotation.Payload;
@Component
@RequiredArgsConstructor
@Slf4j
public class EmissaoCartaoSubscriber {
    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {
        try {

            var mapper = new ObjectMapper();
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartao);
            clienteCartao.setCpf(dados.getCpf());
            clienteCartao.setLimite(dados.getLimiteLiberado());


            clienteCartaoRepository.save(clienteCartao);
        } catch (Exception e) {
            log.error("Erro ao receber solicitacao de emissao de cartao: {} ", e.getMessage());
        }
    }
}
