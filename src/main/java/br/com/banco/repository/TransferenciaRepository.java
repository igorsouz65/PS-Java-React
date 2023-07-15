package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransferenciaRepository extends PagingAndSortingRepository<Transferencia, Long> {
}
