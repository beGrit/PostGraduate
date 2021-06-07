package org.yan.persistence.entity.user;

import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AMS_USER_DETAIL_INFO")
public class UserDetailInfo extends UserBasicInfo {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<University> concernedUniversities;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_major_id")
    private MasterMajor concernedMasterMajor;

    public void addConcernedUniversity(University university) {
        this.concernedUniversities.add(university);
    }

    public Set<University> getConcernedUniversities() {
        return concernedUniversities;
    }

    public void setConcernedUniversities(Set<University> concernedUniversities) {
        this.concernedUniversities = concernedUniversities;
    }

    public MasterMajor getConcernedMasterMajor() {
        return concernedMasterMajor;
    }

    public void setConcernedMasterMajor(MasterMajor concernedMasterMajor) {
        this.concernedMasterMajor = concernedMasterMajor;
    }
}
