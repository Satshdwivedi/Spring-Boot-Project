package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookDTO;
import com.example.demo.model.BorrowRecord;
import com.example.demo.model.Book;
import java.util.List;

import com.example.demo.model.ErrorResponse;
import com.example.demo.model.Member;
import com.example.demo.model.Passport;
import com.example.demo.model.Student;
import com.example.demo.model.UpdateStudentDTO;
import com.example.demo.model.Course;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowRecordService;
import com.example.demo.service.MemberService;
import com.example.demo.service.PassportService;
import com.example.demo.service.StudentService;
import com.example.demo.service.CourseService;



import jakarta.validation.Valid;

@RestController
public class HelloController {
    private BookService bookservice;
    private MemberService memberservice;
    private BorrowRecordService borrowrecordservice;
    private PassportService passportservice;
    private StudentService studentservice;
    private CourseService courseservice;

    public HelloController(BookService bookservice, MemberService memberservice,
            BorrowRecordService borrowrecordservice, PassportService passportservice, StudentService studentservice,
            CourseService courseservice) {
        this.bookservice = bookservice;
        this.memberservice = memberservice;
        this.borrowrecordservice = borrowrecordservice;
        this.passportservice = passportservice;
        this.studentservice = studentservice;
        this.courseservice = courseservice;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/book")
    public Book book() {
        return new Book( "Java", "Smith");
    }

    @GetMapping("/books")
    public List<Book> books() {
        return bookservice.getAllBooks();
    }

    @GetMapping("/books/search")
    public List<Book> search(@RequestParam(required = false) String title) {
        return bookservice.searchByTitle(title);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        Book b = bookservice.getBookById(id);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(b);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO dto) {
        Book nb = new Book( dto.getTitle(),
                dto.getAuthor(), dto.getDiscription(), dto.getPrice());
        Book sb = bookservice.addBook(nb);
        return ResponseEntity.status(201).body(sb);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,
            @Valid @RequestBody BookDTO dto) {
        Book updateBook = bookservice.updateBook(id, dto);
        if (updateBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        boolean deleted = bookservice.deleteBook(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(404).body(new ErrorResponse("Book not found"));

    }
    @PostMapping("/members")
    public Member addMember(@RequestBody Member mam )
   { return memberservice.addMember(mam);

   }
   @PostMapping("/borrow")
   public BorrowRecord addBorrowRecord(@RequestBody BorrowRecord brr)
   {
    return borrowrecordservice.addBorrowRecord(brr);
   }
   @GetMapping("/borrow")
    public List<BorrowRecord> brrs() {
        return borrowrecordservice.getAllBorrowRecords();}

    @PutMapping("/borrow/{id}")
    public BorrowRecord updateBorrowRecord(@PathVariable int id){
    BorrowRecord result=borrowrecordservice.returnBook(id);
    if(result==null){return null;}
    return result;
    }
    @GetMapping("/member/{id}")
    public List<BorrowRecord> getMem(@PathVariable int id){
        Member m=memberservice.getMemberById(id);
        if(m==null){return null;}
        return m.getBorrowRecords();
    }
    @DeleteMapping("/borrow/{id}")
    public ResponseEntity<?> deleteBorrowRecord(@PathVariable int id) {
        boolean delete = borrowrecordservice.deleteBorrowRecord(id);
        if (delete) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(404).body(new ErrorResponse("BorroeRecord not found"));

}
     @PostMapping("/passports")
    public Passport addPasport(@RequestBody Passport pas )
   { return passportservice.addPassport(pas);

   }
   @GetMapping("/member/passport/{id}")
   public Passport getMemPassport(@PathVariable int id){
   Member memb=memberservice.getMemberById(id);
   return memb.getPassport();
   }
   @GetMapping("/members")
    public List<Member> members() {
        return memberservice.getAllMembers();
    }
    @PostMapping("/students")
    public Student addStuden(@RequestBody Student st){
        return studentservice.addStudent(st);
    }
    @PostMapping("/courses")
    public Course addCour(@RequestBody Course c){
        return courseservice.addCourses(c);
    }
    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable int id){
        return courseservice.getCouById(id);
    }
    @GetMapping("/students")
    public Page<Student>getstudents(Pageable pageable){
        return studentservice.getStudents(pageable);
    }
    @GetMapping("/student/jpql")
    public List<Student>getstu(){
        return studentservice.getJPStudents();
    }
    @GetMapping("/students/jpql1")
    public List<Student>getst(@RequestParam int age){
        return studentservice.getJPStuden(age);
    }
    @GetMapping("/student/jpql2")
    public List<Student>getst1(@RequestParam int age,@RequestParam String name){
        return studentservice.getJPS(age,name);
    }
    @GetMapping("/student/jpql4")
    public List<Student>getst2(@RequestParam String name){
        return studentservice.getJPS1(name);
    }
    @GetMapping("/student/jpql3")
    public List<Student>getst3(@RequestParam int minage,@RequestParam int maxage){
        return studentservice.getJPS2(minage,maxage);
} 
    @GetMapping("/student/jpql5")
    public List<Student>getst4(@RequestParam List<Integer>ages){
        return studentservice.getJPS3(ages);
}
    @GetMapping("/student/distinct")
    public List<Integer>getst5(){
        return studentservice.getJPS4();
}
    @GetMapping("/student/orderby")
    public List<Student>getst6(){
        return studentservice.getJPS5();
}  
    @GetMapping("/student/having")
    public List<Object[]>getst7(){
        return studentservice.getJPS6();
}  
    @PutMapping("/student/update/{id}")
    int getst8(@PathVariable int id,@RequestBody UpdateStudentDTO stu){
        return studentservice.getJPS7(id,stu.getAge());
}
    @DeleteMapping("/student/delete/{id}")
    int delst(@PathVariable int id){
        return studentservice.getJPS8(id);
    }
    @GetMapping("/student/name")
    public List<Student> fNameST(@RequestParam String name){
        return studentservice.getST(name);
    }
    @GetMapping("/student/age")
    public List<Student> fAgeST(@RequestParam int age){
        return studentservice.getST1(age);
    }
    @GetMapping("/student/age/greater")
    public List<Student> fAgeGreaterST(@RequestParam int age){
        return studentservice.getST2(age);
    }
    @GetMapping("/student/name/contains")
    public List<Student>fNameContain(@RequestParam String name){
        return studentservice.getST3(name);
    }
    @GetMapping("/student/age/between")
    public List<Student>fAgeBetween(@RequestParam int minage,@RequestParam int maxage){
        return studentservice.getST4(minage,maxage);
}   
    @GetMapping("/student/age")
    public List<Student>fAgeIn(@RequestParam List<Integer>ages){
        return studentservice.getST5(ages);
}
}