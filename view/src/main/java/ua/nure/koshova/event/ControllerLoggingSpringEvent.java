package ua.nure.koshova.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class ControllerLoggingSpringEvent extends ApplicationEvent {
    final Logger log;

    private String message;

    public ControllerLoggingSpringEvent(Object source, String message) {
        super(source);
        log = LoggerFactory.getLogger(getSource().getClass());
        this.message = message;
    }

    public void log() {
        log.info(message);
    }
}
