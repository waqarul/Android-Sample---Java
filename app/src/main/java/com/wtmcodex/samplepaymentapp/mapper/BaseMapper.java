package com.wtmcodex.samplepaymentapp.mapper;

public interface BaseMapper<E, D> {
    D transformToDomain(E type);

    E transformToDto(D type);
}
