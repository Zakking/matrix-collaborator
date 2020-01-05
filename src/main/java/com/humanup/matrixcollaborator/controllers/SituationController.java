package com.humanup.matrixcollaborator.controllers;

import com.humanup.matrixcollaborator.bs.SituationBS;
import com.humanup.matrixcollaborator.vo.SituationVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SituationController {

        @Autowired
        private SituationBS situationBS;

    @Operation(summary = "Create Situation", description = " Create new situation by title, description, ...", tags = { "situation" })
    @RequestMapping(value="/situation", method= RequestMethod.POST,consumes={ "application/json"})
    @ResponseBody
    public ResponseEntity createSituation(@RequestBody SituationVO situation) {
        Optional<Object> findSituation = Optional.ofNullable(situationBS.findSituationByTitle(situation.getSituationTitle()));

        if(findSituation.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This Situation is Founded");
        }
        situationBS.createSituation(situation);
        return ResponseEntity.status(HttpStatus.CREATED).body(situation);
    }

    @Operation(summary = "Find Situation by title", description = "Situation search by %title% format", tags = { "situation" })
    @RequestMapping(value="/situation", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getSituationInfo(@RequestParam(value="title", defaultValue="Situation title") String title){
        Optional<SituationVO> findSituation = Optional.ofNullable(situationBS.findSituationByTitle(title));
        if(findSituation.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findSituation.get());
    }
    @Operation(summary = "Find all situations", description = "Find all situations", tags = { "situation" })
    @RequestMapping(value="/situation/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllSituationInfo(){
        List<SituationVO> findSituations = situationBS.findListSituation();

        if(findSituations.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findSituations);
    }

}
