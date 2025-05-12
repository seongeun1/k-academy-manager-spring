package com.academy.k_academy_manager_spring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter

@Configuration
class RequestLoggingConfig {

  @Bean
  fun requestLoggingFilter(): CommonsRequestLoggingFilter {
    return CommonsRequestLoggingFilter().apply {
      setIncludeClientInfo(true)
      setIncludeQueryString(true)
      setIncludePayload(true)
      setIncludeHeaders(false)
      setMaxPayloadLength(10000)
      setAfterMessagePrefix("▶ REQUEST DATA : ")
    }
  }
}

