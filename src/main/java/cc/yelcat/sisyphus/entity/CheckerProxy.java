package cc.yelcat.sisyphus.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CheckerProxy implements Serializable {
    private Integer id;

    @JsonProperty("local_id")
    private Integer localId;

    @JsonProperty("report_id")
    private String reportId;

    private String addr;

    private Integer type;

    private Integer kind;

    private Integer timeout;

    private String cookie;

    private String referer;

    private String post;

    private String ip;

    @JsonProperty("ip_geo_iso")
    private String addrGeoIso;

    @JsonProperty("addr_geo_country")
    private String addrGeoCountry;

    @JsonProperty("addr_geo_city")
    private String addrGeoCity;

    @JsonProperty("addr_geo_iso")
    private String ipGeoIso;

    @JsonProperty("ip_geo_country")
    private String ipGeoCountry;

    @JsonProperty("ip_geo_city")
    private String ipGeoCity;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm" )
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm" )
    private Date updatedAt;

    private String skip;

    @JsonProperty("from_cache")
    private String fromCache;

    private static final long serialVersionUID = 1L;
}