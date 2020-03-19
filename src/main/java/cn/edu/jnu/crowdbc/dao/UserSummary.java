package cn.edu.jnu.crowdbc.dao;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class UserSummary extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a031916331790556102b5806100326000396000f3006080604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166333be71a6811461008957806355fe9357146100ac578063696ccf2c146100e0578063702dc35d146100f85780637c77e61f146101195780639fa9df0114610140575b34801561008357600080fd5b50600080fd5b34801561009557600080fd5b506100aa600160a060020a0360043516610155565b005b3480156100b857600080fd5b506100c46004356101ca565b60408051600160a060020a039092168252519081900360200190f35b3480156100ec57600080fd5b506100c46004356101f6565b34801561010457600080fd5b506100aa600160a060020a0360043516610207565b34801561012557600080fd5b5061012e61027d565b60408051918252519081900360200190f35b34801561014c57600080fd5b5061012e610283565b600054600160a060020a0316331461016c57600080fd5b6001805480820182556000919091527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf601805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60006002828154811015156101db57fe5b600091825260209091200154600160a060020a031692915050565b60006001828154811015156101db57fe5b600054600160a060020a0316331461021e57600080fd5b600280546001810182556000919091527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace01805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60025490565b600154905600a165627a7a7230582094d9f84429ca4dea278f9e233cb0db6950546660effac4947f98bd0682703ba60029";

    public static final String FUNC_ADDPOSTTASK = "addPostTask";

    public static final String FUNC_GETRECEIVETASKADDR = "getReceiveTaskAddr";

    public static final String FUNC_GETPOSTTASKADDR = "getPostTaskAddr";

    public static final String FUNC_ADDRECEIVETASK = "addReceiveTask";

    public static final String FUNC_GETRECEIVETASKLENGTH = "getReceiveTaskLength";

    public static final String FUNC_GETPOSTTASKLENGTH = "getPostTaskLength";

    @Deprecated
    protected UserSummary(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserSummary(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UserSummary(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UserSummary(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> addPostTask(String rwrc) {
        final Function function = new Function(
                FUNC_ADDPOSTTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rwrc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getReceiveTaskAddr(BigInteger i) {
        final Function function = new Function(
                FUNC_GETRECEIVETASKADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getPostTaskAddr(BigInteger i) {
        final Function function = new Function(
                FUNC_GETPOSTTASKADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addReceiveTask(String rwrc) {
        final Function function = new Function(
                FUNC_ADDRECEIVETASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rwrc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getReceiveTaskLength() {
        final Function function = new Function(
                FUNC_GETRECEIVETASKLENGTH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getPostTaskLength() {
        final Function function = new Function(
                FUNC_GETPOSTTASKLENGTH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<UserSummary> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UserSummary.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<UserSummary> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UserSummary.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UserSummary> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UserSummary.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UserSummary> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UserSummary.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static UserSummary load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserSummary(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UserSummary load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserSummary(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UserSummary load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UserSummary(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UserSummary load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UserSummary(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
