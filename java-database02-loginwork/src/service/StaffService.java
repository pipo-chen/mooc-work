package service;

import entity.Staff;

/**
 * 员工管理 Service
 */
public interface StaffService {

	Staff getStaffInfoService(String username, String password);
}
