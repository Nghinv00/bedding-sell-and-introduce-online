package com.nghinv.beddingsellintroduce.common.dto.web;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Champion implements Serializable {

    //private final String name;
    private String type;
//  @RequiredArgsConstructor + final đồng nghĩa với Constructor như thế này.
//  public Champion(String name) {
//    this.name = name;
//  }


//    // Tạo ra get/set cho name
//    @Getter @Setter private String name;
//    // Tạo ra protected setType(String) thay vì public
//    @Setter(AccessLevel.PROTECTED) private String type1;
//
//    @ToString.Exclude private String type2;
}
