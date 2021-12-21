package com.beauty.designpatterns.behavior;

/**
 * description 责任链模式
 * 请假 <3天 组长 3~5 部门经理  5~ 副总
 *
 * @author yufengwen
 * @date 2021/12/21 11:25 上午
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        final Approver groupLeader = new GroupLeader();
        final Approver deptLeader = new DeptLeader();
        final Approver vicePresident = new VicePresident();
        groupLeader.setNextApprover(deptLeader);
        deptLeader.setNextApprover(vicePresident);
        final Boolean approve = groupLeader.approve(20);
    }

}

/**
 * 审批人
 */
abstract class Approver{

    public Approver nextApprover;

    /**
     * 审批
     * @return
     */
    abstract Boolean approve(Integer days);
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}

/**
 * 组长
 */
class GroupLeader extends Approver {

    /**
     * 审批
     *
     * @param days
     * @return
     */
    @Override
    public Boolean approve(Integer days) {
        if (days == null||days<3) {
            System.out.println("组长审批完成");
            return true;
        }
        if (nextApprover!=null) {

            return nextApprover.approve(days);
        }
        return false;
    }
}


/**
 * 部门leader
 */
class DeptLeader extends Approver{


    /**
     * 审批
     *
     * @param days
     * @return
     */
    @Override
    public Boolean approve(Integer days) {
        if (days >= 3&&days<5) {
            System.out.println("部门经理审批完成");
            return true;
        }
        if (nextApprover!=null) {

            return nextApprover.approve(days);
        }
        return false;
    }
}


/**
 * 副总
 */
class VicePresident extends Approver{


    /**
     * 审批
     *
     * @param days
     * @return
     */
    @Override
    public Boolean approve(Integer days) {
        if (days >= 5) {
            System.out.println("副总审批完成");
            return true;
        }
        if (nextApprover!=null) {

            return nextApprover.approve(days);
        }
        return false;
    }
}


