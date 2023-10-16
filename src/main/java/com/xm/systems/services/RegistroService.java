package com.xm.systems.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xm.systems.dtos.RegistroDto;
import com.xm.systems.entities.RegistroEntity;
import com.xm.systems.repositories.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	private RegistroRepository registroRepository;

	public List<RegistroDto> findAll() {
		List<RegistroEntity> registroEntityList = registroRepository.findAll();
		return registroEntityList.stream().map(x -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}


	public RegistroDto findById(Long id) {
		Optional<RegistroEntity> registroEntityOptional = registroRepository.findById(id);
		RegistroDto registroDto = new RegistroDto();
		if (registroEntityOptional.isPresent()) {
			registroDto = registroEntityOptional.get().toDto();
		}
		return registroDto;
	}


	public RegistroDto save(RegistroDto registro) {
		return registroRepository.save(registro.toEntity()).toDto();
	}


	public RegistroDto update(Long id, RegistroDto novoRegistro) {
		Optional<RegistroEntity> registroEntityOptional = registroRepository.findById(id);
		RegistroDto registroDto = new RegistroDto();
		if(registroEntityOptional.isPresent()) {
			registroDto.setDate(novoRegistro.getDate());
			registroDto.setDescricao(novoRegistro.getDescricao());
			registroDto.setId(id);
			registroDto.setStatus(novoRegistro.getStatus());
			registroDto.setTipo(novoRegistro.getTipo());
			registroDto.setValor(novoRegistro.getValor());
		}
		return registroRepository.save(registroDto.toEntity()).toDto();
	}

	
	public void delete(Long id) {
		Optional<RegistroEntity> registroEntityOptional = registroRepository.findById(id);
		if(registroEntityOptional.isPresent()) {
			registroRepository.deleteById(id);
		}
	}

}
