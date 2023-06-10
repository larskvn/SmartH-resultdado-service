package com.smartheal.resultadoservice.Service;

import com.smartheal.resultadoservice.Entity.Resultado;
import com.smartheal.resultadoservice.Repository.ResultadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoServiceImpl implements ResultadoService{
    @Autowired
    private ResultadoRepository resultadoRepository;

    @Override
    public List<Resultado> findAll() {
       return resultadoRepository.findAll();
    }

    @Override
    public List<Resultado> findAllCustom() {
        return  resultadoRepository.findAllCustom();
    }

    @Override
    public Optional<Resultado> findById(long Id) {
        return  resultadoRepository.findById(Id);
    }

    @Override
    public List<Resultado> findByUserId(int idUser) {
        return resultadoRepository.findByUserId(idUser);
    }

    @Override
    public Resultado add(Resultado a) {
        return resultadoRepository.save(a);
    }

    @Override
    public Resultado update(Resultado a) {
        Resultado resultado = resultadoRepository.getById(a.getIdResult());
        BeanUtils.copyProperties(a,resultado);
        return resultadoRepository.save(resultado);
    }

    @Override
    public Resultado delete(Resultado a) {
        Resultado resultado = resultadoRepository.getById(a.getIdResult());
        resultado.setState(Boolean.FALSE);
        return resultadoRepository.save(resultado);
    }

}
