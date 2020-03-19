package cn.edu.jnu.crowdbc.controller;

import cn.edu.jnu.crowdbc.domain.ResponseBody;
import cn.edu.jnu.crowdbc.service.CrowdBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    private CrowdBCService crowdBCService;

    @Autowired
    public DefaultController(CrowdBCService crowdBCService) {
        this.crowdBCService = crowdBCService;
    }

    @GetMapping(path = "/")
    public ResponseBody<?> index() {
        return crowdBCService.getWeb3jVersion();
    }

    @GetMapping(path = "/register")
    public ResponseBody<?> register() {
        return crowdBCService.deployContract(null);
    }
}
