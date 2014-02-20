/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.efoe.poc.custserv.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Emmanuel
 */
public class LoggerUtil extends Logger {

    private static final String LOG4J_PATH = "../../../../resources/log4j.xml";

    static {
        DOMConfigurator.configure(LOG4J_PATH);
    }

    public LoggerUtil(String name) {
        super(name);
    }

    public static boolean isDebugEnable() {
        Logger logger = Logger.getRootLogger();
        return logger.isDebugEnabled();
    }

    public static void logInfo(Class<?> clazz, String info) {
        Logger logger = Logger.getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(info);
        }
    }

    public static void logInfo(Class<?> clazz, Throwable throwable, String info) {
        Logger logger = Logger.getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(info, throwable);
        }
    }

    public static void logDebug(Class<?> clazz, String debug) {
        Logger logger = Logger.getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(debug);
        }
    }

    public static void logDebug(Class<?> clazz, Throwable throwable, String debug) {
        Logger logger = Logger.getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(debug, throwable);
        }
    }

    public static void logError(Class<?> clazz, String error) {
        Logger logger = Logger.getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.error(error);
        }
    }

    public static void logError(Class<?> clazz, Throwable throwable, String error) {
        Logger logger = Logger.getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(error, throwable);
        }
    }
}
