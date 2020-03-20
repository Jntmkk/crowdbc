package cn.edu.jnu.crowdbc.service;


import cn.edu.jnu.crowdbc.domain.ResponseBody;
import cn.edu.jnu.crowdbc.domain.vo.EvaluateSolutionResultVO;
import cn.edu.jnu.crowdbc.domain.vo.TaskInfoVO;
import cn.edu.jnu.crowdbc.domain.vo.TaskSolutionVO;
import cn.edu.jnu.crowdbc.domain.vo.UserInfoVO;
import org.web3j.abi.datatypes.Address;
import org.web3j.tx.Contract;

/**
 * CrowdBC 提供的服务
 * 主要包括：
 * 服务器信息、平台信息
 * 注册部分
 * 用户信息部分
 * Request-Worker互动部分
 */
public interface CrowdBCService {
    /**
     * @return 获取 web3j 版本
     */
    ResponseBody<?> getWeb3jVersionS();

    ResponseBody<?> getReputationAvgS();

    /**
     * 检测钱包地址和用户名是否已注册
     *
     * @param address 钱包地址
     * @param Name    用户名
     * @return
     */
    ResponseBody<?> isRegisteredS(Address address, String Name);

    ResponseBody<?> registerS(Address address, String Name);

    ResponseBody<?> getUserInfoS(Address address);

    ResponseBody<?> updateUserPassWordS(Address address, String passWord);

    ResponseBody<?> updateUserInfoS(UserInfoVO userInfoVO);

    ResponseBody<?> getUserReceivedTaskS(Address address);

    ResponseBody<?> getUserProcessingTaskS(Address address);

    ResponseBody<?> getUserSubmittedTaskS(Address address);

    ResponseBody<?> getUserEvaluatingTaskS(Address address);

    ResponseBody<?> getUserFinishedTaskS(Address address);

    ResponseBody<?> getAllTaskS();

    /**
     * 还未被接收的任务
     *
     * @return
     */
    ResponseBody<?> getAllUnreceivedTaskS();

    ResponseBody<?> receiveTaskS(String taskIdentity);

    ResponseBody<?> postTaskS(TaskInfoVO taskInfoVO);

    ResponseBody<?> getTaskInfoS(Address address);

    ResponseBody<?> getGMAddressS();

    ResponseBody<?> isReceivedS(String taskIdentity);

    ResponseBody<?> getWorkersListS(String taskIdentity);

    ResponseBody<?> submitSolutionS(TaskSolutionVO taskSolutionVO);

    ResponseBody<?> evaluateSolutionS(EvaluateSolutionResultVO solutionResultVO);

    ResponseBody<?> getAllSolutionS(String taskIdentity);

    ResponseBody<?> deployContractS(Contract contract);

    ResponseBody<?> queryContractS(Address address);

    ResponseBody<?> transferS(String from, String to, String amount);
}
