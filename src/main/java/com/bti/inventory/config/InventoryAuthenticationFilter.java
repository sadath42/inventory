package com.bti.inventory.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bti.inventory.dto.UserSessionDto;
import com.bti.inventory.exception.GlobalExceptionHandler;
import com.bti.inventory.rest.UserServiceClient;

@Component
public class InventoryAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryAuthenticationFilter.class);

	@Autowired
	private UserServiceClient client;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String URI = request.getRequestURI();
		LOGGER.debug("Recived request for {}",URI);

		// Urls which need not be autohrized add here.
		boolean allowedEndpoint = URI.startsWith("/actuator/");

		if (allowedEndpoint) {
			filterChain.doFilter(request, response);
		} else {
			boolean missingSessionAttrib = checkForMissingAttrib(request);
			if (missingSessionAttrib) {
				LOGGER.error("Missing session attributes");
				response.sendError(401, "Not Authorized");
			} else {
				UserSessionDto dto = getUserSession(request);
				ResponseEntity<Boolean> resp = client.validateSession(dto);
				if (resp.getBody()) {
					LOGGER.error("Validation failed in usser management");
					filterChain.doFilter(request, response);
				} else {
					response.sendError(401, "Not Authorized");
				}
			}

		}

		setCrosssOrigin(response);
	}

	private void setCrosssOrigin(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "content-type, session, userid, langid, tenantid");
		response.setHeader("Access-Control-Allow-Credentials", "true");		
	}

	private boolean checkForMissingAttrib(HttpServletRequest request) {
		boolean missingSessionAttrib = false;
		missingSessionAttrib = request.getHeader("currentUser") == null;
		missingSessionAttrib = request.getHeader("sessionId") == null || missingSessionAttrib;
		missingSessionAttrib = request.getHeader("compnayTenantId") == null || missingSessionAttrib;
		return missingSessionAttrib;
	}

	private UserSessionDto getUserSession(HttpServletRequest request) {
		return new UserSessionDto(request.getHeader("sessionId"), Integer.parseInt(request.getHeader("currentUser")),
				request.getHeader("compnayTenantId"));
	}

}
