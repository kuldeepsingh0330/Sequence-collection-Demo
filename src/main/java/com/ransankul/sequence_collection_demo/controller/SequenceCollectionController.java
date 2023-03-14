package com.ransankul.sequence_collection_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ransankul.sequence_collection_demo.model.SequenceCollection;
import com.ransankul.sequence_collection_demo.services.SequenceCollectionService;

@RestController
@RequestMapping("/sequence-collections")
public class SequenceCollectionController {
    
    @Autowired
    private SequenceCollectionService sequenceCollectionService;
    
    @GetMapping("/{name}")
    public ResponseEntity<?> getSequenceCollectionByName(@PathVariable String name) {
        SequenceCollection sequenceCollection = sequenceCollectionService.getSequenceCollectionByName(name);
        
        if (sequenceCollection == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sequence collection not found");
        }
        return ResponseEntity.ok(sequenceCollection);
    }

    @PostMapping("/{collection1Name}/{collection2Name}")
    public ResponseEntity<String> compareSequenceCollections(
            @PathVariable String collection1Name,
            @PathVariable String collection2Name) {


                if (collection1Name == null || collection2Name == null) {
                    return ResponseEntity.ok("Enter a valid input");
                }

                String equal = sequenceCollectionService.compareSequenceCollections(collection1Name, collection2Name);
                return ResponseEntity.ok(equal);
    }
}

