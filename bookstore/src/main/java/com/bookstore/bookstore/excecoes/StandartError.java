package com.bookstore.bookstore.excecoes;

import java.text.SimpleDateFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandartError {
   
    private Long timestamp ;
    private Integer status;
    private String error;

  

    
}
