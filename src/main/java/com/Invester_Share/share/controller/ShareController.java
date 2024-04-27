package com.Invester_Share.share.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invester_Share.share.entity.Share;
import com.Invester_Share.share.service.ShareService;


@RestController
@RequestMapping("/share")
public class ShareController {

	
	@Autowired
    private ShareService shareService;

    @PostMapping("/save")
    public ResponseEntity createProject(@RequestBody Share shareObj) {
        shareService.saveShare(shareObj);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getShares", "/{shareId}"})
    public List<Share> getShares(@PathVariable(required = false) Long shareId) {
        return shareService.getShareDetails(shareId);
    }

    @DeleteMapping("/delete/{shareId}")
    public ResponseEntity removeShare(@PathVariable Long shareId) {
      shareService.deleteShare(shareId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
