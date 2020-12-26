package lzf5207101105_19;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;

////1 定义一个ArrayList对象，存取字符串，然后向此对象添加5个元素，
//并从第三个位置再添加一个元素，删除第2个元素，按对象名称删除元素，判断某个
//对象是否在此集合中，列出第二个元素内容，添加一个元素在最前位置，  
//并用3种迭代方式显示此对象中的所有元素.
public class lzf105_1 {
	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<>();
//		添加5个元素
		String names = "陈润,牛润,马润,羊润,鼠润";
		for (String item : names.split(",")) {
			arrayList.add(item);
		}
		;
		System.out.println("添加5个元素== " + arrayList.toString());
		// 从第三个位置再添加一个元素
		arrayList.add(3, "蛇润");
		System.out.println("从第三个位置再添加一个元素== " + arrayList.toString());
		// 删除第2个元素
		arrayList.remove(2);
		System.out.println("删除第2个元素== " + arrayList.toString());
//		按对象名称删除元素
		arrayList.remove("陈润");
		System.out.println("按对象名称删除元素== " + arrayList.toString());
//		判断某个对象是否在此集合中

		boolean is_exists = arrayList.contains("牛润");
		System.out.println("判断某个对象是否在此集合中==  " + is_exists);
//		列出第二个元素内容
		System.out.println("列出第二个元素内容== " + arrayList.get(2));
//		添加一个元素在最前位置
		arrayList.add(0, "狗润");
		System.out.println("添加一个元素在最前位置== " + arrayList.toString());

//		并用3种迭代方式显示此对象中的所有元素.
		System.out.println("并用3种迭代方式显示此对象中的所有元素: ");
		iterate_byFor(arrayList);
		System.out.println();
		iterate_byIteration(arrayList);
		System.out.println();
		iterate_byStream(arrayList);
	}

	public static void iterate_byFor(ArrayList<String> arrayList) {
		for(String item:arrayList) {
			System.out.print(item+" ");
		};
	}

	public static void iterate_byIteration(ArrayList<String> arrayList) {
		Iterator<String> iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		};

	}

	public static void iterate_byStream(ArrayList<String> arrayList) {
		arrayList.stream().forEach(item->{
			System.out.print(item+" ");
		});

	}

}
