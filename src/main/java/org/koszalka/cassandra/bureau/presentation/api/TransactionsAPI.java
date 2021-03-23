package org.koszalka.cassandra.bureau.presentation.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CPF Transactions mapping declaration
 * @author rkoszalka
 */

@Api(value = "TransactionsAPI")
@RequestMapping("/v1/transactions/{cpfNumber}/{searchType}/{value}")
public interface TransactionsAPI {

    /**
     * Mapping for CPF Transactions endpoint
     * @param cpfNumber CPF Number
     */
    @ApiOperation(value = "Search transactions for requested CPF", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions delivered"),
            @ApiResponse(code = 400, message = "Bad Request."),
            @ApiResponse(code = 500, message = "Server error.")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<TransactionEntity> getCPFTransactions(@PathVariable String cpfNumber, @PathVariable String searchType
            , @PathVariable String value);

}
