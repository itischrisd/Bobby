package pl.edu.pja.s25692.bobby.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pja.s25692.bobby.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("from Employee e left join fetch e.reservations where e.id = :id")
    Optional<Employee> findByIdWithReservations(Long id);

    @Override
    @Query("from Employee e left join fetch e.position")
    List<Employee> findAll();
}
