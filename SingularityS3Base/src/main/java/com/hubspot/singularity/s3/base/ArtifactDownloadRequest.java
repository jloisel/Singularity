package com.hubspot.singularity.s3.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.hubspot.deploy.S3Artifact;

public class ArtifactDownloadRequest {

  private final String targetDirectory;
  private final S3Artifact s3Artifact;

  @JsonCreator
  public ArtifactDownloadRequest(@JsonProperty("targetDirectory") String targetDirectory, @JsonProperty("s3Artifact") S3Artifact s3Artifact) {
    Preconditions.checkNotNull(targetDirectory);
    Preconditions.checkNotNull(s3Artifact);

    this.targetDirectory = targetDirectory;
    this.s3Artifact = s3Artifact;
  }

  public String getTargetDirectory() {
    return targetDirectory;
  }

  public S3Artifact getS3Artifact() {
    return s3Artifact;
  }

  @Override
  public String toString() {
    return "ArtifactDownloadRequest [targetDirectory=" + targetDirectory + ", s3Artifact=" + s3Artifact + "]";
  }

}
