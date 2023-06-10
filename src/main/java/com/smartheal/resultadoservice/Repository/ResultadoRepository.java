package com.smartheal.resultadoservice.Repository;

import com.smartheal.resultadoservice.Entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoRepository  extends JpaRepository<Resultado, Long> {
    @Query("Select r from Resultado r where r.state='1' ")
    List<Resultado> findAllCustom();

    @Query("SELECT r FROM Resultado r WHERE r.idUser = :idUser")
    List<Resultado> findByUserId(@Param("idUser") int idUser);





}
