package service.imp;

import dao.StaffDao;
import entity.Staff;
import service.StaffService;

public class StaffServiceImp implements StaffService {

	@Override
	public Staff findStaffByInfo(String username, String password) {
		StaffDao staffDao = new StaffDao();
		return staffDao.queryStaffByInfo(username, password);
	}

	@Override
	public boolean changeStaffPassword(String pw, int staff_id) {

		StaffDao staffDao = new StaffDao();
		return staffDao.changStaffPassword(pw, staff_id);
	}
}
