package com.moises.javatest.repositories;

import com.moises.javatest.models.DepartmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}