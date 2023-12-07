package com.example.spring_boot.service.impl;

import com.example.spring_boot.controller.BaseController;
import com.example.spring_boot.entity.*;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.*;
import com.example.spring_boot.repository.*;
import com.example.spring_boot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    EmailServiceImpl emailService;
    @Autowired
    VoucherRepository voucherRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    SizeRepository sizeRepository;


    @Override
    public DataObj create(CreateBillManger createBillManger) {
        try {
            long randomNumber = ThreadLocalRandom.current().nextLong(10000000L, 100000000L);
            Optional<CustomerEntity> customer = customerRepository.findById(createBillManger.getIdCustomer());
            BillEntity billEntity = new BillEntity();
            billEntity.setId(randomNumber);
            while (billRepository.existsById(billEntity.getId())) {
                billEntity.setId(randomNumber);

            }
            List<OrderDetailEntity> orderdetails = new ArrayList<>();
            billEntity.setCustomerEntity(customer.get());
            billEntity.setCreateAt(LocalDate.now());
            List<OrderDetailRequest> orderDetailRequests = createBillManger.getOrderDetailRequests();
            for (OrderDetailRequest odr : orderDetailRequests) {
                ProductDetailEntity productEntity = productDetailRepository.findByIdProductDetail(odr.getProductId());
                ProductEntity product = productRepository.findByIdProduct(productEntity.getIdProduct().getId());


                if (product == null) {
                    return new DataObj().setEdesc("400").setEdesc("Sản phẩm không tồn tại");
                }
                if (productEntity.getQuantity() < odr.getQuantity()) {
                    return new DataObj().setEdesc("400").setEdesc("Số Lượng Sản Phẩm trên bill Lớn hơn số hàng tồn trong kho");

                }
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                orderDetailEntity.setProductDetailEntities(productEntity);
                orderDetailEntity.setQuantity_oder(odr.getQuantity());
                orderDetailEntity.setPrice(product.getPrice());
                orderDetailEntity.setDownPrice(product.getDiscount() != null ? product.getPrice() * (product.getDiscount() / 100) : 0);
                orderDetailEntity.setIntoMoney(product.getPrice() - orderDetailEntity.getDownPrice());
                orderDetailEntity.setBillEntity(billEntity);
                orderdetails.add(orderDetailEntity);

            }
            if (createBillManger.getVoucherId() != null && createBillManger.getVoucherId() != 0) {
                VoucherEntity voucherEntity = voucherRepository.findByIdVoucher(createBillManger.getVoucherId());
                if (voucherEntity == null) {
                    return new DataObj().setEdesc("400").setEdesc("Không tìm thấy voucher");

                }
                if (createBillManger.getTotal() < 350000L) {
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
                billEntity.setStatusShipping(EnumShipping.CHUA_XAC_NHAN);
                billEntity.setAddress(createBillManger.getAddress());
                billEntity.setSalesStatus(true);

            billEntity.setSdt(createBillManger.getPhoneNumber());
            billEntity.setTotal(createBillManger.getTotal());
            billEntity.setTransportFee(billEntity.getTransportFee());
            billEntity.setDownTotal(createBillManger.getDownTotal());
            billEntity.setFullName(createBillManger.getFullName());
            billEntity.setNote(createBillManger.getNote());
            billRepository.save(billEntity);
            orderDetailRepository.saveAll(orderdetails);
//            CustomerEntity customerEntity = customerRepository.findByIdUser(customer.get().getId());
//            if (customer.get().getEmail() != null) {
//                emailService.sendCreateBill(customerEntity, billEntity);
//            }
            return new DataObj().setEdesc("200").setEcode("success");
        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEdesc("400").setEcode("Error");
        }
    }

    @Override
    public DataObj createOff(CreateBillMangerOff createBillManger) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String formattedDate = LocalDateTime.now().format(formatter);
            Long idBill = Long.parseLong(formattedDate);
            Optional<CustomerEntity> customer = customerRepository.findById(3L);
            BillEntity billEntity = new BillEntity();
            billEntity.setId(idBill);
//            while (billRepository.existsById(billEntity.getId())) {
//                billEntity.setId(randomNumber);
//
//            }
            List<OrderDetailEntity> orderdetails = new ArrayList<>();
            billEntity.setCustomerEntity(customer.get());
            billEntity.setCreateAt(LocalDate.now());
            List<OrderDetailRequest> orderDetailRequests = createBillManger.getOrderDetailRequests();
            for (OrderDetailRequest odr : orderDetailRequests) {
                ProductDetailEntity productEntity = productDetailRepository.findByIdProductAndIdPropertyAndAndIdSize(odr.getProductId(), odr.getPropertyId(), odr.getSizeId());
                ProductEntity product = productRepository.findByIdProduct(odr.getProductId());
                PropertyEntity property = propertyRepository.findByIdProperty(odr.getPropertyId());
                SizeEntity sizeEntity = sizeRepository.findBySizeID(odr.getSizeId());
                if (productEntity == null) {
                    return new DataObj().setEdesc("420").setEdesc("Sản phẩm không tồn tại");

                }
                if (product == null) {
                    return new DataObj().setEdesc("420").setEdesc("Sản phẩm không tồn tại");
                }
                if (property == null) {
                    return new DataObj().setEdesc("420").setEdesc("Màu sắc không tồn tại");
                }
                if (sizeEntity == null) {
                    return new DataObj().setEdesc("420").setEdesc("size không tồn tại");
                }
                if (productEntity.getQuantity() < odr.getQuantity()) {
                    return new DataObj().setEdesc("420").setEdesc("Số Lượng Sản Phẩm trên bill Lớn hơn số hàng tồn trong kho");
                }

                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                orderDetailEntity.setProductDetailEntities(productEntity);
                orderDetailEntity.setQuantity_oder(odr.getQuantity());
                orderDetailEntity.setPrice(product.getPrice());
                orderDetailEntity.setDownPrice(product.getDiscount() != null ? product.getPrice() * (product.getDiscount() / 100) : 0);
                orderDetailEntity.setIntoMoney(product.getPrice() - orderDetailEntity.getDownPrice());
                orderDetailEntity.setBillEntity(billEntity);
                orderdetails.add(orderDetailEntity);
                productEntity.setQuantity(productEntity.getQuantity() - odr.getQuantity());
                productDetailRepository.save(productEntity);
            }
            if (createBillManger.getVoucherId() != null && createBillManger.getVoucherId() != 0) {
                VoucherEntity voucherEntity = voucherRepository.findByIdVoucher(createBillManger.getVoucherId());
                if (voucherEntity == null) {
                    return new DataObj().setEdesc("420").setEdesc("Không tìm thấy voucher");

                }
                if (createBillManger.getTotal() < 350000L) {
                    return new DataObj().setEdesc("420").setEdesc("Hóa Đơn Nhỏ Hơn 350k không thể ap dụng Voucher");
                }
                if (voucherEntity.getAmount() <= 0) {
                    return new DataObj().setEdesc("420").setEdesc("voucher đã hết hạn");

                }

                billEntity.setDiscount(voucherEntity.getDiscount());
                billEntity.setVoucherId(voucherEntity.getId());
                voucherEntity.setAmount(voucherEntity.getAmount() - 1L);
                voucherRepository.save(voucherEntity);
            }
            Optional<CustomerEntity> customerEntity = customerRepository.findById(4L);
            billEntity.setStatusShipping(EnumShipping.KHACH_DA_NHAN_HANG);
            billEntity.setAddress("shop bán giày");
            billEntity.setPayment(0);
            billEntity.setCustomerEntity(customerEntity.get());
            billEntity.setSalesStatus(false);
            billEntity.setSdt(createBillManger.getPhoneNumber());
            billEntity.setTotal(createBillManger.getTotal());
            billEntity.setTransportFee(0.0);
            billEntity.setDownTotal(createBillManger.getDownTotal());
            billEntity.setFullName(createBillManger.getFullName());
            billEntity.setNote(createBillManger.getNote());
            billRepository.save(billEntity);
            orderDetailRepository.saveAll(orderdetails);
//            CustomerEntity customerEntity = customerRepository.findByIdUser(customer.get().getId());
//            if (customer.get().getEmail() != null) {
//                emailService.sendCreateBill(customerEntity, billEntity);
//            }
            return new DataObj().setEdesc("200").setEcode("success");
        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEdesc("420").setEcode("Error");
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
    public DataObj confirmBillManager(BillRequest billRequest) {
        try {
            BillEntity billEntity = billRepository.findByidBill(billRequest.getIdBill());


            if (billRequest.getOrderDetailRequests() != null) {
                List<OrderDetailRequest> orderDetail = billRequest.getOrderDetailRequests();
                for (OrderDetailRequest orderDetailRequest : orderDetail) {
                    if (orderDetailRequest.getOrderDetailId() != 0) {
                        OrderDetailEntity orderDetailUpdate = orderDetailRepository.findByidOrOrderById(orderDetailRequest.getOrderDetailId());
                        ProductDetailEntity productDetailEntity = orderDetailUpdate.getProductDetailEntities();
                        if (productDetailEntity.getQuantity() < orderDetailRequest.getQuantity()) {
                            return new DataObj().setEdesc("400").setEcode("Số Lượng sản phẩm quá lớn");

                        }
                        if (orderDetailUpdate == null) {
                            return new DataObj().setEdesc("400").setEcode("Order không tồn tại");
                        }
                        orderDetailUpdate.setQuantity_oder(orderDetailRequest.getQuantity());
                        orderDetailRepository.save(orderDetailUpdate);

                    }
                }
            }
            if (billRequest.getStatus() == EnumShipping.DA_XAC_NHAN_VA_DONG_GOI) {

                List<OrderDetailEntity> orderDetailEntities = billEntity.getOderDetailEntities();
                for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
                    ProductDetailEntity productDetailEntity = orderDetailEntity.getProductDetailEntities();
                    if (productDetailEntity.getQuantity() < orderDetailEntity.getQuantity_oder()) {
                        return new DataObj().setEdesc("400").setEcode("số lượng sản phẩm " + productDetailEntity.getIdProduct().getNameProduct() + " quá lớn hăc sản phẩm đã hết");
                    }
                    productDetailEntity.setQuantity(productDetailEntity.getQuantity() - orderDetailEntity.getQuantity_oder());
                    productDetailRepository.save(productDetailEntity);
                }
                billEntity.setUpdateAts(LocalDate.now());
            }

            billEntity.setStatusShipping(billRequest.getStatus());
            billEntity.setUpdateAts(LocalDate.now());
            billRepository.save(billEntity);

            return new DataObj().setEdesc("200").setEcode("Cập nhật đơn hàng thành công");
        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEdesc("420").setEcode("Lỗi Cập nhật đơn hàng");


        }

    }

    @Override
    public Object findByNameLike(BillRequest billRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(billRequest.getPage()), Math.toIntExact(billRequest.getSize()));
        Page<Object> billEntities = billRepository.findByNameLike(billRequest.getFullName(), pageable);

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData(billEntities.getContent());
        return dataObj;

    }

    @Override
    public Object findByDatePhoneStatus(SearchBill searchBill) {

        try {
            Pageable pageable = PageRequest.of(Math.toIntExact(searchBill.getPage()), Math.toIntExact(searchBill.getSize()));

            Page<Object> billEntities = billRepository.findAllBill(
                    searchBill.getStartDate(), searchBill.getPhone(), searchBill.getEmail(), searchBill.getStatusShipping(), searchBill.getPayment(),
                    pageable);
            DataObj dataObj = new DataObj();
            dataObj.setEcode("200");
            dataObj.setEdesc("success");
            dataObj.setData(billEntities);
            return dataObj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error bill search");
        }

    }

    @Override
    public Object findByIdBill(Long idBill) {
        try {
            Object billById = billRepository.findBillById(idBill);
            if (billById == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy bill");
            }
            return billById;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi tìm bill theo id");
        }
    }

    @Override
    public DataObj NumberOfOrderStatuses() {
        try {
            return new DataObj().setEdesc("200").setEcode("thành công").setData(billRepository.NumberOfOrderStatuses());

        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEdesc("400").setEcode("Lỗi tìm trạng thái");

        }
    }
}






