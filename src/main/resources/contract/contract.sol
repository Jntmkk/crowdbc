pragma solidity ^0.6.0;

struct User {
    address addr;
    address usc;
    string username;
    bytes32 password;
    string profile;
    uint registerTime;
    uint processTaskNum;
    uint finishTaskNum;
    uint reputation;
}

struct Task{
    string description;
    uint reward;
    uint deposit;
    uint deadline;
    uint maxWorkerNum;
    uint currentWorkerNum;
    uint minReputation;
    uint taskType;
    Status status;
    string pointer;
}

struct Worker {
    address payable workerAddr;
    string workerName;
    string solution;
    string pointer;
    uint submitTime;
    uint level;
}

enum Status {
    Pending,
    Unaccepted,
    Accepted,
    Evaluating,
    Completed
}


contract Register {
    
    address managerAddr;
    uint maxResisters = 999999;
    uint registerNum = 0;
    uint reputationSum = 0;
    address[] userAddrList;
    //waiting to move to usc/rwrc
    address[] taskList;
    mapping(string => User) userPool;
    mapping(string => address) uscPool;
    
    constructor() public {
        managerAddr = msg.sender;
    }
    
    function isRegister(address addr,  string memory username) public view returns (bool) {
        for(uint i = 0; i < userAddrList.length; i++){
            if(userAddrList[i] == addr){
                return true;
            }
        }
        return userPool[username].addr != address(0);
    }
    
    function register(address addr, string memory username, string memory password, string memory profile) public{
        // require(msg.sender == managerAddr, "msg.sender must be manager!");
        require(registerNum < maxResisters);
        require(isRegister(addr,username) == false, "has been registered!");
        
        //make a usc contract
        UserSummary usc = new UserSummary();
        uscPool[username] = address(usc);
        
        userPool[username] = User(addr,address(usc),username,keccak256(bytes(password)),profile,now,0,0,60);
        userAddrList.push(addr);
        registerNum++;
        reputationSum += 60;
    }
    
    function login(string memory username, string memory password) public view returns (bool) {
        return userPool[username].password == keccak256(bytes(password));
    }
    
    function getUserInformation(string memory username) public view returns (address, address, string memory, uint, uint, uint, uint) {
        User memory user = userPool[username];
        return (user.addr,user.usc,user.profile, user.registerTime, user.processTaskNum, user.finishTaskNum, user.reputation);
    }
    
    function updatePassword(string memory username,string memory newPassword) public {
        // require(msg.sender == managerAddr, "msg.sender must be manager!");
        userPool[username].password = keccak256(bytes(newPassword));
    }
    
    function updateProfile(string memory username, string memory newProfile) public {
        // require(msg.sender == managerAddr, "msg.sender must be manager!");
        userPool[username].profile = newProfile;
    }
    
    function getManagerAddr() public view returns (address){
        return managerAddr;
    }
    
    //Rwrc call:
    function checkAddr(string memory username, address addr) public view returns (bool) {
        return userPool[username].addr == addr;
    }
    
    function getReputationAvg() public view returns (uint) {
        return reputationSum/registerNum;
    }
    
    function getUserReputation(string memory username) public view returns (uint) {
        return userPool[username].reputation;
    }
    
    
    // updateUserReputation、updateFinishTaskNum、addAcceptTaskNUm 
    function updateUserReputation(string memory username, uint newReputation) public {
        require(userPool[username].addr != address(0));
        require(newReputation >= 0 && newReputation <= 100,"new reputation wrong");
        // for(uint i = 0; i < taskList.length; i++){
        //     if(msg.sender == taskList[i]) {
                reputationSum += (newReputation - userPool[username].reputation);
                userPool[username].reputation = newReputation;
        //         break;
        //     }
        // }
    }
    
    function updateFinishTaskNum(string memory username) public {
        require(userPool[username].addr != address(0));
        // for(uint i = 0; i < taskList.length; i++) {
        //     if(msg.sender == taskList[i]) {
                --userPool[username].processTaskNum;
                ++userPool[username].finishTaskNum;
        //         break;
        //     }
        // }
    } 
    
    function addPostTask(string memory username) public {
        require(userPool[username].addr != address(0));
        address taskMagAddr = msg.sender;
        taskList.push(taskMagAddr);
        UserSummary(uscPool[username]).addPostTask(taskMagAddr);
    }
    
    function addAcceptTask(string memory username) public {
        // for(uint i = 0; i < taskList.length; i++){
        //     if(msg.sender == taskList[i]) {
                ++userPool[username].processTaskNum;
                // UserSummary(uscPool[username]).addAcceptTask(taskList[i]);
                UserSummary(uscPool[username]).addAcceptTask(msg.sender);
        //         break;
        //     }
        // }
    }
    
}

contract UserSummary {
    address regAddr;
    Register reg;
    address[] postTaskList;
    address[] acceptTaskList;
    address[] taskList;
    
     constructor() public {
        regAddr = msg.sender;
        reg = Register(regAddr);
    }
    
    function getPostTaskLength() public view returns (uint) {
        return postTaskList.length;
    }
    
    function getAcceptTaskLength() public view returns (uint) {
        return acceptTaskList.length;
    }
    
    function getPostTaskAddr(uint i) public view returns (address){
        return postTaskList[i];
    }
    
    function getAcceptTaskAddr(uint i) public view returns (address){
        return acceptTaskList[i];
    }
    
    //Reg call:
    function addPostTask(address task) public{
        require(msg.sender == regAddr, "msg.sender  != reg!");
        postTaskList.push(task);
    }
    
    function addAcceptTask(address task) public{
        require(msg.sender == regAddr, "msg.sender  != reg!");
        acceptTaskList.push(task);
    }
    
}

contract TaskManagement {
    Register reg;
    address managerAddr;
    address payable posterAddr;
    string posterName;
    Task task;
    Worker[] workerList;
    uint solutionNum;
    uint evaluatedNum;
    
    constructor(address regAddr, address _managerAddr, string memory _posterName,
        string memory description, uint deposit, uint deadline, uint maxWorkerNum, 
        uint minReputation, uint taskType, string memory pointer) public payable{
        reg = Register(regAddr);
        posterAddr = msg.sender;
        managerAddr = _managerAddr;
        posterName = _posterName;
        //not require(reg.checkAddr(posterName, posterAddr));
        require(reg.checkAddr(posterName, posterAddr) == true);
        task.description = description;
        task.reward = msg.value;
        task.deposit = deposit;
        task.deadline = deadline;
        task.maxWorkerNum = maxWorkerNum;
        task.currentWorkerNum = 0;
        task.minReputation = minReputation;
        task.taskType = taskType;
        task.status = Status.Unaccepted;
        task.pointer = pointer;
        
        // The origin of the problem
        reg.addPostTask(posterName);
    }
    
    function getTaskInformation() public returns  (string memory, uint, uint, uint, uint, uint, uint, uint, Status, string memory) {
        updateStatus();
        return (task.description, task.reward, task.deposit, task.deadline, task.maxWorkerNum, task.currentWorkerNum,task.minReputation, task.taskType, task.status, task.pointer);
    }
    
    function checkAcceptCondition(string memory workerName) public view returns (bool) {
        if( keccak256(abi.encodePacked((posterName))) == keccak256(abi.encodePacked((workerName))) )
            return false;
        if(now >= task.deadline)
            return false;
        if(task.status != Status.Unaccepted)
            return false;
        if(msg.sender.balance < task.deposit)
            return false;
        if(reg.getUserReputation(workerName) < task.minReputation )
            return false;
        for(uint i = 0; i < workerList.length; i++){
            string memory _workerName = workerList[i].workerName;
            if( keccak256(abi.encodePacked((_workerName))) == keccak256(abi.encodePacked((workerName))) )
                return false;
        }
        return true;
    }
    
    function acceptTask(string memory workerName) public payable {
        require(checkAcceptCondition(workerName) == true, "Condition is not fullfiled");
        require(msg.value > task.deposit, "msg.value must larger than task.deposit");
        workerList.push(Worker(msg.sender, workerName, "", "", 0, 0));
        reg.addAcceptTask(workerName);
        task.currentWorkerNum ++;
        updateStatus();
    }
    
    function submitSolution(string memory workerName, string memory solution, string memory pointer) public {
        // require(msg.sender == managerAddr, "msg.sender != managerAddr");
        require(now <= task.deadline, "Out of deadline");
        uint id = findWorkerId(workerName);
        require(id != 99999, "id isn't exist!");
        workerList[id].submitTime = now;
        workerList[id].solution = solution;
        workerList[id].pointer = pointer;
        solutionNum++;
        updateStatus();
    }
    
    function evaluateSolution(uint id, uint level) public {
        require(msg.sender == managerAddr, "must be managerAddr");
        require(workerList[id].level == 0, "has been evaluated!");
        workerList[id].level = level;

        //
        string storage workerName = workerList[id].workerName;
        uint rep = reg.getUserReputation(workerName);
        // 计算奖励 ?
        uint sendReward = task.deposit;
        // 平均奖励
        uint reward = task.reward / task.maxWorkerNum;
        // 高评估 高信誉 => 加信誉 + 奖励
        if (level >= 5 && rep >= reg.getReputationAvg()) {
            reg.updateUserReputation(workerName, rep + 1);
            sendReward += reward;
        }

        // 低评估 高信誉 => 减信誉
        else if (level < 5 && rep >= reg.getReputationAvg() + 1) {
            reg.updateUserReputation(workerName, rep - 1);
        }

        // 低评估 平均信誉 => 阈值
        else if (level < 5 && rep == reg.getReputationAvg()) {
            reg.updateUserReputation(workerName, 60);
        }

        // 低信誉 => 加信誉
        else if (rep < reg.getReputationAvg()){
            reg.updateUserReputation(workerName, rep + 1);
        }

        // 发送奖励
        workerList[id].workerAddr.transfer(sendReward);

        // 更新数量
        reg.updateFinishTaskNum(workerName);

        // 更新评估数量
        ++evaluatedNum;

        // 更新任务状态
        updateStatus();
    }
    
    function getSolutionLength() public view returns (uint) {
        return solutionNum;
    }
    
    function getSolutionInfo(uint i) public view returns (string memory, string memory, string memory, uint, uint){
         return (workerList[i].workerName, workerList[i].solution, workerList[i].pointer, workerList[i].submitTime, workerList[i].level);
    }
    
    function kill() public payable {
        require(msg.sender == managerAddr);
        updateStatus();
        if(task.status == Status.Completed){
            posterAddr.transfer(address(this).balance);
        }
    }
    
    function updateStatus() private returns (Status) {

        task.status = Status.Pending; // 0 等待......

        // 未满人数 && 未到时间

        if(task.currentWorkerNum < task.maxWorkerNum && now <= task.deadline)

            task.status = Status.Unaccepted; // 1 未领取完

        // 已满人数 && 未到时间

        if(task.currentWorkerNum == task.maxWorkerNum && now <= task.deadline)

            task.status = Status.Accepted; // 2 已领取完

        // 评估未完 && 到达时间

        if(solutionNum > evaluatedNum && now >= task.deadline)

            task.status = Status.Evaluating; // 3 评估中

        // (评估完毕 && 到达时间) || (评估完毕 && 到达人数)

        if((solutionNum == evaluatedNum && now >= task.deadline) || 

            (solutionNum == evaluatedNum && evaluatedNum == task.maxWorkerNum))

            task.status = Status.Completed; // 4 已完成

    }
    
    function findWorkerId(string memory workerName) private view returns (uint) {
        for(uint i = 0; i < workerList.length; ++i){
            string memory _workerName = workerList[i].workerName;
            if( keccak256(abi.encodePacked((_workerName))) == keccak256(abi.encodePacked((workerName))) )
                return i;
        }
        return 99999;
    }
}

struct Device {
    string deviceName;
    uint deviceId;//only one to 
    string deviceType;
    string APIurl;
    string accessPlatform;
    string description;
    DeviceTestType testType;
}

enum DeviceTestType {
    Online,
    Offline
}

contract DeviceTestManagement {
    mapping(uint => Device) devicePool;
    uint deviceNum;
    // Task task;
    // TaskManagement taskMagContract;
    
    constructor() public {
        deviceNum = 0;
    }
    
    function addDevice(uint deviceId, string memory deviceName, string memory deviceType,
        string memory APIurl, string memory accessPlatform, string memory description, uint testType) public{
            if(testType == 0)
                devicePool[deviceId] = Device(deviceName,deviceId,deviceType,APIurl,accessPlatform,description,DeviceTestType.Online);
            else
                devicePool[deviceId] = Device(deviceName,deviceId,deviceType,APIurl,accessPlatform,description,DeviceTestType.Online);
            deviceNum++;
    }
    
    function getDeviceInfo(uint deviceId) public view returns(uint, string memory, string memory, string memory, string memory, string memory, DeviceTestType) {
        Device memory device = devicePool[deviceId];
        return(device.deviceId,device.deviceName,device.deviceType,device.APIurl,device.accessPlatform,device.description,device.testType);
    }
    
    function getDeviceNum() public view returns(uint) {
        return deviceNum;
    }
    
}




















