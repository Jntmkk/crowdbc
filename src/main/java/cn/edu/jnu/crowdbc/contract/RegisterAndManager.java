package com.github.jntm.web3jspringbootstarter.contract;


import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
 * <p>Generated with web3j version 4.5.11.
 */
@SuppressWarnings("rawtypes")
public class RegisterAndManager extends Contract {
    public static final String BINARY = "60806040526298968060015560006002556000600355600060045534801561002657600080fd5b5060008054600160a060020a03191633179055610f1d806100486000396000f3006080604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632940ce44811461009a57806356eabb9c146101155780636224eed4146101395780637ce7c9901461016a5780638d59cc021461018e578063a86a619f14610226578063b9658bcc14610247578063baccbfdb1461026e578063cb5af49b1461028f575b005b3480156100a657600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610101958335600160a060020a03169536956044949193909101919081908401838280828437509497506102f69650505050505050565b604080519115158252519081900360200190f35b34801561012157600080fd5b50610098600160a060020a036004351660243561039c565b34801561014557600080fd5b5061014e61059d565b60408051600160a060020a039092168252519081900360200190f35b34801561017657600080fd5b5061014e600160a060020a03600435166024356105ac565b60408051602060046024803582810135601f8101859004850286018501909652858552610098958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506105b09650505050505050565b34801561023257600080fd5b5061014e600160a060020a0360043516610a32565b34801561025357600080fd5b5061025c610af2565b60408051918252519081900360200190f35b34801561027a57600080fd5b5061025c600160a060020a0360043516610af8565b34801561029b57600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610101958335600160a060020a0316953695604494919390910191908190840183828082843750949750610b969650505050505050565b600080600160a060020a03166008836040518082805190602001908083835b602083106103345780518252601f199092019160209182019101610315565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922054600160a060020a03169290921491508190506103945750600160a060020a0383811660009081526009602052604090205416155b159392505050565b600160a060020a03828116600090815260096020526040812054909116151561040f576040805160e560020a62461bcd02815260206004820152601360248201527f6163636f756e74206e6f74206578697374732100000000000000000000000000604482015290519081900360640190fd5b60008210158015610421575060648211155b1515610477576040805160e560020a62461bcd02815260206004820152601560248201527f72657075746174696f6e206c696d69746174696f6e0000000000000000000000604482015290519081900360640190fd5b50600160a060020a0380831660009081526009602090815260408083205481517fffe6a18e0000000000000000000000000000000000000000000000000000000081529151941693849363ffe6a18e93600480850194919392918390030190829087803b1580156104e757600080fd5b505af11580156104fb573d6000803e3d6000fd5b505050506040513d602081101561051157600080fd5b5051600380549184039091019055604080517ff43970f3000000000000000000000000000000000000000000000000000000008152600481018490529051600160a060020a0383169163f43970f391602480830192600092919082900301818387803b15801561058057600080fd5b505af1158015610594573d6000803e3d6000fd5b50505050505050565b600054600160a060020a031690565b5090565b60008054600160a060020a03163314610639576040805160e560020a62461bcd02815260206004820152602160248201527f6f6e6c79206f776e657220697320616c6c6f77656420746f206f70657261746560448201527f2e00000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b60015460025460408051808201909152601281527f7265676973746572206c696d746174696f6e00000000000000000000000000006020820152808284116107025760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156106c75781810151838201526020016106af565b50505050905090810190601f1680156106f45780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b5061070d87876102f6565b15610762576040805160e560020a62461bcd02815260206004820152601060248201527f616c726561647920726567697374657200000000000000000000000000000000604482015290519081900360640190fd5b86868642603c610770610c16565b8086600160a060020a0316600160a060020a031681526020018060200180602001858152602001848152602001838103835287818151815260200191508051906020019080838360005b838110156107d25781810151838201526020016107ba565b50505050905090810190601f1680156107ff5780820380516001836020036101000a031916815260200191505b50838103825286518152865160209182019188019080838360005b8381101561083257818101518382015260200161081a565b50505050905090810190601f16801561085f5780820380516001836020036101000a031916815260200191505b50975050505050505050604051809103906000f080158015610885573d6000803e3d6000fd5b509350866008876040518082805190602001908083835b602083106108bb5780518252601f19909201916020918201910161089c565b51815160209384036101000a6000190180199092169116179052920194855250604080519485900382018520805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03988916179091558d871660008181526009855283812080548416998e16999099179098556005805460018181018355918a527f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db001805490931682179092556002805490920190915560038054603c01905585524290850181905260608583018181528d51918701919091528c517f05675541f05670f80ec0de015f30985ac35c702ded7ef2b728203596f0408b4e978f978f9750939550929391926080850192870191908190849084905b838110156109ed5781810151838201526020016109d5565b50505050905090810190601f168015610a1a5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a150505050505050565b600080548290600160a060020a0316331480610a56575033600160a060020a038216145b1515610ad2576040805160e560020a62461bcd02815260206004820152602c60248201527f6f6e6c79206f776e657220616e6420686f6c64657220697320616c6c6f77656460448201527f20746f206f7065726174652e0000000000000000000000000000000000000000606482015290519081900360840190fd5b5050600160a060020a039081166000908152600960205260409020541690565b60035490565b600160a060020a0380821660009081526009602090815260408083205481517fffe6a18e00000000000000000000000000000000000000000000000000000000815291519394169263ffe6a18e9260048084019391929182900301818787803b158015610b6457600080fd5b505af1158015610b78573d6000803e3d6000fd5b505050506040513d6020811015610b8e57600080fd5b505192915050565b600082600160a060020a03166008836040518082805190602001908083835b60208310610bd45780518252601f199092019160209182019101610bb5565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922054600160a060020a03169290921495945050505050565b6040516102cb80610c27833901905600608060405234801561001057600080fd5b506040516102cb3803806102cb8339810160409081528151602080840151928401516060850151608086015160008054600160a060020a03191633179055948601805194969095920193909261006b916004918701906100ad565b5060038054600160a060020a031916600160a060020a038716179055825161009a9060059060208601906100ad565b5060069190915560075550610148915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100ee57805160ff191683800117855561011b565b8280016001018555821561011b579182015b8281111561011b578251825591602001919060010190610100565b5061012792915061012b565b5090565b61014591905b808211156101275760008155600101610131565b90565b610174806101576000396000f30060806040526004361061004b5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663f43970f38114610050578063ffe6a18e1461006a575b600080fd5b34801561005c57600080fd5b50610068600435610091565b005b34801561007657600080fd5b5061007f610142565b60408051918252519081900360200190f35b60005473ffffffffffffffffffffffffffffffffffffffff16331461013d57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602160248201527f6f6e6c79206f776e657220697320616c6c6f77656420746f206f70657261746560448201527f2e00000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b600755565b600754905600a165627a7a72305820ceea63b6391188007517d861ff7744f9ded33e9e15cd552379e2f44f0c5dfddc0029a165627a7a72305820b274e8e5cf5f8472a90e483ecf0548531a88a5ecae2a4ab452051d8408804a200029";

    public static final String FUNC_ISREGISTERED = "isRegistered";

    public static final String FUNC_UPDATEUSERREPUTATION = "updateUserReputation";

    public static final String FUNC_GETGMADDRESS = "getGMAddress";

    public static final String FUNC_TRANSFER2 = "transfer2";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_GETUSCADDRESS = "getUscAddress";

    public static final String FUNC_GETALLREPUTATION = "getAllReputation";

    public static final String FUNC_GETUSERREPUTATION = "getUserReputation";

    public static final String FUNC_ISRELATED = "isRelated";

    public static final Event REGISTEREVENT_EVENT = new Event("RegisterEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected RegisterAndManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RegisterAndManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RegisterAndManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RegisterAndManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isRegistered(String _addr, String _userName) {
        final Function function = new Function(FUNC_ISREGISTERED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.Utf8String(_userName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateUserReputation(String _addr, BigInteger _rep) {
        final Function function = new Function(
                FUNC_UPDATEUSERREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.generated.Uint256(_rep)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getGMAddress() {
        final Function function = new Function(FUNC_GETGMADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> transfer2(String recipient, BigInteger amount) {
        final Function function = new Function(FUNC_TRANSFER2, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> register(String _addr, String _userName, String _profile, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.Utf8String(_userName), 
                new org.web3j.abi.datatypes.Utf8String(_profile)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> getUscAddress(String _addr) {
        final Function function = new Function(FUNC_GETUSCADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAllReputation() {
        final Function function = new Function(FUNC_GETALLREPUTATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getUserReputation(String _addr) {
        final Function function = new Function(FUNC_GETUSERREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isRelated(String _addr, String userName) {
        final Function function = new Function(FUNC_ISRELATED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.Utf8String(userName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public List<RegisterEventEventResponse> getRegisterEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REGISTEREVENT_EVENT, transactionReceipt);
        ArrayList<RegisterEventEventResponse> responses = new ArrayList<RegisterEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RegisterEventEventResponse typedResponse = new RegisterEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._userName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.registerTime = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RegisterEventEventResponse> registerEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RegisterEventEventResponse>() {
            @Override
            public RegisterEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REGISTEREVENT_EVENT, log);
                RegisterEventEventResponse typedResponse = new RegisterEventEventResponse();
                typedResponse.log = log;
                typedResponse._addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._userName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.registerTime = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RegisterEventEventResponse> registerEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REGISTEREVENT_EVENT));
        return registerEventEventFlowable(filter);
    }

    @Deprecated
    public static RegisterAndManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RegisterAndManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RegisterAndManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RegisterAndManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RegisterAndManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RegisterAndManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RegisterAndManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RegisterAndManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RegisterAndManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RegisterAndManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<RegisterAndManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RegisterAndManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RegisterAndManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RegisterAndManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RegisterAndManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RegisterAndManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class RegisterEventEventResponse extends BaseEventResponse {
        public String _addr;

        public String _userName;

        public BigInteger registerTime;
    }
}
