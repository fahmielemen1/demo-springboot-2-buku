package com.example.demospringboot2.buku.controller;

import com.example.demospringboot2.buku.model.ModelBuku;
import com.example.demospringboot2.buku.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    BukuRepository bukuRepository;

    @GetMapping("/")  // @GetMapping digunakan agar http request yang digunakan adalah GET
    public List<ModelBuku> getAll(){
        return bukuRepository.findAll(); // Findall() digunakan agar me-return semua list buku
    }

    @PostMapping("/")
    public ModelBuku tambahbuku(@Valid @RequestBody ModelBuku modelBuku){
        return bukuRepository.save(modelBuku);
    }

    @PutMapping( "/{id}")
    public ResponseEntity<ModelBuku> updateBuku(@PathVariable(value = "id")
                                                Long id, @Valid @RequestBody ModelBuku detailbuku){
//        Optional<ModelBuku> buku = bukuRepository.findById(id);
//        if (buku == null)
//            return ResponseEntity.notFound().build();
//
//        buku.setTitleBook(detailbuku.getTitleBook());
//        buku.setNamaDepanPengarang(detailbuku.getNamaDepanPengarang());
//        buku.setNamaBelakangPengarang(detailbuku.getNamaBelakangPengarang());
//        buku.setNamaPeminjam(detailbuku.getNamaPeminjam());
//        buku.setStatusPeminjaman(detailbuku.getStatusPeminjaman());
//        ModelBuku updatedBuku = bukuRepository.save(buku);
//        return ResponseEntity.ok(updatedBuku);
//

        Optional<ModelBuku> modelBuku;
        modelBuku=bukuRepository.findById(id);
        ModelBuku buku =  new ModelBuku();
        if (modelBuku.isPresent()) {

            buku.setTitleBook(detailbuku.getTitleBook());
            buku.setNamaDepanPengarang(detailbuku.getNamaDepanPengarang());
            buku.setNamaBelakangPengarang(detailbuku.getNamaBelakangPengarang());
            buku.setNamaPeminjam(detailbuku.getNamaPeminjam());
            buku.setStatusPeminjaman(detailbuku.getStatusPeminjaman());
            bukuRepository.save(buku);
        }
        else {
          ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buku);
    }

//    @PutMapping("/{id}")
//    ModelBuku updateBuku(@RequestBody ModelBuku newEmployee, @PathVariable Long id) {
//
//        return BukuRepository.findById(id).map(employee -> {
//            employee.setFirstName(newEmployee.getFirstName());
//            employee.setLastName(newEmployee.getLastName());
//            employee.setEmail(newEmployee.getEmail());
//            return repository.save(employee);
//        }).orElseGet(() -> {
//            newEmployee.setId(id);
//            return repository.save(newEmployee);
//        });
//    }
//
//    @PutMapping("/employees/{id}")
//    ModelBuku updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id).map(employee -> {
//            employee.setFirstName(newEmployee.getFirstName());
//            employee.setLastName(newEmployee.getLastName());
//            employee.setEmail(newEmployee.getEmail());
//            return repository.save(employee);
//        }).orElseGet(() -> {
//            newEmployee.setId(id);
//            return repository.save(newEmployee);
//        });
//    }


}
