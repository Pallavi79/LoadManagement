package com.developer.TransportManagement.services;

import java.util.List;

import com.developer.TransportManagement.entities.Load;

public interface TransportService {
	
	public List<Load> getLoadDetails();

	public Load getLoad(long loadId);

	public Load addLoad(Load load);

	public Load updateLoad(Load load, long loadId);

	public void deleteLoad(long loadId);

}
