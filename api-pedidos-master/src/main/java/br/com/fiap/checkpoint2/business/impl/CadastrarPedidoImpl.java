package br.com.fiap.checkpoint2.business.impl;

import br.com.fiap.checkpoint2.business.CadastrarPedido;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import br.com.fiap.checkpoint2.request.PedidoRequest;
import br.com.fiap.checkpoint2.response.PedidoResponse;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPedidoImpl implements CadastrarPedido {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public CadastrarPedidoImpl(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PedidoResponse execute(PedidoRequest request) {
        var pedido = repository.save(mapper.toModel(request));
        return mapper.toResponse(pedido);
    }
}
