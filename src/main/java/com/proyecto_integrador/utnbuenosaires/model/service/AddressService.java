package com.proyecto_integrador.utnbuenosaires.model.service;

import java.util.List;

import com.proyecto_integrador.utnbuenosaires.model.entity.Address;
import com.proyecto_integrador.utnbuenosaires.model.dto.AddressDTO;

public interface AddressService {
	
	AddressDTO createAddress(AddressDTO addressDTO);
	
	List<AddressDTO> getAddresses();
	
	AddressDTO getAddress(Long addressId);
	
	AddressDTO updateAddress(Long addressId, Address address);
	
	String deleteAddress(Long addressId);
}
