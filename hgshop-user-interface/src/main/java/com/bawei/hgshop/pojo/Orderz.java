package com.bawei.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author 45466
 *
 */
public class Orderz  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3644177378773320587L;
	
	private Integer oid   ;
	private int uid                 ;
	private BigDecimal sumtotal            ;
	private String address             ;
	private int createTime         ;
	
	
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public BigDecimal getSumtotal() {
		return sumtotal;
	}
	public void setSumtotal(BigDecimal sumtotal) {
		this.sumtotal = sumtotal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Orderz [oid=" + oid + ", uid=" + uid + ", sumtotal=" + sumtotal + ", address=" + address
				+ ", createTime=" + createTime + "]";
	}
	
	 
	
	
   

}
