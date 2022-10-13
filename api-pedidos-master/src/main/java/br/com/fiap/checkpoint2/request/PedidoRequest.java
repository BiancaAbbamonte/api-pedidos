package br.com.fiap.checkpoint2.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

public class PedidoRequest {

    @NotNull
    @JsonProperty
    private Instant dataPedido;

    @NotNull
    @JsonProperty
    private Long codigoCliente;

    @NotNull
    @JsonProperty
    private Instant dataCadastro;

    @NotNull
    @DecimalMin(value = "0.01")
    @JsonProperty
    private BigDecimal valorTotal;

    @Deprecated
    public PedidoRequest() {}

    public PedidoRequest(Instant dataPedido, Long codigoCliente, Instant dataCadastro, BigDecimal valorTotal) {
        this.dataPedido = dataPedido;
        this.codigoCliente = codigoCliente;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
