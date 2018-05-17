package com.huobi.kline.day.dao.eth;

import com.huobi.kline.day.domain.eth.OmgEthDay;
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
public interface OmgEthDao extends CrudRepository<OmgEthDay,Long> {

    @Query(value = "select z from OmgEthDay as z where z.id=(select max(z.id) from OmgEthDay as z)")
    OmgEthDay findLastTimeData();
}
