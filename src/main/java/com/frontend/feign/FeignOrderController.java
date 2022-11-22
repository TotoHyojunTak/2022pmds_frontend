package com.frontend.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name="2022pmds-backend-order")
public interface FeignOrderController {
    @GetMapping("/order/feign/{userId}/list")
    List<Map<String, String>> getOrder(@PathVariable String userId);

    @PostMapping("/order/feign/{userId}/orders")
    void postOrder(@PathVariable String userId, Map<String, String> input);
}
