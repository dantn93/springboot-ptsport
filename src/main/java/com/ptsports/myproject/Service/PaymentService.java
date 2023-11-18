package com.ptsports.myproject.Service;


import com.ptsports.myproject.DTO.OrderDto;
import com.ptsports.myproject.DTO.PaymentDto;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface PaymentService {
    String payWithVNPAY(OrderDto orderDto, HttpServletRequest request) throws UnsupportedEncodingException;

    String payWithMoney(PaymentDto paymentDto, HttpServletRequest request);
}
