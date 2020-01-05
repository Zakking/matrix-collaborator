package com.humanup.matrixcollaborator.bs.impl;

import com.humanup.matrixcollaborator.bs.SituationBS;
import com.humanup.matrixcollaborator.dao.SituationDAO;
import com.humanup.matrixcollaborator.dao.entities.Situation;
import com.humanup.matrixcollaborator.vo.SituationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SituationBSImpl implements SituationBS {

    @Autowired
    private SituationDAO situationDAO;

    @Override
    public boolean createSituation(SituationVO situationVO) {
        Situation typeToSave =  Situation.builder()
                .situationTitle(situationVO.getSituationTitle())
                .situationDescription(situationVO.getSituationDescription())
                .build();
        return situationDAO.save(typeToSave) != null;
    }

    @Override
    public SituationVO findSituationByTitle(String situationTitle) {
        return null;
    }

    @Override
    public List<SituationVO> findListSituation() {
        return null;
    }

}
