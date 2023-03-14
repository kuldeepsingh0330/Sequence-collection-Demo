package com.ransankul.sequence_collection_demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ransankul.sequence_collection_demo.model.SequenceCollection;

@Repository
public interface SequenceCollectionRepository extends JpaRepository<SequenceCollection, Long> {

    Optional<SequenceCollection> findByName(String name);

}
