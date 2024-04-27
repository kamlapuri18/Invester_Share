package com.Invester_Share.share.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Invester_Share.share.entity.Share;
import com.Invester_Share.share.repository.ShareRepository;

@Service
public class ShareService {

    @Autowired
    private ShareRepository shareRepository;

    public void saveShare(Share shareObj) {
        shareRepository.save(shareObj);
    }

    public List<Share> getShareDetails(Long shareId) {
        if (null != shareId) {
            return shareRepository.findAllByshareId(shareId);
        } else {
            return shareRepository.findAll();
        }
    }

    public void deleteShare(Long shareId) {
        shareRepository.deleteById(shareId);
    }
}
