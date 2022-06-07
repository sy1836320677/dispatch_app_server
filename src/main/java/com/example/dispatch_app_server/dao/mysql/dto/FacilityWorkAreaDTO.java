package com.example.dispatch_app_server.dao.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FacilityWorkAreaDTO {
    private Integer facilityId;
    private String skillRequirement;
    private Integer maintainTime;
    private Integer longestWorkTime;
    private Integer type;
    private Integer workType;
    private Integer size;

    private Integer workAreaId;
    private String name;
    private String scope;
}
