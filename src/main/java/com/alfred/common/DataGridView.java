package com.alfred.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来存放我们的数据
 * @author Alfred
 * @date 2020/3/14 9:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {

    private Long code=0L;
    private String msg="";
    private Long count;
    private Object data;

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
}
