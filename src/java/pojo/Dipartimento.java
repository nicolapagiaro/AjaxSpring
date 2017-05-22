package pojo;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe che rappresenta la relazione ARTISTI nel db
 * @author nicola
 */
@Entity
@Table(name = "dipartimenti")
public class Dipartimento implements Serializable{
    static final long serialVersionUID = 55L;
    
    
    @Id @GeneratedValue
    @Column(name = "id_dipartimento")
    private int id;
    
    @Column(name = "nome")
    private String nome;
   
    @Column(name = "sede")
    private String sede;
    
    @OneToMany(mappedBy = "dipartimento")
    private List<Persona> persone;

    public Dipartimento() {
    }
    

    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Persona> getPersone() {
        return persone;
    }

    public void setPersone(List<Persona> persone) {
        this.persone = persone;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
   
}
