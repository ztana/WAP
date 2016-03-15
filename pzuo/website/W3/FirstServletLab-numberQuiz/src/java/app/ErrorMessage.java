/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author zuopeng
 */
public class ErrorMessage {

    public enum ID {attempt,wrong};
    private boolean hidden;
    private String message;
    public static ErrorMessage mes;
    //private String answer;
    

    private ErrorMessage()
    {
    }
    static 
    {
        mes = new ErrorMessage();
        mes.hidden = true;
        mes.message = "";
    }
    
    public void setMessage(ID id) {
        setMessage(id,"");
    }
    
    public void setMessage(ID id, String answer) {
        
        switch(id) {
            case wrong:
                message = "Your last answer was not correct! Please try again";
                break;
            case attempt:
                message = "No more Attempt! Correct answer is "+answer;
                break;
        }
    }
    
    public void hidden(boolean h) {
        if(h)
            mes.hidden =  true;
        else
            mes.hidden =  false;
    }
    
    public String getHideMessage() {
        if(mes.hidden)
            return "hidden";
        else
            return "";
    }
    
    public String getMessage() {
          return this.message;
    }
}
