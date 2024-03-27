package org.example.task2.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public abstract class EntityWithRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long relatedEntityId;
}
