package br.com.season.springproject.generic;

import java.util.List;

import br.com.season.springproject.entity.User;

public interface JPAGeneric<T> {
	
	T  findById(Integer id);

	User findByCpf(String cpf);

	List<T> findAll();

	void save(T t);

	T update(T t);

	T delete(T t);
}
