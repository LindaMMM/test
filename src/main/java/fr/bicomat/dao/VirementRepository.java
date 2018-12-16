package fr.bicomat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bicomat.entities.Virement;

@Repository
public interface VirementRepository extends JpaRepository<Virement, Long> {

}
