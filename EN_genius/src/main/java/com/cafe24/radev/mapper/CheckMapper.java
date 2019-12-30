package com.cafe24.radev.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.AskCheck;
import com.cafe24.radev.vo.BasicCheck;
import com.cafe24.radev.vo.RoutineCheck;

@Mapper
public interface CheckMapper {

	public List<RoutineCheck> getRoutineCheckList();
	public List<AskCheck> getAskCheck(String car);
	public String getDate(String repairDate);
	public List<BasicCheck> getBigCheckList(String bigCate);
	public List<BasicCheck> getMidCheckList(String midCate);
	public BasicCheck getSmallCheckList(String smallCate);
}
