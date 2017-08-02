package logback.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangkun
 * @version 1.0
 * @date 2017/8/2
 * @description
 */
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger("kafkaAppender");
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            logger.info("zhangkun kafka, zhangkun kafka");
        }
    }
}
