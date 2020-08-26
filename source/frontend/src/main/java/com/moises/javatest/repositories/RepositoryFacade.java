package com.moises.javatest.repositories;

import java.util.List;
import java.util.Optional;

import com.moises.javatest.models.DepartmentEntity;

public interface RepositoryFacade {
	public DepartmentEntity createDepartment(DepartmentEntity department);
	public Optional<DepartmentEntity> findDepartment(Long id);
	public void deleteDepartment (Long id);
	public DepartmentEntity updateDepartment(DepartmentEntity department);
	public List<DepartmentEntity> listDepartments();
}
