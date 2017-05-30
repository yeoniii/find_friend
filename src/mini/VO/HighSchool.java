package mini.VO;

import java.io.Serializable;

public class HighSchool implements Serializable{
	private int schoolNo;
	private String schoolName;
	private String address;
	private String roadAddress;
	
	public HighSchool(){}
	public HighSchool(int schoolNo, String schoolName, String address, String roadAddress) {
		super();
		this.schoolNo = schoolNo;
		this.schoolName = schoolName;
		this.address = address;
		this.roadAddress = roadAddress;
	}

	public int getSchoolNo() {
		return schoolNo;
	}

	public void setSchoolNo(int schoolNo) {
		this.schoolNo = schoolNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((roadAddress == null) ? 0 : roadAddress.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + schoolNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighSchool other = (HighSchool) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (roadAddress == null) {
			if (other.roadAddress != null)
				return false;
		} else if (!roadAddress.equals(other.roadAddress))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (schoolNo != other.schoolNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HighSchool [schoolNo=" + schoolNo + ", schoolName=" + schoolName + ", address=" + address
				+ ", roadAddress=" + roadAddress + "]";
	}
	
	
}
