package br.com.fiap.checkpoint2.builder;

import br.com.fiap.checkpoint2.model.Pedido;

import java.math.BigDecimal;
import java.time.Instant;

public class PedidoBuilder {

    private Instant dataPedido;
    private Long codigoCliente;
    private Instant dataCadastro;
    private BigDecimal valorTotal;

    public PedidoBuilder addDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
        return this;
    }

    public PedidoBuilder addCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
        return this;
    }

    public PedidoBuilder addDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public PedidoBuilder addValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Pedido build() {
        if (dataPedido == null || codigoCliente == null || dataCadastro == null || valorTotal == null)
            throw new IllegalArgumentException("Pedido inválido!");
        return new Pedido(dataPedido, codigoCliente, dataCadastro, valorTotal);
    }

}
