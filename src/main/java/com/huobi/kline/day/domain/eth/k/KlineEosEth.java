package com.huobi.kline.day.domain.eth.k;

import com.huobi.kline.day.domain.eth.EosEthDay;
import lombok.Data;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 10:44
 **/
@Data
public class KlineEosEth {
    private String status;
    private String ch;
    private Long ts;
    private List<EosEthDay> data;
}
