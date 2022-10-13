package br.com.fiap.checkpoint2.mapper;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.request.PedidoRequest;
import br.com.fiap.checkpoint2.response.PedidoResponse;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(
          pedido.getId(),
          pedido.getDataPedido(),
          pedido.getCodigoCliente(),
          pedido.getDataCadastro(),
          pedido.getValorTotal()
        );
    }

    public Pedido toModel(PedidoRequest request) {
        return new Pedido(
                request.getDataPedido(),
                request.getCodigoCliente(),
                request.getDataCadastro(),
                request.getValorTotal()
        );
    }

}
