/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class Jogo {
    private int id;
  private Selecao selecao1 ;
  private Selecao selecao2;
  private List<Juiz> juizes = new ArrayList<Juiz>();

   
  private Date data;
  private String resultado;
  private String local;

    public Jogo(int id, Date data, String resultado, String local) {
        this.id = id;
        this.data = data;
        this.resultado = resultado;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Selecao getSelecao1() {
        return selecao1;
    }

    public void setSelecao1(Selecao selecao1) {
        this.selecao1 = selecao1;
    }

    public Selecao getSelecao2() {
        return selecao2;
    }

    public void setSelecao2(Selecao selecao2) {
        this.selecao2 = selecao2;
    }

    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
  
     public List<Juiz> getJuizes() {
        return juizes;
    }

    public void setJuizes(List<Juiz> juizes) {
        this.juizes = juizes;
    }
  
  
}
