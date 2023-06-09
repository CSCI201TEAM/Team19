/*
Coded by Ken Xu
04/06/2023 :: UPDATED 04/07/2023
*/
package usc_mealmatch;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class DietPreferenceList {
	@SerializedName("DietPreference")
	private ArrayList<String> DietPreference;
	private Integer userID;

	public int getSize() {
		return DietPreference.size();
	}

	public void addDiet(String diet) {
		DietPreference.add(diet);
	}

	public String getDiet(int index) {
		return DietPreference.get(index);
	}

	public ArrayList<String> getDietList() {
		return DietPreference;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
