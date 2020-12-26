package lzf5207101105_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//定义一个员工类，有员工姓名与员工编号、员工所在部门。定义一个公司类，
//有公司名称与员工，此公司的所有员工数据保存在HashTable对象，
//要求员工编号一样就表示同一员工，此公司类中有多个方法可添加员工（可添加单个或多个员工），
//并可根据员工姓名或员工编号显示员工信息，根据员工姓名删除员工，也可显示所有员工信息，或根据部门显示员工信息。

public class lzf105_5 {

	public static void main(String[] args) {

		Company_ company_ = new Company_();

//		此公司类中有多个方法可添加员工（可添加单个或多个员工）

		List<Staff> staffs = Arrays.asList(new Staff("马润", "1001", "depart1"), new Staff("牛润", "1002", "depart2"),
				new Staff("羊润", "1003", "depart3"), new Staff("龙润", "1005", "depart3"));

		company_.add_manystaffs(staffs);
		company_.add_staff(new Staff("狗润", "1004", "depart4"));
		System.out.println("公司现有员工集合 " + company_.staffs);
//
		System.out.println("通过员工姓名查找员工 " + company_.find_byname("马润"));
		System.out.println("通过员工编号查找员工 " + company_.find_bystaffId("1003"));
		System.out.println("通过员工姓名删除员工 "+company_.delete_byname("马润"));
		System.out.println("删除后的公司员工集合  "+company_.staffs);
		System.out.println("通过员工部门删除员工 "+company_.delete_bydepart("depart3"));
		System.out.println("删除后的公司员工集合 " +company_.staffs);
	}
}

class Company_ {
	public String name;
	// 员工表
	public Hashtable<String, Staff> staffs;
	// 删除掉的员工表
	public Hashtable<String, Staff> drop_staffs;

	public Company_() {
		this.staffs = new Hashtable<>();
		this.drop_staffs = new Hashtable<>();
	};

//	此公司类中有多个方法可添加员工（可添加单个或多个员工）
	public void add_staff(Staff staff) {
		this.staffs.put(staff.getStaffId(), staff);
	};

	public void add_manystaffs(List<Staff> staffs) {

		staffs.stream().forEach(item -> {
			this.add_staff(item);
		});
	};

//	可添加单个或多个员工并可根据员工姓名或员工编号显示员工信息
	public Staff find_byname(String name) {
//	

		for (Map.Entry<String, Staff> item : this.staffs.entrySet()) {
			if (item.getValue().getName().equals(name)) {
				System.out.println(item.getKey());
				return this.staffs.get(item.getKey());
			}
			;
		}
		;

		return null;

	};

	public Staff find_bystaffId(String staffId) {
		if (this.staffs.get(staffId) != null) {
			return staffs.get(staffId);
		}
		return null;

	};

//	//根据员工姓名删除员工，也可显示所有员工信息，或根据部门显示员工信息
	public Staff delete_byname(String name) {
		for (Map.Entry<String, Staff> item : this.staffs.entrySet()) {
			if (item.getValue().getName().equals(name)) {
				Staff res=this.staffs.get(item.getKey());
				this.staffs.remove(item.getKey());
				return res;
						
			}
			;
		}
		;
		return null;

	}
//	//根据部门删除员工信息。
//
	public List<Staff> delete_bydepart(String depart) {
		List<String> drops_key=new ArrayList<String>();
		List<Staff> drops_value=new ArrayList<Staff>();
		for (Map.Entry<String, Staff> item : this.staffs.entrySet()) {
			if (item.getValue().getDepartment().equals(depart)) {
				drops_key.add(item.getKey());
				drops_value.add(item.getValue());
			}
			;
		}
		;
		
		drops_key.stream().forEach(item->{
			this.staffs.remove(item);
		});
		
		return drops_value;

	}
//	
	@Override
	public String toString() {
		return "Company [name=" + name + ", staffs=" + staffs + ", drop_staffs=" + drop_staffs + "]";
	};

};