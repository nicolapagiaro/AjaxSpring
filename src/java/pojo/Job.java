package pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe che rappresenta la relazione ARTISTI nel db
 * @author nicola
 */
@Entity
@Table(name = "job")
public class Job implements Serializable{
    static final long serialVersionUID = 55L;
    
    
    @Id @GeneratedValue
    @Column(name = "id_job")
    private int id;
    
    @Column(name = "nome")
    private String nome;
   
    /**
     * Associazione molti a molti fra artisti e gli eventi a cui partecipano
     */
    @ManyToMany
    @JoinTable(
            name = "assegnazione_compiti",
            joinColumns = {@JoinColumn(name = "fk_job")},
            inverseJoinColumns = {@JoinColumn(name = "fk_persona")}
    )
    private List<Persona> persone;

    public Job() {
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
}
