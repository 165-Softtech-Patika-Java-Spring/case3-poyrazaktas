package com.poyrazaktas.case3poyrazaktas.rev.controller;

import com.poyrazaktas.case3poyrazaktas.gen.dto.RestResponse;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.service.RevReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class RevReviewController {
    private final RevReviewService reviewService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<RevReviewDto> reviewDtoList = reviewService.findAll();
        RestResponse<List<RevReviewDto>> response = RestResponse.of(reviewDtoList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findAllByUserId/{userId}")
    public ResponseEntity findAllByUserId(@PathVariable Long userId) {
        List<RevReviewDto> allByUserId = reviewService.findAllByUserId(userId);
        RestResponse<List<RevReviewDto>> response = RestResponse.of(allByUserId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findAllByProductId/{productId}")
    public ResponseEntity findAllByProductId(@PathVariable Long productId) {
        List<RevReviewDto> allByProductId = reviewService.findAllByProductId(productId);
        RestResponse<List<RevReviewDto>> response = RestResponse.of(allByProductId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        RevReviewDto revReviewDto = reviewService.get(id);
        RestResponse<RevReviewDto> response = RestResponse.of(revReviewDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody RevReviewSaveReqDto reviewSaveReqDto) {
        RevReviewDto reviewDto = reviewService.save(reviewSaveReqDto);
        RestResponse<RevReviewDto> response = RestResponse.of(reviewDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody RevReviewUpdateReqDto reviewUpdateReqDto) {
        RevReviewDto reviewDto = reviewService.update(reviewUpdateReqDto);
        RestResponse<RevReviewDto> response = RestResponse.of(reviewDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
