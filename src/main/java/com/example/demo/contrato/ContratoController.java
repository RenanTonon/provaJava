package com.example.demo.contrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/contrato")
@RestController
public class ContratoController {
    @Autowired
    private ContratoService contratoService;
    private ContratoSchema criaContrato(@RequestBody ContratoSchema objContrato){
        return this.contratoService.criaContrato(objContrato);
    }
}
