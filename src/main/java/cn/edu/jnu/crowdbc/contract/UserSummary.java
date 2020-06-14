package com.your.organisation.name;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class UserSummary extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03199081163317808355600180549092166001600160a01b039091161790556102f690819061004b90396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80632cfa88511461006757806333be71a6146100a05780633bcc08b3146100c85780634cb61b2b146100e2578063696ccf2c146101085780639fa9df0114610125575b600080fd5b6100846004803603602081101561007d57600080fd5b503561012d565b604080516001600160a01b039092168252519081900360200190f35b6100c6600480360360208110156100b657600080fd5b50356001600160a01b0316610157565b005b6100d06101fe565b60408051918252519081900360200190f35b6100c6600480360360208110156100f857600080fd5b50356001600160a01b0316610204565b6100846004803603602081101561011e57600080fd5b50356102ab565b6100d06102ba565b60006003828154811061013c57fe5b6000918252602090912001546001600160a01b031692915050565b6000546001600160a01b031633146101ac576040805162461bcd60e51b81526020600482015260136024820152726d73672e73656e6465722020213d207265672160681b604482015290519081900360640190fd5b600280546001810182556000919091527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace0180546001600160a01b0319166001600160a01b0392909216919091179055565b60035490565b6000546001600160a01b03163314610259576040805162461bcd60e51b81526020600482015260136024820152726d73672e73656e6465722020213d207265672160681b604482015290519081900360640190fd5b600380546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b0180546001600160a01b0319166001600160a01b0392909216919091179055565b60006002828154811061013c57fe5b6002549056fea2646970667358221220eca2aaa89ade0f85f03f45d370412bbf19b6212317147716299be16c153bc70664736f6c63430006080033";

    public static final String FUNC_ADDACCEPTTASK = "addAcceptTask";

    public static final String FUNC_ADDPOSTTASK = "addPostTask";

    public static final String FUNC_GETACCEPTTASKADDR = "getAcceptTaskAddr";

    public static final String FUNC_GETACCEPTTASKLENGTH = "getAcceptTaskLength";

    public static final String FUNC_GETPOSTTASKADDR = "getPostTaskAddr";

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

    public RemoteFunctionCall<TransactionReceipt> addAcceptTask(String task) {
        final Function function = new Function(
                FUNC_ADDACCEPTTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, task)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addPostTask(String task) {
        final Function function = new Function(
                FUNC_ADDPOSTTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, task)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getAcceptTaskAddr(BigInteger i) {
        final Function function = new Function(FUNC_GETACCEPTTASKADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAcceptTaskLength() {
        final Function function = new Function(FUNC_GETACCEPTTASKLENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getPostTaskAddr(BigInteger i) {
        final Function function = new Function(FUNC_GETPOSTTASKADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getPostTaskLength() {
        final Function function = new Function(FUNC_GETPOSTTASKLENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
}
