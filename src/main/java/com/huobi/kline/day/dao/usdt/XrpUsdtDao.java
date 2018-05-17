package com.huobi.kline.day.dao.usdt;

import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import com.huobi.kline.day.domain.usdt.XrpUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface XrpUsdtDao extends CrudRepository<XrpUsdtDay,Long> {
    @Query(value = "select z from XrpUsdtDay as z where z.id=(select max(z.id) from XrpUsdtDay as z)")
    XrpUsdtDay findLastTimeData();
}
