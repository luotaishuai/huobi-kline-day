package com.huobi.kline.day.service;

import com.huobi.kline.day.dao.btc.*;
import com.huobi.kline.day.dao.eth.EosEthDao;
import com.huobi.kline.day.dao.eth.OmgEthDao;
import com.huobi.kline.day.dao.usdt.*;
import com.huobi.kline.day.domain.btc.*;
import com.huobi.kline.day.domain.btc.k.*;
import com.huobi.kline.day.domain.eth.EosEthDay;
import com.huobi.kline.day.domain.eth.OmgEthDay;
import com.huobi.kline.day.domain.eth.k.KlineEosEth;
import com.huobi.kline.day.domain.eth.k.KlineOmgEth;
import com.huobi.kline.day.domain.usdt.*;
import com.huobi.kline.day.domain.usdt.k.*;
import com.huobi.kline.util.HttpUtils;
import com.huobi.kline.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.huobi.kline.common.HuoBiConst.*;

/**
 * @author anonymity
 * @create 2018-04-26 10:00
 **/
@Service
public class DayKlineService {

    private final Logger LOG = LoggerFactory.getLogger(DayKlineService.class);

    @Resource
    private BchUsdtDao bchUsdtDao;
    @Resource
    private BtcUsdtDao btcUsdtDao;
    @Resource
    private EthUsdtDao ethUsdtDao;
    @Resource
    private EosUsdtDao eosUsdtDao;
    @Resource
    private DashUsdtDao dashUsdtDao;
    @Resource
    private EtcUsdtDao etcUsdtDao;
    @Resource
    private LtcUsdtDao ltcUsdtDao;
    @Resource
    private OmgUsdtDao omgUsdtDao;
    @Resource
    private XrpUsdtDao xrpUsdtDao;
    @Resource
    private ZecUsdtDao zecUsdtDao;

    @Resource
    private EosEthDao eosEthDao;
    @Resource
    private OmgEthDao omgEthDao;

    @Resource
    private BchBtcDao bchBtcDao;
    @Resource
    private DashBtcDao dashBtcDao;
    @Resource
    private EosBtcDao eosBtcDao;
    @Resource
    private EthBtcDao ethBtcDao;
    @Resource
    private EtcBtcDao etcBtcDao;
    @Resource
    private LtcBtcDao ltcBtcDao;
    @Resource
    private OmgBtcDao omgBtcDao;
    @Resource
    private XrpBtcDao xrpBtcDao;
    @Resource
    private ZecBtcDao zecBtcDao;


    // ################################## BTC ######################################### //

    public void scheduledZec2Btc() {
        try {
            List<ZecBtcDay> list = zec2btc();
            if (list != null) {
                ZecBtcDay data = zecBtcDao.findLastTimeData();
                if (data != null) {
                    List<ZecBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> zecBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> zecBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the zec to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<ZecBtcDay> zec2btc() {
        try {
            String json = getJson(ZECBTC);
            if (json != null) {
                KlineZecBtc kline = JsonUtil.jsonToEntity(json, KlineZecBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query zec to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledXrp2Btc() {
        try {
            List<XrpBtcDay> list = xrp2btc();
            if (list != null) {
                XrpBtcDay data = xrpBtcDao.findLastTimeData();
                if (data != null) {
                    List<XrpBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> xrpBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> xrpBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the xrp to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<XrpBtcDay> xrp2btc() {
        try {
            String json = getJson(XRPBTC);
            if (json != null) {
                KlineXrpBtc kline = JsonUtil.jsonToEntity(json, KlineXrpBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query xrp to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledOmg2Btc() {
        try {
            List<OmgBtcDay> list = omg2btc();
            if (list != null) {
                OmgBtcDay data = omgBtcDao.findLastTimeData();
                if (data != null) {
                    List<OmgBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> omgBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> omgBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the omg to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<OmgBtcDay> omg2btc() {
        try {
            String json = getJson(OMGBTC);
            if (json != null) {
                KlineOmgBtc kline = JsonUtil.jsonToEntity(json, KlineOmgBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query omg to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledLtc2Btc() {
        try {
            List<LtcBtcDay> list = ltc2btc();
            if (list != null) {
                LtcBtcDay data = ltcBtcDao.findLastTimeData();
                if (data != null) {
                    List<LtcBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> ltcBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> ltcBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the ltc to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<LtcBtcDay> ltc2btc() {
        try {
            String json = getJson(LTCBTC);
            if (json != null) {
                KlineLtcBtc kline = JsonUtil.jsonToEntity(json, KlineLtcBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query ltc to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEtc2Btc() {
        try {
            List<EtcBtcDay> list = etc2btc();
            if (list != null) {
                EtcBtcDay data = etcBtcDao.findLastTimeData();
                if (data != null) {
                    List<EtcBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> etcBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> etcBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the etc to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<EtcBtcDay> etc2btc() {
        try {
            String json = getJson(ETCBTC);
            if (json != null) {
                KlineEtcBtc kline = JsonUtil.jsonToEntity(json, KlineEtcBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query etc to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEth2Btc() {
        try {
            List<EthBtcDay> list = eth2btc();
            if (list != null) {
                EthBtcDay data = ethBtcDao.findLastTimeData();
                if (data != null) {
                    List<EthBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> ethBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> ethBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the eth to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<EthBtcDay> eth2btc() {
        try {
            String json = getJson(ETHBTC);
            if (json != null) {
                KlineEthBtc kline = JsonUtil.jsonToEntity(json, KlineEthBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query eth to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEos2Btc() {
        try {
            List<EosBtcDay> list = eos2btc();
            if (list != null) {
                EosBtcDay data = eosBtcDao.findLastTimeData();
                if (data != null) {
                    List<EosBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> eosBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> eosBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the eos to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<EosBtcDay> eos2btc() {
        try {
            String json = getJson(EOSBTC);
            if (json != null) {
                KlineEosBtc kline = JsonUtil.jsonToEntity(json, KlineEosBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query eos to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledDash2Btc() {
        try {
            List<DashBtcDay> list = dash2btc();
            if (list != null) {
                DashBtcDay data = dashBtcDao.findLastTimeData();
                if (data != null) {
                    List<DashBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> dashBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> dashBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the dash to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<DashBtcDay> dash2btc() {
        try {
            String json = getJson(DASHBTC);
            if (json != null) {
                KlineDashBtc kline = JsonUtil.jsonToEntity(json, KlineDashBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }

        } catch (Exception e) {
            LOG.error("query dash to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledBch2Btc() {
        try {
            List<BchBtcDay> list = bch2btc();
            if (list != null) {
                BchBtcDay data = bchBtcDao.findLastTimeData();
                if (data != null) {
                    List<BchBtcDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> bchBtcDao.save(l));
                } else {
                    list.stream().forEach(l -> bchBtcDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the bch to btc 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<BchBtcDay> bch2btc() {
        try {
            String json = getJson(BCHBTC);
            if (json != null) {
                KlineBchBtc kline = JsonUtil.jsonToEntity(json, KlineBchBtc.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query bch to btc 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    // ##################################### ETH ###################################### //


    public void scheduledOmg2Eth() {
        try {
            List<OmgEthDay> list = omg2eth();
            if (list != null) {
                OmgEthDay data = omgEthDao.findLastTimeData();
                if (data != null) {
                    List<OmgEthDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> omgEthDao.save(l));
                } else {
                    list.stream().forEach(l -> omgEthDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the omg to eth 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<OmgEthDay> omg2eth() {
        try {
            String json = getJson(OMGETH);
            if (json != null) {
                KlineOmgEth kline = JsonUtil.jsonToEntity(json, KlineOmgEth.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query omg to eth 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEos2Eth() {
        try {
            List<EosEthDay> list = eos2eth();
            if (list != null) {
                EosEthDay data = eosEthDao.findLastTimeData();
                if (data != null) {
                    List<EosEthDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> eosEthDao.save(l));
                } else {
                    list.stream().forEach(l -> eosEthDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the eos to eth 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<EosEthDay> eos2eth() {
        try {
            String json = getJson(EOSETH);
            if (json != null) {
                KlineEosEth kline = JsonUtil.jsonToEntity(json, KlineEosEth.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query eos to eth 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    // #################################### USDT ####################################### //

    public void scheduledZec2Usdt() {
        try {
            List<ZecUsdtDay> list = zec2usdt();
            if (list != null) {
                ZecUsdtDay data = zecUsdtDao.findLastTimeData();
                if (data != null) {
                    List<ZecUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> zecUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> zecUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the zec to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<ZecUsdtDay> zec2usdt() {
        try {
            String json = getJson(ZECUSDT);
            if (json != null) {
                KlineZecUsdt kline = JsonUtil.jsonToEntity(json, KlineZecUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query zec to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledXrp2Usdt() {
        try {
            List<XrpUsdtDay> list = xrp2usdt();
            if (list != null) {
                XrpUsdtDay data = xrpUsdtDao.findLastTimeData();
                if (data != null) {
                    List<XrpUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> xrpUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> xrpUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the xrp to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    public List<XrpUsdtDay> xrp2usdt() {
        try {
            String json = getJson(XRPUSDT);
            if (json != null) {
                KlineXrpUsdt kline = JsonUtil.jsonToEntity(json, KlineXrpUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query xrp to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledOmg2Usdt() {
        try {
            List<OmgUsdtDay> list = omg2usdt();
            if (list != null) {
                OmgUsdtDay data = omgUsdtDao.findLastTimeData();
                if (data != null) {
                    List<OmgUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> omgUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> omgUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the omg to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<OmgUsdtDay> omg2usdt() {
        try {
            String json = getJson(OMGUSDT);
            if (json != null) {
                KlineOmgUsdt kline = JsonUtil.jsonToEntity(json, KlineOmgUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query omg to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledLtc2Usdt() {
        try {
            List<LtcUsdtDay> list = ltc2usdt();
            if (list != null) {
                LtcUsdtDay data = ltcUsdtDao.findLastTimeData();
                if (data != null) {
                    List<LtcUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> ltcUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> ltcUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the ltc to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<LtcUsdtDay> ltc2usdt() {
        try {
            String json = getJson(LTCUSDT);
            if (json != null) {
                KlineLtcUsdt kline = JsonUtil.jsonToEntity(json, KlineLtcUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query ltc to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEtc2Usdt() {
        try {
            List<EtcUsdtDay> list = etc2usdt();
            if (list != null) {
                EtcUsdtDay data = etcUsdtDao.findLastTimeData();
                if (data != null) {
                    List<EtcUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> etcUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> etcUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the etc to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<EtcUsdtDay> etc2usdt() {
        try {
            String json = getJson(ETCUSDT);
            if (json != null) {
                KlineEtcUsdt kline = JsonUtil.jsonToEntity(json, KlineEtcUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query etc to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledDash2Usdt() {
        try {
            List<DashUsdtDay> list = dash2usdt();
            if (list != null) {
                DashUsdtDay data = dashUsdtDao.findLastTimeData();
                if (data != null) {
                    List<DashUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> dashUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> dashUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the dash to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<DashUsdtDay> dash2usdt() {
        try {
            String json = getJson(DASHUSDT);
            if (json != null) {
                KlineDashUsdt kline = JsonUtil.jsonToEntity(json, KlineDashUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query dash to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEos2Usdt() {
        try {
            List<EosUsdtDay> list = eos2usdt();
            if (list != null) {
                EosUsdtDay data = eosUsdtDao.findLastTimeData();
                if (data != null) {
                    List<EosUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> eosUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> eosUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the eos to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<EosUsdtDay> eos2usdt() {
        try {
            String json = getJson(EOSUSDT);
            if (json != null) {
                KlineEosUsdt kline = JsonUtil.jsonToEntity(json, KlineEosUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query eos to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledEth2Usdt() {
        try {
            List<EthUsdtDay> list = eth2usdt();
            if (list != null) {
                EthUsdtDay data = ethUsdtDao.findLastTimeData();
                if (data != null) {
                    List<EthUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> ethUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> ethUsdtDao.save(l));
                }
            }
        } catch (Exception e) {

        }
    }

    private List<EthUsdtDay> eth2usdt() {
        try {
            String json = getJson(ETHUSDT);
            if (json != null) {
                KlineEthUsdt kline = JsonUtil.jsonToEntity(json, KlineEthUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query eth to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledBtc2Usdt() {
        try {
            List<BtcUsdtDay> list = btc2usdt();
            if (list != null) {
                BtcUsdtDay data = btcUsdtDao.findLastTimeData();
                if (data != null) {
                    List<BtcUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> btcUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> btcUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the btc to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<BtcUsdtDay> btc2usdt() {
        try {
            String json = getJson(BTCUSDT);
            if (json != null) {
                KlineBtcUsdt kline = JsonUtil.jsonToEntity(json, KlineBtcUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
                }
            }
        } catch (Exception e) {
            LOG.error("query btc to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
    }


    public void scheduledBch2Usdt() {
        try {
            List<BchUsdtDay> list = bch2usdt();
            if (list != null) {
                // 找出最新的一条数据，也就是id最大的一条数据
                BchUsdtDay data = bchUsdtDao.findLastTimeData();
                if (data != null) {
                    // json数据中获取到比数据库中最新的也就是最大的id的那条的所有数据
                    List<BchUsdtDay> needAddList = list.stream().filter(l -> l.getId() > data.getId()).collect(Collectors.toList());
                    needAddList.stream().forEach(l -> bchUsdtDao.save(l));
                } else {
                    list.stream().forEach(l -> bchUsdtDao.save(l));
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOG.error("Get the bch to usdt 1day kline time task failed: {}", e.getMessage(), e);
        }
    }

    private List<BchUsdtDay> bch2usdt() {
        try {
            String json = getJson(BCHUSDT);
            if (json != null) {
                KlineBchUsdt kline = JsonUtil.jsonToEntity(json, KlineBchUsdt.class);
                if (OK.equals(kline.getStatus())) {
                    return kline.getData();
        }
    }
} catch (Exception e) {
        LOG.error("query bch to usdt 1day kline failed: {}", e.getMessage(), e);
        }
        return null;
        }

private String getJson(String symbol) {
        try {
//            String url = HUOBI_BR_KLINE_URL + "?symbol=" + symbol + "&period=1day&size=1000";
//            String json = HttpUtils.sendGet(url, false);
//            if (json !=null && !json.isEmpty()){
//                return json;
//            }
            String url2 = HUOBI_KLINE_URL + "?symbol=" + symbol + "&period=1day&size=1000";
            String json = HttpUtils.sendGet(url2, true);
            if (json != null && !json.isEmpty()) {
                return json;
            }
        } catch (Exception e) {
            LOG.error("getJson failed: {}", e.getMessage(), e);
        }
        return null;
    }
}
