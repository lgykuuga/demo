package com.lgy.demo.disruptor.series;

import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/9 14:21
 **/
public class SeriesDataEventHandler implements WorkHandler<SeriesDataEvent> {

    private Logger logger = LoggerFactory.getLogger(SeriesDataEventHandler.class);

    @Override
    public void onEvent(SeriesDataEvent event) {
        if (event.getValue() == null || StringUtils.isEmpty(event.getValue().getDeviceInfoStr())) {
            logger.warn("receiver series data is empty!");
        }
        logger.error("hello word!");
    }

}