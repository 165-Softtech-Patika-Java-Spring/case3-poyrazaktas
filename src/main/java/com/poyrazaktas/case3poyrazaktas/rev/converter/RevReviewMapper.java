package com.poyrazaktas.case3poyrazaktas.rev.converter;

import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.dto.RevReviewUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RevReviewMapper {
    RevReviewMapper INSTANCE = Mappers.getMapper(RevReviewMapper.class);

    RevReview convertToReview(RevReviewSaveReqDto reviewSaveReqDto);

    RevReview convertToReview(RevReviewUpdateReqDto reviewUpdateReqDto);

    RevReviewDto convertToReviewDto(RevReview review);

    List<RevReviewDto> converToReviewDtoList(List<RevReview> reviewList);
}
