package B1Project;
//���ϼ��ų�Ʒ("*************��ӭʹ�����ϼ��ź������ϵͳ*************")
//ͼ�����ϵͳ

import java.util.Scanner;

public class BookManagement1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//���ݳ�ʼ�����������ͼ��
		//ͼ�飺ͼ��������ƣ�ͼ�����״̬��ͼ��������ڣ�ͼ����Ĵ���
		String[] names = new String[6];//����
		int[] states = new int[6];     //״̬	0�ɽ���	1�ѽ��
		int[] dates = new int[6];      //����
		int[] counts = new int[6];     //����
		
		names[0] = "��ѩ����";//ͼ�����ƣ���ѩ����
		dates[0] = 5;      //������ڣ�5��
		states[0] = 1;     //1�ѽ��
		counts[0] = 10;    //���10��
		
		names[1] = "��«�ֵ�";//ͼ�����ƣ���«�ֵ�
		dates[1] = 0;      //������ڣ�
		states[1] = 0;     //0�ɽ���
		counts[1] = 16;    //���16��
		
		names[2] = "��˱���";//ͼ�����ƣ���ѩ����
		dates[2] = 0;      //������ڣ�
		states[2] = 0;     //0�ɽ���
		counts[2] = 78;    //���78��
		
		//�û��Ƿ��˳�ϵͳ		ture:���˳�	false:�˳�ϵͳ
		boolean flag = true;
		//�û�����0�������˵�
		int num = 0;
		//ͼ�������ز������鿴ͼ��	����ͼ��	����ͼ��	�黹ͼ��	ɾ��ͼ��	�˳�ϵͳ
		//�û�����ѡ��˵�
		do{
			System.out.println("*************��ӭʹ�����ϼ���ͼ�����ϵͳ*************");
			System.out.println("1.�鿴ͼ��");
			System.out.println("2.����ͼ��");
			System.out.println("3.����ͼ��");
			System.out.println("4.�黹ͼ��");
			System.out.println("5.ɾ��ͼ��");
			System.out.println("6.�˳�ϵͳ");
			System.out.print("��ѡ�����Ĳ�����");
			int choose = input.nextInt();
			switch(choose){
				case 1:
					//�鿴ͼ��
					System.out.println("\nͼ����Ϣ�б�--->");
					System.out.println("ͼ�����\tͼ������\tͼ��״̬\t��������\t���Ĵ���");
					//ѭ����������ͼ����Ϣ�����
					for(int i = 0;i < names.length;i++){
						if(names[i]!=null){
							String state = (states[i]==0)?"�ɽ���":"�ѽ��";
							String date = (dates[i]==0)?"":dates[i]+"��";
							String count = counts[i]+"��";
							
							System.out.println((i+1)+"   \t"+names[i]+"\t"+state+"\t"+date+"\t"+count);
						}else{
							//������һ��Ϊnull��ͼ�����ƣ���ζ�ź��ͼ������ҲΪnull��������ѭ����
							break;
						}
					}
					break;
				case 2:
					//����ͼ��
					System.out.println("����ͼ��--->");
					System.out.print("����������ͼ�����ƣ�");
					String name = input.next();
					//�Ƿ�������ͼ�飬������ˣ�6�������޷����false,�����true
					boolean flagAdd = false;
					for(int i = 0;i < names.length;i++){
						if(names[i]==null){
							flagAdd = true;
							names[i] = name;
							System.out.println("ͼ�顶"+name+"����ӳɹ�");
							break;
						}
					}
					if(!flagAdd){
						System.out.println("�Բ��𣬻����������޷����ͼ�飡");
					}
					break;
				case 3: 
					//����ͼ��
					System.out.println("\n����ͼ��--->");
					System.out.print("���������ͼ������ƣ�");
					String want = input.next();
					
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							//û���ҵ���Ҫ���ĵ���
							System.out.println("û���ҵ���Ҫ����!");
							break;
						}else if(names[i].equals(want)&&states[i]==0){
							//�ҵ�����Ҫ���ĵ��飬���״̬�ǿɽ��ĵģ����Խ�
							System.out.print("������������ڣ�");
							dates[i] = input.nextInt();
							while(dates[i]<1||dates[i]>31){
								System.out.print("���ָ�ʽ����ȷ��������1~31֮������֣�");
								dates[i] = input.nextInt();
							}
							System.out.print("�����"+names[i]+"���ɹ�");
							states[i] = 1; //�����״̬��Ϊ�ѽ���
							counts[i]++;  //����Ľ��Ĵ����ۼ�
							break;
							
						}else if(names[i].equals(want)&&states[i]==1){
							//�ҵ�����Ҫ���ĵ��飬���״̬���ѽ��ĵģ������Խ�
							System.out.println("�����Ѿ����ȥ�ˣ�");
							break;
						}
					}
					
					break;
				case 4:
					//�黹ͼ��
					System.out.println("�黹ͼ��--->");
					System.out.print("������黹ͼ������ƣ�");
					String returnBook = input.next();
					
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							//û���ҵ���Ҫ�黹����
							System.out.println("�Բ���û���ҵ���Ҫ�黹���飡");
							break;
						}else if(names[i].equals(returnBook)&&states[i]==1){
							//�ҵ����ˣ���ʾ�ѽ��ģ����Թ黹
							System.out.print("������黹���ڣ�");
							int date = input.nextInt();
							while(date<1||date>31||date<dates[i]){
								if(date<1||date>31){
									System.out.print("���ָ�ʽ����ȷ��������1~31֮������֣�");
									date = input.nextInt();
								}else if(date<dates[i]){
									System.out.print("�黹���ڲ���С�ڽ������ڣ������������룺");
									date = input.nextInt();
								}
							}
							System.out.println("�黹��"+returnBook+"���ɹ�");
							//�������
							int rent = (date-dates[i])*2;//date:�黹����   dates[i]:��������
							System.out.println("Ӧ�����Ϊ��"+rent+"Ԫ");
							//����״̬��Ϊ�ɽ���
							states[i] = 0;  
							//�������ý�������
							dates[i] = 0;
							break;
						}else if(names[i].equals(returnBook)&&states[i]==0){
							//�ҵ����ˣ���ʾ�ɽ��ģ��޷��黹 
							System.out.println("������δ���ģ��黹���ã�");
							break;
						}
					}
					
					break;
				case 5:
					//ɾ��ͼ��
					System.out.println("ɾ��ͼ��--->");
					System.out.print("������ɾ��ͼ������ƣ�");
					String deleteBook = input.next();
					
					//ɾ��ͼ���λ��
					int index = -1;
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							//û�ҵ���Ҫɾ����ͼ��
							System.out.println("û���ҵ���Ҫɾ����ͼ�飬�޷�ɾ����");
							break;
						}else if(names[i].equals(deleteBook)&&states[i]==1){
							//�ҵ�����Ҫɾ�����飬�������Ѿ����ȥ��
							System.out.println("�����Ѿ����ȥ�ˣ��޷�ɾ����");
							break;
						}else if(names[i].equals(deleteBook)&&states[i]==0){
							//�ҵ�����Ҫɾ�����飬������û�н��ȥ
							//��¼һ�¸����λ��
							index = i;
							break;
						}
					}
					//index������Ȼ��-1��Ҳ������һ��������λ��
					//����ͼ���λ�ý���ɾ��������λ��������ǰ���ǣ����һ��ͼ���ƿ�
					if(index!=-1){
						//��index-��������һ���飬������ǰ����
						for(int i = index;i<names.length;i++){
							if(i!=names.length-1){
								names[i] = names[i+1];   //����
								counts[i] = counts[i+1]; //����
								dates[i] = dates[i+1];   //����
								states[i] = states[i+1]; //״̬
							}
							//�����һ��Ԫ���ÿ�
							names[names.length-1] = null;
							counts[names.length-1] = 0;
							dates[names.length-1] = 0;
							states[names.length-1] = 0;
						}
						System.out.println("ɾ����"+deleteBook+"���ɹ�");
					}
					break;
				case 6:
					//�˳�ϵͳ,flag��ʶ��false������ѭ��
					flag = false;
					break;
				default:
					//������һЩ���������
					flag = false;
					break;
			}
			//���flag==false�������ѭ��������ϵͳ
			if(!flag){
				//����ϵͳ
				break;
			}else{
				//�û�������ʹ��ϵͳ�������û��뷵�����˵���������
				System.out.print("������0���أ�");
				num = input.nextInt();
			}
			
		}while(num==0);
		System.out.println("лл����ӭʹ�ã�");
		
		input.close();
	}
}

