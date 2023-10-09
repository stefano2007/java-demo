package com.stefanodev.demo.service;

import com.stefanodev.demo.DTO.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    public void cadastrar(ClienteDTO cliente) {
        System.out.println(cliente);
    }

    public ClienteDTO recuperaPorCPF(String cpf) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCpf(cpf);
        clienteDTO.setEndereco("endereco Teste");
        clienteDTO.setNome("Alexandre Reis");
        clienteDTO.setTelefone("13-9551-5555");
        return clienteDTO;
    }

    public List<ClienteDTO> listar() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCpf("222.555.444-11");
        clienteDTO.setEndereco("endereco Teste");
        clienteDTO.setNome("Alexandre Reis");
        clienteDTO.setTelefone("13-9551-5555");

        ClienteDTO clienteDTO2 = new ClienteDTO();
        clienteDTO2.setCpf("111.222.888-22");
        clienteDTO2.setEndereco("endereco Teste");
        clienteDTO2.setNome("Antonio Reis");
        clienteDTO2.setTelefone("13-8888-5555");

        List<ClienteDTO> listaClientes = new ArrayList<>();
        listaClientes.add(clienteDTO);
        listaClientes.add(clienteDTO2);


        return listaClientes;

    }

    public void delete(String cpf) {
        System.out.println(cpf);
    }
}