package ua.nure.koshova.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ControllerLoggingSpringEventListener implements ApplicationListener<ControllerLoggingSpringEvent> {

    @Override
    public void onApplicationEvent(ControllerLoggingSpringEvent controllerLoggingSpringEvent) {
        controllerLoggingSpringEvent.log();
    }
}
