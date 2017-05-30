package mini.VO;

import java.io.Serializable;

public class Member implements Serializable{
	private String memberId;
	private String memberPassword;
	private String memberName;
	private int graduateYear;
	private String memberEmail;
	private char memberGender;
	private int schoolNo;
	private HighSchool highSchool;
	
	public Member(){}

	public Member(String memberId, String memberPassword, String memberName, int graduateYear, String memberEmail,
			char memberGender, int schoolNo) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.graduateYear = graduateYear;
		this.memberEmail = memberEmail;
		this.memberGender = memberGender;
		this.schoolNo = schoolNo;
	}

	public Member(String memberId, String memberPassword, String memberName, int graduateYear, String memberEmail,
			char memberGender, int schoolNo, HighSchool highSchool) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.graduateYear = graduateYear;
		this.memberEmail = memberEmail;
		this.memberGender = memberGender;
		this.schoolNo = schoolNo;
		this.highSchool = highSchool;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getGraduateYear() {
		return graduateYear;
	}

	public void setGraduateYear(int graduateYear) {
		this.graduateYear = graduateYear;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public char getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}

	public int getSchoolNo() {
		return schoolNo;
	}

	public void setSchoolNo(int schoolNo) {
		this.schoolNo = schoolNo;
	}

	public HighSchool getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(HighSchool highSchool) {
		this.highSchool = highSchool;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + graduateYear;
		result = prime * result + ((highSchool == null) ? 0 : highSchool.hashCode());
		result = prime * result + ((memberEmail == null) ? 0 : memberEmail.hashCode());
		result = prime * result + memberGender;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPassword == null) ? 0 : memberPassword.hashCode());
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
		Member other = (Member) obj;
		if (graduateYear != other.graduateYear)
			return false;
		if (highSchool == null) {
			if (other.highSchool != null)
				return false;
		} else if (!highSchool.equals(other.highSchool))
			return false;
		if (memberEmail == null) {
			if (other.memberEmail != null)
				return false;
		} else if (!memberEmail.equals(other.memberEmail))
			return false;
		if (memberGender != other.memberGender)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberPassword == null) {
			if (other.memberPassword != null)
				return false;
		} else if (!memberPassword.equals(other.memberPassword))
			return false;
		if (schoolNo != other.schoolNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", graduateYear=" + graduateYear + ", memberEmail=" + memberEmail + ", memberGender=" + memberGender
				+ ", schoolNo=" + schoolNo + ", highSchool=" + highSchool + "]";
	}

}