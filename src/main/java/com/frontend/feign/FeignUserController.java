package com.frontend.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name="2022pmds-backend-user", fallback = FallbackFactory.Default.class)
public interface FeignUserController {
    @GetMapping("/user/feign/list")
    List<Map<String, String>> getUserForFeign();
}
