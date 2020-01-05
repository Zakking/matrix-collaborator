package com.humanup.matrixcollaborator.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of= {"situationTitle","situationDescription"})
public class SituationVO {
    int situationId;
    String situationTitle;
    String situationDescription;

    
}
