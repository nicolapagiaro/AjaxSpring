package pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe che rappresenta la relazione ARTISTI nel db
 * @author nicola
 */
@Entity
@Table(name = "persone")
public class Persona implements Serializable{
    static final long serialVersionUID = 55L;
    
    
    @Id @GeneratedValue
    @Column(name = "id_persona")
    private int id;
    
    @Column(name = "nome")
    private String nome;
   
    /**
     * Associazione molti a molti fra artisti e gli eventi a cui partecipano
     */
    @ManyToMany(mappedBy = "persone")
    private List<Job> jobs;

    @ManyToOne
    @JoinColumn(name = "fk_dipartimento")
    private Dipartimento dipartimento;
    
    public Persona() {
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
    
    @JsonIgnore
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @JsonIgnore
    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }
   
}
