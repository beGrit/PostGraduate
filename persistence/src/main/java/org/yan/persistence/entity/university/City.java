package org.yan.persistence.entity.university;

import org.yan.persistence.entity.university.University;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UMS_CITY")
public class City {
    @Id
    private Long id;

    /**
     * 地区名
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * 地区下的院校集合
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    private Set<University> universitySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<University> getUniversitySet() {
        return universitySet;
    }

    public void setUniversitySet(Set<University> universitySet) {
        this.universitySet = universitySet;
    }

    public City() {
    }

    public City(String name) {
        this.name = name;
    }
}
