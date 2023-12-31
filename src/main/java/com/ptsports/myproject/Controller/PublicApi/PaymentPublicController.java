package com.ptsports.myproject.Controller.PublicApi;


import com.ptsports.myproject.DTO.CartDto;
import com.ptsports.myproject.DTO.OrderDto;
import com.ptsports.myproject.DTO.Response.ApiResponse;
import com.ptsports.myproject.DTO.SubmitOrderDto;
import com.ptsports.myproject.Service.CartService;
import com.ptsports.myproject.Service.OrderService;
import com.ptsports.myproject.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentPublicController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @PostMapping("/pay")
    public String pay(@RequestBody OrderDto orderDto, HttpServletRequest request) {
        try {
//luu orderDto vao localStore
            CartDto cart = cartService.getCart(orderDto.getUserID());

            long current = System.currentTimeMillis();

//            Random random = new Random();
//            long randomNumber = random.nextInt(90000) + 10000; // tạo số ngẫu nhiên từ 10000 đến 99999
            orderDto.setVnp_TxnRef(current);
            orderDto.setCode("ORDER-"+current);
            orderDto.setVnp_OrderInfo(orderDto.getCode());

           double price = 0;
            for (int i = 0; i < cart.getItemList().size(); i++) {
                price+= cart.getItemList().get(i).getTotalPrice();
            }

            orderDto.setVnp_Ammount((long)price*100);
            return paymentService.payWithVNPAY(orderDto, request);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/money")

    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto, HttpSession httpSession){
        orderDto.setType(0);//truc tiep, status = false;
        long current = System.currentTimeMillis();
        orderDto.setCode("ORDER-"+current);
        orderDto.setVnp_OrderInfo("thanh toan hoa don ORDER-"+current);
        orderService.saveOrderService(orderDto, httpSession);
        return new ResponseEntity(new ApiResponse("success", true), HttpStatus.OK);

    }
    @PostMapping("/submit-order")
    public ResponseEntity<?>submit(@RequestBody SubmitOrderDto result, HttpServletRequest request, HttpSession httpSession){
        OrderDto orderDto = result.getOrderDto();
        String[] out = result.getString().split("&");
        for (int i = 0; i < out.length; i++) {

            if(out[i].startsWith("vnp_OrderInfo")){
                String[]code = out[i].split("=");
                orderDto.setCode(code[1]);
            }
            if(out[i].startsWith("vnp_ResponseCode")){
                String[]code = out[i].split("=");
                if(code[1].equals("00")){
                    System.out.println("--------------code: "+ code[1]);
                    orderDto.setType(1);

                    orderService.saveOrderService(orderDto, httpSession);
                }
            }

        }


        return new ResponseEntity<>(new ApiResponse("success", true), HttpStatus.OK);
    }
}
