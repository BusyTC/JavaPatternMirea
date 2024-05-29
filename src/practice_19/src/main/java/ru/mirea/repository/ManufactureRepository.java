package ru.mirea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.model.Manufacture;

public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {

}
