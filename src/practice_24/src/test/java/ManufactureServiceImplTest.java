import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.model.Manufacture;
import ru.mirea.repository.ManufactureRepository;
import ru.mirea.model.Worker;
import ru.mirea.service.ManufactureService;
import ru.mirea.service.ManufactureServiceImpl;
import ru.mirea.service.WorkerService;
import ru.mirea.service.WorkerServiceImpl;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ManufactureServiceImplTest {
    @Mock
    private ManufactureRepository manufactureRepository;
    @Mock
    private EntityManager entityManager;

    @Captor
    ArgumentCaptor<Manufacture> captor;

    @Test
    void getManufactures() {
        Manufacture manufacture1 = new Manufacture();
        manufacture1.setName("Test name1");

        Manufacture manufacture2 = new Manufacture();
        manufacture2.setName("Test Name2");

        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture1, manufacture2));
        ManufactureService manufactureService = new ManufactureServiceImpl(manufactureRepository);
        Assertions.assertEquals(2, manufactureService.readAll().size());
        Assertions.assertEquals("Test Name2", manufactureService.readAll().get(1).getName());
    }

    @Test
    void saveManufacture() {
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Test Name3");
        ManufactureService manufactureService = new ManufactureServiceImpl(manufactureRepository);
        manufactureService.create(manufacture);
        Mockito.verify(manufactureRepository).save(captor.capture());
        Manufacture captured = captor.getValue();
        Assertions.assertEquals("Test Name3", captured.getName());
    }
}
