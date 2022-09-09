package com.developer.TransportManagement.services;
import com.developer.TransportManagement.entities.Load;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.developer.TransportManagement.entities.Load;


@Service
public class TransportServiceImplementation implements TransportService {

	List<Load> list;
	
	public TransportServiceImplementation() {
		list = new ArrayList<>();
		list.add(new Load(1,"Delhi","Jaipur","Chemicals","Canter",1,100,"Comment1","shipper1","12/12/12"));
		list.add(new Load(2,"Delhi","Gwalior","Chemicals","Canter",1,100,"Comment1","shipper2","12/12/12"));
		list.add(new Load(3,"Bhopal","Gwalior","Chemicals","Canter",1,100,"Comment1","shipper1","12/12/12"));
	}

	@Override
	public List<Load> getLoadDetails() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Load getLoad(long loadId) {
		// TODO Auto-generated method stub
		
		Load l = null;
		
		for(Load temp : list) {
			if(temp.getLoadId()==loadId) {
				l=temp;
				break;
			}
		}
		return l;
	}

	@Override
	public Load addLoad(Load load) {
		// TODO Auto-generated method stub
		list.add(load);
		return load;
	}

	@Override
	public Load updateLoad(Load load, long loadId) {
		// TODO Auto-generated method stub
		
		list.forEach( e->{
			if(e.getLoadId()==loadId) {
				e.setLoadingPoint(load.getLoadingPoint());
				e.setUnloadingPoint(load.getUnloadingPoint());
				e.setProductType(load.getProductType());
				e.setTruckType(load.getTruckType());
				e.setNoOfTrucks(load.getNoOfTrucks());
				e.setWeight(load.getWeight());
			    e.setComment(load.getComment());
			    e.setShipperId(load.getShipperId());
			    e.setDate(load.getDate());
			}
		});
		return null;
	}

	@Override
	public void deleteLoad(long loadId) {
		// TODO Auto-generated method stub
		list = this.list.stream().filter(e->e.getLoadId()!=loadId).collect(Collectors.toList());
		
	}
	
	
	
	

}
