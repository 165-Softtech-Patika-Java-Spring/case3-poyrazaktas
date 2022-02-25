package com.poyrazaktas.case3poyrazaktas.rev.service;

import com.poyrazaktas.case3poyrazaktas.gen.exception.ItemNotFoundException;
import com.poyrazaktas.case3poyrazaktas.rev.converter.RevReviewMapper;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import com.poyrazaktas.case3poyrazaktas.rev.service.entityservice.RevReviewEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevReviewService {
    private final RevReviewEntityService entityService;

    public List<RevReviewDto> findAll() {
        List<RevReview> reviewList = entityService.findAll();
        return RevReviewMapper.INSTANCE.converToReviewDtoList(reviewList);
    }

    public RevReviewDto get(Long id) {
        RevReview review = entityService.findById(id).orElseThrow(() -> new ItemNotFoundException("Review Not Found!"));
        return RevReviewMapper.INSTANCE.convertToReviewDto(review);
    }

    public RevReviewDto save(RevReviewSaveReqDto reviewSaveReqDto) {
        RevReview review = RevReviewMapper.INSTANCE.convertToReview(reviewSaveReqDto);
        review = entityService.save(review);
        return RevReviewMapper.INSTANCE.convertToReviewDto(review);
    }


    public RevReviewDto update(RevReviewUpdateReqDto reviewUpdateReqDto) {
        RevReview review = RevReviewMapper.INSTANCE.convertToReview(reviewUpdateReqDto);
        review = entityService.save(review);
        return RevReviewMapper.INSTANCE.convertToReviewDto(review);
    }

    public void delete(Long id){
        RevReview review = entityService.findById(id).orElseThrow(()->new ItemNotFoundException("Review not found!"));
        entityService.delete(review);
    }
}
