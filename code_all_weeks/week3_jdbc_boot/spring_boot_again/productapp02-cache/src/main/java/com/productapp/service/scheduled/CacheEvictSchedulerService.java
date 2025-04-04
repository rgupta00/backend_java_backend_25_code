package com.productapp.service.scheduled;

import com.productapp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheEvictSchedulerService {
    private Logger logger= LoggerFactory.getLogger(CacheEvictSchedulerService.class);

    @Autowired
    private ProductService productService;

    @Scheduled(cron = "0,5 * * * * *")
    public void evictProductCache() {
        productService.evictProductCache();
        logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
