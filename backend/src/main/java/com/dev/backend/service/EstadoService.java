package com.dev.backend.service;

import com.dev.backend.model.Estado;
import com.dev.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }
    public Estado insert(Estado estado){
        estado.setDataCriacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }
    public Estado update(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void delete(Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        estadoRepository.delete(estado.get());
    }
}
