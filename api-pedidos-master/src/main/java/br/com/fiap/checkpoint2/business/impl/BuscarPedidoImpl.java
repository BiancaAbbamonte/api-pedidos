package br.com.fiap.checkpoint2.business.impl;

import br.com.fiap.checkpoint2.business.BuscarPedido;
import br.com.fiap.checkpoint2.business.ListarPedido;
import br.com.fiap.checkpoint2.exception.PedidoNotFoundException;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import br.com.fiap.checkpoint2.response.PedidoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarPedidoImpl implements BuscarPedido {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public BuscarPedidoImpl(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PedidoResponse execute(Long id) {
        var optPedido = repository.findById(id);
        return optPedido.map(mapper::toResponse).orElseThrow(PedidoNotFoundException::new);
    }
}
