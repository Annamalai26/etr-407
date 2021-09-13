package com.toll.etrservice.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ETR Error Response Model
 */
@ApiModel(description = "ETR Error Response Model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-10T23:13:29.151519600-04:00[America/Toronto]")

public class ETRErrorResponse   {
  @JsonProperty("errcode")
  private Integer errcode;

  @JsonProperty("errMessage")
  private String errMessage;

  public ETRErrorResponse errcode(Integer errcode) {
    this.errcode = errcode;
    return this;
  }

  /**
   * Get errcode
   * @return errcode
  */
  @ApiModelProperty(value = "")


  public Integer getErrcode() {
    return errcode;
  }

  public void setErrcode(Integer errcode) {
    this.errcode = errcode;
  }

  public ETRErrorResponse errMessage(String errMessage) {
    this.errMessage = errMessage;
    return this;
  }

  /**
   * Get errMessage
   * @return errMessage
  */
  @ApiModelProperty(value = "")


  public String getErrMessage() {
    return errMessage;
  }

  public void setErrMessage(String errMessage) {
    this.errMessage = errMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ETRErrorResponse etRErrorResponse = (ETRErrorResponse) o;
    return Objects.equals(this.errcode, etRErrorResponse.errcode) &&
        Objects.equals(this.errMessage, etRErrorResponse.errMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errcode, errMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ETRErrorResponse {\n");
    
    sb.append("    errcode: ").append(toIndentedString(errcode)).append("\n");
    sb.append("    errMessage: ").append(toIndentedString(errMessage)).append("\n");
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

