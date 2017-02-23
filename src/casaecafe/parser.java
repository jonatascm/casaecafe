/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaecafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonat
 */
public class parser {
    
    public parser(){
    }
    
    public List<item> parseLine(String line) throws ParseException{
        List<String> lstr = new ArrayList<String>();
        List<item> litem = new ArrayList<item>();
        item i = new item();
        int index = 0;
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date;
        //Separa [ e ] do inicio e fim
        line = line.substring(1, line.length()-1);
        
        // Separa a linha em linhas que contem o item 
        for (String val: line.split(", "))
            lstr.add(val);
        
        //Separa cada linha em partes dos itens
        if(!lstr.isEmpty()){
            for (String temp : lstr) {
                //Remove " "
                temp = temp.substring(1, temp.length()-1);
                
                //Separa na ordem categoria - id - data
                String arrayItem[] = temp.split("-");
                i = new item();
                i.putIndex(index);
                i.putCategory(arrayItem[0]);
                i.putId(arrayItem[1]);
                date = formatter.parse(arrayItem[2]);
                i.putDate(date);
                
                litem.add(i);
                index++;
            }
        }
        Collections.sort(litem, Collections.reverseOrder());
        return litem;
    }
    
    public void printResult(List<item> lres, String category, int n){
        System.out.print("<lista>\n");
        System.out.print("\t<categoria>"+category+"<categoria>\n");
        if(lres.isEmpty()){
            System.out.print("\t<itens/>\n");
        }else{
            System.out.print("\t<itens>\n");
            for(int i=0; i < lres.size(); i++){
                System.out.print("\t\t<item>\n");
                System.out.print("\t\t\t<id>"+lres.get(i).getId()+"</id>\n");
                System.out.print("\t\t\t<data>"+lres.get(i).getDate()+"</data>\n");
                System.out.print("\t\t</item>\n");
            }
            System.out.print("\t</itens>\n");
        }
        System.out.print("</lista>\n");
    }
    
}
   
