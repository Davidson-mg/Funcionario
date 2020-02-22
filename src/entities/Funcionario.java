/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.NivelCargo;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.List;


public class Funcionario {
    
    private String nome;
    private NivelCargo nivel;
    private Double salarioBase;
    
    private Departamento departamento; /*Um funcionario pode ter um departamento*/
    private List<Contrato> contratos = new ArrayList<>(); /*Um funcionario pode ter varios contratos. Por isso usamos uma lista*/
    
    public Funcionario(){};
    
    public Funcionario (String nome, NivelCargo nivel, Double salarioBase, Departamento departamento){
    
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    
    }
    
   
    public void setNome(String nome){
    
        this.nome = nome;
        
    }
    public String getNome(){
    
        return nome;
    
    }
    
    public void setNivel(NivelCargo nivel){
    
        this.nivel = nivel;
    
    }
    
    public NivelCargo getNivel(){
    
        return nivel;
    
    }
    
    public void setSalarioBase (Double salarioBase){
    
        this.salarioBase = salarioBase;
    
    }
    
    public Double getSalarioBase (){
    
        return salarioBase;
    
    }

    public Departamento getDepartamento() {
        return departamento;
    }


    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
    
   
    public void addContrato (Contrato contratos){
    
        this.contratos.add(contratos);
    
    }
    
    
    public void removeContrato (Contrato contratos){
    
        this.contratos.remove(contratos);
    
    }
    
    public double renda (int mes, int ano){
    
        double soma = salarioBase;
        
        Calendar cal = Calendar.getInstance();
        
        for (Contrato c : contratos){
            
            cal.setTime(c.getData());
            
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);
            
            if (mes == c_ano && ano == c_mes){
            
                soma = soma + c.valorTotal();
            
            }  
        }
        return soma;
    }
    
}
