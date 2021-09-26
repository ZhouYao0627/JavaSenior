package com.atguigu.p2.ui;

/**
 * @author��ZhouYao
 * @create��2021-09-22 21:37
 */

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

/**
 * Title: CustomerView
 * Description:
 *
 * @author zhouyao
 * @date 2021��4��8��
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    // ��ʼ����һ���ͻ�
//	public CustomerView() {
//		Customer customer = new Customer("����", '��', 30, "1151511215", "abs@163.com");
//		customerList.addCustomer(customer);
//	}

    /**
     * ��ʾ���ͻ���Ϣ�������������ķ���
     * Title: enterMainMenu
     * Description:
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n-----------------�ͻ���Ϣ�������-----------------\n");
            System.out.println("                   1 �� �� �� ��");
            System.out.println("                   2 �� �� �� ��");
            System.out.println("                   3 ɾ �� �� ��");
            System.out.println("                   4 �� �� �� ��");
            System.out.println("                   5 ��       ��\n");
            System.out.print("                   ��ѡ��(1-5)��");

            char menu = CMUtility.readMenuSelection();

            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
//				System.out.println("�˳�");
                    System.out.println("�Ƿ�ȷ���˳�(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    // break;
            }

        }
    }

    /**
     * ���ӿͻ��Ĳ���
     * Title: addNewCustomer
     * Description:
     */
    private void addNewCustomer() {
//		System.out.println("���ӿͻ��Ĳ���");
        System.out.println("---------------------��ӿͻ�---------------------");
        System.out.print("������");
        String name = CMUtility.readString(10);
        System.out.print("�Ա�");
        char gender = CMUtility.readChar();
        System.out.print("����");
        int age = CMUtility.readInt();
        System.out.print("�绰");
        String phone = CMUtility.readString(13);
        System.out.print("����");
        String email = CMUtility.readString(30);

        // ���������ݷ�װ��������
        Customer customer = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("---------------------������---------------------");
        } else {
            System.out.println("----------------�ͻ�Ŀ¼����,�޷����-----------------");
        }

    }

    /**
     * �޸Ŀͻ��Ĳ���
     * Title: modifyCustomer
     * Description:
     */
    private void modifyCustomer() {
//		System.out.println("�޸Ŀͻ��Ĳ���");

        System.out.println("---------------------�޸Ŀͻ�---------------------");
        Customer cust;
        int number;
        for (;;) { // ��֪����ȷִ�ж��ٴ�
            System.out.print("��ѡ����޸Ŀͻ����(-1�˳�)��");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            } else {
                cust = customerList.getCustomer(number - 1);
                if (cust == null) {
                    System.out.println("�޷��ҵ�ָ���ͻ�");
                } else { // �ҵ�����Ӧ��ŵĿͻ�
                    break;
                }
            }
        }
        // �޸Ŀͻ���Ϣ
        System.out.println("����(" + cust.getName() + "):");
        String name = CMUtility.readString(10, cust.getName());

        System.out.println("�Ա�(" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());

        System.out.println("����(" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());

        System.out.println("�绰(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(13, cust.getPhone());

        System.out.println("����(" + cust.getEmail() + "):");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
        if (isReplaced) {
            System.out.println("---------------------�޸����---------------------");
        } else {
            System.out.println("----------�޷��ҵ�ָ���ͻ�,�޸�ʧ��--------------");
        }

    }

    /**
     * ɾ���ͻ��Ĳ���
     * Title: modifyCustomer
     * Description:
     */
    private void deleteCustomer() {
//		System.out.println("ɾ���ͻ��Ĳ���");
        System.out.println("---------------------ɾ���ͻ�---------------------");
        int number = 0;
        Customer customer;
        for (;;) {
            System.out.println("ѡ���ɾ���ͻ��ı��(-1�˳�)");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }

            customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("�޷��ҵ�ָ���ͻ�");
            } else
                break;
        }
        // �ҵ���ָ���ͻ�
        System.out.println("ȷ���Ƿ�ɾ��(Y/N)");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean deleteSuccess = customerList.deleteCustomer(number - 1);
            if (deleteSuccess) {
                System.out.println("---------------------ɾ�����---------------------");
            } else {
                System.out.println("----------�޷��ҵ�ָ���ͻ�,ɾ��ʧ��--------------");
            }
        } else {
            return;
        }

    }

    /**
     * ��ʾ�ͻ��б�Ĳ���
     * Title: modifyCustomer
     * Description:
     */
    private void listAllCustomer() {
//		System.out.println("��ʾ�ͻ��б�Ĳ���");
        System.out.println("---------------------------�ͻ��б�---------------------------");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("û�пͻ���¼");
        } else {
            System.out.println("���\t����\t�Ա�\t����\t\t�绰\t\t����");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
                        + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }
        System.out.println("-------------------------�ͻ��б����-------------------------");
    }

    public static void main(String[] args) {

        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }

}

