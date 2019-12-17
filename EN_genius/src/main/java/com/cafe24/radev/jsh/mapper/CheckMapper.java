package com.cafe24.radev.jsh.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.jsh.vo.AskCheck;
import com.cafe24.radev.jsh.vo.BasicCheck;
import com.cafe24.radev.jsh.vo.RoutineCheck;

@Mapper
public interface CheckMapper {

	public List<RoutineCheck> getRoutineCheckList();
	public List<AskCheck> getAskCheck(String car);
	public String getDate(String repairDate);
	public List<BasicCheck> getBasicCheckList(String bigCate);
}
