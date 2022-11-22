package com.frontend.controller;

import com.frontend.feign.FeignCatalogController;
import com.frontend.feign.FeignOrderController;
import com.frontend.feign.FeignUserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value="/order")
public class OrderController {
    private final FeignOrderController feignOrderController;
    private final FeignUserController feignUserController;

    private final FeignCatalogController feignCatalogController;

    public OrderController(FeignOrderController feignOrderController, FeignUserController feignUserController, FeignCatalogController feignCatalogController) {
        this.feignOrderController = feignOrderController;
        this.feignUserController = feignUserController;
        this.feignCatalogController = feignCatalogController;
    }
    //@Value("${page.user-url}")
	//private String userUrl;

    @GetMapping("/page")
    public String getPage(Model model){
        // 웹어플리케이션에서 '/hello' 라고 요청이 들어오면 해당 메서드를 호출한다.
        // 스프링 MVC가 내부에서 @Controller를 찾고, 거기에 있는 @GetMapping의 정보를 다 등록해둡니다.
        // 그래서 URL에 동일한 경로가 있으면 호출해줍니다.
        //model.addAttribute("userUrl", userUrl); // 키값과 밸류값을 지정해서 model에 담아서 view에 넘긴다.

        // 사용자 목록
        model.addAttribute("userList", feignUserController.getUserForFeign()); // 키값과 밸류값을 지정해서 model에 담아서 view에 넘긴다.
        model.addAttribute("catalogList", feignCatalogController.getCatalogListForFeign()); // 키값과 밸류값을 지정해서 model에 담아서 view에 넘긴다.
        return "order";
    }

    @GetMapping("/test")
    public String getUserPage(){
        // 웹어플리케이션에서 '/hello' 라고 요청이 들어오면 해당 메서드를 호출한다.
        // 스프링 MVC가 내부에서 @Controller를 찾고, 거기에 있는 @GetMapping의 정보를 다 등록해둡니다.
        // 그래서 URL에 동일한 경로가 있으면 호출해줍니다.
        return "helloworld!!";
    }

    @GetMapping("/list/{userId}")
    @ResponseBody
    public List<Map<String, String>> getOrderListByUser(@PathVariable String userId){

        return feignOrderController.getOrder(userId);
    }

    @PostMapping("/orders/{userId}")
    @ResponseBody
    public void postOrderByUser(@PathVariable String userId
                                                    , @RequestBody Map<String, String> input
    ){
        userId = URLDecoder.decode(userId, StandardCharsets.UTF_8);
        feignOrderController.postOrder(userId, input);
    }
}
