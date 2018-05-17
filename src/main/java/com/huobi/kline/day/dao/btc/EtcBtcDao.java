package com.huobi.kline.day.dao.btc;

import com.huobi.kline.day.domain.btc.EtcBtcDay;
import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface EtcBtcDao extends CrudRepository<EtcBtcDay,Long> {
    @Query(value = "select z from EtcBtcDay as z where z.id=(select max(z.id) from EtcBtcDay as z)")
    EtcBtcDay findLastTimeData();
}
