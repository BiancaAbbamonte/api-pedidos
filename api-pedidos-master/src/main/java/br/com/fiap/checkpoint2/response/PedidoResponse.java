package br.com.fiap.checkpoint2.response;

import br.com.fiap.checkpoint2.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

public class PedidoResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Instant dataPedido;

    @JsonProperty
    private Long codigoCliente;

    @JsonProperty
    private Instant dataCadastro;

    @JsonProperty
    private BigDecimal valorTotal;

    public PedidoResponse(Long id, Instant dataPedido, Long codigoCliente, Instant dataCadastro, BigDecimal valorTotal) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.codigoCliente = codigoCliente;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }
}
