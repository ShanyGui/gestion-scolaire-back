package com.shany.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.Establishment;

public interface EstablishmentDao extends JpaRepository <Establishment, Integer> {

}
