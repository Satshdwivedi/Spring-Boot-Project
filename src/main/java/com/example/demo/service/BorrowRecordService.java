package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BorrowRecord;
import com.example.demo.repository.BorrowRecordRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class BorrowRecordService {
 private final BorrowRecordRepository borrowRecordrepo;

 public BorrowRecord addBorrowRecord(BorrowRecord brr){
    return borrowRecordrepo.save(brr);
 }
 public List<BorrowRecord> getAllBorrowRecords(){
   return borrowRecordrepo.findAll();
 }
 public BorrowRecord returnBook(int id){
   BorrowRecord rec=borrowRecordrepo.findById(id).orElse(null);
   if(rec==null) {return null;}
   rec.setReturnDate(LocalDate.now());
   return borrowRecordrepo.save(rec);
 }
 public boolean deleteBorrowRecord(int id){
           if(borrowRecordrepo.existsById(id)){
            borrowRecordrepo.deleteById(id);
            return true;
           }
         return false;
 }

}
