package com.john.massplanning.massplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MassPlanItemRepository extends JpaRepository<MassPlanItem, Integer> {
}
