/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaecafe;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jonat
 */
public class item implements Comparable<item> {
    private int index;
    private String category;
    private String id;
    private Date date;
    
    public item(){
        this.index = -1;
        this.category = "";
        this.id = "";
        this.date = new Date();
    }
    
    public item(int index, String category, String id, Date date){
        this.index = index;
        this.category = category;
        this.id = id;
        this.date = date;
    }
    
    public void putIndex(int index){
        this.index = index;
    }
    
    public void putCategory(String category){
        this.category = category;
    }
    
    public void putId(String id){
        this.id = id;
    }
    
    public void putDate(Date date){
        this.date = date;
    }
    
    public String getCategory(){
        return this.category;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(this.date);
    }
    
    public String getItem(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return this.index+" "+this.category+" "+this.id+" "+formatter.format(this.date);
    }

    @Override
    public int compareTo(item o) {
        return getDate().compareTo(o.getDate());
    }
    
}
