package io.github.kduferreira.mscartoes.application;

import io.github.kduferreira.mscartoes.application.representation.CartaoSaveRequest;
import io.github.kduferreira.mscartoes.application.representation.CartoesporClienteController;
import io.github.kduferreira.mscartoes.application.representation.ClienteCartaoService;
import io.github.kduferreira.mscartoes.domain.Cartao;
import io.github.kduferreira.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("cartoes")
public class CartoesController {

    private final CartaoService cartaoService;

    private final ClienteCartaoService clienteCartaoService;
    @GetMapping
    public String status () {
        return "ok";
    }
    @PostMapping
    public ResponseEntity cadastrar (@RequestBody CartaoSaveRequest request) {
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda) {
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }
    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesporClienteController>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesporClienteController> resultList = lista.stream().map(CartoesporClienteController::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
