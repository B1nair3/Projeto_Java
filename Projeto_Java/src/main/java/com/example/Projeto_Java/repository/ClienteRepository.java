package com.example.Projeto_Java.repository;

import com.example.Projeto_Java.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author B1nair3
 */

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select c from Cliente c where nome like ?1%")
    public List<Cliente> findByNome(String nome);

    @Query("select c from Cliente c where email = ?1")
    public List<Cliente> findByEmail(String email);

    @Query("select c from Cliente c where nome like %?1% and email like %?2%")
    public List<Cliente> findByNomeEmail(String nome, String email);
}
