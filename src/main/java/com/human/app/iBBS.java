package com.human.app;

import java.util.ArrayList;

public interface iBBS {
	void writerbbs(String sTitle, String sContent, String sWriter, String sPasscode);

	ArrayList<BBSrec> getList();
	
	BBSrec getPost(int bbs_id);
	
	void deleteBBS(int bbs_id);

	void updateBBS(int bbs_id, String title, String content);
	
	void addMemeber(String name, String userid, String password);
}
