package com.xm.systems.dtos;

import java.time.Instant;
import java.util.Objects;

import org.modelmapper.ModelMapper;

import com.xm.systems.entities.RegistroEntity;

public class RegistroDto {

	private Long id;
	private String descricao;
	private Instant date;
	private String tipo;
	private double valor;
	private String status;

	public RegistroDto() {
	}

	public RegistroDto(Long id, String descricao, Instant date, String tipo, double valor, String status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.date = date;
		this.tipo = tipo;
		this.valor = valor;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroDto other = (RegistroDto) obj;
		return Objects.equals(id, other.id);
	}
	
	public RegistroEntity toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, RegistroEntity.class);
	}

}
