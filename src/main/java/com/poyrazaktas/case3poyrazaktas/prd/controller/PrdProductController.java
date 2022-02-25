package com.poyrazaktas.case3poyrazaktas.prd.controller;

import com.poyrazaktas.case3poyrazaktas.prd.dto.PrdProductDto;
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
    public ResponseEntity<List<PrdProductDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PrdProductDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping("/save")
    public ResponseEntity<PrdProductDto> save(@RequestBody PrdProductSaveReqDto productSaveReqDto){
        return ResponseEntity.ok(productService.save(productSaveReqDto));
    }

    @PutMapping("/update")
    public ResponseEntity<PrdProductDto> update(@RequestBody PrdProductUpdateReqDto productUpdateReqDto){
        return ResponseEntity.ok(productService.update(productUpdateReqDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
