/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Contrato;
import entities.Departamento;
import entities.Funcionario;
import entities.enums.NivelCargo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javafx.scene.chart.PieChart;

/**
 *
 * @author David
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner leia = new Scanner(System.in);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        
        
        System.out.println("Informe o nome do departamento: ");
        String dpt = leia.next();
        System.out.println("");
        System.out.println("Inserir dados do trabalhador"); 
        
        System.out.println("");
        
        System.out.println("Nome: ");
        String funcionarioNome = leia.next();
        System.out.println("Nivel cargo: ");
        String FuncionarioNivel = leia.next();
        System.out.println("Salario Base: ");
        double funcionarioSalarioBase = leia.nextDouble();
        
        Funcionario funcionario = new Funcionario 
        (funcionarioNome, NivelCargo.valueOf(FuncionarioNivel), funcionarioSalarioBase, new Departamento(dpt));
        
        
        
        System.out.println("Informe quantos contratos: ");
        Integer qtdContratos = leia.nextInt();
        
        
        
        for (int i = 0; i < qtdContratos; i++) {
            
            System.out.println("Informe a º"+1+" data (dd/MM/yyyy): ");
            Date dataContrato = sdf.parse(leia.next());
  
            System.out.println("Informe o valor por hora: ");
            double valorPorHora = leia.nextDouble();
            
            System.out.println("Informe a quantidade de horas:");
            int qtdHoras = leia.nextInt();
            
            Contrato contrato = new Contrato (dataContrato, valorPorHora, qtdHoras);
            
            funcionario.addContrato(contrato);
     
        }
        
        System.out.println("Informe o mes e o ano para calcular a renda (mm/yyyy): ");
        String mesAno = leia.next();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));
        
        System.out.println("Nome: "+funcionario.getNome());
        System.out.println("Departamento: "+funcionario.getDepartamento().getNome());
        System.out.println("Renda total: "+funcionario.renda(mes, ano));
        
    }
    
}
