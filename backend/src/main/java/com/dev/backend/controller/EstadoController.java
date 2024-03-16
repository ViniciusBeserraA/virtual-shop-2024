package com.dev.backend.controller;


import com.dev.backend.model.Estado;
import com.dev.backend.service.EstadoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;
    @GetMapping("/listar")
    public List<Estado> listarEstados(){
        return estadoService.findAll();
    }
    @PostMapping("/inserir")
    public Estado inserir(@RequestBody Estado estado){
        return estadoService.insert(estado);
    }
    @PutMapping("/alterar")
    public Estado alterar(@RequestBody Estado estado){
        return estadoService.update(estado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        estadoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
