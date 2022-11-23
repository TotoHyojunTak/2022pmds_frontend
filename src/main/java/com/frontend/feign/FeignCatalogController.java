package com.frontend.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name="2022pmds-backend-catalog", fallback = FallbackFactory.Default.class)
public interface FeignCatalogController {
    @GetMapping("/catalog/feign/list")
    List<Map<String, String>> getCatalogListForFeign();

    @PostMapping("/catalog/feign/list")
    List<Map<String, String>> saveCatalogForFeign(Map<String, String> input);
}
