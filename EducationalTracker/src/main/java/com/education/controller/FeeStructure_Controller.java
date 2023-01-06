package com.education.controller;

import com.education.dto.FeeInfoBasedOnStandard_ResDto;
import com.education.dto.FeeStructureResDto;
import com.education.dto.FeeStructureUpdateReqDto;
import com.education.service.FeeStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educational/friends")
public class FeeStructure_Controller {

    @Autowired
    private FeeStructure feeStructure;

    @GetMapping("/feeStructure")
    public ResponseEntity<FeeStructureResDto> getFeeStructure(){
        return ResponseEntity.ok(feeStructure.getFeeStructure());
    }

    @PostMapping("/updateFeeStructure")
    public ResponseEntity<FeeStructureResDto> updateFeeStructure(@RequestBody FeeStructureUpdateReqDto feeStructureUpdateReqDto){
        return ResponseEntity.ok(feeStructure.updateFeeStructure(feeStructureUpdateReqDto));
    }

    @GetMapping("/amountByStandard")
    public ResponseEntity<FeeInfoBasedOnStandard_ResDto> getFeeInfoBasedOnStandard(@RequestParam("Standard") String standard){
        return ResponseEntity.ok(feeStructure.getFeeInfoBasedOnStandard(standard));
    }
}
