/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.spinnaker.clouddriver.artifacts;

import com.netflix.spinnaker.clouddriver.artifacts.embedded.EmbeddedArtifactConfiguration;
import com.netflix.spinnaker.clouddriver.artifacts.gcs.GcsArtifactConfiguration;
import com.netflix.spinnaker.clouddriver.artifacts.github.GitHubArtifactConfiguration;
import com.netflix.spinnaker.clouddriver.artifacts.http.HttpArtifactConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@EnableScheduling
@Component
@ComponentScan({"com.netflix.spinnaker.clouddriver.artifacts"})
@Import({
  EmbeddedArtifactConfiguration.class,
  GcsArtifactConfiguration.class,
  GitHubArtifactConfiguration.class,
  HttpArtifactConfiguration.class
})
public class ArtifactConfiguration {
  @Bean
  ArtifactCredentialsRepository artifactCredentialsRepository() {
    return new ArtifactCredentialsRepository();
  }
}
