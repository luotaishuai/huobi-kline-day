package com.huobi.kline.day.domain.btc.k;

import com.huobi.kline.day.domain.btc.OmgBtcDay;
import lombok.Data;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 10:44
 **/
@Data
public class KlineOmgBtc {
    private String status;
    private String ch;
    private Long ts;
    private List<OmgBtcDay> data;
}
