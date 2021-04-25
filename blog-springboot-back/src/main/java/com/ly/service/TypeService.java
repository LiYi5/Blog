package com.ly.service;

import com.ly.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    List<Type> getType(Type type);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}