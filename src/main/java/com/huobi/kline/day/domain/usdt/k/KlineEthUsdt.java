package com.huobi.kline.day.domain.usdt.k;

import com.huobi.kline.day.domain.usdt.EthUsdtDay;
import lombok.Data;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 10:44
 **/
@Data
public class KlineEthUsdt {
    private String status;
    private String ch;
    private Long ts;
    private List<EthUsdtDay> data;
}
