package br.com.fiap.checkpoint2.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
    private Instant dataPedido;

    @Column(nullable = false)
    private Long codigoCliente;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
    private Instant dataCadastro;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Deprecated
    public Pedido() {}

    public Pedido(Instant dataPedido, Long codigoCliente, Instant dataCadastro, BigDecimal valorTotal) {
        this.dataPedido = dataPedido;
        this.codigoCliente = codigoCliente;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
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

    public void update(Pedido otherPedido) {
        this.dataPedido = otherPedido.getDataPedido();
        this.codigoCliente = otherPedido.getCodigoCliente();
        this.dataCadastro = otherPedido.getDataCadastro();
        this.valorTotal = otherPedido.getValorTotal();
    }
}
