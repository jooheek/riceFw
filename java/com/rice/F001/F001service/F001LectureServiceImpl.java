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


	@Override
	public List<Map<String, Object>> enrolmentInfo() {
		List<Map<String, Object>> enrolmentInfo = f001LectureDAO.enrolmentInfo();
		return enrolmentInfo;
	}


	@Override
	public Map<String, Object> partnerOrderId() {
		Map<String, Object> partnerOrderId = f001LectureDAO.partnerOrderId();
		return partnerOrderId;
	}


	@Override
	public void insertEnrolLec(Map<String,Object> insertEnrolLecS) {
		System.out.println("service : "+insertEnrolLecS);
		f001LectureDAO.insertEnrolLec(insertEnrolLecS);
		
	}


	@Override
	public List<Map<String, Object>> searchClassIdName() {
		List<Map<String, Object>> searchClassIdName = f001LectureDAO.searchClassIdName();
		return searchClassIdName;
	}


	@Override
	public void holdDel(F001LectureVO f001LectureVO) {
		f001LectureDAO.holdDel(f001LectureVO);
		return;
	}




	@Override
	public List<Map<String, Object>> delRegL(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> delRegL = f001LectureDAO.delRegL(f001LectureVO);
		return delRegL;
	}


	@Override
	public List<Map<String, Object>> searchClassTea() {
		List<Map<String, Object>> searchClassTea = f001LectureDAO.searchClassTea();
		return searchClassTea;
	}


	@Override
	public List<Map<String, Object>> getSubIdJspC(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> getSubIdJspC = f001LectureDAO.getSubIdJspC(f001LectureVO);
		return getSubIdJspC;
	}


	@Override
	public void insertCart(Map<String, Object> insertEnrolLecS) {
		f001LectureDAO.insertCart(insertEnrolLecS);
		System.out.println("controller_ insertEnrolLecS : " +insertEnrolLecS);
		return;
	}


	@Override
	public void paidlist(String enrId) {
		f001LectureDAO.paidlist(enrId);
		System.out.println("service 실행");
		
	}


	@Override
	public void savePaidlist(Map<String, Object> insertEnrolLecS) {
		f001LectureDAO.savePaidlist(insertEnrolLecS);
		
	}


	@Override
	public String searchSub(String tempId) {
		String searchSub = f001LectureDAO.searchSub(tempId);
		return searchSub;
	}


	@Override
	public void insertOrderList(Map<String, Object> map) {
		f001LectureDAO.insertOrderList(map);
		
	}


	@Override
	public List<Map<String, Object>> selectPaidListR(Map<String, Object> memNum) {
		List<Map<String, Object>> selectPaidListR = f001LectureDAO.selectPaidListR(memNum);
		System.out.println("service selectPaidListR : " + selectPaidListR);
		return selectPaidListR;
	}


	@Override
	public List<Map<String, Object>> cartInfo(String memNum) {
		List<Map<String, Object>> cartInfo = f001LectureDAO.cartInfo(memNum);
		return cartInfo;
	}


	@Override
	public void delCartList(Map<String, Object> memNum) {
		f001LectureDAO.delCartList(memNum);
		return;
	}


	@Override
	public void wholeDelButton(Map<String, Object> memNum) {
		f001LectureDAO.wholeDelButton(memNum);
		
	}


	@Override
	public void selectDelButton(Map<String, Object> memNum) {
		f001LectureDAO.selectDelButton(memNum);
		
	}


	@Override
	public List<Map<String, Object>> paidList(Map<String, Object> memNum) {
		List<Map<String, Object>> paidList = f001LectureDAO.paidList(memNum);
		return paidList;
	}


	@Override
	public List<Map<String, Object>> paidListDetail(Map<String, Object> DetailCart) {
		List<Map<String, Object>> paidListDetail = f001LectureDAO.paidListDetail(DetailCart);
		//System.out.println("service paidListDetail : "+ paidListDetail);
		return paidListDetail;
	}


	@Override
	public Map<String, Object> selectBulCl(Map<String, Object> detailCart) {
		Map<String, Object> selectBulCl = f001LectureDAO.selectBulCl(detailCart);
		return selectBulCl;
	}


	@Override
	public List<Map<String, Object>> searchOpenClT(Map<String, Object> detailCart) {
		List<Map<String, Object>> searchOpenClT = f001LectureDAO.searchOpenClT(detailCart);
		System.out.println("controller_ searchOpenClT : "+ searchOpenClT);
		return searchOpenClT;
	}


	@Override
	public Map<String, Object> selectCountCapa(Map<String, Object> detailCart) {
		Map<String, Object> selectCountCapa = f001LectureDAO.selectCountCapa(detailCart);
		return selectCountCapa;
	}


	@Override
	public List<Map<String, Object>> lecCodeVal() {
		List<Map<String, Object>> lecCodeVal = f001LectureDAO.lecCodeVal();
		return lecCodeVal;
	}


	@Override
	public void lecturePlanAdd(Map<String, Object> memNum) {
		System.out.println("service memNum:" +memNum);
		f001LectureDAO.lecturePlanAdd(memNum);
		
	}


	@Override
	public List<Map<String, Object>> selectCountSub(F001LectureVO f001LectureVO) {
		List<Map<String, Object>> selectCountSub = f001LectureDAO.selectCountSub();
		return selectCountSub;
	}


	@Override
	public Map<String, Object> selectRecomendInfo(Map<String, Object> memNum) {
		Map<String, Object> selectRecomendInfo = f001LectureDAO.selectRecomendInfo(memNum);
		return selectRecomendInfo;
	}


	@Override
	public List<Map<String, Object>> selectClassCapa(Map<String, Object> memNum) {
		List<Map<String, Object>> selectClassCapa = f001LectureDAO.selectClassCapa(memNum);
		return selectClassCapa;
	}





	
	
}
