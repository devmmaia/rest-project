package com.moises.javatest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moises.javatest.controllers.responses.DefaultResponse;
import com.moises.javatest.controllers.responses.ResponseHelper;
import com.moises.javatest.models.DepartmentEntity;
import com.moises.javatest.usecases.CreateDepartmentUseCase;
import com.moises.javatest.usecases.DeleteDepartmentUseCase;
import com.moises.javatest.usecases.GetDepartmentUseCase;
import com.moises.javatest.usecases.ListDepartmentUseCase;
import com.moises.javatest.usecases.UpdateDepartmentUseCase;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {

	@Autowired
	private CreateDepartmentUseCase createDepartmentUseCase;
	@Autowired
	private UpdateDepartmentUseCase updateDepartmentUseCase;
	@Autowired
	private ListDepartmentUseCase listDepartmentUseCase;
	@Autowired
	private GetDepartmentUseCase getDepartmentUseCase;
	@Autowired
	private DeleteDepartmentUseCase deleteDepartmentUseCase;

	@GetMapping("/departments")
	public ResponseEntity<DefaultResponse> listDepartments() {
		List<DepartmentEntity> result = listDepartmentUseCase.executar();
		return ResponseHelper.createResponse(result, HttpStatus.OK);
	}

	@PostMapping("/departments")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<DefaultResponse> saveDepartment(@RequestBody DepartmentEntity department) {
		
		createDepartmentUseCase.executar(department);
		return ResponseHelper.createResponse(department, HttpStatus.CREATED, "Salvo com sucesso");
	}

	@PutMapping("/departments/{id}")
	public ResponseEntity<DefaultResponse> updateDepartment(@PathVariable Long id,
			@RequestBody DepartmentEntity department) {
		Optional<DepartmentEntity> entity = getDepartmentUseCase.executar(id);
		if (entity.isPresent()) {
			updateDepartmentUseCase.executar(department);
			return ResponseHelper.createResponse(department, HttpStatus.OK, "Salvo com sucesso");
		}
		return ResponseHelper.notFound();
	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<DefaultResponse> deleteDepartment(@PathVariable Long id) {
		Optional<DepartmentEntity> entity = getDepartmentUseCase.executar(id);
		if (entity.isPresent()) {
			deleteDepartmentUseCase.executar(id);
			return ResponseHelper.createResponse(null, HttpStatus.OK, "Removido com sucesso");
		}
		return ResponseHelper.notFound();
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<DefaultResponse> test(@PathVariable Long id) {
		Optional<DepartmentEntity> entity = getDepartmentUseCase.executar(id);
		if (entity.isPresent()) {
			return ResponseHelper.createResponse(entity, HttpStatus.OK, "Sucessfull");

		}
		return ResponseHelper.notFound();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}

}