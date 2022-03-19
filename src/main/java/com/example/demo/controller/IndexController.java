package com.example.demo.controller;

//import com.example.demo.dao.ClienteDao;
import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    //private ClienteDao clienteDao;
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");

        var mensaje = "Mensaje desde el controlador";
        model.addAttribute("Mensaje", mensaje);

        Cliente cliente = new Cliente("Alejandro", "Mendez Sequeira", "ale01sequeira@hotmail.com", "63716090");
        model.addAttribute(cliente);

        Cliente cliente2 = new Cliente("Pedro", "Chavarria Sequeira", "pedro01sequeira@hotmail.com", "58964163");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes", clientes);

        // clienteDao.save(cliente2);
        //var clientesDB = clienteDao.findAll();
        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB", clientesDB);

        return "Index";
    }

    
    @GetMapping("/nuevoCliente")
    public String  nuevoCliente (Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente (Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente (Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente",respuesta);
        return "modificarCliente";
    }
    
    @GetMapping ("/eliminarCliente/{idcliente}")
    public String eliminarCliente (Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    
    
}
