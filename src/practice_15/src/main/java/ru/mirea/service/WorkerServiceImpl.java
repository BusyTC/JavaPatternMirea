package ru.mirea.service;

import org.springframework.stereotype.Service;
import ru.mirea.model.Worker;
import ru.mirea.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {

        this.workerRepository = workerRepository;
    }


    @Override
    public void create(Worker worker) {

        workerRepository.save(worker);
    }

    @Override
    public List<Worker> readAll() {

        return workerRepository.findAll();
    }

    @Override
    public Worker read(int id) {

        return workerRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Worker worker, int id) {
        if (workerRepository.existsById(id)) {
            worker.setId(id);
            workerRepository.save(worker);
            return  true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
