package com.papers.repository;

import com.papers.model.db.College;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends MongoRepository<College,String> {
}
