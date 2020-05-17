package com.ibcaka.issuemanagement.api;

import com.ibcaka.issuemanagement.dto.ProjectDto;
import com.ibcaka.issuemanagement.service.impl.ProjectServiceImpl;
import com.ibcaka.issuemanagement.util.ApiPaths;
import com.ibcaka.issuemanagement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
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
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Slf4j // loglama iin kullancağımız instance otomati verecek bize
public class ProjectController {
    /**
     * ProjectDto dönücez aslında bizim Entitymizin şemasını dönmemiz gerekiyor
     * Entitymizi dışarıya kapatıcaz Entity yerine dış tarafla DTOlar üzerinden konuşcaz
     * ResponseEntity<> bizim api metodlarımızın veya tüm webservislerimiz içerisinde geliştireceğimiz
     * metodlarımızın ve apilarımızın dışarıda ortak bir imzaya sahip olması için öncelikli
     * ikinici olarak entitymize status ,message koyabilmemizi hızlıca build etmemizi
     */
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/pagination")
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("ProjectController-> GetByID");
        log.debug("ProjectController-> GetByID -> PARAm:" + id);
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    //@Valid : ProjectDto daki Notnullın geçerli olmasını sağlar
    //@Requestbody : post ederken body formatında gönderim sağlatır.
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
