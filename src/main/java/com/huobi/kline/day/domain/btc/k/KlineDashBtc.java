package com.huobi.kline.day.domain.btc.k;

import com.huobi.kline.day.domain.btc.DashBtcDay;
import lombok.Data;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 10:44
 **/
@Data
public class KlineDashBtc {
    private String status;
    private String ch;
    private Long ts;
    private List<DashBtcDay> data;
}
