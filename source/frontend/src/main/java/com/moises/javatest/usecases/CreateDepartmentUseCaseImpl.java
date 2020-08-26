package com.moises.javatest.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moises.javatest.models.DepartmentEntity;
import com.moises.javatest.repositories.RepositoryFacade;

@Component
public class CreateDepartmentUseCaseImpl implements CreateDepartmentUseCase {

	@Autowired
	RepositoryFacade repository;
	public DepartmentEntity executar(DepartmentEntity department) {
		return repository.createDepartment(department);
	}

}
