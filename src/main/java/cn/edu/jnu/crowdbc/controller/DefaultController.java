package cn.edu.jnu.crowdbc.controller;

import cn.edu.jnu.crowdbc.domain.ResponseBody;
import cn.edu.jnu.crowdbc.domain.vo.UserInfoVO;
import cn.edu.jnu.crowdbc.service.CrowdBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {
    private CrowdBCService crowdBCService;

    @Autowired
    public DefaultController(CrowdBCService crowdBCService) {
        this.crowdBCService = crowdBCService;
    }

    @GetMapping(path = "/web3jVersion")
    public ResponseBody<?> index() {
        return crowdBCService.getWeb3jVersionS();
    }

    @PostMapping(path = "/register")
    public ResponseBody<?> register(@RequestBody UserInfoVO userInfoVO) {
        return crowdBCService.registerS(userInfoVO.getAddress(),userInfoVO.getUserName());
    }
}
