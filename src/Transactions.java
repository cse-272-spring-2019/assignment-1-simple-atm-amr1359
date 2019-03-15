


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */

public class Transactions {
    public int i;
    public String[] history=new String[100];
    public static int balance1 = 0;
    public String str2 = "0";
    
    
    public double deposit (String amount5){
        String ss = (String) amount5;
        
      int amounti = Integer.valueOf(ss);
      balance1 = balance1 + amounti;
      history[i]=("the accounted has been deposited by "+amount5);
            i++;
     return balance1;
    }
    public boolean vwithdraw(String amount2){
    
        int y = Integer.valueOf(amount2);
        
        if (y<balance1) { 
            balance1-=y;
            history[i]=("the accounted has been withdrawed by "+amount2);
            i++;
        return true;
        }  
        else{
       return false;
    }
    }
}
