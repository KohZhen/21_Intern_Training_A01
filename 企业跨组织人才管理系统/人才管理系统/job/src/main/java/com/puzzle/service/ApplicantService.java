package com.puzzle.service;

import com.puzzle.entity.User;
import com.puzzle.mapper.ApplicantMapper;
import com.puzzle.entity.Applicant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantMapper applicantMapper;

    public int create(Applicant applicant) {
        return applicantMapper.create(applicant);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                applicantMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return applicantMapper.delete(id);
    }

    public int update(Applicant applicant) {
        return applicantMapper.update(applicant);
    }

    public int updateSelective(Applicant applicant) {
        return applicantMapper.updateSelective(applicant);
    }

    public PageInfo<Applicant> query(Applicant applicant) {
        if(applicant != null && applicant.getPage() != null){
            PageHelper.startPage(applicant.getPage(),applicant.getLimit());
        }
        return new PageInfo<Applicant>(applicantMapper.query(applicant));
    }

    public Applicant detail(Integer id) {
        return applicantMapper.detail(id);
    }

    public int count(Applicant applicant) {
        return applicantMapper.count(applicant);
    }

        public Applicant login(String account, String password){
        Applicant param = new Applicant();
        param.setAccount(account);
        param.setPassword(password);
        List<Applicant> list = applicantMapper.query(param);
        if(list != null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
