package models;


import java.sql.Date;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class Participante {

    private Integer id;
    private String nacionalidade;
    private Date data_nasc;
    private String nome;
    private String foto;

    public Participante(Integer id, String nacionalidade, Date data_nasc, String nome, String foto) {
        setData_nasc(data_nasc);
        setId(id);
        setNome(nome);
        setNacionalidade(nacionalidade);
        setFoto(foto);
    }

    public Participante(Integer id, String nacionalidade, Date data_nasc, String nome) {
        setData_nasc(data_nasc);
        setId(id);
        setNome(nome);
        setNacionalidade(nacionalidade);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the data_nasc
     */
    public Date getData_nasc() {
        return data_nasc;
    }

    /**
     * @param data_nasc the data_nasc to set
     */
    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

}
