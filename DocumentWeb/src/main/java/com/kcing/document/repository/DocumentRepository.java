package com.kcing.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
