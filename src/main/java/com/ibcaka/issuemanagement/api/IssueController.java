package com.ibcaka.issuemanagement.api;

import com.ibcaka.issuemanagement.dto.IssueDto;
import com.ibcaka.issuemanagement.service.impl.IssueServiceImpl;
import com.ibcaka.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * apiler @RestControllerın çalışması için ;
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-data-rest</artifactId>
 * </dependency>
 * eklenmesi gereklidir.
 * web tarafınfan dışardan uygulama içersinde erişilebilir bir yapı haline getircez bunuda Restfull servislerle kazandırcaz
 * Entityleri dışarıya açıcak olan apiları oluşturcaz
 */
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    /**
     * ProjectDto dönücez aslında bizim Entitymizin şemasını dönmemiz gerekiyor
     * Entitymizi dışarıya kapatıcaz Entity yerine dış tarafla DTOlar üzerinden konuşcaz
     * ResponseEntity<> bizim api metodlarımızın veya tüm webservislerimiz içerisinde geliştireceğimiz
     * metodlarımızın ve apilarımızın dışarıda ortak bir imzaya sahip olması için öncelikli
     * ikinici olarak entitymize status ,message koyabilmemizi hızlıca build etmemizi
     */
    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    //@Valid : ProjectDto daki Notnullın geçerli olmasını sağlar
    //@Requestbody : post ederken body formatında gönderim sağlatır.
    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
