package com.toll.etrservice.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.toll.etrservice.models.Route;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Location Model
 */
@ApiModel(description = "Location Model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-10T23:13:29.151519600-04:00[America/Toronto]")

public class Location   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("lat")
  private BigDecimal lat;

  @JsonProperty("lng")
  private BigDecimal lng;

  @JsonProperty("devcomment")
  private String devcomment;

  @JsonProperty("routes")
  @Valid
  private List<Route> routes = null;

  public Location id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location lat(BigDecimal lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Get lat
   * @return lat
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getLat() {
    return lat;
  }

  public void setLat(BigDecimal lat) {
    this.lat = lat;
  }

  public Location lng(BigDecimal lng) {
    this.lng = lng;
    return this;
  }

  /**
   * Get lng
   * @return lng
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getLng() {
    return lng;
  }

  public void setLng(BigDecimal lng) {
    this.lng = lng;
  }

  public Location devcomment(String devcomment) {
    this.devcomment = devcomment;
    return this;
  }

  /**
   * Get devcomment
   * @return devcomment
  */
  @ApiModelProperty(value = "")


  public String getDevcomment() {
    return devcomment;
  }

  public void setDevcomment(String devcomment) {
    this.devcomment = devcomment;
  }

  public Location routes(List<Route> routes) {
    this.routes = routes;
    return this;
  }

  public Location addRoutesItem(Route routesItem) {
    if (this.routes == null) {
      this.routes = new ArrayList<>();
    }
    this.routes.add(routesItem);
    return this;
  }

  /**
   * Get routes
   * @return routes
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.id, location.id) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.lat, location.lat) &&
        Objects.equals(this.lng, location.lng) &&
        Objects.equals(this.devcomment, location.devcomment) &&
        Objects.equals(this.routes, location.routes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lat, lng, devcomment, routes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
    sb.append("    devcomment: ").append(toIndentedString(devcomment)).append("\n");
    sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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

