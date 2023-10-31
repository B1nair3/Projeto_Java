package com.example.demoApi2.repository;

import com.example.demoApi2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author B1nair3
 */

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("select p from Produto p where descricao like ?1%")
    public List<Produto> findByDescricao(String descricao);

    @Query("select p from Produto p where preco < ?1")
    public List<Produto> findByPreco(double preco);

    @Query("select p from Produto p where marca = ?1")
    public List<Produto> findByMarca(String marca);

    @Query("select p from Produto p where marca like %?1% and preco < ?2")
    public List<Produto> findByMarcaPreco(String marca, double preco);
}
