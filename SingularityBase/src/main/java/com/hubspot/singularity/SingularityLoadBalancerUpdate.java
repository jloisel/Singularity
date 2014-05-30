package com.hubspot.singularity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.hubspot.singularity.LoadBalancerRequestType.LoadBalancerRequestId;

public class SingularityLoadBalancerUpdate extends SingularityJsonObject {

  private final LoadBalancerState loadBalancerState;
  private final Optional<String> message;
  private final long timestamp;
  private final String uri;
  private final LoadBalancerMethod method;
  private final LoadBalancerRequestId loadBalancerRequestId;
  
  public static SingularityLoadBalancerUpdate fromBytes(byte[] bytes, ObjectMapper objectMapper) {
    try {
      return objectMapper.readValue(bytes, SingularityLoadBalancerUpdate.class);
    } catch (IOException e) {
      throw new SingularityJsonException(e);
    }
  }
  
  public enum LoadBalancerMethod { 
    ENQUEUE, CHECK_STATE, CANCEL;
  }
  
  @JsonCreator
  public SingularityLoadBalancerUpdate(@JsonProperty("state") LoadBalancerState loadBalancerState, @JsonProperty("loadBalancerRequestId") LoadBalancerRequestId loadBalancerRequestId, @JsonProperty("message") Optional<String> message, 
      @JsonProperty("timestamp") long timestamp, @JsonProperty("method") LoadBalancerMethod method, @JsonProperty("uri") String uri) {
    this.loadBalancerState = loadBalancerState;
    this.message = message;
    this.timestamp = timestamp;
    this.uri = uri;
    this.method = method;
    this.loadBalancerRequestId = loadBalancerRequestId;
  }

  public LoadBalancerState getLoadBalancerState() {
    return loadBalancerState;
  }

  public Optional<String> getMessage() {
    return message;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getUri() {
    return uri;
  }

  public LoadBalancerMethod getMethod() {
    return method;
  }

  public LoadBalancerRequestId getLoadBalancerRequestId() {
    return loadBalancerRequestId;
  }

  @Override
  public String toString() {
    return "SingularityLoadBalancerUpdate [loadBalancerState=" + loadBalancerState + ", message=" + message + ", timestamp=" + timestamp + ", uri=" + uri + ", method=" + method + ", loadBalancerRequestId=" + loadBalancerRequestId + "]";
  }
  
}
