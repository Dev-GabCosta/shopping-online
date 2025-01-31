package com.online.shopping.mappers;

@FunctionalInterface
public interface GenericMapper<E, D> {
	D map(E entity);
}
