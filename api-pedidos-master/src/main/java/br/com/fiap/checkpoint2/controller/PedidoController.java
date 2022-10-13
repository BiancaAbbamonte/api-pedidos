package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.business.*;
import br.com.fiap.checkpoint2.request.PedidoRequest;
import br.com.fiap.checkpoint2.response.PedidoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Api(value = "API REST Pedidos")
public class PedidoController {

    private final ListarPedido listarPedido;
    private final BuscarPedido buscarPedido;
    private final CadastrarPedido cadastrarPedido;
    private final AtualizarPedido atualizarPedido;
    private final ExcluirPedido excluirPedido;

    public PedidoController(
            ListarPedido listarPedido,
            BuscarPedido buscarPedido,
            CadastrarPedido cadastrarPedido,
            AtualizarPedido atualizarPedido,
            ExcluirPedido excluirPedido
    ) {
        this.listarPedido = listarPedido;
        this.buscarPedido = buscarPedido;
        this.cadastrarPedido = cadastrarPedido;
        this.atualizarPedido = atualizarPedido;
        this.excluirPedido = excluirPedido;
    }

    @GetMapping
    @ApiOperation(value = "Listagem de pedidos")
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        var pedidosResponse = listarPedido.execute();
        return ResponseEntity.ok(pedidosResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca de pedido")
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable Long id) {
        var pedidoResponse = buscarPedido.execute(id);
        return ResponseEntity.ok(pedidoResponse);
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de pedido")
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest request) {
        var pedidoResponse = cadastrarPedido.execute(request);
        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedidoResponse.getId())
                .toUri();
        return ResponseEntity.created(location).body(pedidoResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualização de pedido")
    public ResponseEntity<PedidoResponse> atualizarPedido(@PathVariable Long id, @RequestBody @Valid PedidoRequest request) {
        var pedidoResponse = atualizarPedido.execute(id, request);
        return ResponseEntity.ok(pedidoResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclusão de pedido")
    public ResponseEntity excluirPedido(@PathVariable Long id) {
        excluirPedido.execute(id);
        return ResponseEntity.noContent().build();
    }

}
