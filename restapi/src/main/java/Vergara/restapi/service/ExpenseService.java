package Vergara.restapi.service;

import Vergara.restapi.DTO.ExpenseDTO;

import java.util.List;


/**
 * Service interface for Expense module
 * @author Bertin V
 * **/
public interface ExpenseService {

    /**
     * it will fetch the expenses from database
     * @return list
     * **/

    List<ExpenseDTO> getAllExpenses();

}
