package com.example.dispatch_app_server.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobNeedPeoplePojo {
    private String type;
    private Integer number;
}
