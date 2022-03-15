package com.beauty.designpatterns.behavior;

import java.util.Stack;

/**
 * description 命令模式
 * <p>
 * 比如看电视时，我们只需要轻轻一按遥控器就能完成频道的切换，这就是命令模式，将换台请求和换台处理完全解耦了。
 * 电视机遥控器（命令发送者）通过按钮（具体命令）来遥控电视机（命令接收者）。
 * <p>
 * 命令（Command）模式的定义如下：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
 * 这样两者之间通过命令对象进行沟通，这样方便将命令对象进行储存、传递、调用、增加与管理。
 * <p>
 * 命令模式的主要优点如下。
 * 通过引入中间件（抽象接口）降低系统的耦合度。
 * 扩展性良好，增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，且满足“开闭原则”。
 * 可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令。
 * 方便实现 Undo 和 Redo 操作。命令模式可以与后面介绍的备忘录模式结合，实现命令的撤销与恢复。
 * 可以在现有命令的基础上，增加额外功能。比如日志记录，结合装饰器模式会更加灵活。
 * <p>
 * 其缺点是：
 * 可能产生大量具体的命令类。因为每一个具体操作都需要设计一个具体命令类，这会增加系统的复杂性。
 * 命令模式的结果其实就是接收方的执行结果，但是为了以命令的形式进行架构、解耦请求与实现，引入了额外类型结构（引入了请求方与抽象命令接口），
 * 增加了理解上的困难。不过这也是设计模式的通病，抽象必然会额外增加类的数量，代码抽离肯定比代码聚合更加难理解。
 * <p>
 * 1. 模式的结构
 * 命令模式包含以下主要角色。
 * 抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
 * 具体命令类（Concrete Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
 * 实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 * 调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。
 *
 * @author yufengwen
 * @date 2021/12/16 7:53 下午
 */
public class CommandPattern {

    public static void main(String[] args) {
//        Command command = new ConcreteCommand();
//        final Invoker invoker = new Invoker(command);
//        invoker.senCommand();

        testECommand();
    }


    public static void testECommand(){
        final RemoteControl remoteControl = new RemoteControl();

        remoteControl.seteCommand(new ChangeChannelCommand());
        remoteControl.execute();
        remoteControl.seteCommand(new IncreaseVoiceCommand());
        remoteControl.execute();
        remoteControl.seteCommand(new DecreaseVoiceCommand());
        remoteControl.execute();
    }

}


interface Command {
    void excute();
}


class ConcreteCommand implements Command {

    private final Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void excute() {
        receiver.doWork();
    }
}

class Receiver {

    public void doWork() {
        System.out.println("命令执行成功了");
    }

}


class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void senCommand() {
        System.out.println("发送命令成功了");
        command.excute();
    }


}


// 案例：遥控器 控制家电

/*
 * 抽象命令：控制家电命令抽象
 * 具体命令：具体的控制家电命令
 * 执行者：家电
 * 调用者：遥控器
 */
interface ECommand{

    void execute();


}

/**
 * 换频道
 */
class ChangeChannelCommand implements ECommand{
    private ElectricAppliance electricAppliance;

    public void setElectricAppliance(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    public ChangeChannelCommand() {
        this.electricAppliance = new ElectricAppliance();
    }

    public ChangeChannelCommand(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    @Override
    public void execute(){
        electricAppliance.changeChannel();
    }

}


/**
 * 加音量
 */
class IncreaseVoiceCommand implements ECommand{
    private ElectricAppliance electricAppliance;

    public void setElectricAppliance(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    public IncreaseVoiceCommand() {
        this.electricAppliance = new ElectricAppliance();
    }

    public IncreaseVoiceCommand(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    @Override
    public void execute(){
        electricAppliance.increaseVoice();
    }

}

/**
 * 减音量
 */
class DecreaseVoiceCommand implements ECommand{
    private ElectricAppliance electricAppliance;

    public void setElectricAppliance(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }


    public DecreaseVoiceCommand() {
        this.electricAppliance = new ElectricAppliance();
    }


    public DecreaseVoiceCommand(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    @Override
    public void execute(){
        electricAppliance.decreaseVoice();
    }

}

/**
 * 接受者 -- 家电
 */
class ElectricAppliance{

    public void changeChannel(){

        System.out.println("换台");
    }
    public void increaseVoice(){
        System.out.println("加音量");
    }
    public void decreaseVoice(){
        System.out.println("减音量");
    }

}

/**
 * 遥控器
 */
class RemoteControl{

    private ECommand eCommand;

    public void seteCommand(ECommand eCommand) {
        this.eCommand = eCommand;
    }

    public void execute(){
        eCommand.execute();
    }
}





// 案例：结合备忘录模式 实现 undo和 redo


// 案例：结合组合模式 实现 宏命令




