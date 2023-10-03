package com.example.spring_boot.payload;

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
    private Object data2;

    public DataObj(String ecode, String edesc, Object data) {
        this.ecode = ecode;
        this.edesc = edesc;
        this.data = data;
    }

}
