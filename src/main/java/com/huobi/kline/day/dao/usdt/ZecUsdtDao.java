package com.huobi.kline.day.dao.usdt;

import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import com.huobi.kline.day.domain.usdt.ZecUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface ZecUsdtDao extends CrudRepository<ZecUsdtDay,Long> {
    @Query(value = "select z from ZecUsdtDay as z where z.id=(select max(z.id) from ZecUsdtDay as z)")
    ZecUsdtDay findLastTimeData();
}
