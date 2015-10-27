package ca.on.oicr.gsi.miso.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * A Sample contains information about the original material upon which a sequencing experiment is to be based.
 * <p/>
 * Samples can be used in any number of sequencing {@link Experiment}s in the form of a {@link Library} that is processed further into
 * pooled {@link Dilution}s. Samples can be described further by a scientific name which, when enabled, will be checked against the NCBI
 * Taxonomy database.
 * <p/>
 * Sample properties are specified mainly by the SRA schema requirements, e.g. they have a Sample type string based on an SRA enumeration.
 *
 * @author Rob Davey
 * @since 0.0.2
 */
@JsonSerialize(typing = JsonSerialize.Typing.STATIC, include = JsonSerialize.Inclusion.NON_NULL)
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonIgnoreProperties({ "securityProfile", "submissionDocument" })
public interface Sample {

  /** Field UNSAVED_ID */
  public static final Long UNSAVED_ID = 0L;
  /** Field PREFIX */
  public static final String PREFIX = "SAM";

  /**
   * Returns the sampleId of this Sample object.
   *
   * @return Long sampleId.
   */
  @Deprecated
  public Long getSampleId();

  /**
   * Sets the sampleId of this Sample object.
   *
   * @param sampleId
   *          sampleId.
   */
  @Deprecated
  public void setSampleId(Long sampleId);

  public void setId(long id);

  /**
   * Returns the accession of this Sample object.
   *
   * @return String accession.
   */
  public String getAccession();

  /**
   * Sets the accession of this Sample object.
   *
   * @param accession
   *          accession.
   */
  public void setAccession(String accession);

  /**
   * Sets the name of this Sample object.
   *
   * @param name
   *          name.
   */
  public void setName(String name);

  /**
   * Returns the description of this Sample object.
   *
   * @return String description.
   */
  public String getDescription();

  /**
   * Sets the description of this Sample object.
   *
   * @param description
   *          description.
   */
  public void setDescription(String description);

  /**
   * Returns the scientificName of this Sample object. This should ideally match a taxon name of a species in the NCBI Taxonomy database.
   *
   * @return String scientificName.
   */
  public String getScientificName();

  /**
   * Sets the scientificName of this Sample object. This should ideally match a taxon name of a species in the NCBI Taxonomy database.
   *
   * @param scientificName
   *          scientificName.
   */
  public void setScientificName(String scientificName);

  /**
   * Returns the taxonIdentifier of this Sample object. This should ideally match a taxon ID of a strain in the NCBI Taxonomy database.
   *
   * @return String taxonIdentifier.
   */
  public String getTaxonIdentifier();

  /**
   * Sets the taxonIdentifier of this Sample object. This should ideally match a taxon ID of a strain in the NCBI Taxonomy database.
   *
   * @param taxonIdentifier
   *          taxonIdentifier.
   */
  public void setTaxonIdentifier(String taxonIdentifier);

  /**
   * Returns the alias of this Sample object.
   *
   * @return String alias.
   */
  public String getAlias();

  /**
   * Sets the alias of this Sample object.
   *
   * @param alias
   *          alias.
   */
  public void setAlias(String alias);

  /**
   * Returns the project of this Sample object.
   *
   * @return Project project.
   */
  // @JsonBackReference(value="project")
  public Project getProject();

  /**
   * Sets the project of this Sample object.
   *
   * @param project
   *          project.
   */
  public void setProject(Project project);

  /**
   * Returns the sampleType of this Sample object.
   *
   * @return String sampleType.
   */
  public String getSampleType();

  /**
   * Sets the sampleType of this Sample object.
   *
   * @param string
   *          sampleType.
   */
  public void setSampleType(String string);

  /**
   * Returns the receivedDate of this Sample object.
   *
   * @return Date receivedDate.
   */
  public Date getReceivedDate();

  /**
   * Sets the receivedDate of this Sample object.
   *
   * @param date
   *          receivedDate.
   */
  public void setReceivedDate(Date date);

  /**
   * Returns the qcPassed of this Sample object.
   *
   * @return Boolean qcPassed.
   */
  public Boolean getQcPassed();

  /**
   * Sets the qcPassed attribute of this Sample object. This should be true when a suitable QC has been carried out that passes a given
   * result.
   *
   * @param qcPassed
   *          qcPassed.
   */
  public void setQcPassed(Boolean qcPassed);

  Date getLastUpdated();

  void setLastUpdated(Date lastUpdated);
}
