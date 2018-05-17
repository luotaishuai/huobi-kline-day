package com.huobi.kline.day.dao.btc;

import com.huobi.kline.day.domain.btc.EthBtcDay;
import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface EthBtcDao extends CrudRepository<EthBtcDay, Long> {
    @Query(value = "select z from EthBtcDay as z where z.id=(select max(z.id) from EthBtcDay as z)")
    EthBtcDay findLastTimeData();
}
