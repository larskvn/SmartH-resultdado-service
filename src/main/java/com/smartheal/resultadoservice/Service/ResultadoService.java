package com.smartheal.resultadoservice.Service;

import com.smartheal.resultadoservice.Entity.Resultado;

import java.util.List;
import java.util.Optional;

public interface ResultadoService {

    public List<Resultado> findAll();

    public List<Resultado> findAllCustom();

    public Optional<Resultado> findById(long Id);

    public List<Resultado> findByUserId(int idUser);

    public Resultado add(Resultado a);

    public Resultado update(Resultado a);

    public Resultado delete(Resultado a);
}
