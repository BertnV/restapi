package Vergara.restapi.repository;

import Vergara.restapi.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long>
{
}
