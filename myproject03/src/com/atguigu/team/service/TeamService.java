/**
 * <p>Title: TeamService.java</p>
 * <p>Description: </p>
 *
 * @author zhouyao
 * @date 2021��6��30��
 * @version 1.0
 */
package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

public class TeamService {

    private static int counter = 1; // ��memberId��ֵʹ��
    private final int MAX_MEMBER = 5; // ���ƿ����Ŷӵ�����
    private Programmer[] team = new Programmer[MAX_MEMBER]; // ���濪���Ŷӳ�Ա
    private int total; // ��¼�����Ŷ���ʵ������

    /**
     *
     * @Title: getTeam
     * @Description:��ȡ�����Ŷ��е����г�Ա
     * @return:�������г�Ա��������飬�����С���Ա����һ��
     */
    public Programmer[] getTeam() { // ����δ��
        Programmer[] team = new Programmer[total];// ��������Ҳд��team�����Ƿ��ܷ���
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     *
     * @Title: addMember
     * @Description:��ָ����Ա����ӵ������Ŷ���
     * @param e:����ӳ�Ա�Ķ���
     * @throws TeamException:���ʧ�ܣ� TeamException�а�����ʧ��ԭ��
     */
    public void addMember(Employee e) throws TeamException {
//		��Ա�������޷����
        if (total >= team.length) {
            throw new TeamException("��Ա�������޷����");
        }

//		�ó�Ա���ǿ�����Ա���޷����
        if (!(e instanceof Programmer)) {
            throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
        }

//		��Ա�����ڱ������Ŷ���
        if (isExit(e)) {
            throw new TeamException("��Ա�����ڱ������Ŷ���");
        }

//		��Ա������ĳ�Ŷӳ�Ա (�ڱ��Ŷӿ�����team���Ƚϣ����������Ŷ�����״̬�����ǣ���Status)
//		��Ա�����ݼ٣��޷����
        Programmer p = (Programmer) e;// �ߵ���һ������϶���Programmer���㲻�����ClassCastException����ת���쳣
//		if (("BUSY").equalsIgnoreCase(p.getStatus().getNAME())) {// ǰ����һ��ȷ�����ַ������϶�������ֿ�ָ���� // if
//																	// (p.getStatus().getNAME().equals("BUSY"))ǰ���п��ܻ���null�������˿�ָ���쳣�ķ���
//			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
//		} else if (("VOCATION").equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("��Ա�����ݼ٣��޷����");
//		}

        switch (p.getStatus()) {
            case BUSY:
                throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
            case VOCATION:
                throw new TeamException("��Ա�����ݼ٣��޷����");
        }

//		�Ŷ�������ֻ����һ���ܹ�ʦ
//		�Ŷ�������ֻ�����������ʦ
//		�Ŷ�������ֻ������������Ա

        // ��ȡteam�����г�Ա�мܹ�ʦ�����ʦ������Ա������
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

        // ��ȷ��
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
            }
        } else if (p instanceof Designer) {
            if (numOfDef >= 2) {
                throw new TeamException("�Ŷ�������ֻ�����������ʦ");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("�Ŷ�������ֻ������������Ա");
            }
        }

        // ����� �����Լ�����0λ�ܹ�ʦ��2λ���ʦ������Ҫ�����Ϊ�ܹ�ʦ
//		if (p instanceof Architect && numOfArch >= 1) {   // ����Ϊfalse
//			throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
//		} else if (p instanceof Designer && numOfDef >= 2) { // ����Ϊtrue���ʳ�������
//			throw new TeamException("�Ŷ�������ֻ�����������ʦ");
//		} else if (p instanceof Programmer && numOfPro >= 3) {
//			throw new TeamException("�Ŷ�������ֻ������������Ա");
//		}

        // ��p(��e)��ӵ����е�team��
        team[total++] = p;
        // p�����Ը�ֵ
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * @Title: isExit
     * @Description:�ж�ָ����Ա���Ƿ���������п����Ŷ���
     * @param e
     * @return
     */
    private boolean isExit(Employee e) {
        for (int i = 0; i < total; i++) {
//			if (team[i].getId() == e.getId()) {
//				return true;// �ҵ���
//			}��
            return team[i].getId() == e.getId();

        }
        return false;
    }

    /**
     *
     * @Title: removeMember
     * @Description:���Ŷ���ɾ����Ա
     * @param memberId:��ɾ����Ա��memberId
     * @throws TeamException���Ҳ���ָ��memberId��Ա����ɾ��ʧ��
     */
    public void removeMember(int memberId) throws TeamException { // memberId�Ͳ�����Ϊ0��

        int i = 0;
        for (; i < total; i++) {
            if (team[i].getId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        // δ�ҵ�ָ��Id�������Ҳ����isFlag�������жϣ�
        if (i == total) {
            throw new TeamException("�Ҳ���ָ��memberId��Ա����ɾ��ʧ��");
        }

        // ��һԪ�ظ���ǰһ��Ԫ�أ�ʵ��ɾ������
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        // ��
//		for (int j = i; j < total - 1; j++) {
//			team[j] = team[j + 1];
//		}

        team[--total] = null;

    }

}
