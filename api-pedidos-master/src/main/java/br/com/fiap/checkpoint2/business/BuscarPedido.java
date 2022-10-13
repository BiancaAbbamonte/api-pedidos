package br.com.fiap.checkpoint2.business;

import br.com.fiap.checkpoint2.response.PedidoResponse;

public interface BuscarPedido {

    PedidoResponse execute(Long id);

}
