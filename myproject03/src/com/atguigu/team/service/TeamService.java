/**
 * <p>Title: TeamService.java</p>
 * <p>Description: </p>
 *
 * @author zhouyao
 * @date 2021年6月30日
 * @version 1.0
 */
package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

public class TeamService {

    private static int counter = 1; // 给memberId赋值使用
    private final int MAX_MEMBER = 5; // 限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 保存开发团队成员
    private int total; // 记录开发团队中实际人数

    /**
     *
     * @Title: getTeam
     * @Description:获取开发团队中的所有成员
     * @return:包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() { // 可能未满
        Programmer[] team = new Programmer[total];// 故意这里也写了team，看是否能分清
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     *
     * @Title: addMember
     * @Description:将指定的员工添加到开发团队中
     * @param e:待添加成员的对象
     * @throws TeamException:添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee e) throws TeamException {
//		成员已满，无法添加
        if (total >= team.length) {
            throw new TeamException("成员已满，无法添加");
        }

//		该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

//		该员工已在本开发团队中
        if (isExit(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }

//		该员工已是某团队成员 (在本团队可以用team来比较，若在其它团队则用状态来考虑，即Status)
//		该员正在休假，无法添加
        Programmer p = (Programmer) e;// 走到这一步，其肯定是Programmer；便不会出现ClassCastException类型转换异常
//		if (("BUSY").equalsIgnoreCase(p.getStatus().getNAME())) {// 前面是一个确定的字符串，肯定不会出现空指针了 // if
//																	// (p.getStatus().getNAME().equals("BUSY"))前面有可能会是null，增加了空指针异常的风险
//			throw new TeamException("该员工已是某团队成员");
//		} else if (("VOCATION").equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("该员正在休假，无法添加");
//		}

        switch (p.getStatus()) {
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员正在休假，无法添加");
        }

//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员

        // 获取team中已有成员中架构师、设计师、程序员的人数
        int numOfArch = 0, numOfDef = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDef++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

        // 正确的
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDef >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        // 错误的 比如以及有了0位架构师、2位设计师，现在要添加以为架构师
//		if (p instanceof Architect && numOfArch >= 1) {   // 这里为false
//			throw new TeamException("团队中至多只能有一名架构师");
//		} else if (p instanceof Designer && numOfDef >= 2) { // 这里为true，故出现问题
//			throw new TeamException("团队中至多只能有两名设计师");
//		} else if (p instanceof Programmer && numOfPro >= 3) {
//			throw new TeamException("团队中至多只能有三名程序员");
//		}

        // 将p(或e)添加到现有的team中
        team[total++] = p;
        // p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * @Title: isExit
     * @Description:判断指定的员工是否存在于现有开发团队中
     * @param e
     * @return
     */
    private boolean isExit(Employee e) {
        for (int i = 0; i < total; i++) {
//			if (team[i].getId() == e.getId()) {
//				return true;// 找到了
//			}或
            return team[i].getId() == e.getId();

        }
        return false;
    }

    /**
     *
     * @Title: removeMember
     * @Description:从团队中删除成员
     * @param memberId:待删除成员的memberId
     * @throws TeamException：找不到指定memberId的员工，删除失败
     */
    public void removeMember(int memberId) throws TeamException { // memberId就不改了为0了

        int i = 0;
        for (; i < total; i++) {
            if (team[i].getId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        // 未找到指定Id的情况（也可用isFlag来进行判断）
        if (i == total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        // 后一元素覆盖前一个元素，实现删除操作
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        // 或
//		for (int j = i; j < total - 1; j++) {
//			team[j] = team[j + 1];
//		}

        team[--total] = null;

    }

}
