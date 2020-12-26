package lzf5207101105_19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//3 声明一个HashSet集合对象，
//然后向其添加任意5个字符串数据元素(包括重复数据)，
//也可删除其中一个元素，判断某个元素是否在该集合中，
//最后用两种迭代方式显示此集合的所有元素。.
public class lzf105_3 {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
//		然后向其添加任意5个字符串数据元素(包括重复数据)，		
		String names = "陈润,牛润,马润,羊润,鼠润,鼠润";
		for(String item:names.split(",")) {
			hashSet.add(item);
		};
		
		System.out.println("现有集合"+hashSet.toString());
//		也可删除其中一个元素
		hashSet.remove("马润");
		System.out.println("删除后的集合 "+hashSet.toString());
//		判断某个元素是否在该集合中，
		System.out.println("判断某个元素是否在该集合中 "+hashSet.contains("马润"));
//		两种迭代方式显示此集合的所有元素
		System.out.println("两种迭代方式显示此集合的所有元素");
		iterate_byIteration(hashSet);
		System.out.println();
		iterate_byStream(hashSet);
		System.out.println();
	}
	public static void iterate_byIteration(HashSet<String> hashSet) {
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		};

	}

	public static void iterate_byStream(HashSet<String> hashSet) {
		hashSet.stream().forEach(item->{
			System.out.print(item+" ");
		});

	}

}
