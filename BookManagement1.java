package B1Project;
//王氏集团出品("*************欢迎使用王氏集团红包计算系统*************")
//图书馆里系统

import java.util.Scanner;

public class BookManagement1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//数据初始化，最多六本图书
		//图书：图书借阅名称，图书借阅状态，图书借阅日期，图书借阅次数
		String[] names = new String[6];//名称
		int[] states = new int[6];     //状态	0可借阅	1已借出
		int[] dates = new int[6];      //日期
		int[] counts = new int[6];     //次数
		
		names[0] = "白雪公主";//图书名称：白雪公主
		dates[0] = 5;      //借出日期：5号
		states[0] = 1;     //1已借出
		counts[0] = 10;    //借出10次
		
		names[1] = "葫芦兄弟";//图书名称：葫芦兄弟
		dates[1] = 0;      //借出日期：
		states[1] = 0;     //0可借阅
		counts[1] = 16;    //借出16次
		
		names[2] = "舒克贝塔";//图书名称：白雪公主
		dates[2] = 0;      //借出日期：
		states[2] = 0;     //0可借阅
		counts[2] = 78;    //借出78次
		
		//用户是否退出系统		ture:不退出	false:退出系统
		boolean flag = true;
		//用户输入0返回主菜单
		int num = 0;
		//图书管理相关操作：查看图书	新增图书	借阅图书	归还图书	删除图书	退出系统
		//用户操作选择菜单
		do{
			System.out.println("*************欢迎使用王氏集团图书管理系统*************");
			System.out.println("1.查看图书");
			System.out.println("2.新增图书");
			System.out.println("3.借阅图书");
			System.out.println("4.归还图书");
			System.out.println("5.删除图书");
			System.out.println("6.退出系统");
			System.out.print("请选择您的操作：");
			int choose = input.nextInt();
			switch(choose){
				case 1:
					//查看图书
					System.out.println("\n图书信息列表--->");
					System.out.println("图书序号\t图书名称\t图书状态\t借阅日期\t借阅次数");
					//循环遍历所有图书信息并输出
					for(int i = 0;i < names.length;i++){
						if(names[i]!=null){
							String state = (states[i]==0)?"可借阅":"已借出";
							String date = (dates[i]==0)?"":dates[i]+"日";
							String count = counts[i]+"次";
							
							System.out.println((i+1)+"   \t"+names[i]+"\t"+state+"\t"+date+"\t"+count);
						}else{
							//遇到第一个为null的图书名称，意味着后边图书名称也为null，不必再循环了
							break;
						}
					}
					break;
				case 2:
					//新增图书
					System.out.println("新增图书--->");
					System.out.print("请输入新增图书名称：");
					String name = input.next();
					//是否能新增图书，如果满了（6），则无法添加false,能添加true
					boolean flagAdd = false;
					for(int i = 0;i < names.length;i++){
						if(names[i]==null){
							flagAdd = true;
							names[i] = name;
							System.out.println("图书《"+name+"》添加成功");
							break;
						}
					}
					if(!flagAdd){
						System.out.println("对不起，货架已满，无法添加图书！");
					}
					break;
				case 3: 
					//借阅图书
					System.out.println("\n借阅图书--->");
					System.out.print("请输入借阅图书的名称：");
					String want = input.next();
					
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							//没有找到您要借阅的书
							System.out.println("没有找到您要的书!");
							break;
						}else if(names[i].equals(want)&&states[i]==0){
							//找到了您要借阅的书，书的状态是可借阅的，可以借
							System.out.print("请输入借阅日期：");
							dates[i] = input.nextInt();
							while(dates[i]<1||dates[i]>31){
								System.out.print("数字格式不正确，请输入1~31之间的数字：");
								dates[i] = input.nextInt();
							}
							System.out.print("借出《"+names[i]+"》成功");
							states[i] = 1; //将书的状态改为已借阅
							counts[i]++;  //将书的借阅次数累加
							break;
							
						}else if(names[i].equals(want)&&states[i]==1){
							//找到了您要借阅的书，书的状态是已借阅的，不可以借
							System.out.println("该书已经借出去了！");
							break;
						}
					}
					
					break;
				case 4:
					//归还图书
					System.out.println("归还图书--->");
					System.out.print("请输入归还图书的名称：");
					String returnBook = input.next();
					
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							//没有找到您要归还的书
							System.out.println("对不起，没有找到您要归还的书！");
							break;
						}else if(names[i].equals(returnBook)&&states[i]==1){
							//找到书了，显示已借阅，可以归还
							System.out.print("请输入归还日期：");
							int date = input.nextInt();
							while(date<1||date>31||date<dates[i]){
								if(date<1||date>31){
									System.out.print("数字格式不正确，请输入1~31之间的数字：");
									date = input.nextInt();
								}else if(date<dates[i]){
									System.out.print("归还日期不能小于借阅日期，请您重新输入：");
									date = input.nextInt();
								}
							}
							System.out.println("归还《"+returnBook+"》成功");
							//计算租金
							int rent = (date-dates[i])*2;//date:归还日期   dates[i]:借阅日期
							System.out.println("应付金额为："+rent+"元");
							//将书状态改为可借阅
							states[i] = 0;  
							//重新设置借阅日期
							dates[i] = 0;
							break;
						}else if(names[i].equals(returnBook)&&states[i]==0){
							//找到书了，显示可借阅，无法归还 
							System.out.println("该书尚未借阅，归还不用！");
							break;
						}
					}
					
					break;
				case 5:
					//删除图书
					System.out.println("删除图书--->");
					System.out.print("请输入删除图书的名称：");
					String deleteBook = input.next();
					
					//删除图书的位置
					int index = -1;
					for(int i = 0;i<names.length;i++){
						if(names[i]==null){
							//没找到你要删除的图书
							System.out.println("没有找到您要删除的图书，无法删除！");
							break;
						}else if(names[i].equals(deleteBook)&&states[i]==1){
							//找到了您要删除的书，但是书已经借出去了
							System.out.println("该书已经借出去了，无法删除！");
							break;
						}else if(names[i].equals(deleteBook)&&states[i]==0){
							//找到了您要删除的书，但是书没有借出去
							//记录一下该书的位置
							index = i;
							break;
						}
					}
					//index可能依然是-1，也可能是一个正常的位置
					//根据图书的位置进行删除，后续位置依次往前覆盖，最后一个图书制空
					if(index!=-1){
						//从index-数组的最后一本书，依次往前覆盖
						for(int i = index;i<names.length;i++){
							if(i!=names.length-1){
								names[i] = names[i+1];   //名称
								counts[i] = counts[i+1]; //次数
								dates[i] = dates[i+1];   //日期
								states[i] = states[i+1]; //状态
							}
							//将最后一个元素置空
							names[names.length-1] = null;
							counts[names.length-1] = 0;
							dates[names.length-1] = 0;
							states[names.length-1] = 0;
						}
						System.out.println("删除《"+deleteBook+"》成功");
					}
					break;
				case 6:
					//退出系统,flag标识成false，跳出循环
					flag = false;
					break;
				default:
					//输入了一些错误的数字
					flag = false;
					break;
			}
			//如果flag==false，则结束循环，跳出系统
			if(!flag){
				//跳出系统
				break;
			}else{
				//用户不结束使用系统，代表用户想返回主菜单继续操作
				System.out.print("请输入0返回：");
				num = input.nextInt();
			}
			
		}while(num==0);
		System.out.println("谢谢，欢迎使用！");
		
		input.close();
	}
}

