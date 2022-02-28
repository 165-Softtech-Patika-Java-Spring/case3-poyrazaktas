package com.poyrazaktas.case3poyrazaktas.prd.controller;

import com.poyrazaktas.case3poyrazaktas.gen.dto.RestResponse;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductPriceDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.prd.service.PrdProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class PrdProductController {
    private final PrdProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<PrdProductDto> productDtoList = productService.findAll();
        RestResponse response = RestResponse.of(productDtoList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        PrdProductDto productDto = productService.get(id);
        RestResponse<PrdProductDto> response = RestResponse.of(productDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody PrdProductSaveReqDto productSaveReqDto){
        PrdProductDto productDto = productService.save(productSaveReqDto);
        RestResponse<PrdProductDto> response = RestResponse.of(productDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody PrdProductUpdateReqDto productUpdateReqDto){
        PrdProductDto productDto = productService.update(productUpdateReqDto);
        RestResponse<PrdProductDto> response = RestResponse.of(productDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/updatePrice/{id}")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestBody PrdProductPriceDto productPriceDto){
        PrdProductDto productDto = productService.updatePrice(id, productPriceDto);
        RestResponse<PrdProductDto> response = RestResponse.of(productDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
