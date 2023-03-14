package com.ransankul.sequence_collection_demo.services;

import java.util.List;
import java.util.Optional;
import com.ransankul.sequence_collection_demo.model.SequenceCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransankul.sequence_collection_demo.dao.SequenceCollectionRepository;

@Service
public class SequenceCollectionService {

    @Autowired
    private final SequenceCollectionRepository sequenceCollectionRepository;

    public SequenceCollectionService(SequenceCollectionRepository sequenceCollectionRepository) {
        this.sequenceCollectionRepository = sequenceCollectionRepository;
    }

    public SequenceCollection getSequenceCollectionByName(String name) {
        Optional<SequenceCollection> seqCol=sequenceCollectionRepository.findByName(name);
        if(seqCol.isEmpty()) return null;
        else return seqCol.get();
    }

    public List<SequenceCollection> getAllSequenceCollections() {
        return sequenceCollectionRepository.findAll();
    }

    public String compareSequenceCollections(String name1, String name2) {
        SequenceCollection collection1 = getSequenceCollectionByName(name1);
        SequenceCollection collection2 = getSequenceCollectionByName(name2);
        
        if (collection1 == null || collection2 == null) {
            return "Invalid sequence collection name";
        }
        
        if (collection1.getSequences().size() != collection2.getSequences().size()) {
            return "Not matched";
        }
        
        for (int i = 0; i < collection1.getSequences().size(); i++) {
            String sequence1 = collection1.getSequences().get(i);
            String sequence2 = collection2.getSequences().get(i);
            if (!sequence1.equals(sequence2)) {
                return "Not matched";
            }
        }
        
        return "matched";
    }
}


