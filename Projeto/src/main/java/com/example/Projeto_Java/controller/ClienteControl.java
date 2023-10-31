package com.example.demoApi2.controller;

import com.example.demoApi2.model.Cliente;
import com.example.demoApi2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author B1nair3
 */

@RestController
@RequestMapping("/apiCliente")
public class ClienteControl {

    @Autowired
    ClienteRepository clRepository;

    @PostMapping("/cadastrar")
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        clRepository.save(cliente);
    }

    @GetMapping("/buscar/todos")
    public List<Cliente> buscarTodosCliente() {
        return clRepository.findAll();
    }

    @GetMapping("/buscar/todos/codigo/{codigo}")
    public Optional<Cliente> buscarClienteCodigo(@PathVariable("codigo") int codigo) {
        return clRepository.findById(codigo);
    }

    @GetMapping("/buscar/todos/nome/{nome}")
    public List<Cliente> buscarClienteNome(@PathVariable("nome") String nome) {
        return clRepository.findByNome(nome);
    }

    @GetMapping("/buscar/todos/email/{email}")
    public List<Cliente> buscarClienteEmail(@PathVariable("email") String email) {
        return clRepository.findByEmail(email);
    }

    @GetMapping("/buscar/todos/nomeEmail/{nome}/{email}")
    public List<Cliente> buscarClienteNomeEmail(@PathVariable("nome") String nome, @PathVariable("email") String email) {
        return clRepository.findByNomeEmail(nome, email);
    }

    @DeleteMapping("/deletar")
    public void deletarCliente(@RequestBody Cliente cliente) {
        clRepository.delete(cliente);
    }

    @DeleteMapping("/deletar/codigo/{codigo}")
    public void deletarClienteCodigo(@PathVariable("codigo") int codigo) {
        clRepository.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cliente) {
        clRepository.save(cliente);
    }
}
