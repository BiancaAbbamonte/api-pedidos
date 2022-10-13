package br.com.fiap.checkpoint2.business;

import br.com.fiap.checkpoint2.request.PedidoRequest;
import br.com.fiap.checkpoint2.response.PedidoResponse;

public interface AtualizarPedido {

    PedidoResponse execute(Long id, PedidoRequest request);

}
