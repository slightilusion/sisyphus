package cc.yelcat.sisyphus.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class TypechoRelationships implements Serializable {
    private Integer cid;

    private Integer mid;

    private static final long serialVersionUID = 1L;
}