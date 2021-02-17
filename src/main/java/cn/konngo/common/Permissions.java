package cn.konngo.common;

public class Permissions {
    private int id;
    private String name;
    private boolean add;
    private boolean delete;
    private boolean update;

    public Permissions() {
    }

    public Permissions(int id, String name, boolean add, boolean delete, boolean update) {
        this.id = id;
        this.name = name;
        this.add = add;
        this.delete = delete;
        this.update = update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", add=" + add +
                ", delete=" + delete +
                ", update=" + update +
                '}';
    }
}
