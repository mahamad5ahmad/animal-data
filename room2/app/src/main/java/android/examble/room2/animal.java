package android.examble.room2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "animal")
public class animal {
    @PrimaryKey(autoGenerate = true)
    private long fie_id ;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "name")
    private String name ;
    @ColumnInfo(name = "weight")
    private String weight;
    @ColumnInfo(name = "kind")
    private int kind;
    public  animal (String type,String name,String weight,int kind){
        this.type=type;
        this.name=name;
        this.weight=weight;
        this.kind=kind;
    }
    public Long getFie_id() {
        return fie_id;
    }

    public void setFie_id(Long fie_id) {
        this.fie_id = fie_id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public int getKind() {
        return kind;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }
}
