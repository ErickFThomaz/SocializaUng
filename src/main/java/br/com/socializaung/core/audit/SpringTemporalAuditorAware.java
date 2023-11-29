package br.com.socializaung.core.audit;

import lombok.AllArgsConstructor;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

public class SpringTemporalAuditorAware implements DateTimeProvider {

    private final Clock systemClock;

    public SpringTemporalAuditorAware(Clock systemClock) {
        this.systemClock = systemClock;
    }

    @Override
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(ZonedDateTime.now(systemClock));
    }

}