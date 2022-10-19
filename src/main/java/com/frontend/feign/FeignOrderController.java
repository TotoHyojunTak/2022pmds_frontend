package com.frontend.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name="2022pmds-backend-order")
public interface FeignOrderController {
    @GetMapping("/orders")
    List<Map<String, String>> getOrder();
}
