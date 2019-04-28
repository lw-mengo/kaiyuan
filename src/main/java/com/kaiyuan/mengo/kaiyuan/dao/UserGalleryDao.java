package com.kaiyuan.mengo.kaiyuan.dao;

import com.kaiyuan.mengo.kaiyuan.entity.UserGallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGalleryDao extends JpaRepository<UserGallery,Integer> {
    @Override
    List<UserGallery> findAll();
}
