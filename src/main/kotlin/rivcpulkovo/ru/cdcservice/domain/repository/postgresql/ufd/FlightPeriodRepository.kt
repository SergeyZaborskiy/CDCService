package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.ufd;

import org.springframework.data.jpa.repository.JpaRepository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public.FlightPeriod

interface FlightPeriodRepository : JpaRepository<FlightPeriod, Int> {
}