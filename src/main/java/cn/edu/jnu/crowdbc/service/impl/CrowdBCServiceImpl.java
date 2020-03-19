package cn.edu.jnu.crowdbc.service.impl;

import cn.edu.jnu.crowdbc.dao.Register;
import cn.edu.jnu.crowdbc.dao.RequesterWorkerRelationship;
import cn.edu.jnu.crowdbc.domain.ResponseBody;
import cn.edu.jnu.crowdbc.dao.UserSummary;
import cn.edu.jnu.crowdbc.domain.ResponseStatusEnum;
import cn.edu.jnu.crowdbc.domain.vo.EvaluateSolutionResultVO;
import cn.edu.jnu.crowdbc.domain.vo.TaskInfoVO;
import cn.edu.jnu.crowdbc.domain.vo.TaskSolutionVO;
import cn.edu.jnu.crowdbc.domain.vo.UserInfoVO;
import cn.edu.jnu.crowdbc.service.CrowdBCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@Service
public class CrowdBCServiceImpl implements CrowdBCService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Credentials credentials = Credentials.create("84495972845D968D351EABCB8266D0E6C756008EAB94FEF903573177889382AF");
    private final DefaultGasProvider gasProvider = new DefaultGasProvider();

    private Web3j web3j;
    private Register register;
    private RequesterWorkerRelationship relationship;
    private UserSummary userSummary;

    @Autowired
    public CrowdBCServiceImpl(Web3j web3j) {
        this.web3j = web3j;
    }

    @Override
    public ResponseBody<?> getWeb3jVersion() {
        return null;
    }

    @Override
    public ResponseBody<?> getReputationAvg() {
        return null;
    }

    @Override
    public ResponseBody<?> isRegistered(String address, String Name) {
        return null;
    }

    @Override
    public ResponseBody<?> register(String address, String Name) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserInfo(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> updateUserPassWord(String address, String passWord) {
        return null;
    }

    @Override
    public ResponseBody<?> updateUserInfo(UserInfoVO userInfoVO) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserReceivedTask(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserProcessingTask(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserSubmittedTask(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserEvaluatingTask(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserFinishedTask(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> getAllTask() {
        return null;
    }

    @Override
    public ResponseBody<?> getAllUnreceivedTask() {
        return null;
    }

    @Override
    public ResponseBody<?> receiveTask(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> postTask(TaskInfoVO taskInfoVO) {
        return null;
    }

    @Override
    public ResponseBody<?> getTaskInfo(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> getGMAddress() {
        return null;
    }

    @Override
    public ResponseBody<?> isReceived(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> getWorkersList(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> submitSolution(TaskSolutionVO taskSolutionVO) {
        return null;
    }

    @Override
    public ResponseBody<?> evaluateSolution(EvaluateSolutionResultVO solutionResultVO) {
        return null;
    }

    @Override
    public ResponseBody<?> getAllSolution(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> deployContract(Contract contract) {
        Register register = null;
        try {
            register = Register.deploy(web3j, credentials, gasProvider).send();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (register == null)
            return new ResponseBody<String>(ResponseStatusEnum.DEPOLY_FAILURE);
        ResponseBody<String> responseBody = new ResponseBody<>(ResponseStatusEnum.SUCCESS);
        responseBody.setData(Arrays.asList(register.getContractAddress()));
        return responseBody;
    }

    @Override
    public ResponseBody<?> queryContract(String address) {
        return null;
    }

    @Override
    public ResponseBody<?> transfer(String from, String to, String amount) {
        return null;
    }
}
