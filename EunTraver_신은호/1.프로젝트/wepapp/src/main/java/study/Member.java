package study;

import java.sql.Date;

public class Member {
   private int no;
   private String name;
   private String email;
   private String password;
   private Date createdDate; // 생성일
   private Date modifiedDate; // 마지막 수정일
   
   public int getNo() {
      return no;
   }
   public Member setNo(int no) {
      this.no = no;
      return this;
   }
   public String getName() {
      return name;
   }
   public Member setName(String name) {
      this.name = name;
      return this;
   }
   public String getEmail() {
      return email;
   }
   public Member setEmail(String email) {
      this.email = email;
      return this;
   }
   public String getPassword() {
      return password;
   }
   public Member setPassword(String password) {
      this.password = password;
      return this;
   }
   public Date getCreatedDate() {
      return createdDate;
   }
   public Member setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
      return this;
   }
   public Date getModifiedDate() {
      return modifiedDate;
   }
   public Member setModifiedDate(Date modifiedDate) {
      this.modifiedDate = modifiedDate;
      return this;
   }
}