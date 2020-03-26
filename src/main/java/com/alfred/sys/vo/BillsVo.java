package com.alfred.sys.vo;

import com.alfred.sys.domain.Bills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Alfred
 * @date 2020/3/14 12:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BillsVo extends Bills {

    private static final long serialVersionUID = 1L;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private Integer page;
    private Integer limit;
}
