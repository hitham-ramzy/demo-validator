package com.olx.resources;

import com.olx.model.UploadAction;
import com.olx.services.UploadActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
@RequestMapping("/api/upload-action")
public class UploadActionResource {

    @Autowired
    private UploadActionService uploadActionService;

    @GetMapping()
    public List<UploadAction> getUploadActions() {
        return uploadActionService.findAll();
    }

    @GetMapping(path = "/{id}")
    public UploadAction getUploadActions(@PathVariable("id") Long id) {
        return uploadActionService.findById(id);
    }

    @GetMapping(path = "/latest")
    public UploadAction getLastUploadActions() {
        return uploadActionService.findLatest();
    }
}
