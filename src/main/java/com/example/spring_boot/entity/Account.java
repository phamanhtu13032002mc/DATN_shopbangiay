package com.example.spring_boot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
    private static final long OTP_TIME_GENERATE = 1 * 60 * 1000;   // 1 minutes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String capcha;

    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Authority> authorities;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Image> image;
    @JsonIgnore
    public boolean isOTPRequired() {
        if (this.getOneTimePassword() == null) {
            return false;
        }

        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
            // OTP expires
            return false;
        }

        return true;
    }

    //check neu ton tai ma se gui sau 1 phut
    @JsonIgnore
    public boolean isOTPGenerrate() {

        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

        if (otpRequestedTimeInMillis + OTP_TIME_GENERATE < currentTimeInMillis) {
            return false;
        }
        return true;
    }


}
