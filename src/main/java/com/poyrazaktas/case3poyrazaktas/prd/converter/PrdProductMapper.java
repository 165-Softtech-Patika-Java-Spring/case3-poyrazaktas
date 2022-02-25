package com.poyrazaktas.case3poyrazaktas.prd.converter;

import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductMapper {
    PrdProductMapper INSTANCE = Mappers.getMapper(PrdProductMapper.class);

    PrdProduct convertToProduct(PrdProductSaveReqDto prdProductSaveReqDto);

    PrdProduct convertToProduct(PrdProductUpdateReqDto prdProductUpdateReqDto);

    PrdProductDto convertToProductDto(PrdProduct product);

    List<PrdProductDto> convertToProductDtoList(List<PrdProduct> prdProductList);
}
