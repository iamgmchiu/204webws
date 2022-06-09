// Value Object:一個Object代表Dept Table一筆Row

import java.io.*;

public class Dept implements Serializable{

    private int deptno;
    private String dname;
 
    //Constructor
    public Dept(int deptno, String dname) {
      this.deptno = deptno;
      this.dname = dname;
    }

    public int getDeptno() {
      return this.deptno ;
    }

    public String getDname() {
      return this.dname ;
    }

    public void setDname(String dname) {
      this.dname = dname;
    }

}