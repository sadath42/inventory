package com.bti.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.bti.inventory.entity.SiteEntity;

public interface InventoryRepository extends CrudRepository<SiteEntity, Long> {

	SiteEntity findBySiteID(String siteID);

	void deleteBySiteID(String siteId);

}
