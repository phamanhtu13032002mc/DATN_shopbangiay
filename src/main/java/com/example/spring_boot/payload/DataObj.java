package com.example.spring_boot.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class DataObj {

    private String ecode;
    private String edesc;
    private Object data;
    @JsonIgnore
    private Object data2;
    public DataObj(Object data) {
        this.ecode = ecode;
        this.edesc = edesc;
        this.data = data;
    }
//    public DataObj(EventEntity ecode, String edesc, Object data) {
//        this.ecode = String.valueOf(ecode);
//        this.edesc = edesc;
//        this.data = data;
//    }
//
//    public DataObj(String s, String đánhDấuThànhCông, boolean data) {
//    }
//
//    public DataObj(VoucherEntity ecode, String edesc, Object data) {
//        this.ecode = String.valueOf(ecode);
//        this.edesc = edesc;
//        this.data = data;
//    }
//
//
//    public DataObj(List<CategoryRequest> ecode, String edesc, Object data) {
//        this.ecode = String.valueOf(ecode);
//        this.edesc = edesc;
//        this.data = data;
//    }
}
