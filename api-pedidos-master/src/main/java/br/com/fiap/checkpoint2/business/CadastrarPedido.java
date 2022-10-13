package br.com.fiap.checkpoint2.business;

import br.com.fiap.checkpoint2.request.PedidoRequest;
import br.com.fiap.checkpoint2.response.PedidoResponse;

public interface CadastrarPedido {

    PedidoResponse execute(PedidoRequest request);

}
