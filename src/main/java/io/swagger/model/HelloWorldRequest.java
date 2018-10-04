package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * HelloWordRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-09-07T07:48:13.195Z")

public class HelloWorldRequest {

	@NotNull
	@NotEmpty
	@NotBlank
	@JsonProperty("myName")
	private String myName = null;

	@NotNull
	@NotEmpty
	@JsonProperty("friends")
	private List<String> friends = null;

	public HelloWorldRequest myName(String myName) {
		this.myName = myName;
		return this;
	}

	/**
	 * Get myName
	 * 
	 * @return myName
	 **/
	@ApiModelProperty(value = "")

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public HelloWorldRequest friends(List<String> friends) {
		this.friends = friends;
		return this;
	}

	public HelloWorldRequest addFriendsItem(String friendsItem) {
		if (this.friends == null) {
			this.friends = new ArrayList<String>();
		}
		this.friends.add(friendsItem);
		return this;
	}

	/**
	 * Get friends
	 * 
	 * @return friends
	 **/
	@ApiModelProperty(value = "")

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HelloWorldRequest helloWordRequest = (HelloWorldRequest) o;
		return Objects.equals(this.myName, helloWordRequest.myName)
				&& Objects.equals(this.friends, helloWordRequest.friends);
	}

	@Override
	public int hashCode() {
		return Objects.hash(myName, friends);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HelloWordRequest {\n");

		sb.append("    myName: ").append(toIndentedString(myName)).append("\n");
		sb.append("    friends: ").append(toIndentedString(friends)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
