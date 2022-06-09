import java.util.*;
public class ErrorMessage{
  
  String title;
 
  Vector<String>  errorDesc = new Vector<String>();
  
  boolean errorFlag = false;

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setErrorDesc(String error) {
    errorDesc.addElement(error);
  }

  public Vector<String> getErrorDesc() {
    return errorDesc;
  }

  public void setErrorFlag(boolean flag) {
    errorFlag = flag;
  }

  public boolean getErrorFlag() {
    return errorFlag;
  }

}