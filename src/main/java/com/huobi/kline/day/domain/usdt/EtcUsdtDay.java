package com.huobi.kline.day.domain.usdt;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author anonymity
 * @create 2018-04-18 10:46
 **/
@Data
@Entity
@Table(name = "etcusdt_day")
public class EtcUsdtDay {
    @Id
    private Long id;
    @Column(precision = 40, scale = 20)
    private BigDecimal amount;
    @Column(precision = 40, scale = 20)
    private BigDecimal count;
    @Column(precision = 40, scale = 20)
    private BigDecimal open;
    @Column(precision = 40, scale = 20)
    private BigDecimal close;
    @Column(precision = 40, scale = 20)
    private BigDecimal low;
    @Column(precision = 40, scale = 20)
    private BigDecimal high;
    @Column(precision = 40, scale = 20)
    private BigDecimal vol;

}
