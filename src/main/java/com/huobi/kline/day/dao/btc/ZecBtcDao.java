package com.huobi.kline.day.dao.btc;

import com.huobi.kline.day.domain.btc.ZecBtcDay;
import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface ZecBtcDao extends CrudRepository<ZecBtcDay, Long> {
    @Query(value = "select z from ZecBtcDay as z where z.id=(select max(z.id) from ZecBtcDay as z)")
    ZecBtcDay findLastTimeData();
}
