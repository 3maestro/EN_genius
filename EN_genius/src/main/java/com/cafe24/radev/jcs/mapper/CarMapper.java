package com.cafe24.radev.jcs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.jcs.vo.VoCarColor;
import com.cafe24.radev.jcs.vo.VoCarDetail;
import com.cafe24.radev.jcs.vo.VoCarFuel;
import com.cafe24.radev.jcs.vo.VoCarOption;
import com.cafe24.radev.jcs.vo.VoCarRegister;

@Mapper
public interface CarMapper {
	
	
	public List<VoCarFuel> getPowTrainSelect();
	
	public List<VoCarFuel> getDriveWaySelect();
	/**
	 * 차량 트렌스미션 선택 메서드
	 * @return
	 */
	public List<VoCarFuel> getTrnsMiSelect();
	
	/**
	 * 차량 엔진 선택 메서드
	 * @return
	 */
	public List<VoCarFuel> getEngineSelect();
	
	/**
	 * 차량 연료 선택 메서드
	 * @return
	 */
	public List<VoCarFuel> getFuelSelect();
	
	/**
	 * 차량 중분류 컬러선택 메서드
	 * @return
	 */
	public List<VoCarColor> getMidColSelect();
	
	/**
	 * 차량 대분류 컬러선택 메서드
	 * @return
	 */
	public List<VoCarColor> getBigColSelect();
	
	/**
	 * 차량 선택옵션 메서드
	 * @return
	 */
	public List<VoCarOption> getCarOpChoiceSelect();
	
	/**
	 * 차량 옵션등급 메서드
	 * @return
	 */
	public List<VoCarOption> getOpGradeSelect();
	
	/**
	 * voCarDetail insert
	 * @param voDetail
	 * @return
	 */
	public int getDetailInsert(VoCarDetail voDetail);
	
	/**
	 * 연도별 차량 메서드
	 * @return
	 */
	public List<VoCarDetail> getYearCarSelect();
	
	
	/**
	 * 차량 모델 메서드 (차량 모델 코드, 차량 모델 명)
	 * @return
	 */
	public List<VoCarDetail> getCarModelSelect();
	
	/**
	 * 차량 종류 메서드(차량 종류 코드, 차량 종류 명)
	 * @return
	 */
	public List<VoCarDetail> getCarClassSelect();
	
	/**
	 * 차량 제작회사 (제작회사코드, 제작회사 명)
	 * @return
	 */
	public List<VoCarDetail> getCarVendorSelect();
	
	/**
	 * 차량 제조국가 (국가코드,국가 명)
	 * @return
	 */
	public List<VoCarDetail> getCarOriginSelect();
	
	
	/**
	 * 차량 리스트 (....)
	 * @return
	 */
	public List<VoCarRegister> getCarList();
	
	
	
	
	
	
	
	
	
	
	//가져갈 값이 1개일땐 리턴데이터 타입을 vo객체로 한다
	//차량 등록 수정 메서드
	public VoCarRegister getCarUpdate(String cuscar);
	
	
	
	
	

	//등록할떄마다 값을 가져와야 하기 떄문에 vo의 매개변수를 입력해야 한다
	//차량 등록 메서드
	public int getCarInsert(VoCarRegister vcreg);

}
