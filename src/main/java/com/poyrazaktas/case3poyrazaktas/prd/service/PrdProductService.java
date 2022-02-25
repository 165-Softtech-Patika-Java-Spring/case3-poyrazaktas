package com.poyrazaktas.case3poyrazaktas.prd.service;

import com.poyrazaktas.case3poyrazaktas.gen.exception.ItemNotFoundException;
import com.poyrazaktas.case3poyrazaktas.prd.converter.PrdProductMapper;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductPriceDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.prd.entity.PrdProduct;
import com.poyrazaktas.case3poyrazaktas.prd.service.entityservice.PrdProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrdProductService {
    private final PrdProductEntityService productEntityService;

    public List<PrdProductDto> findAll(){
        List<PrdProduct> prdProductList = productEntityService.findAll();
        return PrdProductMapper.INSTANCE.convertToProductDtoList(prdProductList);
    }

    public PrdProductDto get(Long id){
        PrdProduct product = productEntityService.findById(id).orElseThrow(()-> new ItemNotFoundException("Product not found!"));
        return PrdProductMapper.INSTANCE.convertToProductDto(product);
    }

    public PrdProductDto save(PrdProductSaveReqDto productSaveReqDto){
        PrdProduct product = PrdProductMapper.INSTANCE.convertToProduct(productSaveReqDto);
        product = productEntityService.save(product);
        return PrdProductMapper.INSTANCE.convertToProductDto(product);
    }

    public PrdProductDto update(PrdProductUpdateReqDto productUpdateReqDto){
        PrdProduct product = PrdProductMapper.INSTANCE.convertToProduct(productUpdateReqDto);
        product = productEntityService.save(product);
        return PrdProductMapper.INSTANCE.convertToProductDto(product);
    }

    public void delete(Long id){
        PrdProduct product = productEntityService.findById(id).orElseThrow(()->new ItemNotFoundException("Product not found!"));
        productEntityService.delete(product);
    }

    public PrdProductDto updatePrice(Long id, PrdProductPriceDto productPriceDto) {
        PrdProduct product = productEntityService.findById(id).orElseThrow(()->new ItemNotFoundException("Product not found!"));
        product.setPrice(productPriceDto.getPrice());
        product = productEntityService.save(product);
        return PrdProductMapper.INSTANCE.convertToProductDto(product);
    }
}
