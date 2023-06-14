package io.github.kduferreira.mscartoes.application.representation;

import io.github.kduferreira.mscartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartoesporClienteController {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;



    public static CartoesporClienteController fromModel(ClienteCartao model) {
        return new CartoesporClienteController(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }
}
