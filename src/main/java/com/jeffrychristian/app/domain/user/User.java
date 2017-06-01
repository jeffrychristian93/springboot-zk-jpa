package com.jeffrychristian.app.domain.user;

import com.jeffrychristian.app.common.types.GenderType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jeffry.christian on 11/9/2016.
 */

@Entity
@Table(name = "mst_user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(name="USER_SEQ", sequenceName="USER_SEQ", allocationSize=1)
	@Column(name = "id")												private Long        id;
	@Column(name = "firstname") 										private String      firstName;
	@Column(name = "lastname") 											private String      lastName;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender") 											private GenderType gender;
	@Column(name = "mobilephone") 										private String      mobilePhone;
	@Column(name = "bio") 												private String      bio;
//	@Column(name = "imagename") 										private String      imageName;
	@Column(name = "username", unique = true) 							private String      userName;
	@Column(name = "password")											private String      password;
	@Column(name = "email", unique = true)								private String      email;
	@Column(name = "enabled") 											private int         enabled;
	@Column(name = "active") 											private boolean     active; // Active or Inactive
	@Column(name = "banned") 											private boolean     banned;
	@Column(name = "special") 											private boolean     special;
	@Column(name = "token") 											private String      token;
	@Column(name = "createdtime") 										private Date        createdTime;
	@Column(name = "updatedtime") 										private Date        updatedTime;
	@Column(name = "remoteaddress") 									private String 		remoteAddress;
	@Column(name = "remotehost") 										private String 		remoteHost;
	@Column(name = "session") 											private String 		session;
	@Column(name = "logindate") 										private Date 		loginDate;
	@Column(name = "logoutdate") 										private Date 		logoutDate;
	@Column(name = "lastlogindate") 									private Date 		lastLoginDate;
	@Column(name = "lastloginfailed") 									private Date 		lastLoginFailed;
	@Column(name = "locked", nullable = false) 							private boolean 	locked;
	@Column(name = "loginattempt") 										private int 		loginAttempt;
	@Column(name = "uuid", nullable = false, unique = true)        		private String  	uuid; //android ID

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userId", cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "roleid", referencedColumnName = "id")
	private UserRole userRole;

	public User(){}

	public User(User user) {
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.gender = user.gender;
		this.mobilePhone = user.mobilePhone;
		this.bio = user.bio;
//		this.imageName = user.imageName;
		this.userName = user.userName;
		this.password = user.password;
		this.email = user.email;
		this.enabled = user.enabled;
		this.active = user.active;
		this.banned = user.banned;
		this.special = user.special;
		this.token = user.token;
		this.createdTime = user.createdTime;
		this.updatedTime = user.updatedTime;
		this.remoteAddress = user.remoteAddress;
		this.remoteHost = user.remoteHost;
		this.session = user.session;
		this.loginDate = user.loginDate;
		this.logoutDate = user.logoutDate;
		this.lastLoginDate = user.lastLoginDate;
		this.lastLoginFailed = user.lastLoginFailed;
		this.locked = user.locked;
		this.loginAttempt = user.loginAttempt;
		this.userRole = user.userRole;
		this.uuid = user.uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLoginFailed() {
		return lastLoginFailed;
	}

	public void setLastLoginFailed(Date lastLoginFailed) {
		this.lastLoginFailed = lastLoginFailed;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}