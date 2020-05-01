package com.ibcaka.issuemanagement.service.impl;

import com.ibcaka.issuemanagement.dto.IssueDto;
import com.ibcaka.issuemanagement.entity.Issue;
import com.ibcaka.issuemanagement.repository.IssueRepository;
import com.ibcaka.issuemanagement.service.IssueService;
import com.ibcaka.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**ModelMapper kullanmak için uygulamada(IssueManagementApplication.java) instanceını yaratmamız gereklidir.
modelmapper ; içerde dtolar ile çalışırken dışarda entitylerle çalışmayı sağlar
IssueDto ile Issue Entitysinin verilerini eşleştirip geriye dönüyor
Önce dışardan gelen nesneyi içerdeki modele dönüştürür içerdeki modelden de veritabanına kaydettikten sonra yine o nesneyi dto ya dönüştürüp geri verir
yani servisten sonraki hiç bir katmanda Dtolarla konuşmucaz ama servis ve
servisten dışarı doğru çıkarken api katmanına doğru çıkarken bu defada entityleri dışarı çıkartmıyoz*/
@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null){
            throw new IllegalArgumentException("Issue Date Cannot be Null");
        }
        /**IssueDto tipinden intanceın datasını Issue tipinden bir classın instanceına koyup geri veriyor
        bunlarıda IssueDto ve Issuedaki property nameleri eşleştirerek yapıyor*/
        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data=issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto isssue) {
        return null;
    }
}
