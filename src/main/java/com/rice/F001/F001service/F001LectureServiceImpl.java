package com.rice.F001.F001service;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rice.C001.boardvo.C001ClassBoardVO;
import com.rice.F001.F001dao.F001LectureDAO;
import com.rice.F001.F001vo.F001LectureVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class F001LectureServiceImpl implements F001LectureService {
	private static final Logger logger = LoggerFactory.getLogger(F001LectureServiceImpl.class);

	@Autowired
	private F001LectureDAO f001LectureDAO;
	

	@Override
	public Map<String, Object> selectSubId(F001LectureVO f001LectureVO) {
		//logger.info("ok");
		Map<String, Object> subId = f001LectureDAO.selectSubId(f001LectureVO);
		return subId;
	}


	@Override
	public List<Map<String, Object>> selectSubCode(F001LectureVO f001LectureVO) {
		//logger.info("ok");
		List<Map<String, Object>> subCode = f001LectureDAO.selectSubCode(f001LectureVO);
		return subCode;
	}

	//insert
	@Override
	public void lectureAdd(F001LectureVO f001LectureVO) {
		f001LectureDAO.lectureAdd(f001LectureVO);
		
	}

	//selectList
	@Override
	public List<Map<String, Object>> selectSubInfo() {
		List<Map<String, Object>> selectSubInfo = f001LectureDAO.selectSubInfo();
		return selectSubInfo;
	}


	@Override
	public List<Map<String, Object>> selectLecturePlanInfo(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> selectLecturePlanInfo = f001LectureDAO.selectLecturePlanInfo(f001LectureVO);
		return selectLecturePlanInfo;
	}


	@Override
	public String selectMemName(C001ClassBoardVO c001ClassBoardVO) {
		String selectMemName = f001LectureDAO.selectMemName(c001ClassBoardVO);
		return selectMemName;
	}


	@Override
	public List<Map<String, Object>> lecturePlanInfoND(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> lecturePlanInfoND = f001LectureDAO.lecturePlanInfoND(f001LectureVO);
		return lecturePlanInfoND;
	}


	@Override
	public List<Map<String, Object>> selectLecPlanId(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> selectLecPlanId = f001LectureDAO.selectLecPlanId(f001LectureVO);
		return selectLecPlanId;
	}


	@Override
	public String reGetTeaName(C001ClassBoardVO c001ClassBoardVO) {
		String reGetTeaName = f001LectureDAO.reGetTeaName(c001ClassBoardVO);
		return reGetTeaName;
	}


	@Override
	public void insertOpenLec(F001LectureVO f001LectureVO) {
		f001LectureDAO.insertOpenLec(f001LectureVO);
		
	}


	@Override
	public List<Map<String, Object>> classIdLec() {
		List<Map<String, Object>> classIdLec = f001LectureDAO.classIdLec();
		return classIdLec;
	}


	@Override
	public List<Map<String, Object>> bulCodeLec(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> bulCodeLec = f001LectureDAO.bulCodeLec(f001LectureVO);
		return bulCodeLec;
	}


	@Override
	public List<Map<String, Object>> selectTeaName(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> selectTeaName = f001LectureDAO.selectTeaName(f001LectureVO);
		return selectTeaName;
	}


	
	
}