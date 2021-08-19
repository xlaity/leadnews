package com.heima.search.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heima.behavior.feign.ApBehaviorEntryFeign;
import com.heima.model.behavior.pojos.ApBehaviorEntry;
import com.heima.model.search.pojos.ApUserSearch;
import com.heima.model.user.pojos.ApUser;
import com.heima.search.mapper.ApUserSearchMapper;
import com.heima.search.service.ApUserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Service
@Transactional
public class ApUserSearchServiceImpl implements ApUserSearchService {
    @Autowired
    private ApUserSearchMapper apUserSearchMapper;

    @Autowired
    private ApBehaviorEntryFeign apBehaviorEntryFeign;

    @Override
    public void saveUserSearch(Map<String, Object> msgMap) {
        //取出参数值
        Integer userId = (Integer)msgMap.get("userId");
        Integer equipmentId = (Integer)msgMap.get("equipmentId");
        String keyword = (String)msgMap.get("keyword");

        //查询是否存在行为实体
        ApBehaviorEntry behaviorEntry = apBehaviorEntryFeign.findByUserIdOrEquipmentId(userId, equipmentId);
        if(behaviorEntry==null)return;

        //查询搜索记录
        QueryWrapper<ApUserSearch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("entry_id",behaviorEntry.getId());
        queryWrapper.eq("keyword",keyword);
        ApUserSearch apUserSearch = apUserSearchMapper.selectOne(queryWrapper);

        if(apUserSearch==null){
            //添加用户搜索记录
            apUserSearch = new ApUserSearch();
            apUserSearch.setEntryId(behaviorEntry.getId());
            apUserSearch.setKeyword(keyword);
            apUserSearch.setStatus(true);
            apUserSearch.setCreatedTime(new Date());
            apUserSearchMapper.insert(apUserSearch);
        }else{
            if(apUserSearch.getStatus()==false){
                //修改status为true
                apUserSearch.setStatus(true);
                apUserSearchMapper.updateById(apUserSearch);
            }
        }
    }
}
