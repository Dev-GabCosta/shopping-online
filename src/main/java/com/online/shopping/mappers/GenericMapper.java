package com.online.shopping.mappers;

@FunctionalInterface
public interface GenericMapper<Source, Target> {
	Target map(Source source);
}
