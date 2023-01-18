package com.squaretrade.challenge.repository;

import com.squaretrade.challenge.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
}
