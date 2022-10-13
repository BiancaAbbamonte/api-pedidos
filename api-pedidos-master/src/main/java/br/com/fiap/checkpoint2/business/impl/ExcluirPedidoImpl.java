package br.com.fiap.checkpoint2.business.impl;

import br.com.fiap.checkpoint2.business.ExcluirPedido;
import br.com.fiap.checkpoint2.exception.PedidoNotFoundException;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class ExcluirPedidoImpl implements ExcluirPedido {

    private final PedidoRepository repository;

    public ExcluirPedidoImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Long id) {
        if (!repository.existsById(id))
            throw new PedidoNotFoundException();
        repository.deleteById(id);
    }
}
