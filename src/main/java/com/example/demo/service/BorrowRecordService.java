package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BorrowRecord;
import com.example.demo.repository.BorrowRecordRepository;

@Service 
public class BorrowRecordService {
 private BorrowRecordRepository borrowRecordrepo;

 public BorrowRecordService(BorrowRecordRepository borrowRecordrepo) {
    this.borrowRecordrepo = borrowRecordrepo;
 }
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
 

}
