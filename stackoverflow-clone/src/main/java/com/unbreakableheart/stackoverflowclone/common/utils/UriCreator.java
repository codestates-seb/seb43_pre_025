package com.unbreakableheart.stackoverflowclone.common.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriCreator {
    public static URI createURI(Long id){
        return UriComponentsBuilder.newInstance().build(id);
    }
}
