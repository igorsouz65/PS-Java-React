package br.com.banco.endpoint;

import br.com.banco.repository.TransferenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class TransferenciaEndpoint {

    private TransferenciaRepository transferenciaDAO;

    public TransferenciaEndpoint(TransferenciaRepository transferenciaDAO) {
        this.transferenciaDAO = transferenciaDAO;
    }

    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(transferenciaDAO.findAll(), HttpStatus.OK);
    }

}
