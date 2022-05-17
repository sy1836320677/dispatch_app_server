package com.example.dispatch_app_server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
public enum StringEnum {
    SUPER_ADMIN("super_admin","超级管理员"),
    ADMIN("admin","管理员"),
    USER("user","普通用户"),
    NULL(null,"未获得权限");

    public String type;
    public String msg;

    public static StringEnum find(String push_or_message){
        StringEnum[] stringEnums = StringEnum.values();
        StringEnum stringEnum = StringEnum.NULL;
        for(int i = 0; i < stringEnums.length; i++){
            if (StringUtils.equals(stringEnums[i].getType(),push_or_message)) {
                stringEnum=stringEnums[i];
            }
        }
        return stringEnum;
    }
}
