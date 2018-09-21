package gaia3d.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaia3d.domain.APIHeader;
import gaia3d.domain.APIResult;
import gaia3d.domain.APIValidationType;
import gaia3d.domain.CacheManager;
import gaia3d.domain.Client;
import gaia3d.domain.Policy;
import gaia3d.domain.TokenLog;
import gaia3d.service.ClientService;
import gaia3d.service.TokenLogService;
import lombok.extern.slf4j.Slf4j;

/**
 * restconroller 사용시 responsebody는 생략
 * @author Cheon JeongDae
 *
 */
@Slf4j
@RequestMapping("/authentication/")
@RestController
public class AuthenticationAPIController implements APIController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private TokenLogService tokenLogService;
	
	@PostMapping("token")
	public ResponseEntity<APIResult> createToken(HttpServletRequest request) {
		log.info("@@@@@@@@@@ createToken api call");
		
		APIResult aPIResult = null;
		HttpStatus httpStatus = null;
		Policy policy = CacheManager.getPolicy();
		try {
			APIHeader aPIHeader = getHeader(policy.getRest_api_encryption_yn(), log, request);
			aPIResult = validate(APIValidationType.AUTHETICATION, getHeader(policy.getRest_api_encryption_yn(), log, request));
			if(aPIResult.getStatusCode() != HttpStatus.OK.value()) return new ResponseEntity<APIResult>(aPIResult, HttpStatus.valueOf(aPIResult.getStatusCode()));
			
			// api key 조회
			Client client = clientService.getClientByAPIKey(aPIHeader.getApiKey());
			if(client == null || client.getClient_id() == null) {
				aPIResult.setStatusCode(HttpStatus.FORBIDDEN.value());
				aPIResult.setMessage("Unregistered client");
				return new ResponseEntity<APIResult>(aPIResult, HttpStatus.valueOf(aPIResult.getStatusCode()));
			}
			
			// token 발행
			TokenLog tokenLog = new TokenLog();
			tokenLog.setClient_id(client.getClient_id());
			tokenLogService.getToken(tokenLog);
			
			try {
				//aPIService.insertAPILog(aPILog);
			} catch(Exception ex) {
				ex.printStackTrace();
				log.error("@@@@@@@@ API 이력 저장 중 오류가 발생했지만... 무시");
			}
			
			httpStatus = HttpStatus.OK;
			aPIResult.setStatusCode(httpStatus.value());
		} catch(Exception e) {
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			aPIResult.setStatusCode(httpStatus.value());
			aPIResult.setException(e.getMessage());
		}
		
		return new ResponseEntity<APIResult>(aPIResult, httpStatus);
	}
	
	@PutMapping
	public String refreshToken() {
		return "";
	}
	
	@Override
	public void insertLog() {
		
	}
}
