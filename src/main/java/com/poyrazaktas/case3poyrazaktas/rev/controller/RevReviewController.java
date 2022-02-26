package com.poyrazaktas.case3poyrazaktas.rev.controller;

import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.service.RevReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class RevReviewController {
    private final RevReviewService reviewService;

    @GetMapping("/findAll")
    public ResponseEntity<List<RevReviewDto>> findAll(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/findAllByUserId/{userId}")
    public ResponseEntity<List<RevReviewDto>> findAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(reviewService.findAllByUserId(userId));
    }

    @GetMapping("/findAllByProductId/{productId}")
    public ResponseEntity<List<RevReviewDto>> findAllByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(reviewService.findAllByProductId(productId));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RevReviewDto> get(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.get(id));
    }

    @PostMapping("/save")
    public ResponseEntity<RevReviewDto> save(@RequestBody RevReviewSaveReqDto reviewSaveReqDto){
        return ResponseEntity.ok(reviewService.save(reviewSaveReqDto));
    }

    @PutMapping("/update")
    public ResponseEntity<RevReviewDto> update(@RequestBody RevReviewUpdateReqDto reviewUpdateReqDto){
        return ResponseEntity.ok(reviewService.update(reviewUpdateReqDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.OK);
    }
}
