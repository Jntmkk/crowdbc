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
import cn.edu.jnu.crowdbc.utils.CredentialsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;

@Service
public class CrowdBCServiceImpl implements CrowdBCService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final DefaultGasProvider gasProvider = new DefaultGasProvider();
    private Web3j web3j;

    private Register register;
    private RequesterWorkerRelationship relationship;
    private UserSummary userSummary;
    private CredentialsManager credentialsManager;

    @Autowired
    public CrowdBCServiceImpl(Web3j web3j, CredentialsManager credentialsManager) {
        this.web3j = web3j;
        this.credentialsManager = credentialsManager;
    }


    @Override
    public ResponseBody<?> getWeb3jVersionS() {
        ResponseBody responseBody = new ResponseBody<String>(ResponseStatusEnum.SUCCESS);
        try {
            responseBody.setMsg(web3j.web3ClientVersion().send().getWeb3ClientVersion());
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
        return responseBody;
    }

    @Override
    public ResponseBody<?> getReputationAvgS() {
        return null;
    }

    @Override
    public ResponseBody<?> isRegisteredS(Address address, String Name) {
        return null;
    }

    @Override
    public ResponseBody<?> registerS(Address address, String Name) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserInfoS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> updateUserPassWordS(Address address, String passWord) {
        return null;
    }

    @Override
    public ResponseBody<?> updateUserInfoS(UserInfoVO userInfoVO) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserReceivedTaskS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserProcessingTaskS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserSubmittedTaskS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserEvaluatingTaskS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> getUserFinishedTaskS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> getAllTaskS() {
        return null;
    }

    @Override
    public ResponseBody<?> getAllUnreceivedTaskS() {
        return null;
    }

    @Override
    public ResponseBody<?> receiveTaskS(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> postTaskS(TaskInfoVO taskInfoVO) {
        return null;
    }

    @Override
    public ResponseBody<?> getTaskInfoS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> getGMAddressS() {
        return null;
    }

    @Override
    public ResponseBody<?> isReceivedS(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> getWorkersListS(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> submitSolutionS(TaskSolutionVO taskSolutionVO) {
        return null;
    }

    @Override
    public ResponseBody<?> evaluateSolutionS(EvaluateSolutionResultVO solutionResultVO) {
        return null;
    }

    @Override
    public ResponseBody<?> getAllSolutionS(String taskIdentity) {
        return null;
    }

    @Override
    public ResponseBody<?> deployContractS(Contract contract) {
        return null;
    }

    @Override
    public ResponseBody<?> queryContractS(Address address) {
        return null;
    }

    @Override
    public ResponseBody<?> transferS(String from, String to, String amount) {
        return null;
    }
}
