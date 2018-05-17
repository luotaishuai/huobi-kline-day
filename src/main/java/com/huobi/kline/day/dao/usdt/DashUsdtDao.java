package com.huobi.kline.day.dao.usdt;

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
public interface DashUsdtDao extends CrudRepository<DashUsdtDay,Long> {

    @Query(value = "select z from DashUsdtDay as z where z.id=(select max(z.id) from DashUsdtDay as z)")
    DashUsdtDay findLastTimeData();
}
