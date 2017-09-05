package com.pearson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lanil Marasinghe on 05-Sep-17.
 */
@RestController
@RequestMapping(path = "/public")
public class PublicController {
    @GetMapping(path = "/test")
    @ResponseBody
    public boolean testPublicApi(){
        return true;
    }
}
