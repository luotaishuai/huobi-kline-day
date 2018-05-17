package com.huobi.kline.day.dao.usdt;

import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import com.huobi.kline.day.domain.usdt.EtcUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface EtcUsdtDao extends CrudRepository<EtcUsdtDay,Long> {
    @Query(value = "select z from EtcUsdtDay as z where z.id=(select max(z.id) from EtcUsdtDay as z)")
    EtcUsdtDay findLastTimeData();
}
