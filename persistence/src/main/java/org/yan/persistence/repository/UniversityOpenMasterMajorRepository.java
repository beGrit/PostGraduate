package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.entity.university.University;

public interface UniversityOpenMasterMajorRepository extends CrudRepository<UniversityOpenMasterMajor, Long> {
    boolean existsByUniversity_IdAndMasterMajor_Id(Long university_id, Long masterMajor_id);

    UniversityOpenMasterMajor findByUniversity_IdAndMasterMajor_Id(Long university_id, Long masterMajor_id);
}
