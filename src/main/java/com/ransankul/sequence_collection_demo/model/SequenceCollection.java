package com.ransankul.sequence_collection_demo.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "sequence_collections")
public class SequenceCollection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ElementCollection
    @CollectionTable(name = "sequence", joinColumns = @JoinColumn(name = "sequence_collections_id"))
    @Column(name = "sequence")
    private List<String> sequences;
    
    @ElementCollection
    @CollectionTable(name = "sequence_length", joinColumns = @JoinColumn(name = "sequence_collections_id"))
    @Column(name = "length")
    private List<Integer> lengths;
    
    public SequenceCollection() {
        // default constructor
    }
    
    public SequenceCollection(String name, List<String> sequences, List<Integer> lengths) {
        this.name = name;
        this.sequences = sequences;
        this.lengths = lengths;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<String> getSequences() {
        return sequences;
    }
    
    public void setSequences(List<String> sequences) {
        this.sequences = sequences;
    }
    
    public List<Integer> getLengths() {
        return lengths;
    }
    
    public void setLengths(List<Integer> lengths) {
        this.lengths = lengths;
    }
}