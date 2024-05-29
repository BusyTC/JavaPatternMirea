import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.repository.WorkerRepository;
import ru.mirea.model.Worker;
import ru.mirea.repository.WorkerRepository;
import ru.mirea.service.WorkerService;
import ru.mirea.service.WorkerServiceImpl;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class WorkerServiceImplTest {
    @Mock
    private WorkerRepository workerRepository;
    private final EntityManager entityManager;

    @Captor
    ArgumentCaptor<Worker> captor;

    @Test
    void getWorkers() {
        Worker worker1 = new Worker();
        worker1.setFirstName("Test firstName1");
        worker1.setMiddleName("Test middleName1");
        worker1.setLastName("Test lastName1");

        Worker worker2 = new Worker();
        worker2.setFirstName("Test firstName2");
        worker2.setMiddleName("Test middleName2");
        worker2.setLastName("Test lastName2");

        Mockito.when(workerRepository.findAll()).thenReturn(List.of(worker1, worker2));
        WorkerService workerService = new WorkerServiceImpl(workerRepository, );
        Assertions.assertEquals(2, workerService.readAll().size());
        Assertions.assertEquals("Test firstName2", workerService.readAll().get(1).getFirstName());
    }

    @Test
    void saveWorker() {
        Worker worker = new Worker();
        worker.setFirstName("Test firstName3");
        worker.setMiddleName("Test middleName3");
        worker.setLastName("Test lastName3");
        WorkerService itemService = new WorkerServiceImpl(workerRepository);
        itemService.create(worker);
        Mockito.verify(workerRepository).save(captor.capture());
        Worker captured = captor.getValue();
        Assertions.assertEquals("Test firstName3", captured.getFirstName());
    }
}
