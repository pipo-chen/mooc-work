package service;

import entity.Staff;

public interface StaffService {
	Staff findStaffByInfo(String username, String password);

	boolean changeStaffPassword(String pw, int staff_id);
}
