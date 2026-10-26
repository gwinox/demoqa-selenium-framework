package framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;

public class LoggerUtil {

    private LoggerUtil() {
    }

    private static Logger getLogger() {
        String callerClassName = StackWalker.getInstance()
                .walk(stream -> stream
                        .map(StackWalker.StackFrame::getClassName)
                        .filter(className -> !className.equals(LoggerUtil.class.getName()))
                        .findFirst()
                        .orElse(LoggerUtil.class.getName()));

        return LogManager.getLogger(callerClassName);
    }

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void info(String message, Object... params) {
        getLogger().info(new ParameterizedMessage(message, params));
    }

    public static void error(String message, Throwable t) {
        getLogger().error(message, t);
    }
}