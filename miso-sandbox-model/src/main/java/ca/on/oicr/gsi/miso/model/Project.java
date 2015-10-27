/*
 * Copyright (c) 2012. The Genome Analysis Centre, Norwich, UK
 * MISO project contacts: Robert Davey, Mario Caccamo @ TGAC
 * *********************************************************************
 *
 * This file is part of MISO.
 *
 * MISO is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MISO is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MISO.  If not, see <http://www.gnu.org/licenses/>.
 *
 * *********************************************************************
 */

package ca.on.oicr.gsi.miso.model;

import java.util.Collection;
import java.util.Date;

//import com.fasterxml.jackson.annotation.*;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * A Project represents the top level object in the MISO data model. A Project couples together {@link Study} and {@link Sample} objects to
 * record information about a given sequencing project.
 * <p/>
 * A Project's progress status is tracked by its {@link ProgressType} enumeration. A Project describes a collaborator or PI via the
 * {@link ProjectOverview} object, whereby proposed start and end dates, number of expected samples and watchers can be assigned.
 *
 * @author Rob Davey
 * @since 0.0.2
 */
@JsonSerialize(typing = JsonSerialize.Typing.STATIC, include = JsonSerialize.Inclusion.NON_NULL)
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonIgnoreProperties({ "securityProfile" })
public interface Project {
  /** Field PREFIX */
  public static final String PREFIX = "PRO";

  public void setId(long id);

  /**
   * Returns the alias of this Project object.
   *
   * @return String alias.
   */
  String getAlias();

  /**
   * Sets the alias of this Project object.
   *
   * @param alias
   *          alias.
   */
  void setAlias(String alias);

  /**
   * Returns the registered samples of this Project object.
   *
   * @return Collection<Sample> samples.
   */
  Collection<Sample> getSamples();

  /**
   * Registers a collection of samples to this Project object.
   *
   * @param samples
   *          samples.
   */
  void setSamples(Collection<Sample> samples);

  /**
   * Register that a Sample has been recieved in relation to this Project
   *
   * @param sample
   *          of type Sample
   */
  void addSample(Sample sample);

  /**
   * Returns the associated issue keys of this Project object.
   *
   * @return Collection<String> issueKeys.
   */
  Collection<String> getIssueKeys();

  /**
   * Registers a collection of issue keys from an issue tracker to this Project object.
   *
   * @param issueKeys
   *          issueKeys.
   */
  void setIssueKeys(Collection<String> issueKeys);

  /**
   * Registers an issue key from an issue tracker to this Project object.
   *
   * @param issueKey
   *          issueKey.
   */
  void addIssueKey(String issueKey);

  Date getLastUpdated();

  void setLastUpdated(Date lastUpdated);
}
