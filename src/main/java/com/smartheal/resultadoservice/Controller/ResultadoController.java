package com.smartheal.resultadoservice.Controller;

import com.smartheal.resultadoservice.Entity.Resultado;
import com.smartheal.resultadoservice.Service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resultado")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
    public List<Resultado> findAll(){
        return resultadoService.findAll();
    }

    @GetMapping("/Custom")
    public  List<Resultado> findAllCustom(){
        return resultadoService.findAllCustom();
    }

    /*
    @GetMapping("/{id}")
    public Optional<Resultado> findById(@PathVariable Long id){
        return resultadoService.findById(id);
    }*/

    @GetMapping("/byuser/{idUser}")
    public ResponseEntity<List<Resultado>> getByUserId(@PathVariable("idUser") int idUser){
        List<Resultado> resultados= resultadoService.findByUserId(idUser);
        if (resultados.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(resultados);

    }

    @PostMapping
    public Resultado add(@RequestBody Resultado r){
        return resultadoService.add(r);
    }

    @PutMapping("/{id}")
    public Resultado update(@PathVariable Long id, @RequestBody Resultado r){
        r.setIdResult(id);
        return resultadoService.update(r);
    }

    @DeleteMapping("/{id}")
    public Resultado delete(@PathVariable Long id){
        Resultado resultado = new Resultado();
        resultado.setState(false);
        return resultadoService.delete(Resultado.builder().idResult(id).build());
    }




}
