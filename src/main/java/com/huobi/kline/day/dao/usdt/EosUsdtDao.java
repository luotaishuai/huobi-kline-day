package com.huobi.kline.day.dao.usdt;

import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import com.huobi.kline.day.domain.usdt.EosUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface EosUsdtDao extends CrudRepository<EosUsdtDay,Long> {
    @Query(value = "select z from EosUsdtDay as z where z.id=(select max(z.id) from EosUsdtDay as z)")
    EosUsdtDay findLastTimeData();
}
