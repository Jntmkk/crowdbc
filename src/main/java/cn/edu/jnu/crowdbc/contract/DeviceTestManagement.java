package com.your.organisation.name;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
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
public class DeviceTestManagement extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506000600155610c1d806100256000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80632d75ae6c146100465780633db6b6c01461028f5780633ee92a0814610552575b600080fd5b6100636004803603602081101561005c57600080fd5b503561056c565b60405180888152602001806020018060200180602001806020018060200187600181111561008d57fe5b60ff16815260200186810386528c818151815260200191508051906020019080838360005b838110156100ca5781810151838201526020016100b2565b50505050905090810190601f1680156100f75780820380516001836020036101000a031916815260200191505b5086810385528b5181528b516020918201918d019080838360005b8381101561012a578181015183820152602001610112565b50505050905090810190601f1680156101575780820380516001836020036101000a031916815260200191505b5086810384528a5181528a516020918201918c019080838360005b8381101561018a578181015183820152602001610172565b50505050905090810190601f1680156101b75780820380516001836020036101000a031916815260200191505b5086810383528951815289516020918201918b019080838360005b838110156101ea5781810151838201526020016101d2565b50505050905090810190601f1680156102175780820380516001836020036101000a031916815260200191505b5086810382528851815288516020918201918a019080838360005b8381101561024a578181015183820152602001610232565b50505050905090810190601f1680156102775780820380516001836020036101000a031916815260200191505b509c5050505050505050505050505060405180910390f35b610550600480360360e08110156102a557600080fd5b81359190810190604081016020820135600160201b8111156102c657600080fd5b8201836020820111156102d857600080fd5b803590602001918460018302840111600160201b831117156102f957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561034b57600080fd5b82018360208201111561035d57600080fd5b803590602001918460018302840111600160201b8311171561037e57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156103d057600080fd5b8201836020820111156103e257600080fd5b803590602001918460018302840111600160201b8311171561040357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561045557600080fd5b82018360208201111561046757600080fd5b803590602001918460018302840111600160201b8311171561048857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156104da57600080fd5b8201836020820111156104ec57600080fd5b803590602001918460018302840111600160201b8311171561050d57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955050913592506108ea915050565b005b61055a610b01565b60408051918252519081900360200190f35b600060608060608060606000610580610b08565b6000898152602081815260409182902082518154600260018216156101009081026000190190921604601f81018590049094028201810190945260e0810183815290939192849284919084018282801561061b5780601f106105f05761010080835404028352916020019161061b565b820191906000526020600020905b8154815290600101906020018083116105fe57829003601f168201915b5050505050815260200160018201548152602001600282018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106c75780601f1061069c576101008083540402835291602001916106c7565b820191906000526020600020905b8154815290600101906020018083116106aa57829003601f168201915b505050918352505060038201805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815293820193929183018282801561075b5780601f106107305761010080835404028352916020019161075b565b820191906000526020600020905b81548152906001019060200180831161073e57829003601f168201915b505050918352505060048201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156107ef5780601f106107c4576101008083540402835291602001916107ef565b820191906000526020600020905b8154815290600101906020018083116107d257829003601f168201915b505050918352505060058201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156108835780601f1061085857610100808354040283529160200191610883565b820191906000526020600020905b81548152906001019060200180831161086657829003601f168201915b5050509183525050600682015460209091019060ff1660018111156108a457fe5b60018111156108af57fe5b9052506020810151815160408301516060840151608085015160a086015160c090960151949f939e50919c509a509850919650945092505050565b806109f2576040518060e001604052808781526020018881526020018681526020018581526020018481526020018381526020016000600181111561092b57fe5b905260008881526020818152604090912082518051919261095192849290910190610b4f565b506020828101516001830155604083015180516109749260028501920190610b4f565b5060608201518051610990916003840191602090910190610b4f565b50608082015180516109ac916004840191602090910190610b4f565b5060a082015180516109c8916005840191602090910190610b4f565b5060c082015160068201805460ff1916600183818111156109e557fe5b0217905550905050610af0565b6040518060e0016040528087815260200188815260200186815260200185815260200184815260200183815260200160006001811115610a2e57fe5b9052600088815260208181526040909120825180519192610a5492849290910190610b4f565b50602082810151600183015560408301518051610a779260028501920190610b4f565b5060608201518051610a93916003840191602090910190610b4f565b5060808201518051610aaf916004840191602090910190610b4f565b5060a08201518051610acb916005840191602090910190610b4f565b5060c082015160068201805460ff191660018381811115610ae857fe5b021790555050505b505060018054810190555050505050565b6001545b90565b6040518060e0016040528060608152602001600081526020016060815260200160608152602001606081526020016060815260200160006001811115610b4a57fe5b905290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610b9057805160ff1916838001178555610bbd565b82800160010185558215610bbd579182015b82811115610bbd578251825591602001919060010190610ba2565b50610bc9929150610bcd565b5090565b610b0591905b80821115610bc95760008155600101610bd356fea2646970667358221220d578ab087a6bd9fa829c0718ed0fbc12b89e96d401f2aee69e43a1e2fcc39bbb64736f6c63430006080033";

    public static final String FUNC_ADDDEVICE = "addDevice";

    public static final String FUNC_GETDEVICEINFO = "getDeviceInfo";

    public static final String FUNC_GETDEVICENUM = "getDeviceNum";

    @Deprecated
    protected DeviceTestManagement(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DeviceTestManagement(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DeviceTestManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DeviceTestManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addDevice(BigInteger deviceId, String deviceName, String deviceType, String APIurl, String accessPlatform, String description, BigInteger testType) {
        final Function function = new Function(
                FUNC_ADDDEVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(deviceId), 
                new org.web3j.abi.datatypes.Utf8String(deviceName), 
                new org.web3j.abi.datatypes.Utf8String(deviceType), 
                new org.web3j.abi.datatypes.Utf8String(APIurl), 
                new org.web3j.abi.datatypes.Utf8String(accessPlatform), 
                new org.web3j.abi.datatypes.Utf8String(description), 
                new org.web3j.abi.datatypes.generated.Uint256(testType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple7<BigInteger, String, String, String, String, String, BigInteger>> getDeviceInfo(BigInteger deviceId) {
        final Function function = new Function(FUNC_GETDEVICEINFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(deviceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple7<BigInteger, String, String, String, String, String, BigInteger>>(function,
                new Callable<Tuple7<BigInteger, String, String, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple7<BigInteger, String, String, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, String, String, String, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getDeviceNum() {
        final Function function = new Function(FUNC_GETDEVICENUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static DeviceTestManagement load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DeviceTestManagement(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DeviceTestManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DeviceTestManagement(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DeviceTestManagement load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DeviceTestManagement(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DeviceTestManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DeviceTestManagement(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DeviceTestManagement> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DeviceTestManagement.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<DeviceTestManagement> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DeviceTestManagement.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DeviceTestManagement> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DeviceTestManagement.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DeviceTestManagement> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DeviceTestManagement.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
