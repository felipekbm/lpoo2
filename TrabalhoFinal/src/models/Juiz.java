package models;

import java.sql.Date;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class Juiz extends Participante {

    public Juiz(Integer id, String nacionalidade, Date data_nasc, String nome, String foto) {
        super(id, nacionalidade, data_nasc, nome, foto);

    }
}
