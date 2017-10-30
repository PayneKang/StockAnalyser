package psn.kang.stock.dataAccess.dalEntities;

import java.util.Date;

public class StockBaseInfoDal {
    private String code;
    private String name;
    private String description;
    private Date LastUpdate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        LastUpdate = lastUpdate;
    }
}
