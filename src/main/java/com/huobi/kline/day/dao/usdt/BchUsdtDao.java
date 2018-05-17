package com.huobi.kline.day.dao.usdt;

import com.huobi.kline.day.domain.usdt.BchUsdtDay;
import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface BchUsdtDao extends CrudRepository<BchUsdtDay,Long> {
    @Query(value = "select z from BchUsdtDay as z where z.id=(select max(z.id) from BchUsdtDay as z)")
    BchUsdtDay findLastTimeData();
}
