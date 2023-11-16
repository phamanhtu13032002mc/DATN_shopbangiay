package com.example.spring_boot.service.impl;

import com.example.spring_boot.controller.AuthController;
import com.example.spring_boot.controller.BaseController;
import com.example.spring_boot.entity.*;

import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.BillManager;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.payload.request.UpdateBillCustomer;
import com.example.spring_boot.repository.*;
import com.example.spring_boot.service.BillService;
import com.example.spring_boot.service.UserDetailImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BillServiceImpl extends BaseController implements BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    VoucherRepository voucherRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<BillEntity> findAllBill(BillRequest billRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(billRequest.getPage()), Math.toIntExact(billRequest.getSize()));

        return billRepository.findAllBill(billRequest, pageable);
    }

    @Override
    public DataObj create(BillRequest billRequest) {
        try {
            long randomNumber = ThreadLocalRandom.current().nextLong(10000000L, 100000000L);
            CustomerEntity customer = customerRepository.findByIdUser(getAuthUID());
            BillEntity billEntity = new BillEntity();
            billEntity.setId(randomNumber);
            while (billRepository.existsById(billEntity.getId())) {
                billEntity.setId(randomNumber);

            }
            List<OrderDetailEntity> orderdetails = new ArrayList<>();
            billEntity.setCustomerEntity(customer);
            billEntity.setCreateAt(LocalDate.now());
            billEntity.setAddress(billRequest.getAddress());
            List<ProductDetailRequest> productDetailRequests = billRequest.getProductDetail();
            for (ProductDetailRequest pdr : productDetailRequests) {
                ProductDetailEntity productEntity = productDetailRepository.findByIdProductDetail(pdr.getId());
                ProductEntity product = productRepository.findByIdProduct(productEntity.getIdProduct().getId());

                if (product == null) {
                    return new DataObj().setEdesc("400").setEdesc("Sản phẩm không tồn tại");
                }
                if (productEntity.getQuantity() < pdr.getQuantityBill()) {
                    return new DataObj().setEdesc("400").setEdesc("Số Lượng Sản Phẩm trên bill Lớn hơn số hàng tồn trong kho");

                }
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                orderDetailEntity.setProductDetailEntities(productEntity);
                orderDetailEntity.setQuantity_oder(pdr.getQuantityBill());
                orderDetailEntity.setPrice(product.getPrice());
                orderDetailEntity.setDownPrice(product.getDiscount() != null ? product.getPrice() * (product.getDiscount() / 100) : 0);
                orderDetailEntity.setIntoMoney(product.getPrice() - orderDetailEntity.getDownPrice());
                orderDetailEntity.setBillEntity(billEntity);
                orderdetails.add(orderDetailEntity);

            }
            if (billRequest.getVoucher_id() != null) {
                VoucherEntity voucherEntity = voucherRepository.findByIdVoucher(billRequest.getVoucher_id());
                if (voucherEntity == null) {
                    return new DataObj().setEdesc("400").setEdesc("Không tìm thấy voucher");

                }
                if (billRequest.getTotal() < 350000L) {
                    return new DataObj().setEdesc("400").setEdesc("Hóa Đơn Nhỏ Hơn 350k không thể ap dụng Voucher");
                }
                if (voucherEntity.getAmount() <= 0) {
                    return new DataObj().setEdesc("400").setEdesc("voucher đã hết hạn");

                }
                billEntity.setDiscount(voucherEntity.getDiscount());
                billEntity.setVoucherId(voucherEntity.getId());
                voucherEntity.setAmount(voucherEntity.getAmount() - 1L);
                voucherRepository.save(voucherEntity);
            }
            billRepository.save(billEntity);
            orderDetailRepository.saveAll(orderdetails);
            return new DataObj().setEdesc("200").setEcode("success");
        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEdesc("400").setEcode("Error");
        }
    }

    @Override
    public DataObj updateBillCustomer(UpdateBillCustomer updateBillCustomer) {
        BillEntity entity = billRepository.findByidBill(updateBillCustomer.getIdBill());
        if (entity == null) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng không tồn tại");

        }
        if (!entity.getStatusShipping().equals(EnumShipping.CHUA_XAC_NHAN)) {
            return new DataObj().setEdesc("400").setEcode("không thể hủy đơn hàng khi đã xác nhận");

        }
        CustomerEntity customer = customerRepository.findByIdUser(getAuthUID());
        if (!Objects.equals(customer.getId(), entity.getCustomerEntity().getId())) {
            return new DataObj().setEdesc("400").setEcode("không thể hủy đơn hàng này (không đủ quyền hạn)");

        }
        entity.setAddress(updateBillCustomer.getAddress());
        entity.setSdt(updateBillCustomer.getSdt());
        entity.setFullName(updateBillCustomer.getFullname());
        entity.setNote(updateBillCustomer.getNote());
        entity.setUpdateAts(LocalDate.now());
        billRepository.save(entity);
        return new DataObj().setEdesc("200").setEcode("update success");
    }

    @Override
    public DataObj cancelBillCustomer(UpdateBillCustomer updateBillCustomer) {
        BillEntity billEntity = billRepository.findByidBill(updateBillCustomer.getIdBill());
        CustomerEntity customer = customerRepository.findByIdUser(getAuthUID());
        if (!Objects.equals(customer.getId(), billEntity.getCustomerEntity().getId())) {
            return new DataObj().setEdesc("400").setEcode("không thể hủy đơn hàng này (không đủ quyền hạn)");

        }
        if (billEntity.getStatusShipping() == EnumShipping.CHUA_XAC_NHAN || billEntity.getStatusShipping() == EnumShipping.DA_XAC_NHAN_VA_DONG_GOI) {
            billEntity.setStatusShipping(EnumShipping.HUY);
        }
        if (billEntity.getStatusShipping() == EnumShipping.DA_GIAO_BEN_VAN_CHUYEN) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng đã giao bên vận chuyển không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.HUY) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng này đã được hủy trước đó");
        }
        if (billEntity.getStatusShipping() == EnumShipping.KHACH_DA_NHAN_HANG) {
            return new DataObj().setEdesc("400").setEcode("khách đã nhận hàng không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.HOAN_HANG) {
            return new DataObj().setEdesc("400").setEcode("đơn hàng đang được hoàn ề không thể hủy");
        }
        billEntity.setUpdateAts(LocalDate.now());
        billRepository.save(billEntity);

        return new DataObj().setEdesc("200").setEcode("Hủy Đơn Thành Công");
    }

    @Override
    public DataObj cancelBillManager(BillManager billManager) {
        BillEntity billEntity = billRepository.findByidBill(billManager.getIdBill());
        if (billEntity == null) {
            return new DataObj().setEdesc("400").setEcode("không tìm thấy đơn hàng");
        }
        CustomerEntity customer = billEntity.getCustomerEntity();

        if (billEntity.getStatusShipping() == EnumShipping.CHUA_XAC_NHAN || billEntity.getStatusShipping() == EnumShipping.DA_XAC_NHAN_VA_DONG_GOI) {
            billEntity.setStatusShipping(EnumShipping.HUY);
        }
        if (billEntity.getStatusShipping() == EnumShipping.DA_GIAO_BEN_VAN_CHUYEN) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng đã giao bên vận chuyển không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.HUY) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng này đã được hủy trước đó");
        }
        if (billEntity.getStatusShipping() == EnumShipping.KHACH_DA_NHAN_HANG) {
            return new DataObj().setEdesc("400").setEcode("khách đã nhận hàng không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.HOAN_HANG) {
            return new DataObj().setEdesc("400").setEcode("đơn hàng đang được hoàn ề không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.DA_XAC_NHAN_VA_DONG_GOI) {

            List<ProductDetailEntity> productDetailEntityList = new ArrayList<>();
            List<OrderDetailEntity> orderDetailEntity = billEntity.getOderDetailEntities();
            for (OrderDetailEntity orderDetail : orderDetailEntity) {
                ProductDetailEntity productDetailEntity = orderDetail.getProductDetailEntities();
                productDetailEntity.setQuantity(productDetailEntity.getQuantity() + orderDetail.getQuantity_oder());
                productDetailEntityList.add(productDetailEntity);
            }
            productDetailRepository.saveAll(productDetailEntityList);

        }
        billEntity.setUpdateAts(LocalDate.now());

        return new DataObj().setEdesc("200").setEcode("Hủy đơn hàng Thành công");
    }

    @Override
    public DataObj confirmBillManager(BillManager billManager) {
        BillEntity billEntity = billRepository.findByidBill(billManager.getIdBill());
        if (billEntity == null) {
            return new DataObj().setEdesc("200").setEcode("Đơn hàng không tồn tại ");
        }

        if (billEntity.getStatusShipping() == EnumShipping.CHUA_XAC_NHAN) {
            billEntity.setStatusShipping(EnumShipping.DA_XAC_NHAN_VA_DONG_GOI);
        }
        if (billEntity.getStatusShipping() == EnumShipping.DA_GIAO_BEN_VAN_CHUYEN) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng đã giao bên vận chuyển không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.HUY) {
            return new DataObj().setEdesc("400").setEcode("Đơn hàng này đã được hủy trước đó");
        }
        if (billEntity.getStatusShipping() == EnumShipping.KHACH_DA_NHAN_HANG) {
            return new DataObj().setEdesc("400").setEcode("khách đã nhận hàng không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.HOAN_HANG) {
            return new DataObj().setEdesc("400").setEcode("đơn hàng đang được hoàn ề không thể hủy");
        }
        if (billEntity.getStatusShipping() == EnumShipping.DA_XAC_NHAN_VA_DONG_GOI) {
            return new DataObj().setEdesc("400").setEcode("đơn hàng đang trong trạng thái đã xác nhận và đóng gói rồi");
        }

        List<ProductDetailEntity> productDetailEntityList = new ArrayList<>();
        List<OrderDetailEntity> orderDetailEntities = billEntity.getOderDetailEntities();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
            ProductDetailEntity productDetailEntity = orderDetailEntity.getProductDetailEntities();
            if (productDetailEntity.getQuantity() < orderDetailEntity.getQuantity_oder()) {
                return new DataObj().setEdesc("400").setEcode("số lượng sản phẩm " + productDetailEntity.getIdProduct().getNameProduct() + " quá lớn hăc sản phẩm đã hết");
            }
            productDetailEntity.setQuantity(productDetailEntity.getQuantity() - orderDetailEntity.getQuantity_oder());
            productDetailEntityList.add(productDetailEntity);
        }
        productDetailRepository.saveAll(productDetailEntityList);
        billEntity.setUpdateAts(LocalDate.now());
        billRepository.save(billEntity);


        return new DataObj().setEdesc("200").setEcode("Cập nhật đơn hàng thành công");
    }


}


