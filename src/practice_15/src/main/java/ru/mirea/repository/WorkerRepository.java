package ru.mirea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
