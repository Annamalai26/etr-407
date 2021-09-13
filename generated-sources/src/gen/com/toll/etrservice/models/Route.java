package com.toll.etrservice.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Route Model
 */
@ApiModel(description = "Route Model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-10T23:13:29.151519600-04:00[America/Toronto]")

public class Route   {
  @JsonProperty("toId")
  private Integer toId;

  @JsonProperty("distance")
  private BigDecimal distance;

  @JsonProperty("enter")
  private Boolean enter = true;

  @JsonProperty("exit")
  private Boolean exit = true;

  public Route toId(Integer toId) {
    this.toId = toId;
    return this;
  }

  /**
   * Get toId
   * @return toId
  */
  @ApiModelProperty(value = "")


  public Integer getToId() {
    return toId;
  }

  public void setToId(Integer toId) {
    this.toId = toId;
  }

  public Route distance(BigDecimal distance) {
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

  public Route enter(Boolean enter) {
    this.enter = enter;
    return this;
  }

  /**
   * Get enter
   * @return enter
  */
  @ApiModelProperty(value = "")


  public Boolean getEnter() {
    return enter;
  }

  public void setEnter(Boolean enter) {
    this.enter = enter;
  }

  public Route exit(Boolean exit) {
    this.exit = exit;
    return this;
  }

  /**
   * Get exit
   * @return exit
  */
  @ApiModelProperty(value = "")


  public Boolean getExit() {
    return exit;
  }

  public void setExit(Boolean exit) {
    this.exit = exit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.toId, route.toId) &&
        Objects.equals(this.distance, route.distance) &&
        Objects.equals(this.enter, route.enter) &&
        Objects.equals(this.exit, route.exit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toId, distance, enter, exit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    
    sb.append("    toId: ").append(toIndentedString(toId)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    enter: ").append(toIndentedString(enter)).append("\n");
    sb.append("    exit: ").append(toIndentedString(exit)).append("\n");
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

