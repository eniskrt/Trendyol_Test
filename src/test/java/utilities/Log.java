package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log {

    private static final Logger logger;

    static {
        // log4j2.xml dosyasını classpath'ten yüklemek
        Configurator.initialize(null, "log4j2.xml");
        logger = LogManager.getLogger(Log.class);
    }

    // Bilgi seviyesinde loglama
    public void info(String message) {
        logger.info(message);
    }

    // Uyarı seviyesinde loglama
    public void warn(String message) {
        logger.warn(message);
    }

    // Hata seviyesinde loglama
    public void error(String message) {
        logger.error(message);
    }
}
