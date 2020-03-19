package cn.edu.jnu.crowdbc.service;


import cn.edu.jnu.crowdbc.domain.ResponseBody;
import cn.edu.jnu.crowdbc.domain.vo.EvaluateSolutionResultVO;
import cn.edu.jnu.crowdbc.domain.vo.TaskInfoVO;
import cn.edu.jnu.crowdbc.domain.vo.TaskSolutionVO;
import cn.edu.jnu.crowdbc.domain.vo.UserInfoVO;
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
    ResponseBody<?> getWeb3jVersion();

    ResponseBody<?> getReputationAvg();

    /**
     * 检测钱包地址和用户名是否已注册
     *
     * @param address 钱包地址
     * @param Name    用户名
     * @return
     */
    ResponseBody<?> isRegistered(String address, String Name);

    ResponseBody<?> register(String address, String Name);

    ResponseBody<?> getUserInfo(String address);

    ResponseBody<?> updateUserPassWord(String address, String passWord);

    ResponseBody<?> updateUserInfo(UserInfoVO userInfoVO);

    ResponseBody<?> getUserReceivedTask(String address);

    ResponseBody<?> getUserProcessingTask(String address);

    ResponseBody<?> getUserSubmittedTask(String address);

    ResponseBody<?> getUserEvaluatingTask(String address);

    ResponseBody<?> getUserFinishedTask(String address);

    ResponseBody<?> getAllTask();

    /**
     * 还未被接收的任务
     *
     * @return
     */
    ResponseBody<?> getAllUnreceivedTask();

    ResponseBody<?> receiveTask(String taskIdentity);

    ResponseBody<?> postTask(TaskInfoVO taskInfoVO);

    ResponseBody<?> getTaskInfo(String address);

    ResponseBody<?> getGMAddress();

    ResponseBody<?> isReceived(String taskIdentity);

    ResponseBody<?> getWorkersList(String taskIdentity);

    ResponseBody<?> submitSolution(TaskSolutionVO taskSolutionVO);

    ResponseBody<?> evaluateSolution(EvaluateSolutionResultVO solutionResultVO);

    ResponseBody<?> getAllSolution(String taskIdentity);

    ResponseBody<?> deployContract(Contract contract);

    ResponseBody<?> queryContract(String address);

    ResponseBody<?> transfer(String from, String to, String amount);
}
