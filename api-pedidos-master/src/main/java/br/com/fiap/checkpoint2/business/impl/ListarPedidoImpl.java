package br.com.fiap.checkpoint2.business.impl;

import br.com.fiap.checkpoint2.business.ListarPedido;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import br.com.fiap.checkpoint2.response.PedidoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPedidoImpl implements ListarPedido {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public ListarPedidoImpl(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PedidoResponse> execute() {
        var pedidos = repository.findAll();
        return pedidos.stream().map(mapper::toResponse).collect(Collectors.toList());
    }
}
