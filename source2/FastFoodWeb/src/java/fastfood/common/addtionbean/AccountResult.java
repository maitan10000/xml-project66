/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.addtionbean;

/**
 *
 * @author Everything
 */
public class AccountResult {

    private boolean Success;
    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public boolean isResult() {
        return Success;
    }

    public void setResult(boolean Result) {
        this.Success = Result;
    }


}
