package Vergara.restapi.controller;


import Vergara.restapi.DTO.ExpenseDTO;
import Vergara.restapi.io.ExpenseRequest;
import Vergara.restapi.io.ExpenseResponse;
import Vergara.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

        /**
         *  This is controller class for expense module
         * @author Bertin
         * **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

        /**
         * it will fetch the expenses from database
         * @return list
         * **/
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
        log.info("API GET /expenses called");
        //Call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("Printing the data from service {}", list);
        //Convert the Expense DTO to expense response
        List<ExpenseResponse> response = list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO))
                .collect(Collectors.toList());
        //Return the list/response
        return response;
    }
        /**
         * Mapper method for converting expense dto object to expense response object
         * @param expenseDTO
         * @return ExpenseResponse
         * **/
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
       return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
