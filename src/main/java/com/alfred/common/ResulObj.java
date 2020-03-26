package com.alfred.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Alfred
 * @date 2020/3/14 9:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResulObj {
    //业务响应码
    private int code ;
    //业务消息
    private String msg;
}
