package br.com.fiap.checkpoint2.business.impl;

import br.com.fiap.checkpoint2.business.AtualizarPedido;
import br.com.fiap.checkpoint2.exception.PedidoNotFoundException;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import br.com.fiap.checkpoint2.request.PedidoRequest;
import br.com.fiap.checkpoint2.response.PedidoResponse;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPedidoImpl implements AtualizarPedido {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public AtualizarPedidoImpl(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PedidoResponse execute(Long id, PedidoRequest request) {
        var pedido = repository.findById(id).orElseThrow(PedidoNotFoundException::new);
        pedido.update(mapper.toModel(request));
        repository.save(pedido);
        return mapper.toResponse(pedido);
    }
}
