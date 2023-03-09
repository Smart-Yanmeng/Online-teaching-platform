package com.ruoyi.system.service.online;

import com.ruoyi.system.domain.entity.BActivityEntity;
import com.ruoyi.system.domain.view.ActivityInfoView;
import com.ruoyi.system.mapper.online.IActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Autowired
    IActivityMapper activityMapper;

    public List<ActivityInfoView> selectActivityList() {
        List<BActivityEntity> activityEntities = activityMapper.selectActivity();

        return activityEntities.stream().map(item -> new ActivityInfoView().transfer(item)).collect(Collectors.toList());
    }
}
