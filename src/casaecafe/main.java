/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaecafe;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class main {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ParseException {
        System.out.println("Insira os parametros de entrada:");
        
        Scanner scanner = new Scanner(System.in);
        String input, category;
        int n;
        
        input = scanner.nextLine();
        category = scanner.nextLine();
        n = scanner.nextInt();
        
        xmlcreator(input,category,n);
    }
    public static void xmlcreator(String input, String category, int n) throws ParseException {
        List<item> litem = new ArrayList<item>();
        List<item> lres = new ArrayList<item>();
        
        category = category.substring(1, category.length()-1);
      
        parser p = new parser();
        litem = p.parseLine(input);
        
        //Adiciona os itens com a categoria procurada na lista de resultados
        for(int i=0; i<litem.size(); i++){
            if( category.equals(litem.get(i).getCategory()) && n > 0){
                lres.add(litem.get(i));
                n--;
            }
            if(n==0)
                break;
        }
        Collections.reverse(lres);
        p.printResult(lres,category,n);
        
    }
    
}
