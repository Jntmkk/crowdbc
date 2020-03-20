package cn.edu.jnu.crowdbc.domain.vo;

import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Bytes32;

public class UserInfoVO {
    private Address address;
    private Address userAddress;
    private String userName;
    private Bytes32 passWord;
    private String profile;
    private Uint registerTime;
    private Uint processingTaskNum;
    private Uint finishedTaskNum;
    private Uint reputation;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Bytes32 getPassWord() {
        return passWord;
    }

    public void setPassWord(Bytes32 passWord) {
        this.passWord = passWord;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Uint getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Uint registerTime) {
        this.registerTime = registerTime;
    }

    public Uint getProcessingTaskNum() {
        return processingTaskNum;
    }

    public void setProcessingTaskNum(Uint processingTaskNum) {
        this.processingTaskNum = processingTaskNum;
    }

    public Uint getFinishedTaskNum() {
        return finishedTaskNum;
    }

    public void setFinishedTaskNum(Uint finishedTaskNum) {
        this.finishedTaskNum = finishedTaskNum;
    }

    public Uint getReputation() {
        return reputation;
    }

    public void setReputation(Uint reputation) {
        this.reputation = reputation;
    }
}
