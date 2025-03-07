package com.papers.service;

import com.papers.model.db.College;
import com.papers.model.dto.CreateCollegeRequest;
import com.papers.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

  @Autowired private CollegeRepository collegeRepository;

  public void createCollege(CreateCollegeRequest createCollegeRequest) {
    collegeRepository.save(
        College.builder().collegeName(createCollegeRequest.getCollegeName()).build());
  }
}
