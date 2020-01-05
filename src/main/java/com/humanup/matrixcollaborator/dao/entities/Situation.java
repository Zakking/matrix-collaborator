package com.humanup.matrixcollaborator.dao.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString(of= {"situationId","situationTitle","situationDescription"})
public class Situation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long situationId;
    String situationTitle;
    String situationDescription;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            //Check the correct value
            mappedBy = "situations")
    Set<Collaborator> collaborators = new HashSet<>();

}
