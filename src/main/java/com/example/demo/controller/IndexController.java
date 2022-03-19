package com.example.demo.controller;

import com.example.demo.dao.ClienteDao;
import com.example.demo.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteDao clienteDao;

    @RequestMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se una arquitectura MVC");

        var mensaje = "Mensaje desde el controlador";
        model.addAttribute("Mensaje", mensaje);

        Cliente cliente = new Cliente("Alejandro", "Mendez Sequeira", "ale01sequeira@hotmail.com", "63716090");
        model.addAttribute(cliente);

        Cliente cliente2 = new Cliente("Pedro", "Chavarria Sequeira", "pedro01sequeira@hotmail.com", "58964163");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes", clientes);

        // clienteDao.save(cliente2);
        
       // var clientesDB = clienteDao.findById(Long.parseLong("2"));
       // model.addAttribute("clientesDB", clientesDB);
        
        return "Index";
    }

}
