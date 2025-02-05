package com.online.shopping.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCustomerNotFound(CustomerNotFoundException exception) {
		Map<String, String> error = new HashMap<>();
		error.put("Erro", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleProductNotFound(ProductNotFoundException exception) {
		Map<String, String> error = new HashMap<>();
		error.put("erro", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MissingProductException.class)
	public ResponseEntity<Map<String, String>> handleMissingProduct(MissingProductException exception) {
		Map<String, String> error = new HashMap<>();
		error.put("Erro", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(UsedEmailException.class)
	public ResponseEntity<Map<String, String>> handleUsedEmail(UsedEmailException exception) {
		Map<String, String> error = new HashMap<>();
		error.put("Erro", exception.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(InsufficientStockException.class)
	public ResponseEntity<Map<String, String>> handleInsufficientStock(InsufficientStockException exception) {
		Map<String, String> error = new HashMap<>();
		error.put("Erro", exception.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException exception) {
		Map<String, String> error = new HashMap<>();
error.put("Erro", "É possível que você esteja tentando enviar um valor (nome do produto ou CPF) já armazenado no banco de dados. Por favor, verifique e tente novamente");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
