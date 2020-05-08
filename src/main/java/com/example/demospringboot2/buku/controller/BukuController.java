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


//        Optional<ModelBuku> modelBuku;
//       modelBuku=bukuRepository.findById(id);
//        if (modelBuku.isPresent()) {
//            modelBuku=ResponseEntity.notFound().build();
//        }
//        else {
//
//        }
//
//
//        return ResponseEntity.ok(modelBuku);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ModelBuku> updateBuku(@PathVariable(value="id")Long id,
//                                           @Valid @RequestBody ModelBuku detailbuku){
//        Optional<ModelBuku> buku = bukuRepository.findById(id);
//        if(buku == null)
//            return ResponseEntity.notFound().build();
//        buku.setTitleBook(detailbuku.getTitleBook());
//        buku.setNamaDepanPengarang(detailbuku.getNamaDepanPengarang());
//        buku.setNamaBelakangPengarang(detailbuku.getNamaBelakangPengarang());
//        buku.setNamaPeminjam(detailbuku.getNamaPeminjam());
//        buku.setStatusPeminjaman(detailbuku.getStatusPeminjaman());
//        Buku updatedBuku = bukuRepository.save(buku);
//        return ResponseEntity.ok(updatedBuku);
//    }

//    @DeleteMapping("/{id}")
//    public String deleteBuku(@PathVariable (value="id") Long id){
//        Optional<ModelBuku> modelBuku;
//        modelBuku = bukuRepository.findById(id);
//        String result = "";
//        if(modelBuku.isPresent()) {
//            result = "id "+id+" tidak ditemukan";
//            return result;
//        }
//        result = "id "+id+" berhasil di hapus";
//        bukuRepository.deleteById(id);
//        return result;
//    }

    @DeleteMapping("/{id}")
    public String deleteBuku(@PathVariable (value="id") Long id){
        Optional<ModelBuku> modelBuku;
        modelBuku = bukuRepository.findById(id);
        String result = "";
        if(modelBuku.isPresent()) {

            result = "id "+id+" berhasil di hapus";
            bukuRepository.deleteById(id);
            return result;
        }
        result = "id "+id+" tidak ditemukan";
        return result;


    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ModelBuku> deleteTutorial(@PathVariable("id") long id) {
//        try {
//            BukuRepository(id);
//            return new ResponseEntity<>(ModelBuku.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(ModelBuku.EXPECTATION_FAILED);
//        }
//    }

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
