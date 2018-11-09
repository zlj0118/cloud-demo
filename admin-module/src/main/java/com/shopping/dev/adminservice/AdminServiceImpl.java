package com.shopping.dev.adminservice;

import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminRepository adminRepository;

    @Override
    public List<ContentCategory> findAll() {
        return adminRepository.findAll();
    }
}
