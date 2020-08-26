package com.moises.javatest.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moises.javatest.models.DepartmentEntity;
import com.moises.javatest.repositories.RepositoryFacade;

@Component
public class ListDepartmentUseCaseImpl implements ListDepartmentUseCase {

	@Autowired
	RepositoryFacade repository;
	public List<DepartmentEntity> executar() {
		return repository.listDepartments();
	}

}
