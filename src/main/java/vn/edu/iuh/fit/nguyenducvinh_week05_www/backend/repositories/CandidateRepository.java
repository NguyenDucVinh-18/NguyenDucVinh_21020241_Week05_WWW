package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;

@Repository
public interface CandidateRepository extends PagingAndSortingRepository<Candidate, Long> {
}