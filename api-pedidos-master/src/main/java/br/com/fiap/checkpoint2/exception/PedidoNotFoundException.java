package br.com.fiap.checkpoint2.exception;

public class PedidoNotFoundException extends BusinessException {

    public PedidoNotFoundException() {
        super("Pedido não encontrado.");
    }

}
