package com.br.bandtec.avaliacao

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.ArrayList
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping




@RestController
@RequestMapping("/cliente")
class ClienteController {

    private val clientes = mutableListOf<Cliente>()

    //---------------

    @GetMapping("/{id}")
    fun pesquisarCliente(@PathVariable id: Int): ResponseEntity<*>? {
        return if (clientes.size >= id) {
            ResponseEntity.ok(clientes[id - 1])
        } else {
            ResponseEntity.notFound().build<Any>()
        }
    }

    //---------------

    @PostMapping("/novoCliente")
    fun novoCamisaC(@RequestBody novoCliente: Cliente?) {
        clientes.add(novoCliente!!)
    }

    //---------------

    @GetMapping("/clientes/maisRicos")
    fun pesquisarClienteRicos(@PathVariable id: Int): Any {
        return clientes.filter { item -> item.renda > 15000 }
    }

    //---------------

    @DeleteMapping("/")
    fun deletarCliente(@PathVariable id: Int){
        clientes.removeAt( id - 1)
    }



}