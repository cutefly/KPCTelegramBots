package com.kpcard.telegrambots.account;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.kpcard.telegrambots.type.AccountStatus;
import com.kpcard.telegrambots.type.AccountType;

/**
 * Account 정보
 * @author happymoney
 *
 */
@Entity(name = "account_information")
public class AccountInformation {
	/**
	 * 아이디
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String	id;

	/**
	 * 수정시간
	 */
	@Column(name = "updated_timestamp")
	private Date	updatedTimestamp;

	/**
	 * Account 유형
	 */
	@Column(name = "type")
	private AccountType	type;

	/**
	 * Account 번호
	 */
	@Column(name = "account_number")
	private String	accountNumber;

	/**
	 * 보안코드
	 */
	@Column(name = "security_code")
	private String	securityCode;

	/**
	 * 상품라인 아이디
	 */
	@Column(name = "product_line_id")
	private String	productLineId;

	/**
	 * 상품 아이디
	 */
	@Column(name = "product_id")
	private String	productId;

	/**
	 * 잔액
	 */
	@Column(name = "balance")
	private BigDecimal	balance;

	/**
	 * 최종 잔액조회 시간
	 */
	@Column(name = "balance_as_of")
	private Date	balanceAsOf;

	/**
	 * 잔액정보 캐싱플래그
	 */
	@Column(name = "is_balance_stale")
	private Boolean	isBalanceStale;

	/**
	 * 통화코드
	 */
	@Column(name = "currency")
	private String	currency;

	/**
	 * 활성화 정보(카드번호 또는 전화번호)
	 */
	@Column(name = "activation_account_number")
	private String	activationAccountNumber;

	/**
	 * 활성화 금액
	 */
	@Column(name = "activation_amount")
	private BigDecimal	activationAmount;

	/**
	 * 황성화 시간
	 */
	@Column(name = "activation_timestamp")
	private Date	activationTimestamp;

	/**
	 * 활성화 장소
	 */
	@Column(name = "activation_location")
	private String	activationLocation;

	/**
	 * 먼료일
	 */
	@Column(name = "expiration_day")
	private Integer	expirationDay;

	/**
	 * 만료월
	 */
	@Column(name = "expiration_month")
	private Integer	expirationMonth;

	/**
	 * 만료년도
	 */
	@Column(name = "expiration_year")
	private Integer	expirationYear;

	/**
	 * 추가 리뎀션 정보
	 */
	@Column(name = "additional_redemption_data")
	private String	additionalRedemptionData;

	/**
	 * Account 상태
	 */
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AccountStatus	status;

	/**
	 * 바코드
	 */
	@Column(name = "barcode_value")
	private String	barCodeValue;

	/**
	 * 잔액조회 결과
	 */
	@Column(name = "balance_response")
	private String	balanceResponse;
}
