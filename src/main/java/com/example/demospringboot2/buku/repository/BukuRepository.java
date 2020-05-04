package com.example.demospringboot2.buku.repository;

import com.example.demospringboot2.buku.model.ModelBuku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<ModelBuku, Long> {
    List<ModelBuku> findByStatusPeminjaman (int statusPeminjaman);
    List<ModelBuku> findByTitleBook(String titleBook);
}
