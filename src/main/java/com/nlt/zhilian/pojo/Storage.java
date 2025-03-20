package com.nlt.zhilian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private String product;
    private String id;
    private int stock;
    private Date entryDate;
    private Date expirationDate;
    private String area;
    private String status;

}
