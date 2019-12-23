package com.cafe24.radev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.VoCarColor;
import com.cafe24.radev.vo.VoCarDetail;
import com.cafe24.radev.vo.VoCarFuel;
import com.cafe24.radev.vo.VoCarOption;
import com.cafe24.radev.vo.VoCarRegister;

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
	
	//등록할떄마다 값을 가져와야 하기 떄문에 vo의 매개변수를 입력해야 한다
	/**
	 * voCarDetail insert
	 * @param voDetail
	 * @return
	 */
	public int getCarRegister(VoCarRegister voDetail);
	
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
	public List<VoCarDetail> getCarList();
	
	//가져갈 값이 1개일땐 리턴데이터 타입을 vo객체로 한다
	/**
	 * 차량 상세리스트 메서드
	 * @param carUpList
	 * @return
	 */
	public VoCarDetail getCarUpdateList(String carUpList);

	
	
	//  셀렉트한 값을 가져와서 벤더사 가져오기
	public List<VoCarDetail> getDBCarModel(String originSm);

	public List<VoCarDetail> getDBCarVendor(String vendorSm); 
	
}
