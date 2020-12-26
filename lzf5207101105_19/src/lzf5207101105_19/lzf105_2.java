package lzf5207101105_19;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//2 定义一个员工类，有员工姓名与员工编号、员工所在部门。
//定义一个公司类，有公司名称与员工，此公司的所有员工数据保存在LinkedList对象，
//此公司类中有多个方法可添加员工（可添加单个或多个员工），并可根据员工姓名或员工编号显示员工信息，
//根据员工姓名删除员工，也可显示所有员工信息，或根据部门显示员工信息。
public class lzf105_2 {
	public static void main(String[] args) {
		Company company = new Company();

//		此公司类中有多个方法可添加员工（可添加单个或多个员工）

		List<Staff> staffs = Arrays.asList(new Staff("马润", "1001", "depart1"),
				new Staff("牛润", "1002", "depart2"),
				new Staff("羊润", "1003", "depart3"),
				new Staff("龙润", "1005", "depart3"));

		company.add_manystaffs(staffs);
		company.add_staff(new Staff("狗润", "1004", "depart4"));
		System.out.println("公司现有员工集合 "+company.staffs);

		System.out.println("通过员工姓名查找员工 "+company.find_byname("马润"));
		System.out.println("通过员工编号查找员工 "+company.find_bystaffId("1002"));
		System.out.println("通过员工姓名删除员工 "+company.delete_byname("马润"));
		System.out.println("删除后的公司员工集合  "+company.staffs);
		System.out.println("通过员工部门删除员工 "+company.delete_bydepart("depart3"));
		System.out.println("删除后的公司员工集合 " +company.staffs);
//		System.out.println(company.toString());
	}

}

 class Staff {
	public String name;
	public String staffId;
	public String department;

	public Staff(String name, String staffId, String department) {
		super();
		this.name = name;
		this.staffId = staffId;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", staffId=" + staffId + ", department=" + department + "]";
	}

};

class Company {
	public String name;
	//员工表
	public LinkedList<Staff> staffs;
	//删除掉的员工表
	public  LinkedList<Staff> drop_staffs;
	
	public Company() {
		this.staffs = new LinkedList<>();
		this.drop_staffs = new LinkedList<>();
	};

//	此公司类中有多个方法可添加员工（可添加单个或多个员工）
	public void add_staff(Staff staff) {
		this.staffs.add(staff);
	};

	public void add_manystaffs(List<Staff> staffs) {

		staffs.stream().forEach(item -> {
			this.add_staff(item);
		});
	};

//	可添加单个或多个员工并可根据员工姓名或员工编号显示员工信息
	public Staff find_byname(String name) {
		List<Staff> staffs = this.staffs.stream().filter(item -> item.name.equals(name))
				.collect(Collectors.toList());
		if (staffs.isEmpty()) {
			System.err.println("cause by 没有 department 为 "+name+"的员工");
			return null;
		}
			return staffs.get(0);
	
	

	};
	public Staff find_bystaffId(String staffId) {
		List<Staff> staffs = this.staffs.stream().filter(item -> item.staffId.equals(staffId))
				.collect(Collectors.toList());
		if (staffs.isEmpty()) {
			System.err.println("cause by 没有 department 为 "+staffId+"的员工");
			return null;
		}
			return staffs.get(0);
	

	
	};
	public Staff find_bydepart(String department) {
		List<Staff> staffs = this.staffs.stream().filter(item -> item.department.equals(department))
				.collect(Collectors.toList());
		if (staffs.isEmpty()) {
			System.err.println("cause by 没有 department 为 "+department+"的员工");
			return null;
		}
			return staffs.get(0);
	

	
	};
	//根据员工姓名删除员工，也可显示所有员工信息，或根据部门显示员工信息
	public Staff delete_byname(String name) {
		Staff staff = this.find_byname(name);
		
		List<Staff> staffs = this.staffs.stream().filter(item -> !item.name.equals(name))
				.collect(Collectors.toList());
		this.drop_staffs.add(staff);
		this.staffs=new LinkedList<>(staffs);
		return staff;

	}
	//根据部门删除员工信息。

	public List<Staff> delete_bydepart(String depart) {
		
		
		List<Staff> save_staff = this.staffs.stream().filter(item -> !item.department.equals(depart))
				.collect(Collectors.toList());
		List<Staff> drop_staffs = this.staffs.stream().filter(item -> item.department.equals(depart))
				.collect(Collectors.toList());
		this.drop_staffs.addAll(drop_staffs);
		this.staffs=new LinkedList<>(save_staff);
		return drop_staffs;

	}
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", staffs=" + staffs + ", drop_staffs=" + drop_staffs + "]";
	};
	
};