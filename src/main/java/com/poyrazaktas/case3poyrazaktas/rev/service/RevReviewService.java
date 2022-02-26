package com.poyrazaktas.case3poyrazaktas.rev.service;

import com.poyrazaktas.case3poyrazaktas.gen.exception.ItemNotFoundException;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductDto;
import com.poyrazaktas.case3poyrazaktas.prd.service.PrdProductService;
import com.poyrazaktas.case3poyrazaktas.rev.converter.RevReviewMapper;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import com.poyrazaktas.case3poyrazaktas.rev.service.entityservice.RevReviewEntityService;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDto;
import com.poyrazaktas.case3poyrazaktas.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevReviewService {
    private final RevReviewEntityService reviewEntityService;
    private final UsrUserService userService;
    private final PrdProductService productService;

    public List<RevReviewDto> findAll() {
        List<RevReview> reviewList = reviewEntityService.findAll();
        return RevReviewMapper.INSTANCE.converToReviewDtoList(reviewList);
    }

    public List<RevReviewDto> findAllByUserId(Long userId) {
        List<RevReview> reviewList = reviewEntityService.findAllByUserId(userId);
        UsrUserDto usrUserDto = userService.get(userId);
        checkIfUserReviewsIsEmpty(reviewList, usrUserDto);
        return RevReviewMapper.INSTANCE.converToReviewDtoList(reviewList);
    }

    public List<RevReviewDto> findAllByProductId(Long productId) {
        List<RevReview> reviewList = reviewEntityService.findAllByProductId(productId);
        PrdProductDto prdProductDto = productService.get(productId);
        checkIfProductReviewsIsEmpty(reviewList, prdProductDto);
        return RevReviewMapper.INSTANCE.converToReviewDtoList(reviewList);
    }

    public RevReviewDto get(Long id) {
        RevReview review = reviewEntityService.findById(id).orElseThrow(() -> new ItemNotFoundException("Review Not Found!"));
        return RevReviewMapper.INSTANCE.convertToReviewDto(review);
    }

    public RevReviewDto save(RevReviewSaveReqDto reviewSaveReqDto) {
        RevReview review = RevReviewMapper.INSTANCE.convertToReview(reviewSaveReqDto);
        review = reviewEntityService.save(review);
        return RevReviewMapper.INSTANCE.convertToReviewDto(review);
    }


    public RevReviewDto update(RevReviewUpdateReqDto reviewUpdateReqDto) {
        RevReview review = RevReviewMapper.INSTANCE.convertToReview(reviewUpdateReqDto);
        review = reviewEntityService.save(review);
        return RevReviewMapper.INSTANCE.convertToReviewDto(review);
    }

    public void delete(Long id) {
        RevReview review = reviewEntityService.findById(id).orElseThrow(() -> new ItemNotFoundException("Review not found!"));
        reviewEntityService.delete(review);
    }

    private void checkIfUserReviewsIsEmpty(List<RevReview> reviewList, UsrUserDto usrUserDto) {
        if (reviewList.isEmpty()) {
            throw new ItemNotFoundException(String.format("%s adlı kullanıcı henüz yorum yapmamıştır.", usrUserDto.getUserName()));
        }
    }

    private void checkIfProductReviewsIsEmpty(List<RevReview> reviewList, PrdProductDto prdProductDto) {
        if (reviewList.isEmpty()) {
            throw new ItemNotFoundException(String.format("%s adlı ürüne henüz yorum yapılmamıştır.", prdProductDto.getName()));
        }
    }
}
