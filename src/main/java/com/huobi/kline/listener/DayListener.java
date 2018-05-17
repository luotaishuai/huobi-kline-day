package com.huobi.kline.listener;

import com.huobi.kline.day.service.DayKlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.TimeZone;

/**
 * @author anonymity
 * @create 2018-04-25 13:40
 **/
@Configuration
public class DayListener {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DayKlineService dayKlineService;

    // 每天的00:05执行一次
//    @Scheduled(cron = "0 5 0 * * ?")
    // 每6个小时获取一次
    @Scheduled(fixedRate = 21600 * 1000)
    public void getDayKline() {
        LOG.info("====定时任务开始====");
        coin2UsdtTask();
        coin2EthTask();
        coin2BtcTask();
        LOG.info("====定时任务结束====");
    }

    // 定时coin2EthTask
    private void coin2EthTask() {
        dayKlineService.scheduledEos2Eth();
        dayKlineService.scheduledOmg2Eth();
    }

    // 定时coin2UsdtTask
    private void coin2UsdtTask() {
        dayKlineService.scheduledBch2Usdt();
        dayKlineService.scheduledBtc2Usdt();
        dayKlineService.scheduledEth2Usdt();
        dayKlineService.scheduledEos2Usdt();
        dayKlineService.scheduledDash2Usdt();
        dayKlineService.scheduledEtc2Usdt();
        dayKlineService.scheduledLtc2Usdt();
        dayKlineService.scheduledOmg2Usdt();
        dayKlineService.scheduledXrp2Usdt();
        dayKlineService.scheduledZec2Usdt();
    }

    // 定时coin2BtcTask
    private void coin2BtcTask() {
        dayKlineService.scheduledBch2Btc();
        dayKlineService.scheduledDash2Btc();
        dayKlineService.scheduledEos2Btc();
        dayKlineService.scheduledEth2Btc();
        dayKlineService.scheduledEtc2Btc();
        dayKlineService.scheduledLtc2Btc();
        dayKlineService.scheduledOmg2Btc();
        dayKlineService.scheduledXrp2Btc();
        dayKlineService.scheduledZec2Btc();

    }

}
