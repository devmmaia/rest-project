package com.moises.javatest.usecases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moises.javatest.models.DepartmentEntity;
import com.moises.javatest.repositories.RepositoryFacade;

@Component
public class GetDepartmentUseCaseImpl implements GetDepartmentUseCase {

	@Autowired
	RepositoryFacade repository;
	public Optional<DepartmentEntity> executar(Long id) {
		return repository.findDepartment(id);
	}

}
