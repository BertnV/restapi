package Vergara.restapi.service.impl;

import Vergara.restapi.DTO.ExpenseDTO;
import Vergara.restapi.Entity.ExpenseEntity;
import Vergara.restapi.repository.ExpenseRepository;
import Vergara.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

    /**
     * Service implementation for expense module
     * @author Bertin V
     * **/
@Service
@RequiredArgsConstructor
@Slf4j

public class ExpenseServiceimpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    /**
     * it will fetch the expenses from database
     * @return list
     * **/
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        //Call repository method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from repository {}", list);
        //convert the Entity object to DTO object
        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        //Return the list

        return listOfExpenses;
    }

        /**
         * Mapper to convert expense entity to expense DTO
         * @param expenseEntity
         * @return ExpenseDTO
         * **/
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity){
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
