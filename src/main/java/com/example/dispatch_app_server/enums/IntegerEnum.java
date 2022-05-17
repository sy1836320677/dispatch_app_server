package com.example.dispatch_app_server.enums;

import com.example.dispatch_app_server.commons.GetByIndexEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  IntegerEnum implements GetByIndexEnum {
    STATE0(0,"状态1"),
    STATE1(1,"状态2"),
    STATE2(2,"状态3"),
    STATE3(3,"状态4"),
    STATE4(4,"状态5"),
    STATE5(5,"状态6"),
    ;
    final int index;
    final String name;
}
