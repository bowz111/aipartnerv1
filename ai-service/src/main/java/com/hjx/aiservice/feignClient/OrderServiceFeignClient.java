package com.hjx.aiservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "order-service")
public interface OrderServiceFeignClient {

    @PostMapping(value = "/order/add")
    String addOrder();
}
