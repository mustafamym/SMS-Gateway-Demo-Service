package com.demo.smsgw.scheduler;

import com.demo.smsgw.model.AppConf;
import com.demo.smsgw.service.AppConfService;
import com.demo.smsgw.service.InboxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InboxCheckerScheduler {
    final private AppConfService appConfService;
    final private InboxService inboxService;

    @Scheduled(cron = "0 */1 * * * *") // every 5 min
    public void runInboxCheckerScheduler() {
        boolean isContinue = false;

        do {
            List<AppConf> activeAppConfs = appConfService.findAppConfByStatus(1);
            int defaultPageNumber = 0;
            if (!activeAppConfs.isEmpty()) {
                for (AppConf appConf : activeAppConfs) {
                    Pageable pageable = PageRequest.of(defaultPageNumber, appConf.getNumberOfRow());
                    inboxService.findInboxByStatus("N", pageable);
                    log.info("NumberOf message reading ::" + appConf.getNumberOfRow());
                    log.info("Appconfig Status ::" + appConf.getStatus());
                    if (appConf.getStatus() == 1) {
                        isContinue = true;
                        defaultPageNumber = defaultPageNumber + appConf.getNumberOfRow();
                    }
                }
            }
            log.info("is Inbox message reading continue ::" + isContinue);
        } while (isContinue);
    }
}
