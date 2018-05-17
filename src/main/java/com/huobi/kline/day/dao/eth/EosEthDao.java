package com.huobi.kline.day.dao.eth;

import com.huobi.kline.day.domain.eth.EosEthDay;
import com.huobi.kline.day.domain.usdt.DashUsdtDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 * @create 2018-04-18 11:12
 **/
@Repository
public interface EosEthDao extends CrudRepository<EosEthDay,Long> {
    @Query(value = "select z from EosEthDay as z where z.id=(select max(z.id) from EosEthDay as z)")
    EosEthDay findLastTimeData();
}
