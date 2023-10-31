package com.example.demoApi2.controller;

import com.example.demoApi2.model.Produto;
import com.example.demoApi2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author B1nair3
 */

@RestController
@RequestMapping("/apiProduto")
public class ProdutoControl {

    @Autowired
    ProdutoRepository prRepository;

    @PostMapping("/cadastrar")
    public void cadastrarProduto(@RequestBody Produto produto) {
        prRepository.save(produto);
    }

    @GetMapping("/buscar/todos")
    public List<Produto> buscarTodosProdutos() {
        return prRepository.findAll();
    }

    @GetMapping("/buscar/todos/codigo/{codigo}")
    public Optional<Produto> buscarProdutoCodigo(@PathVariable("codigo") int codigo) {
        return prRepository.findById(codigo);
    }

    @GetMapping("/buscar/todos/descricao/{descricao}")
    public List<Produto> buscarProdutoDescricao(@PathVariable("descricao") String descricao) {
        return prRepository.findByDescricao(descricao);
    }

    @GetMapping("/buscar/todos/precoMenorQue/{preco}")
    public List<Produto> buscarProdutoPrecoMenorQue(@PathVariable("preco") double preco) {
        return prRepository.findByPreco(preco);
    }

    @GetMapping("/buscar/todos/marca/{marca}")
    public List<Produto> buscarProdutoMarca(@PathVariable("marca") String marca) {
        return prRepository.findByMarca(marca);
    }

    @GetMapping("/buscar/todos/marcaPreco/{marca}/{preco}")
    public List<Produto> buscarProdutoMarcaPreco(@PathVariable("marca") String marca, @PathVariable("preco") double preco) {
        return prRepository.findByMarcaPreco(marca, preco);
    }

    @DeleteMapping("/deletar")
    public void deletarProduto(@RequestBody Produto produto) {
        prRepository.delete(produto);
    }

    @DeleteMapping("/deletar/codigo/{codigo}")
    public void deletarProdutoCodigo(@PathVariable("codigo") int codigo) {
        prRepository.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody Produto produto) {
        prRepository.save(produto);
    }
}
