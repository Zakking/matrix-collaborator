package com.humanup.matrixcollaborator.bs;


import com.humanup.matrixcollaborator.vo.SituationVO;

import java.util.List;

public interface SituationBS {

    boolean createSituation(SituationVO situationVO);
    SituationVO findSituationByTitle(String situationTitle);
    List<SituationVO> findListSituation();
}
