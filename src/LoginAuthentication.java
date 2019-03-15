/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class LoginAuthentication {
    
    
    public boolean validate(String username){
    boolean validationresult; 
        String cardnumber = (String) username;
        int x = 1;
        String str1 = Integer.toString(x);
        if (cardnumber.equals(str1)) { 
        return true;
        }  
        else{
       return false;
    }
    }
}