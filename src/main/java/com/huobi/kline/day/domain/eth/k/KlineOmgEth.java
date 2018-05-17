package com.huobi.kline.day.domain.eth.k;

import com.huobi.kline.day.domain.eth.OmgEthDay;
import lombok.Data;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 10:44
 **/
@Data
public class KlineOmgEth {
    private String status;
    private String ch;
    private Long ts;
    private List<OmgEthDay> data;
}
