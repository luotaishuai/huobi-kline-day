package com.huobi.kline.day.dao.usdt;

import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import com.huobi.kline.day.domain.usdt.OmgUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface OmgUsdtDao extends CrudRepository<OmgUsdtDay,Long> {
    @Query(value = "select z from OmgUsdtDay as z where z.id=(select max(z.id) from OmgUsdtDay as z)")
    OmgUsdtDay findLastTimeData();
}
