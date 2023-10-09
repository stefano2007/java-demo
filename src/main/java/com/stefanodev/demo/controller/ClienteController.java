package com.stefanodev.demo.controller;

import com.stefanodev.demo.DTO.ClienteDTO;
import com.stefanodev.demo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    public ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastra(@RequestBody ClienteDTO clienteDTO){
        clienteService.cadastrar(clienteDTO);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteDTO.getCpf()).toUri()).build() ;
    }

    @GetMapping(path= "/{cpf}")
    public ResponseEntity<ClienteDTO> busca(@PathVariable String cpf){
        return ResponseEntity.ok(clienteService.recuperaPorCPF(cpf));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> lista(){
        return ResponseEntity.ok(clienteService.listar());
    }
    @PutMapping(value="/{cpf}")
    public ResponseEntity<ClienteDTO> atualiza(@PathVariable("cpf") String cpf,
                                               @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO record = clienteService.recuperaPorCPF(cpf);
        record.setNome(clienteDTO.getNome());
        record.setEndereco(clienteDTO.getEndereco());
        record.setTelefone(clienteDTO.getTelefone());
        return ResponseEntity.ok().body(record);
    }

    @DeleteMapping(path= "/{cpf}")
    public ResponseEntity<ClienteDTO> deleta(@PathVariable String cpf){
        clienteService.delete(cpf);
        return ResponseEntity.accepted().build();
    }
}