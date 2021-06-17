package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.entity.university.University;

import java.util.List;
import java.util.Optional;

public interface UniversityOpenMasterMajorRepository extends CrudRepository<UniversityOpenMasterMajor, Long> {
    boolean existsByUniversity_IdAndMasterMajor_Id(Long university_id, Long masterMajor_id);

    Optional<UniversityOpenMasterMajor> findByUniversity_IdAndMasterMajor_Id(Long university_id, Long masterMajor_id);

    List<UniversityOpenMasterMajor> findAllByMasterMajorId(Long mid);
}
