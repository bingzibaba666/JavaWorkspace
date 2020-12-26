package lzf5207101105_19;

import java.util.Comparator;
import java.util.TreeSet;

//声明一个TreeSet集合对象，
//然后向其添加任意5个人类对象的数据元素(人类包括姓名与年龄，并按年龄大小排序)，
//也可删除其中一个元素，最后显示此集合的所有元素.
public class lzf105_4 {
	public static void main(String[] args) {
		String[] names = "陈润,牛润,马润,羊润,鼠润".split(",");
		String[] ages = "20,25,23,18,30".split(",");

		TreeSet<People> treeSet = new TreeSet<>();
		
		for (int i = 0; i < names.length; i++) {
			People people = new People(names[i], Integer.parseInt(ages[i]));
			treeSet.add(people);
		}
//		显示此集合的所有元素.
		treeSet.stream().forEach(item->{
			System.out.println(item.toString()+" ");
		});

	}

}

class People implements Comparable {
	public String name;
	public int age;

	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 需要继承使用比较器,然后不再报错 https://blog.csdn.net/xfy2015/article/details/84442302
//	
	
	@Override
	public int compareTo(Object object) {
		// TODO Auto-generated method stub
		return (((People) object).getAge() - this.age);
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}

	


};
//接口比较器
class AgeComparator implements Comparator {
	@Override
	public int compare(Object object1, Object object2) {// 实现接口中的方法
		People p1 = (People) object1; // 强制转换
		People p2 = (People) object2;
		return new Double(p1.getAge()).compareTo(new Double(p2.getAge())) * (-1); // 降序
	}

	
}