package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaRepository extends PagingAndSortingRepository<Transferencia, Long> {

    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Transferencia> findByNomeOperadorTransacaoIgnoreCaseContaining(String nome);

    List<Transferencia> findByNomeOperadorTransacaoIgnoreCaseContainingAndDataTransferenciaBetween(String nome, LocalDateTime inicio, LocalDateTime fim);

}
