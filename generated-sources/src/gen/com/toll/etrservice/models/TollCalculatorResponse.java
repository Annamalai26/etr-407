package com.toll.etrservice.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.toll.etrservice.models.ETRErrorResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Toll Calculator Response Model
 */
@ApiModel(description = "Toll Calculator Response Model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-10T23:13:29.151519600-04:00[America/Toronto]")

public class TollCalculatorResponse   {
  @JsonProperty("entry")
  private String entry;

  @JsonProperty("exit")
  private String exit;

  @JsonProperty("distance")
  private BigDecimal distance;

  @JsonProperty("charge")
  private BigDecimal charge;

  @JsonProperty("error")
  private ETRErrorResponse error = null;

  public TollCalculatorResponse entry(String entry) {
    this.entry = entry;
    return this;
  }

  /**
   * Get entry
   * @return entry
  */
  @ApiModelProperty(value = "")


  public String getEntry() {
    return entry;
  }

  public void setEntry(String entry) {
    this.entry = entry;
  }

  public TollCalculatorResponse exit(String exit) {
    this.exit = exit;
    return this;
  }

  /**
   * Get exit
   * @return exit
  */
  @ApiModelProperty(value = "")


  public String getExit() {
    return exit;
  }

  public void setExit(String exit) {
    this.exit = exit;
  }

  public TollCalculatorResponse distance(BigDecimal distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getDistance() {
    return distance;
  }

  public void setDistance(BigDecimal distance) {
    this.distance = distance;
  }

  public TollCalculatorResponse charge(BigDecimal charge) {
    this.charge = charge;
    return this;
  }

  /**
   * Get charge
   * @return charge
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCharge() {
    return charge;
  }

  public void setCharge(BigDecimal charge) {
    this.charge = charge;
  }

  public TollCalculatorResponse error(ETRErrorResponse error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(value = "")


  public ETRErrorResponse getError() {
    return error;
  }

  public void setError(ETRErrorResponse error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TollCalculatorResponse tollCalculatorResponse = (TollCalculatorResponse) o;
    return Objects.equals(this.entry, tollCalculatorResponse.entry) &&
        Objects.equals(this.exit, tollCalculatorResponse.exit) &&
        Objects.equals(this.distance, tollCalculatorResponse.distance) &&
        Objects.equals(this.charge, tollCalculatorResponse.charge) &&
        Objects.equals(this.error, tollCalculatorResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entry, exit, distance, charge, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TollCalculatorResponse {\n");
    
    sb.append("    entry: ").append(toIndentedString(entry)).append("\n");
    sb.append("    exit: ").append(toIndentedString(exit)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

