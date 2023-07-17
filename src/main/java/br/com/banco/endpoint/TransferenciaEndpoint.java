package br.com.banco.endpoint;

import br.com.banco.repository.TransferenciaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("v1")
public class TransferenciaEndpoint {

    private final TransferenciaRepository transferenciaDAO;

    public TransferenciaEndpoint(TransferenciaRepository transferenciaDAO) {
        this.transferenciaDAO = transferenciaDAO;
    }

    @GetMapping(path = "transferencias")
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(transferenciaDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "transferencias/{dataInicio}/{dataFim}")
    public ResponseEntity<?> findTransferenciaByData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                     @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim){
        return new ResponseEntity<>(transferenciaDAO.findByDataTransferenciaBetween(
               dataInicio,
                dataFim),
                HttpStatus.OK);
    }

    @GetMapping(path = "transferencias/{nomeOperador}")
    public ResponseEntity<?> findTransferenciaByNomeOperador(@PathVariable String nomeOperador){
        return new ResponseEntity<>(transferenciaDAO.findByNomeOperadorTransacaoIgnoreCaseContaining(nomeOperador), HttpStatus.OK);
    }

    @GetMapping(path = "transferencias/{nomeOperador}/{dataInicio}/{dataFim}")
    public ResponseEntity<?> findByNomeOperadorAndDataTransferencia(@PathVariable String nomeOperador,
                                                                    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                                    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim){
        return new ResponseEntity<>(transferenciaDAO.findByNomeOperadorTransacaoIgnoreCaseContainingAndDataTransferenciaBetween(
                nomeOperador,
                dataInicio,
                dataFim),
                HttpStatus.OK);
    }

}
