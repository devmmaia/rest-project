package com.moises.javatest.usecases;

import java.util.Optional;

import com.moises.javatest.models.DepartmentEntity;

public interface GetDepartmentUseCase {
	public Optional<DepartmentEntity> executar(Long id);
}
