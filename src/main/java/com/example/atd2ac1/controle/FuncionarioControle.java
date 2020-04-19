package com.example.atd2ac1.controle;

import java.util.List;

import com.example.atd2ac1.entidade.Funcionario;
import com.example.atd2ac1.servico.FuncionarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioControle {
    
    @Autowired
    private FuncionarioServico servico;
    
    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios(){

        ModelAndView mv = new ModelAndView("funcionarios");
        List <Funcionario> list = servico.getFuncionarios();
        System.out.println(list);
        
        mv.addObject("funcionarios", servico.getFuncionarios());

        return mv;
    }

    @GetMapping("/index")
    public String addfuncionario(){
        return "index";
    }

    @PostMapping("/index")
    public ResponseEntity<String> addfunc(@ModelAttribute Funcionario func){
        servico.saveFunc(mapFunc(func));
        return new ResponseEntity<>("Cadastrado!!", HttpStatus.CREATED);
    }
    
    protected Funcionario mapFunc(Funcionario func){
        Funcionario funcionario = new Funcionario(func.getNome(), func.getIdade(), func.getCargo(), func.getSalario());
        return funcionario;
    }
}