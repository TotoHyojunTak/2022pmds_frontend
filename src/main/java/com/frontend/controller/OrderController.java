package com.frontend.controller;

import com.frontend.feign.FeignOrderController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value="/order")
public class OrderController {
    private final FeignOrderController feignOrderController;

    public OrderController(FeignOrderController feignOrderController) {
        this.feignOrderController = feignOrderController;
    }
    //@Value("${page.user-url}")
	//private String userUrl;

    @GetMapping("/page")
    public String getPage(Model model){
        // 웹어플리케이션에서 '/hello' 라고 요청이 들어오면 해당 메서드를 호출한다.
        // 스프링 MVC가 내부에서 @Controller를 찾고, 거기에 있는 @GetMapping의 정보를 다 등록해둡니다.
        // 그래서 URL에 동일한 경로가 있으면 호출해줍니다.
        //model.addAttribute("userUrl", userUrl); // 키값과 밸류값을 지정해서 model에 담아서 view에 넘긴다.
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
}
