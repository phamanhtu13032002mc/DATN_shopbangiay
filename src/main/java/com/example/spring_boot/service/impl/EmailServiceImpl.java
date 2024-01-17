package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.entity.UserEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.CustomerRequest;
import com.example.spring_boot.payload.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl {
    @Autowired
    JavaMailSender mailSender;
    public void sendCreateBill(CustomerEntity userRequest, BillEntity billEntity)
            throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@shopme.com", "Stride Style Shoes");
        helper.setTo(userRequest.getEmail());

        String subject = "Đã tạo đơn hàng!";

        String content = "<p>Xin chào <b>" + userRequest.getFullName() + "!</b></p>"
                + "<p>Đơn hàng của bạn đã được tạo!</p>"
                + "<p>Thông tin đơn hàng.</p>"
                + "<p>Mã đơn hàng: <b>" + billEntity.getId()+ "</b></p>"
                + "<br>"
                + "<p>Họ tên người nhận: <b>" + billEntity.getFullName() + "</b></p>"
                + "<p>Tổng giá trị đơn hàng: <b>" + billEntity.getDownTotal() + "đ </b></p>"
                + "<p>Địa chỉ nhận hàng: <b>" + billEntity.getAddress() + "</b></p>"
                + "<p>Mã vận đơn Trên Ghn: <b>" + billEntity.getOrderCode() + "</b></p>"
                + "<br>"
                + "<p><u>Mọi thắc mắc vui lòng liên hệ:</u> stridestyleshoes@gmail.com</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }
    public void sendCreateBill(CustomerRequest customerRequest)
            throws UnsupportedEncodingException, MessagingException {


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("contact@shopme.com", "Stride Style Shoes");
        helper.setTo(customerRequest.getEmail());

        String subject = "Tạo đơn thành công !";
        String content = "<p>Xin chào <b>" + customerRequest.getFullName() + "!</b></p>"
                + "<p>Đơn hàng của bạn đã được tạo!</p>"
                + "<p>Thông tin đơn hàng.</p>"
                + "<br>"
                + "<p>Họ tên người nhận: <b>" + customerRequest.getFullName() + "</b></p>"
                + "<p>Địa chỉ nhận hàng: <b>" + customerRequest.getAddress() + "</b></p>"
                + "<br>"
                + "<p><u>Mọi thắc mắc vui lòng liên hệ:</u> stridestyleshoes@gmail.com</p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }

    public void sendUpdateBill(BillEntity billEntity)
            throws UnsupportedEncodingException, MessagingException {


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("contact@shopme.com", "Stride Style Shoes");
        helper.setTo(billEntity.getCustomerEntity().getEmail());

        String subject = "Chuyển TRạng thái đơn hàng!";
        String content = "<p>Xin chào <b>" + billEntity.getFullName() + "!</b></p>"
                + "<p>Đơn hàng của bạn với mã vận đơn "+billEntity.getId() +"</p>"
                + "<p> đã chuyển sang trạng thái"+billEntity.getStatusShipping()+"</p>"
                + "<br>"
                + "<p><u>Mọi thắc mắc vui lòng liên hệ:</u> stridestyleshoes@gmail.com</p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }
    private CustomerEntity convertToCustomerEntity(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail(customerRequest.getEmail());
        // Map other properties if needed
        customerEntity.setFullName(customerRequest.getFullName());
        customerEntity.setAddress(customerRequest.getAddress());
        // Map other properties if needed
        return customerEntity;
    }



}
