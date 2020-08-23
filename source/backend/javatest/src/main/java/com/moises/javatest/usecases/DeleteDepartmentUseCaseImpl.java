package com.moises.javatest.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moises.javatest.repositories.RepositoryFacade;

@Component
public class DeleteDepartmentUseCaseImpl implements DeleteDepartmentUseCase {

	@Autowired
	RepositoryFacade repository;
	public void executar(Long id) {
		repository.deleteDepartment(id);
	}

}
