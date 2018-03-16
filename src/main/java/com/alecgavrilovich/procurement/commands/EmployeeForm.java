package com.alecgavrilovich.procurement.commands;


public class EmployeeForm {
		
		private Integer id;
		private Long uprn;
		private String position;
		private int department_id;
		private String first_name;
		private String last_name;
		private int salary;
		private int status = 0;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Long getUprn() {
			return uprn;
		}
		public void setUprn(Long uprn) {
			this.uprn = uprn;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public int getDepartment_id() {
			return department_id;
		}
		public void setDepartment_id(int department_id) {
			this.department_id = department_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		
		
}
