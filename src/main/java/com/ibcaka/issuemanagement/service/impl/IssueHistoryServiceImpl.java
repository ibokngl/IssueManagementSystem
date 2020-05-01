package com.ibcaka.issuemanagement.service.impl;

import com.ibcaka.issuemanagement.entity.Issue;
import com.ibcaka.issuemanagement.entity.IssueHistory;
import com.ibcaka.issuemanagement.repository.IssueHistoryRepository;
import com.ibcaka.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }


    @Override
    public IssueHistory save(IssueHistory issuehistory) {
        if(issuehistory.getDate()==null){
            throw new IllegalArgumentException("Date Cannot be Null");
        }
        return issueHistoryRepository.save(issuehistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
