package com.example.demospringboot2.buku.controller;

import com.example.demospringboot2.buku.model.ModelBuku;
import com.example.demospringboot2.buku.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//anotasi @RestController untuk menandakan bahwa class ini merupakan controller

@RequestMapping("/buku")
public class BukuController {
    @Autowired
    BukuRepository bukuRepository;

    @GetMapping("/")  // @GetMapping digunakan agar http request yang digunakan adalah GET
    public List<ModelBuku> getAll(){
        return bukuRepository.findAll(); // Findall() digunakan agar me-return semua list buku
    }

    @PostMapping("/")
    public ModelBuku tambahbuku(@Valid @RequestBody ModelBuku buku){
        return bukuRepository.save(buku);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ModelBuku> updateBuku(@PathVariable(value = "id")Long id,
//                                                @Valid @RequestBody ModelBuku detailbuku){
//        ModelBuku buku = bukuRepository.findOne(id);
//        if (buku == null)
//            return ResponseEntity.notFound().build();
//        buku.setTitleBook(detailbuku.getTitleBook());
//        buku.setNamaDepanPengarang(detailbuku.getNamaDepanPengarang());
//        buku.setNamaBelakangPengarang(detailbuku.getNamaBelakangPengarang());
//        buku.setNamaPeminjam(detailbuku.getNamaPeminjam());
//        buku.setStatusPeminjaman(detailbuku.getStatusPeminjaman());
//        ModelBuku updatedBuku = bukuRepository.save(buku);
//    }
}
